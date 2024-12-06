package hn.bancatlan.cierrecajaempresarial.entity.indexes;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;

@Data
public class ICTRLCTA implements Serializable {

    BigDecimal codigoAplicacion;
    BigDecimal tipoCuenta;
}
