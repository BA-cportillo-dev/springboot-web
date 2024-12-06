package hn.bancatlan.cierrecajaempresarial.entity.indexes;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ICAEMORD implements Serializable {
    private BigDecimal CIENUM;
    private BigDecimal MORDEMP;
    private BigDecimal MORDSER;
}
