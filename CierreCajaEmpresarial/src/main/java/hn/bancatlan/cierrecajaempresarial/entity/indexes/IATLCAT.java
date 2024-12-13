package hn.bancatlan.cierrecajaempresarial.entity.indexes;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class IATLCAT implements Serializable {
    private BigDecimal CATCOD;
    private String CATTIP;
    private String CATVAL;
}
