package hn.bancatlan.cierrecajaempresarial.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.bancatlan.cierrecajaempresarial.dto.ServicioEmpresaDTO;
import hn.bancatlan.cierrecajaempresarial.entity.CAESCU;
import hn.bancatlan.cierrecajaempresarial.entity.CAETRD;
import hn.bancatlan.cierrecajaempresarial.entity.CTRLCTA;
import hn.bancatlan.cierrecajaempresarial.repository.CAESCURepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAESERRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CTRLCTARepo;
import hn.bancatlan.cierrecajaempresarial.utils.commons.GestionCierre;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;

@Service
public class ProcesarMonedaService {

    @Autowired
    CTRLCTARepo ctrlctaRepo;

    @Autowired
    CAESERRepo caeserRepo;

    @Autowired
    BitacoraService bitacoraService;

    @Autowired
    CAESCURepo caescuRepo;

    private static final Logger logger = LoggerFactory.getLogger(GestionCierre.class);

    private BigDecimal totalRecaudadoMoneda;
    private BigDecimal totalTransaccionesRegistradas;
    private BigDecimal totalRecaudadoMonedaLocal;
    
    public boolean procesarMoneda(PeticionBaseCierre peticionBaseCierre, String codigoMoneda, List<CAETRD> transaccionesDiarias){
        //1 setea &Tipo = 1 sí es LPS o 2 en otro caso
        BigDecimal tipo =  "LPS".equals(codigoMoneda) ? BigDecimal.valueOf(1) : BigDecimal.valueOf(2);
        
        //2 Busca en la SRVDTA.CTRLCTA por CTRLAPL y &Tipo y setea varias variables
        CTRLCTA cuentasContabilidad = null;

        Optional<CTRLCTA> optinalCuentas = ctrlctaRepo.getCuentasCierre(new BigDecimal(peticionBaseCierre.getCodigoAplicacion()), tipo);
        if (optinalCuentas.isPresent()) {
            cuentasContabilidad = optinalCuentas.get();
            logger.info("Cuentas Contables: " + cuentasContabilidad);
        }else{
            logger.info("No se encontraron cuentas contables para la moneda: " + codigoMoneda);
            return false;
        }
        //3Recorre la CAEDTA.CAESER con un Join con la CAEEMP. (Aquí propongo recorrer sólo los servicios que están en el Diario y no todas).

        //Obteniendo los sevicios del diario:
        List<ServicioEmpresaDTO> serviciosRecorrer = mapearServicios(caeserRepo.getServiciosEmpresas(peticionBaseCierre.getPeticionEspecificaCierre().getFechaCierre()));

        for (ServicioEmpresaDTO servicio : serviciosRecorrer) {

            logger.info("Servicio a recorrer: " + servicio.getEMPNUM() + " " + servicio.getSERNUM());
            //4 Setea variables del servicio que será procesado y setea en 0 variables de cálculo.
            totalRecaudadoMoneda = BigDecimal.ZERO;
            totalRecaudadoMonedaLocal = BigDecimal.ZERO;
            totalTransaccionesRegistradas = BigDecimal.ZERO;
            
            //5 crea la descripción de auditoría que enviará para hacer los movimientos contables.
            //Acreditar lo recaudado a la Empresa
            String auditDescripcion = "CajaEmp-CRSer;" + servicio.getEMPDES().trim() + ";" + servicio.getSERNUM() + ";" + servicio.getSERDES().trim();
            //6 Llama al programa PCAEPRCNF que se encarga de acreditar lo recaudado a la empresa (Esta lógica se trabajará después.)
            logger.info("PCAEPRCNF: " + auditDescripcion);
            boolean respuestaPCAEPRCNF = true;
            //7 Evalúa sí la respuesta es exitosa, sí no, registra el error en la caebit y finaliza el proceso.
            if (!respuestaPCAEPRCNF) {
                logger.error("99", "Problemas al procesar los recaudos, consulte el administrador de sistema.");
                bitacoraService.insertarEnBitacora("Problemas al procesar los recaudos, consulte el administrador de sistema", "ERRORFATAL");
                return false;
            }

            //8 Llama al programa PCAEOCS para obtener las cuentas de débito y crédito
            BigDecimal servicioCuentaDebito = BigDecimal.ZERO;
            BigDecimal servicioCuentaCredito = BigDecimal.ZERO;
            String servicioTipoCuentaDebito = "";
            String servicioTipoCuentaCredito = "";
            
            Optional<CAESCU> optionalCuentas = caescuRepo.getSucursal(servicio.getEMPNUM(), servicio.getSERNUM(), codigoMoneda);

            if (optionalCuentas.isPresent()) {
                CAESCU cuenta = optionalCuentas.get();
                servicioCuentaDebito = cuenta.getSCUCUD();
                servicioCuentaCredito = cuenta.getSCUCUC();
                servicioTipoCuentaDebito = cuenta.getSCUCDT();
                servicioTipoCuentaCredito = cuenta.getSCUCCT();

                logger.info("Cuentas para el servicio: " + cuenta);
            }else{
                logger.info("No se encontraron cuentas para: " + servicio.getEMPDES() + " " + servicio.getSERNUM() + " en moneda: " + codigoMoneda);
            }

            //9 Setea la descripción para el cobro de comisión
            auditDescripcion = "CajaEmp-DBSer;" + servicio.getEMPDES() + ";" + servicio.getSERNUM() + ";" + servicio.getSERDES();
            
            //10 hace el llamado al programa PCAEOTESF que calcula los totales del servicio.

            // Filtrar transacciones del diario para el servicio y empresa actual
            List<CAETRD> transaccionesFiltradas = transaccionesDiarias.stream()
                .filter(transaccion -> transaccion.getEMPNUM().equals(servicio.getEMPNUM()) && transaccion.getSERNUM().equals(servicio.getSERNUM()) && transaccion.getTRDREM().equals(codigoMoneda))
                .collect(Collectors.toList());
            
            for (CAETRD transaccion : transaccionesFiltradas) {
                totalRecaudadoMoneda = totalRecaudadoMoneda.add(transaccion.getTRDRET());
                totalRecaudadoMonedaLocal = totalRecaudadoMonedaLocal.add(transaccion.getTRDRET()).multiply(transaccion.getTRDTAC());
                totalTransaccionesRegistradas = totalTransaccionesRegistradas.add(BigDecimal.ONE);
            }
            logger.info("Empresa: "+ servicio.getEMPNUM() +" Servicio: "+ servicio.getSERNUM() +" totalRecaudado: " + totalRecaudadoMoneda + " TotalMoneda: " + totalRecaudadoMonedaLocal + " #transacciones: " + totalTransaccionesRegistradas);
        }
        //11 hace el llamado al programa PCaEGCom que calcula la comisión.
        //12 Evalúa sí la comisión es > 0, sí no, sólo registra en la bitácora las comisiones en 0. //Este registro lo mantendría sí solo recorro lo necesario, lo eliminaría sí tengo que recorrer todos los servicios por empresa.
        //13 Evalúa con cases la &sCUCDT y setea cuenta y otras variables, el otherwise evalúa la respuesta de un 03
        //14 setea más variables.
        //15 valida la cuenta de débito con el 03 y sí la respuesta es 00 setea la MonDeb
        //16 Setea más variables
        //17 Cambio CAEMOR para buscar por empresa, servicio y moneda y aumenta el monto a cobrar.
        //18 Ejecuta el cobro de la comisión con el 001
        //19 evalúa la respuesta del 001 y sí es 00 ejecuta Dis-Agencia la cuál se realizará el análisis posteriormente.
        //20 Elimina los registros que se cobraron de la CAEMOR
        //21 Evalúa si la &banDeuda es 0 ejecuta normalmente el Dis-Agencia sí no:
        //22 Sí el cobro fue con mora, ejecuta el 006 con la sucursal 7500
        //23 Sí el 001 da error, registra el error contable en la CAEBIT
        //24 Registra el error en el cobro de la comisión en la CAEBMN
        //25 Registra en la CAEMOR el pago pendiente de comisión.
        //26 Crea el registro en la CAECSM y suma los montos.

        return true;
    }

    public List<ServicioEmpresaDTO> mapearServicios(List<Object[]> resultados) {
        return resultados.stream().map(fila -> {
            ServicioEmpresaDTO dto = new ServicioEmpresaDTO();
            dto.setEMPNUM((BigDecimal) fila[0]);
            dto.setSERNUM((BigDecimal) fila[1]);
            dto.setSERDES(fila[2] != null ? fila[2].toString() : null);
            dto.setEMPDES(fila[3] != null ? fila[3].toString() : null);
            dto.setEMPEST(fila[4] != null ? fila[4].toString() : null);
            dto.setSEREST(fila[5] != null ? fila[5].toString() : null);
            dto.setSERCFR((BigDecimal) fila[6]);
            return dto;
        }).collect(Collectors.toList());
    }

    
}
