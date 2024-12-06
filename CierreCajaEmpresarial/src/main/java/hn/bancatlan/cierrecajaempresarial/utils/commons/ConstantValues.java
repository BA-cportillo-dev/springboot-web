package hn.bancatlan.cierrecajaempresarial.utils.commons;

//Declara constantes utilizadas en el proyecto

public class ConstantValues {

    private ConstantValues() {
    }

    private static final Integer ID_CIERRE = 24; //CAMBIAR A NUMERO DE CIERRE
    private static final String CODIGO_RESPUESTA = "codigoRespuesta";
    private static final String LITERAL_FALSE = "false";
    private static final String FORMATO_HORA = "HH:mm:ss";

    public static String getCodigoRespuesta() {
        return CODIGO_RESPUESTA;
    }

    public static Integer getIdCierre() {
        return ID_CIERRE;
    }

    public static String getLiteralFalse() {
        return LITERAL_FALSE;
    }

    public static String getFormatoHora() {
        return FORMATO_HORA;
    }

}
