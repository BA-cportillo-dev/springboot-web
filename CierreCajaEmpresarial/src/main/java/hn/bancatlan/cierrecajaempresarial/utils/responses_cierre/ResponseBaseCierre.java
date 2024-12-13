package hn.bancatlan.cierrecajaempresarial.utils.responses_cierre;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBaseCierre {

    String codigoPeticionUnica;
    String codigoRespuesta;
    String descripcion;
    String detalleTecnico;
    String accion;
    boolean ejecucionExitosa;
    BigDecimal totalRecaudo;
    BigDecimal totalComision;
    int totalTransacciones;
    List<?> parametroAdicional;
}
