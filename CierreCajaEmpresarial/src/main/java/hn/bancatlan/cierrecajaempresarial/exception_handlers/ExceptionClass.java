package hn.bancatlan.cierrecajaempresarial.exception_handlers;

import hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes.CustomizeException;
import hn.bancatlan.cierrecajaempresarial.utils.commons.UtilResponses;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.responses_cierre.ResponseBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.wsoracle_router.WSOracleRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionClass {

    @Autowired
    UtilResponses utilResponses;
    @Autowired
    WSOracleRouter wsOracleRouter;
    private static final Logger logger = LoggerFactory.getLogger(ExceptionClass.class);

    @ExceptionHandler(CustomizeException.class)
    public ResponseEntity<ResponseBaseCierre> controlExcepciones(CustomizeException customizeException) throws CustomizeException {

        logger.info("Se genero una excepcion costruyendo la respuesta");
        PeticionBaseCierre peticionBaseCierre = customizeException.getPeticionBaseCierre();
        if (peticionBaseCierre != null) {
            wsOracleRouter.updateDiario(peticionBaseCierre, 0, 2);
        }
        return utilResponses.generarRespuesta(customizeException);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBaseCierre> controlExcepciones(Exception exception) {

        logger.info("Se genero una excepcion costruyendo la respuesta");
        return utilResponses.generarRespuesta(exception);

    }

}
