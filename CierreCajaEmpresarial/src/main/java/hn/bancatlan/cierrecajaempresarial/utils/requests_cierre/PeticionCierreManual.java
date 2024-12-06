package hn.bancatlan.cierrecajaempresarial.utils.requests_cierre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeticionCierreManual {

    String usuario;
    String ipUsuario;
    String fechaExeCierre;
}
