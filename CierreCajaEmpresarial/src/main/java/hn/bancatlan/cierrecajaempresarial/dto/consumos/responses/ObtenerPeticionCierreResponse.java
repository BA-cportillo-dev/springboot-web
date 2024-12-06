package hn.bancatlan.cierrecajaempresarial.dto.consumos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObtenerPeticionCierreResponse {

    String codigoPeticion;
    String codigoRespuesta;
    String descripcion;
    String usuario;
    String transaccion;
    String codigoAplicacion;
    String empresa;
    String institucion;
    String pais;
    String region;
    String banco;
    String coreBanking;
    String agencia;
    String sucursal;
    String canal;
    String usuarioPeticion;
    String direccionIP;
    Integer indicadorFecha;

}
