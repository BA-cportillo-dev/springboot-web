package hn.bancatlan.cierrecajaempresarial.utils.commons;

import hn.bancatlan.cierrecajaempresarial.dto.consumos.responses.ErrorControladoResponse;
import hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes.CustomizeException;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.responses_cierre.ResponseBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.wsoracle_router.WSOracleRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UtilResponses {

    @Autowired
    WSOracleRouter wsOracleRouter;

    public ResponseEntity<ResponseBaseCierre> generarRespuesta(PeticionBaseCierre peticionBaseCierre) throws CustomizeException {

        if (peticionBaseCierre != null) {
            Integer idEstado = peticionBaseCierre.getCodigoStatus().equals("0") ? 1 : 2;
            wsOracleRouter.updateDiario(peticionBaseCierre, 0, idEstado);
            ErrorControladoResponse errorControladoResponse = wsOracleRouter.getErrorControlado(peticionBaseCierre);
            return ResponseEntity.status(200)
                    .body(ResponseBaseCierre
                            .builder()
                            .codigoPeticionUnica(UUID.randomUUID().toString())
                            .codigoRespuesta(errorControladoResponse.getIdError().toString().equals("0") ? "00" : errorControladoResponse.getIdError().toString())
                            .descripcion(errorControladoResponse.getDescripcion())
                            .detalleTecnico(errorControladoResponse.getDescripcionTecnica())
                            .ejecucionExitosa(peticionBaseCierre.getCodigoStatus().equals("0"))
                            .accion(String.valueOf(peticionBaseCierre.getPeticionEspecificaCierre().getAccion()))
                            .totalRecaudo(peticionBaseCierre.getInfoResponse().getMontoTotal())
                            .totalComision(peticionBaseCierre.getInfoResponse().getComisionTotal())
                            .totalTransacciones(peticionBaseCierre.getInfoResponse().getTotalTransacciones())
                            .build());
        } else {
            return ResponseEntity.status(404)
                    .body(ResponseBaseCierre
                            .builder()
                            .codigoPeticionUnica(UUID.randomUUID().toString())
                            .codigoRespuesta("99")
                            .descripcion("Error al armar la petición")
                            .detalleTecnico("Error al procesar el cierre al no poder armar la petición desde la BD")
                            .ejecucionExitosa(false)
                            .parametroAdicional(null)
                            .build());
        }

    }

    public ResponseEntity<ResponseBaseCierre> generarRespuesta(CustomizeException exception) {
        if (exception.getPeticionBaseCierre().getCodigoStatus().equals("1002")) {
            return ResponseEntity.status(200)
                    .body(ResponseBaseCierre
                            .builder()
                            .codigoPeticionUnica(UUID.randomUUID().toString())
                            .codigoRespuesta("00")
                            .descripcion(exception.getMensajePersonalizado())
                            .detalleTecnico(exception.getException().getMessage())
                            .ejecucionExitosa(false)
                            .build());
        } else {
            return ResponseEntity.status(400)
                    .body(ResponseBaseCierre
                            .builder()
                            .codigoPeticionUnica(UUID.randomUUID().toString())
                            .codigoRespuesta("99")
                            .descripcion(exception.getMensajePersonalizado())
                            .detalleTecnico(exception.getException().getMessage())
                            .ejecucionExitosa(false)
                            .build());
        }
    }

    public ResponseEntity<ResponseBaseCierre> generarRespuesta(Exception exception) {
        return ResponseEntity.status(406)
                .body(ResponseBaseCierre
                        .builder()
                        .codigoPeticionUnica(UUID.randomUUID().toString())
                        .codigoRespuesta("99")
                        .descripcion(exception.getMessage())
                        .detalleTecnico(exception.getMessage())
                        .ejecucionExitosa(false)
                        .build());

    }

}
