package hn.bancatlan.cierrecajaempresarial.services;

import hn.bancatlan.cierrecajaempresarial.dto.consumos.responses.ErrorControladoResponse;
import hn.bancatlan.cierrecajaempresarial.dto.consumos.responses.EstadoCierreResponse;
import hn.bancatlan.cierrecajaempresarial.dto.consumos.responses.RegistarCierreDiarioResponse;
import hn.bancatlan.cierrecajaempresarial.entity.CAECCC;
import hn.bancatlan.cierrecajaempresarial.entity.CAECIE;
import hn.bancatlan.cierrecajaempresarial.entity.CAEMON;
import hn.bancatlan.cierrecajaempresarial.entity.CAEPAR;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRD;
import hn.bancatlan.cierrecajaempresarial.entity.CTRLCTA;
import hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes.CustomizeException;
import hn.bancatlan.cierrecajaempresarial.repository.CAECCCRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAECIERepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAEMONRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAEPARRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRDRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CTRLCTARepo;
import hn.bancatlan.cierrecajaempresarial.repository.REGCCORepo;
import hn.bancatlan.cierrecajaempresarial.utils.commons.GestionCierre;
import hn.bancatlan.cierrecajaempresarial.utils.commons.InformacionCierre;
import hn.bancatlan.cierrecajaempresarial.utils.commons.UtilidadesGenerales;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.srvbasa_router.SRVBASARouter;
import hn.bancatlan.cierrecajaempresarial.utils.wsoracle_router.WSOracleRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CierreCajaEmpresarialService {

    Integer idOperacion;
    String resCierreEjecucion = "";
    Double montoRecaudo = 0.0;
    Double montoComision = 0.0;
    int totalTransacciones = 0;
    String fechaProcesamientoCierre = "";
    String fechaCierre = "";
    String usuarioEjecucion = "";
    private static final Logger logger = LoggerFactory.getLogger(CierreCajaEmpresarialService.class);

    //Inicialización de los repos de las tablas a utilizar:
    @Autowired
    CTRLCTARepo ctrlctaRepo;

    @Autowired
    REGCCORepo regccoRepo;

    @Autowired
    SRVBASARouter srvbasaRouter;

    @Autowired
    WSOracleRouter wsOracleRouter;

    @Autowired
    GestionCierre gestionCierre;

    @Autowired
    CAECIERepo caecieRepo;

    @Autowired
    CAETRDRepo caetrdRepo;
    
    @Autowired
    CAEPARRepo caeParRepo;
    
    @Autowired
    CAEMONRepo caemonRepo;

    @Autowired
    CAECCCRepo caecccRepo;

    @Autowired
    BitacoraService bitacoraService;

    @Autowired
    CreaCierreService creaCierreService;

    @Autowired
    private UtilidadesGenerales utilidadesGenerales;

    //Lógica del Cierre:
    @Transactional
    @Modifying
    public void ejecutarCierre(PeticionBaseCierre peticionBaseCierre, Integer idOperacion)
            throws CustomizeException {

        this.idOperacion = idOperacion;
        //Estableciendo la hora de inicio del cierre:
        fechaProcesamientoCierre = peticionBaseCierre.getFechaProcesamientoCierre();
        fechaCierre = peticionBaseCierre.getPeticionEspecificaCierre().getFechaCierre();
        usuarioEjecucion = peticionBaseCierre.getUsuarioEjecucionCierre().equals("autoControlM") ? "ATLCTRLM" : peticionBaseCierre.getUsuarioEjecucionCierre();

        logger.info("Validacion de estado de cierre");
        EstadoCierreResponse estadoCierreResponse = wsOracleRouter.getEstadoCierre(peticionBaseCierre);
        if (!estadoCierreResponse.getValido().equals("A")) {
            registroError("1001", peticionBaseCierre);
            return;
        }

        logger.info("Validacion de estado de cierre diario");
        wsOracleRouter.getRegCierreDiario(peticionBaseCierre);
        if (!peticionBaseCierre.getCodigoStatus().equals("0")) {
            registroError("5007", peticionBaseCierre);
            return;
        }

        logger.info("Insercion de cierre en la tabla de cierres diarios");
        RegistarCierreDiarioResponse registarCierre = wsOracleRouter.insertarDiario(3, peticionBaseCierre, 0, idOperacion);
        if (!registarCierre.getCodigoRespuesta().equals("00")) {
            return;
        }

        peticionBaseCierre.setIdCierreDiario(registarCierre.getIdCierre());

        //////////////PCaECieNF/////////////////////////|
        ///1 Verifica que no haya otro cierre ejecutándose.
        CAECIE cierre = caecieRepo.getExiste(fechaCierre);

        if (cierre != null) {
            if (bitacoraService.insertarEnBitacora("ERROR, Existe un cierre sin finalizar.", "ERRORFATAL")) {
                logger.info("Existe un cierre ejecutandose en la CAECIE.");
            }else{
                logger.info("No se pudo registrar en la caebit.");
            }
            registroError("1002", peticionBaseCierre);
            return;
        } else {
            bitacoraService.insertarEnBitacora("Inicio Cierre CAEDTA", "MSG");
        }

        ///2 Setea variables &Esp01 - &Esp05 = 'S'
        String Esp01 = "S"; // &Esp01 1: Escribir en el audit
        String Esp02 = "N"; //&Esp02 2: Escribir en el histórico
        String Esp03 = "S"; //&Esp03 3: Eliminar el diario
        String codigoAplicacion = "";
        String codigoMoneda = "";

        ///3 Escribe el inicio del cierre en la bitácora.
        /// Ya se hizo arriba
        ///4 Setea la fecha &fechac en formato YYYMMDD
        //También ya está: fechaCierre
        ///5 Busca en la CAEDTA.CAEPAR Where PARNUM=1
        CAEPAR parametros = new CAEPAR();
        try {
            parametros = caeParRepo.getParametros();

            if (parametros == null || parametros.getPARMOL() == null || parametros.getPARMOL().isEmpty()) {
                bitacoraService.insertarEnBitacora("ParMoL, Moneda Local no definida", "ERRORFATAL");
                codigoAplicacion = "2179";
            }else{
                codigoAplicacion = parametros.getPARHCA() != null ? parametros.getPARHCA().toString() : "";
                codigoAplicacion = codigoAplicacion.length() >= 4 ? codigoAplicacion.substring(0, 4) : "2179";
            }
        } catch (Exception e) {
            bitacoraService.insertarEnBitacora("Error al obtener ParMoL Catch", "ERRORFATAL");
            logger.info("Error al obtener ParMoL: " + e);
            registroError("1002", peticionBaseCierre);
            return;
        }
        
        ///6 Crea el registro del cierre con PCaEOSC
        int Error = 1;
        String mensaje = "Error en cierre actual";

        BigDecimal numeroCierre = creaCierreService.numeroCierre(parametros, usuarioEjecucion, fechaCierre);
        logger.info("Numero de cierre generado: " + numeroCierre);

        if (numeroCierre.equals(BigDecimal.ZERO)) {
            bitacoraService.insertarEnBitacora(String.format("ERROR, Registro ya existe en CaECie: %s", numeroCierre), "ERRORFATAL");
            logger.info("Error, Cierre ya existente en la CaeCie.");
            registroError("1002", peticionBaseCierre);
            return;
        }

        Optional<CAECIE> cierreActualizar = caecieRepo.getCierreExiste(numeroCierre);

        ///7 Setea &CieFeC con el día actual y luego setea &CieFeCh con formato YYYMMDD
        /// Este paso es innecesario.
        ///8 Setea otras variables del cierre como &CieHoC &CieToR &CieToO
        BigDecimal totalRegistradoLPS = BigDecimal.ZERO;
        BigDecimal totalOperaciones = BigDecimal.ZERO;
        ///9 valida el número del cierre &CieNum si es 0 escribe error en la bitácora. Sí no, actualiza la descripción del cierre.
        /// No es necesario, la validación ya se hizo anteriormente.
        ///10 Obtiene el &TrDNum ordenando por fecha y trdnum (creo que es el más alto, para establecer un tope y no procesar pagos que ocurran durante la ejecución del cierre)
        BigDecimal ultimoRegistroDiario = caetrdRepo.getUltimaTransaccion().orElse(BigDecimal.ZERO);
        logger.info(String.format("Trdnum Max: %s", ultimoRegistroDiario));

        //Obteniendo los registros de la tabla diaria:
        logger.info("Registros diarios: " + fechaCierre);
        List<CAETRD> regsDiarios = caetrdRepo.getDiario(fechaCierre, ultimoRegistroDiario);
        regsDiarios.stream().forEach(diario -> {
			logger.info("Trnnum=" + diario.getTRDNUM());
		});

        //No existen registros para contabilizar
        if (regsDiarios == null || regsDiarios.isEmpty()) {
            logger.info("Aun no hay registros");
            registroError("1002", peticionBaseCierre);
            return;
        }

        ///11 Recorre la moneda 'A' en la tabla CAEMON, luego recorre el diario y sí TrDReM = &MonCod and TrDCaj <> 'V' and AgeCod < 100:
        List<CAEMON> monedasActivas = caemonRepo.findByMONEST("A");
        if (!monedasActivas.isEmpty()) {
            // Itera sobre las monedas activas
            for (CAEMON moneda : monedasActivas) {
                System.out.println(moneda);
                //PARCHE, repara Bug de que a veces la Suc 1 pasa a ser la 10, este parche solo esta incluido en este tipo de cierre
                for (CAETRD registro : regsDiarios) {
                    if (registro.getTRDREM().equals(moneda.getMONCOD()) &&
                        !registro.getTRDCAJ().equals("V") &&
                        registro.getAGECOD().compareTo(BigDecimal.valueOf(100)) < 0) {

                        BigDecimal agecodT = registro.getTRDSUC().multiply(BigDecimal.valueOf(100)).add(registro.getAGECOD());
                        logger.info(String.format("Se actualiza el registro: %s con AGECOD: %s", registro.getTRDNUM(), agecodT));
                        
                        registro.setAGECOD(agecodT);

                        caetrdRepo.save(registro);
                    }
                }
            }
        } else {
            logger.info("No hay monedas activas.");
            registroError("1002", peticionBaseCierre);
            return;
        }
        ///12 Inicializa la moneda, recorre la CAEMON y registra en la bitácora los el inicio de la moneda, además inicializa &CCCToT y &CCCToC
        if (Esp01.equals("S")) {
            for (CAEMON moneda : monedasActivas) {
                Error = 0;
                codigoMoneda = moneda.getMONCOD();
                bitacoraService.insertarEnBitacora("Inicia cierre para moneda = '" + codigoMoneda +"'", "MSG");

                BigDecimal totalTransado = BigDecimal.ZERO;
                BigDecimal totalRecaudadoComision = BigDecimal.ZERO;
                BigDecimal totalRecaudadoMoneda = BigDecimal.ZERO;

                ///13 recorre el diario y suma &CSMToR += TrDReT
                //Calcular el total recaudado por moneda:
                for (CAETRD registro : regsDiarios) {
                    if (registro.getTRDREM().equals(moneda.getMONCOD())) {
                        totalRecaudadoMoneda = totalRecaudadoMoneda.add(registro.getTRDRET());
                    }
                }
                logger.info(String.format("Listo para recorrer la moneda, monto total para moneda %s: %s", moneda.getMONCOD(), totalRecaudadoMoneda));
                ///14 Inicia procesarMoneda: este flujo lo tomaremos a parte.
                
                /// ///Se trabajará a parte
                ///15 recorre la tabla CAECCC por CIENUM = &CieNum and CMOCOD = &MonCod
                Optional<CAECCC> cierreCuentaContable = caecccRepo.findByCIENUMAndCMOCOD(numeroCierre, codigoMoneda);
                if (cierreCuentaContable.isPresent()) {
                    bitacoraService.insertarEnBitacora(String.format("ERROR, Registro ya existe en CaECCC %s", numeroCierre), "ERRORFATAL");
                    logger.info("ERROR+FATAL: Numero de (Cierre,Moneda) ya existe en historico. contacte al Administrador del Sys");
                    registroError("1002", peticionBaseCierre);
                    return;
                } else {
                    CAECCC nuevoCierreCuenta = new CAECCC(numeroCierre, codigoMoneda, BigDecimal.ZERO, BigDecimal.ZERO, totalTransado, totalRecaudadoComision);
                    logger.info("Se registra en la CAECCC: " + nuevoCierreCuenta);
                    caecccRepo.saveAndFlush(nuevoCierreCuenta);
                }
            }
        }

        logger.info("Sali de registra en la CAECCC.");
        ///16 Setea el cierre finalizado al 33% (creo que aquí ya va mucho más avanzado)
        utilidadesGenerales.actualizarCierre(cierreActualizar, totalRegistradoLPS, totalOperaciones, BigDecimal.valueOf(33));

        logger.info("Salgo del paso 16.");
        ///17 Pasar al histórico: recorre la moneda CAEMON y luego recorre la CAEPAM para obtener:
        if (Esp02.equals("S")) {
            if (!gestionCierre.moverAlHistorico(regsDiarios, peticionBaseCierre, monedasActivas, numeroCierre)) {
                logger.info("Problemas al pasar los registros al historico.");
                registroError("1002", peticionBaseCierre);
                return;
            }
        }
        ///18 sí el error es 0, recorre el diario CAETRD, va registro por registro y valida si existe en la CAETRH, sí está retorna error en la bitácora.
        ///19 sí no está en el histórico, guarda el registro en el histórico.
        ///20 recorre la CAETRDC ordendando por TRDNUM Y TRDCNU e inserta en la CAETRHC
        ///21 Recorre la CAETRDF ordenando por TRDNUM Y TRDFFD e inserta en la CAETRHF
        ///22 le coloca un 66 por ciento al cierre
        utilidadesGenerales.actualizarCierre(cierreActualizar, totalRegistradoLPS, totalOperaciones, BigDecimal.valueOf(66));
        ///23 Elimina del diario: recorre por moned, vuelve a validar la CAEPAM.
        if (Esp03.equals("S")) {
            gestionCierre.eliminarDelDiario(regsDiarios, peticionBaseCierre, monedasActivas);
            logger.info("Movimientos del diario eliminados.");
        }
        ///24 Le coloca 100 por ciento al cierre y finaliza el cierre
        utilidadesGenerales.actualizarCierre(cierreActualizar, totalRegistradoLPS, totalOperaciones, BigDecimal.valueOf(100));
        bitacoraService.insertarEnBitacora("Exito en cierre", "FINAL");
        //////////////PCaECieNF END/////////////////////////|

        //Obtener cuentas
        CTRLCTA cuentas = ctrlctaRepo.getCuentasCierre(new BigDecimal(peticionBaseCierre.getCodigoAplicacion()), BigDecimal.ONE);

        String trades = cuentas.getDescripcionRecaudo().trim() + " " + gestionCierre.formatoFecha(peticionBaseCierre.getPeticionEspecificaCierre().getFechaCierre());
        logger.info("trades: " + trades);
        logger.info("Realizando movimientos contables");
//        srvbasaRouter.doblePartida( //cambiar parametros para moldearlos al cierre
//        ConsumoMicroservicio01PartidaDoble.builder()
//                .cuentaCredito(cuentas.getCTRLCCL().toString())
//                .cuentaDebito(cuentas.getCTRLCCT().toString())
//                .formaPago("")
//                .monedaTransaccion("LPS")
//                .montoTransaccion(montoComision)
//                .tipoNotaPago("100")
//                .textoNotaPago(trades)
//                .build(),
//                peticionBaseCierre);

        //Bandera True para pruebas
        /*
        if (!srvbasaRouter.getRespuestaDoblePartida().getCodigoMensaje().equals("00")) { //error en doble partida
            registroError("5003", peticionBaseCierre);
            return;
        }*/        
//
//        srvbasaRouter.ejecutarBasa001( //cambiar parametros para moldearlos al cierre
//                ConsumoMicroservicio01.builder()
//                .formaPago("")
//                .monedaTransaccion("LPS")
//                .montoTransaccion(montoComision)
//                .numeroCuenta(cuentas.getCTRLCCL().toString())
//                .sucursalOrigen("7500")
//                .tipoNotaPago("100")
//                .textoNotaPago(trades)
//                .build(),
//                peticionBaseCierre);
        /* 
        if (!srvbasaRouter.getRespuestaSrvBasa001().getCodigoMensaje().equals("00")) {
            registroError("5003", peticionBaseCierre);
            return;
        }*/
        //Revisar e implementar comisiones si cobran
        
        //Preparar informacion para response de cierre
        InformacionCierre infoResponse = InformacionCierre.builder()
                .montoTotal(BigDecimal.ONE)
                .comisionTotal(BigDecimal.ONE)
                .totalTransacciones(0)
                .build();
        peticionBaseCierre.setInfoResponse(infoResponse);
    }

    public void registroError(String codigoError, PeticionBaseCierre peticionBaseCierre) throws CustomizeException {
        RegistarCierreDiarioResponse registarError;
        if (codigoError.equals("1001") || codigoError.equals("5007")) {
            registarError = wsOracleRouter.insertarDiario(2, peticionBaseCierre, Integer.valueOf(codigoError), idOperacion);
            peticionBaseCierre.setIdCierreDiario(registarError.getIdCierre());
        } else {
            wsOracleRouter.updateDiario(peticionBaseCierre, 1002, 2);
        }
        peticionBaseCierre.setCodigoStatus(codigoError);
        ErrorControladoResponse error = wsOracleRouter.getErrorControlado(peticionBaseCierre);
        wsOracleRouter.insertarError(peticionBaseCierre, error.getDescripcion());
    }
}
