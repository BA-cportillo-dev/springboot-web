package hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes;

import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import lombok.Data;

@Data
public class CustomizeException extends Exception {

    final Exception exception;
    final String mensajePersonalizado;
    final transient PeticionBaseCierre peticionBaseCierre;

    public CustomizeException(
            Exception exception,
            PeticionBaseCierre peticionBaseCierre,
            String mensajePersonalizado) {

        this.exception = exception;
        this.peticionBaseCierre = peticionBaseCierre;
        this.mensajePersonalizado = mensajePersonalizado;

    }

}
