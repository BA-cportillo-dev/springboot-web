package hn.bancatlan.cierrecajaempresarial.utils.commons;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.bancatlan.cierrecajaempresarial.entity.CAECIE;
import hn.bancatlan.cierrecajaempresarial.repository.CAECIERepo;

@Component
public class UtilidadesGenerales {

    @Autowired
    CAECIERepo caecieRepo;

    public String fechaActual() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.now().format(formatoFecha);
    }

    public String horaActual() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.now().format(formatoHora);
    }

    public String truncate(String value, int maxLength) {
        if (value != null && value.length() > maxLength) {
            return value.substring(0, maxLength);
        }
        return value;
    }

    public void actualizarCierre(Optional<CAECIE> cierreUdp, BigDecimal totalRegistradoLPS, BigDecimal totalOperaciones, BigDecimal cierrePorcentaje){
        if (cierreUdp.isPresent()) {
            CAECIE cierreDB = cierreUdp.get();
            cierreDB.setCIETOR(totalRegistradoLPS);
            cierreDB.setCIETOO(totalOperaciones);
            cierreDB.setCIEPOC(cierrePorcentaje);
            caecieRepo.saveAndFlush(cierreDB);
        }
    }
}
