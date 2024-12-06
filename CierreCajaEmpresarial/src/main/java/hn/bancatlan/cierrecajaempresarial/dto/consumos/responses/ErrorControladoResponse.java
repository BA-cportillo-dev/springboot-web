package hn.bancatlan.cierrecajaempresarial.dto.consumos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorControladoResponse {

    Integer idError;
    String descripcion;
    String codigoPeticion;
    String codigoRespuesta;
    String descripcionTecnica;

}
