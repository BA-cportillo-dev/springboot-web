package hn.bancatlan.cierrecajaempresarial.dto.consumos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCierreResponse {

    String codigoPeticion;
    String codigoRespuesta;
    String descripcion;
    String valido;

}