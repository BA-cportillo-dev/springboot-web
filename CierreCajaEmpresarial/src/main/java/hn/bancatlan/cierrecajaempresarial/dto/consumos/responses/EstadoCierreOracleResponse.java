package hn.bancatlan.cierrecajaempresarial.dto.consumos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCierreOracleResponse {

    String valido;
    String descripcion;
    String codigoPeticion;
    String codigoRespuesta;

}
