package hn.bancatlan.cierrecajaempresarial.utils.commons;

import hn.bancatlan.cierrecajaempresarial.dto.consumos.responses.ObtenerPeticionCierreResponse;
import hn.bancatlan.cierrecajaempresarial.entity.CAEMON;
import hn.bancatlan.cierrecajaempresarial.entity.CAEPAM;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRD;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRDC;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRDF;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRH;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRHC;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRHF;
import hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes.CustomizeException;
import hn.bancatlan.cierrecajaempresarial.repository.CAEPAMRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRDCRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRDFRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRDRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRHCRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRHFRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAETRHRepo;
import hn.bancatlan.cierrecajaempresarial.services.BitacoraService;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionEspecificaCierre;
import hn.bancatlan.cierrecajaempresarial.utils.wsoracle_router.WSOracleRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

@Component
public class GestionCierre {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    WSOracleRouter wsOracleRouter;

    @Autowired
    CAEPAMRepo caepamRepo;

    @Autowired
    CAETRHRepo caetrhRepo;

    @Autowired
    CAETRHCRepo caetrhcRepo;

    @Autowired
    CAETRHFRepo caetrhfRepo;

    @Autowired
    CAETRDRepo caetrdRepo;

    @Autowired
    CAETRDCRepo caetrdcRepo;

    @Autowired
    CAETRDFRepo caetrdfRepo;

    @Autowired
    BitacoraService bitacoraService;

    SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

    private static final Logger logger = LoggerFactory.getLogger(GestionCierre.class);

    public PeticionBaseCierre generarPeticionCierre(
            String usuario,
            String ipUsuario,
            String fechaExecCierre,
            LocalTime horaInicio,
            int accion) throws ParseException, CustomizeException {

        logger.info("Extraccion de la peticion del cierre");
        String execDate = "";
        String pattern = "yyyy-MM-dd";
        String pattern2 = "yyyyMMdd";
        String fechaProceso = new SimpleDateFormat(pattern).format(new Date(System.currentTimeMillis()));
        String fechaParaCierre = new SimpleDateFormat(pattern2).format(new Date(System.currentTimeMillis()));

        ObtenerPeticionCierreResponse peticionCierre = null;
        try {
            peticionCierre = wsOracleRouter.getPeticionCierre();
        } catch (CustomizeException e) {
            throw new CustomizeException(e, null, "No se pudo obtener la petición del cierre");
        }
        String user = usuario.isEmpty() ? peticionCierre.getUsuario() : usuario;
        String userIP = ipUsuario.isEmpty() ? peticionCierre.getDireccionIP() : ipUsuario;

        if (fechaExecCierre.isEmpty()) {

            Calendar c = Calendar.getInstance();
            DateFormat formateador = new SimpleDateFormat(pattern2);
            String indicadorFecha = peticionCierre.getIndicadorFecha().toString();
            if (indicadorFecha.equals("1")) {

                Date fechaCierre = formateador.parse(fechaParaCierre);
                c.setTime(fechaCierre);
                c.add(Calendar.DAY_OF_YEAR, -1);
                fechaParaCierre = formateador.format(c.getTime());

            }
            execDate = fechaParaCierre;
        } else {
            execDate = fechaExecCierre;
        }

        PeticionEspecificaCierre peticionEspecificaCierre = PeticionEspecificaCierre
                .builder()
                .fechaCierre(execDate)
                .accion(accion)
                .build();

        return PeticionBaseCierre
                .builder()
                .fechaProcesamientoCierre(fechaProceso)
                .codigoPeticionUnica(UUID.randomUUID() + "_" + fechaProceso)
                .codigoTransaccion(peticionCierre.getTransaccion())
                .codigoAplicacion(peticionCierre.getCodigoAplicacion())
                .codigoEmpresa(peticionCierre.getEmpresa())
                .codigoInstitucion(peticionCierre.getInstitucion())
                .codigoPais(peticionCierre.getPais())
                .codigoRegion(peticionCierre.getRegion())
                .codigoBanco(peticionCierre.getBanco())
                .codigoAgencia(peticionCierre.getAgencia())
                .codigoSucursal(peticionCierre.getSucursal())
                .codigoCanal(peticionCierre.getCanal())
                .usuarioPeticion(peticionCierre.getUsuarioPeticion())
                .usuarioEjecucionCierre(user)
                .direccionIp(userIP)
                .codigoCoreBanking(peticionCierre.getCoreBanking())
                .peticionEspecificaCierre(peticionEspecificaCierre)
                .codigoStatus("0")
                .tiempoInicio(horaInicio)
                .build();

    }

    public String formatoFecha(String fecha) {
        String anio = fecha.substring(0, 4);
        String mes = fecha.substring(4, 6);
        String dia = fecha.substring(6, 8);
        return dia + "/" + mes + "/" + anio;
    }

    public String getParteFecha(String fecha, String parte) {
        switch (parte) {
            case "anio":
                return fecha.substring(0, 4);
            case "mes":
                return fecha.substring(4, 6);
            case "dia":
                return fecha.substring(6, 8);
            default:
                return fecha;
        }
    }

    @Transactional
    public void sumatoriaMontoCierre(String parametros) { //cambiar parametros por los necesarios para utilizar la función

    }

    @Transactional
    public boolean moverAlHistorico(List<CAETRD> transaccionesDiarias,
            PeticionBaseCierre peticionBaseCierre, List<CAEMON> monedasActivas, BigDecimal numeroCierre) throws CustomizeException {
        try {
            String fechaCierre = peticionBaseCierre.getPeticionEspecificaCierre().getFechaCierre();

            Map<String, CAEPAM> parametrosPorMoneda = caepamRepo.findAllByPARNUM(BigDecimal.ONE).stream()
                .collect(Collectors.toMap(CAEPAM::getMONCOD, Function.identity()));

            for (CAEMON moneda : monedasActivas) {
                //Valida la CAEPAM
                Optional<CAEPAM> parametroMoneda = Optional.ofNullable(parametrosPorMoneda.get(moneda.getMONCOD()));
                if (!parametroMoneda.isPresent()) {
                    logger.info("No se encontraron parametros para la moneda: " + moneda.getMONCOD());
                    return false;
                }
                // Filtrar transacciones diarias por la moneda actual
                List<CAETRD> transaccionesPorMoneda = transaccionesDiarias.stream()
                    .filter(registro -> registro.getTRDREM().equals(moneda.getMONCOD()))
                    .collect(Collectors.toList());

                // Obtener los TRDNUM de las transacciones de esta moneda
                List<BigDecimal> numerosDiarios = transaccionesPorMoneda.stream()
                    .map(CAETRD::getTRDNUM)
                    .collect(Collectors.toList());

                if (numerosDiarios != null && !numerosDiarios.isEmpty()) {
                    if (caetrhRepo.existeRegistroEnHistorico(fechaCierre, numerosDiarios) > 0) {
                        bitacoraService.insertarEnBitacora("ERROR, Registro del diario ya existe en CaETRH", "ERRORFATAL");
                        logger.info("El registro del diario ya existe en el historico.");
                        
                        return false;
                    }
                    //Obteniendo los registros a insertar el la CAETRH de la CAETRD por moneda
                    List<CAETRH> historicoNuevos = transaccionesPorMoneda.stream()
                        .map(registro -> mapToHistorico(registro, numeroCierre, fechaCierre))
                        .collect(Collectors.toList());

                    //Obteniendo los registros a pasar de la CAETRDC a la CAETRHC por moneda
                    List<CAETRDC> registrosDiariosC = caetrdcRepo.getDiarioC(numerosDiarios);
                    List<CAETRHC> historicoConceptosNuevos = registrosDiariosC.stream()
                        .map(registroC -> mapHistoricoConcepto(registroC))
                        .collect(Collectors.toList());
                    //Obteniendo los registros a pasar de la CAETRDF 
                    List<CAETRDF> registrosDiariosF = caetrdfRepo.getDiarioF(numerosDiarios);
                    List<CAETRHF> historicoFuenteNuevos = registrosDiariosF.stream()
                    .map(registroF -> mapHistoricoFuente(registroF))
                    .collect(Collectors.toList());
                    // Insertar los registros en la base de datos
                    insertarLotes(historicoNuevos, 1000, caetrhRepo);
                    insertarLotes(historicoConceptosNuevos, 1000, caetrhcRepo);
                    insertarLotes(historicoFuenteNuevos, 1000, caetrhfRepo);
                }else{
                    logger.info("No hay movimientos diarios para la moneda " + moneda.getMONCOD());
                }
            }
        } catch (Exception exception) {
            throw new CustomizeException(
                    exception,
                    peticionBaseCierre,
                    "No se pudo realizar el movimiento de la tabla diaria al historico");
        }

        return true;
    }

    @Transactional
    public <T> boolean insertarLotes(List<T> registros, int batchSize, JpaRepository<T, ?> repository) {
        try {
            if (registros == null || registros.isEmpty()) {
                logger.info("No hay registros para insertar.");
                return false;
            }

            // Insertar los registros en lotes
            for (int i = 0; i < registros.size(); i += batchSize) {
                int end = Math.min(i + batchSize, registros.size());
                List<T> batch = registros.subList(i, end);
                repository.saveAll(batch);  // Guarda el lote de registros
                repository.flush();         // Asegura que los cambios se persistan en la base de datos
            }

            logger.info("Registros insertados correctamente.");
            return true;
        } catch (Exception exception) {
            logger.error("Error al insertar los registros en lotes: ", exception);
            return false;
        }
    }

    public CAETRH mapToHistorico(CAETRD registroDiario, BigDecimal numeroCierre, String fechaCierre) {
        CAETRH historico = new CAETRH();

        historico.setTRHNUM(registroDiario.getTRDNUM());
        historico.setEMPNUM(registroDiario.getEMPNUM());
        historico.setSERNUM(registroDiario.getSERNUM());
        historico.setTRHID1(registroDiario.getTRDID1());
        historico.setTRHID2(registroDiario.getTRDID2());
        historico.setTRHID3(registroDiario.getTRDID3());
        historico.setTRHTIC(registroDiario.getTRDTIC());
        historico.setTRHSAV(registroDiario.getTRDSAV());
        historico.setTRHVAM(registroDiario.getTRDVAM());
        historico.setTRHPAM(registroDiario.getTRDPAM());
        historico.setTRHFEV(registroDiario.getTRDFEV());
        historico.setTRHCOM(registroDiario.getTRDCOM());
        historico.setTRHCAF(registroDiario.getTRDCAF());
        historico.setTRHCAH(registroDiario.getTRDCAH());
        historico.setTRHCAU(registroDiario.getTRDCAU());
        historico.setTRHPAN(registroDiario.getTRDPAN());
        historico.setTRHNOA(registroDiario.getTRDNOA());
        historico.setTRHIDC(registroDiario.getTRDIDC());
        historico.setTRHCCE(registroDiario.getTRDCCE());
        historico.setTRHIEN(registroDiario.getTRDIEN());
        historico.setTRHIED(registroDiario.getTRDIED());
        historico.setTRHREM(registroDiario.getTRDREM());
        historico.setTRHREA(registroDiario.getTRDREA());
        historico.setTRHREF(registroDiario.getTRDREF());
        historico.setTRHREH(registroDiario.getTRDREH());
        historico.setTRHVAC(registroDiario.getTRDVAC());
        historico.setTRHTAC(registroDiario.getTRDTAC());
        historico.setTRHINE(registroDiario.getTRDINE());
        historico.setTRHREE(registroDiario.getTRDREE());
        historico.setTRHREC(registroDiario.getTRDREC());
        historico.setTRHRECN(registroDiario.getTRDRECN());
        historico.setTRHRECB(registroDiario.getTRDRECB());
        historico.setTRHCAJ(registroDiario.getTRDCAJ());
        historico.setTRHRET(registroDiario.getTRDRET());
        historico.setTRHCIBS(registroDiario.getTRDCIBS());
        historico.setAGECOD(registroDiario.getAGECOD());
        historico.setTRHSUC(registroDiario.getTRDSUC());
        historico.setTRHMOC(registroDiario.getTRDMOC());
        historico.setTRHIDCON(registroDiario.getTRDIDCON());

        historico.setCIENUM(numeroCierre);
        historico.setTRHACF(fechaCierre);

        return historico;
    }

    public CAETRHC mapHistoricoConcepto(CAETRDC registroDiarioConcepto) {
        CAETRHC historicoConceptos = new CAETRHC();

        historicoConceptos.setTRHNUM(registroDiarioConcepto.getTRDNUM());
        historicoConceptos.setTRHCNU(registroDiarioConcepto.getTRDCNU());
        historicoConceptos.setTRHCMO(registroDiarioConcepto.getTRDCMO());
        historicoConceptos.setTRHCOP(registroDiarioConcepto.getTRDCOP());

        return historicoConceptos;
    }

    public CAETRHF mapHistoricoFuente(CAETRDF registroDiarioFuente) {
        CAETRHF historicoFuente = new CAETRHF();

        historicoFuente.setTRHNUM(registroDiarioFuente.getTRDNUM());
        historicoFuente.setTRHFDB(registroDiarioFuente.getTRDFFD());
        historicoFuente.setTRHFCB(registroDiarioFuente.getTRDFCB());
        historicoFuente.setTRHFMD(registroDiarioFuente.getTRDFMD());
        historicoFuente.setTRHFNP(registroDiarioFuente.getTRDFNP());

        return historicoFuente;
    }

    @Transactional
    public void eliminarDelDiario(List<CAETRD> transaccionesDiarias, PeticionBaseCierre peticionBaseCierre, List<CAEMON> monedasActivas) throws CustomizeException {
        try {
            //Ejemplo para eliminar diario
            logger.info("Inicio eliminar del diario.");
            
            logger.info("Recorre por moneda");
            for (CAEMON moneda : monedasActivas) {
                //Se omite la validación de los parámetros porque ya se realizó en el traslado del diario y no se hicieron modificaciones en este transcurso
                // Filtrar transacciones diarias por la moneda actual
                List<CAETRD> transaccionesPorMoneda = transaccionesDiarias.stream()
                    .filter(registro -> registro.getTRDREM().equals(moneda.getMONCOD()))
                    .collect(Collectors.toList());

                // Obtener los TRDNUM de las transacciones de esta moneda
                List<BigDecimal> numerosDiarios = transaccionesPorMoneda.stream()
                    .map(CAETRD::getTRDNUM)
                    .collect(Collectors.toList());
                
                if (numerosDiarios != null && !numerosDiarios.isEmpty()) {
                    logger.info("Lista de trdnum a eliminar: " + numerosDiarios);

                    List<CAETRDC> registrosDiariosC = caetrdcRepo.getDiarioC(numerosDiarios);
                    if (!registrosDiariosC.isEmpty()) {
                        caetrdcRepo.deleteAllInBatch(registrosDiariosC);
                        logger.info("Eliminados {} registros de CAETRDC para la moneda: {}", registrosDiariosC.size(), moneda.getMONCOD());
                    }
                    
                    caetrdRepo.deleteAllById(numerosDiarios);
                    logger.info("Eliminados {} registros de CAETRD para la moneda: {}", numerosDiarios.size(), moneda.getMONCOD());
                }else{
                    logger.info("No hay movimientos diarios a eliminar para la moneda " + moneda.getMONCOD());
                }
                
            }
        } catch (DataAccessException e) {
            throw new CustomizeException(
                    e,
                    peticionBaseCierre,
                    "No se pudo eliminar las transacciones de la tabla diaria");
        }
    }

}
