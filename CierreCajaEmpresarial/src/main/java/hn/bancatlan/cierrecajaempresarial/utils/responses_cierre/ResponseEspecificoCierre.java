package hn.bancatlan.cierrecajaempresarial.utils.responses_cierre;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseEspecificoCierre extends ResponseBaseCierre {

    public ResponseEspecificoCierre(
            String codigoPeticionUnica,
            String codigoRespuesta,
            String descripcion,
            String detalleTecnico,
            String accion,
            boolean ejecucionExitosa,
            List<?> parametroAdicional
    ) {
        super(codigoPeticionUnica, codigoRespuesta, descripcion,
                detalleTecnico, accion, ejecucionExitosa,
                null, null, 0, parametroAdicional);
    }

}
