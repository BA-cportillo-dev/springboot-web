package hn.bancatlan.cierrecajaempresarial.entity.indexes;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ICAEBMN implements Serializable {
    private BigDecimal CIENUM;
    private BigDecimal EMPNUM;
    private BigDecimal SERNUM;
    private BigDecimal BMNCOR;
}
