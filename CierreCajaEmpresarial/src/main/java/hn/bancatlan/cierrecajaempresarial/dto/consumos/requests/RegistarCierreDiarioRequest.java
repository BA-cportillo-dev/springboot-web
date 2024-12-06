package hn.bancatlan.cierrecajaempresarial.dto.consumos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistarCierreDiarioRequest {

    Integer idCierre;
    Integer idEstado;
    String idUsuario;
    Integer codigoError;
    String horaInicio;
    String horaFin;
    Integer idOperacion;
    String duracionEjecucion;
    String fechaUltimaEjecucion;

}
