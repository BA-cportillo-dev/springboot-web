package hn.bancatlan.cierrecajaempresarial.dto.consumos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDiarioRequest {

    Integer estado;
    String horaFin;
    Integer idCierre;
    Integer codigoError;
    String duracionEjecucion;

}
