package hn.bancatlan.cierrecajaempresarial.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.bancatlan.cierrecajaempresarial.entity.CAESER;
import hn.bancatlan.cierrecajaempresarial.entity.CAESERC;
import hn.bancatlan.cierrecajaempresarial.repository.CAESERCRepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAESERRepo;
import hn.bancatlan.cierrecajaempresarial.utils.commons.GestionCierre;


@Service
public class calculaComisionService {

    @Autowired
    CAESERRepo caeserRepo;

    @Autowired
    CAESERCRepo caeserCRepo;

    @Autowired
    BitacoraService bitacoraService;

    private static final Logger logger = LoggerFactory.getLogger(GestionCierre.class);

    private BigDecimal totalComisionMonedaLocal = BigDecimal.ZERO;
    private CAESER servicio = null;
    
    public BigDecimal getComision(BigDecimal numeroEmpresa, BigDecimal numeroServicio, BigDecimal totalRecaudado, BigDecimal totalTransacciones){
        //1.Setea variables iniciales
        BigDecimal error = BigDecimal.ZERO;
        String detalleBitacora = "";
        String detalleBitacora2 = "";
        String tipoComision = "";
        BigDecimal porcentaje = BigDecimal.ZERO;
        BigDecimal montoPorTrn = BigDecimal.ZERO;

        tipoComision = caeserRepo.findTICCODByEMPNUMAndSERNUM(numeroEmpresa, numeroServicio);
            
        List<CAESERC> servicioComision = caeserCRepo.getServicios(numeroEmpresa, numeroServicio);

        //3Setea otras variables para la descripción en bitácora y el tipo comisión.
        detalleBitacora2 = numeroEmpresa + "- " + numeroServicio;
        tipoComision = servicio.getTICCOD();

        if (!servicioComision.isEmpty()) {
            for (CAESERC servicioCriterio : servicioComision) {
                BigDecimal montoMinimo = BigDecimal.ZERO;
                BigDecimal montoMaximo = BigDecimal.ZERO;

                montoMinimo = servicioCriterio.getSECMOC();
                montoMaximo = servicioCriterio.getSECMOF();

                if ((totalRecaudado.compareTo(montoMinimo) >= 1) && (totalRecaudado.compareTo(montoMaximo) <= -1)) {
                    porcentaje = servicioCriterio.getSECPOR();
                    montoPorTrn = servicioCriterio.getSECMON();
                    logger.info("Seleccionó Criterio: " + servicioCriterio.getSECCRN());
                }else if ((totalRecaudado.compareTo(montoMinimo) >= 1) && (montoMaximo.compareTo(BigDecimal.ZERO) == 0)) {
                    porcentaje = servicioCriterio.getSECPOR();
                    montoPorTrn = servicioCriterio.getSECMON();
                    logger.info("Seleccionó Criterio: " + servicioCriterio.getSECCRN());
                    break;
                }
            }
        }else{
            detalleBitacora = "No se encontraron criterios de comision para: " + numeroEmpresa + "- " + numeroServicio;
        }
        
        //4Realiza un switch case según el tipo de comisión:
        switch (tipoComision) {
            case "S%ST":
                if (porcentaje.compareTo(BigDecimal.ZERO) <= -1) {
                    detalleBitacora = detalleBitacora + "E:" + numeroEmpresa + "S:" + numeroServicio + "; %02 = " + porcentaje;
                    bitacoraService.insertarEnBitacora(detalleBitacora, "ADV");
                }

                totalComisionMonedaLocal = totalRecaudado.multiply(porcentaje).setScale(2, RoundingMode.HALF_UP);
                logger.info("calculada: " + totalRecaudado + "*" + porcentaje + "=" + totalComisionMonedaLocal);
                break;
            case "SMST":
                if (montoPorTrn.compareTo(BigDecimal.ZERO) <= -1) {
                    detalleBitacora = detalleBitacora + "E:" + numeroEmpresa + "S:" + numeroServicio + "; %M02 = " + montoPorTrn;
                    bitacoraService.insertarEnBitacora(detalleBitacora, "ADV");
                    totalComisionMonedaLocal = totalTransacciones.multiply(montoPorTrn).setScale(2, RoundingMode.HALF_UP);
                    logger.info("calculada: " + totalTransacciones + "*" + montoPorTrn + "=" + totalComisionMonedaLocal);
                }
                break;
            default:
                error = BigDecimal.ONE;
                detalleBitacora2 = detalleBitacora2 + "_E: COMISIÓN no definida o SIN Comisión";
                break;
        }
        
        
        //14 evalúa sí la comisión <= 0 guarda detalle bitácora y suma al error.
        //15 sí el error es distinto a 0:
        //16 guarda en la bitácora el &BitDet2
        return totalComisionMonedaLocal;
    }
}
