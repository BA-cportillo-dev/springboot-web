package hn.bancatlan.cierrecajaempresarial.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEmpresaDTO {
    private BigDecimal EMPNUM;
    private BigDecimal SERNUM;
    private String SERDES;
    private String EMPDES;
    private String EMPEST;
    private String SEREST;
    private BigDecimal SERCFR;
}
