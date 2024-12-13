package hn.bancatlan.cierrecajaempresarial.services;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.bancatlan.cierrecajaempresarial.repository.CAEBITRepo;
import hn.bancatlan.cierrecajaempresarial.entity.CAEBIT;
import hn.bancatlan.cierrecajaempresarial.utils.commons.UtilidadesGenerales;

@Service
public class BitacoraService {
    @Autowired
    private CAEBITRepo caeBitRepo;

    @Autowired
    private UtilidadesGenerales utilidadesGenerales;

    private static final Logger logger = LoggerFactory.getLogger(BitacoraService.class);

    @Transactional
    public boolean insertarEnBitacora(String detalle, String impacto) {
        try {
            detalle = utilidadesGenerales.truncate(detalle, 100);
            impacto = utilidadesGenerales.truncate(impacto, 10);
            //Obtener el máximo Bitnum y sumarle uno
            BigDecimal nuevo = caeBitRepo.getUltimoRegistro();
            nuevo = nuevo.add(BigDecimal.ONE);
            //Crear guardar el nuevo registro en la caebit
            CAEBIT bitacora = new CAEBIT(nuevo, detalle, utilidadesGenerales.fechaActual(), utilidadesGenerales.horaActual(), impacto);
            caeBitRepo.save(bitacora);

            caeBitRepo.flush();
            return true;
        } catch (Exception e) {
            logger.info("Error al insertar en la CAEBIT: "  + e.getMessage());
            return false;
        }
    }
}
