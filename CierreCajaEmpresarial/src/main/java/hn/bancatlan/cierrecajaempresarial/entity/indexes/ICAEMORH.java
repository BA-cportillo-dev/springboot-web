package hn.bancatlan.cierrecajaempresarial.entity.indexes;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ICAEMORH implements Serializable {
    private BigDecimal CIENUM;
    private BigDecimal MORHEMP;
    private BigDecimal MORHSER;
}