package hn.bancatlan.cierrecajaempresarial.utils.wsoracle_router;

import hn.bancatlan.cierrecajaempresarial.configuration.DbConfig;
import hn.bancatlan.cierrecajaempresarial.dto.consumos.requests.*;
import hn.bancatlan.cierrecajaempresarial.dto.consumos.responses.*;
import hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes.CustomizeException;
import hn.bancatlan.cierrecajaempresarial.utils.commons.ConstantValues;
import hn.bancatlan.cierrecajaempresarial.utils.commons.RestTemplateFunctions;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import org.springframework.web.client.RestClientException;

@Component
public class WSOracleRouter {
    
    @Autowired
    DbConfig config;
    
    @Autowired
    RestTemplateFunctions restTemplateFunctions;
    
    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(ConstantValues.getFormatoHora());

    public void getRegCierreDiario(PeticionBaseCierre peticionBaseCierre) throws CustomizeException {

        try {
            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();
            EstadoCierreOracleRequest estadoCierreOracleRequest = EstadoCierreOracleRequest
                    .builder()
                    .idCierre(ConstantValues.getIdCierre())
                    .build();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
            HttpEntity<EstadoCierreOracleRequest> requestHttpEntity = new HttpEntity<>(estadoCierreOracleRequest, headers);
            ResponseEntity<EstadoCierreOracleResponse> estadoCierre = restTemplate.exchange(
                    config.getUrlOracle() + "getCierreDiario",
                    HttpMethod.POST,
                    requestHttpEntity,
                    EstadoCierreOracleResponse.class);
            Optional.ofNullable(estadoCierre.getBody())
                    .ifPresent(body -> {
                        if (!estadoCierre.getBody().getCodigoRespuesta().equals("00")) {
                            peticionBaseCierre.setCodigoStatus("1999");
                        }
                    });

        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException e) {
            if (e.getMessage().contains("\"codigoRespuesta\":\"01\"")) {
                peticionBaseCierre.setCodigoStatus("5007");
            } else {
                throw new CustomizeException(
                        e,
                        peticionBaseCierre,
                        "Esta ocurriendo un error al momento de conectar con el calculo del estado");
            }
        }
    }

    public RegistarCierreDiarioResponse insertarDiario(
            Integer idEstado,
            PeticionBaseCierre peticionBaseCierre,
            Integer codigoError,
            Integer operacion) throws CustomizeException {

        try {
            
            RegistarCierreDiarioRequest registarCierre = RegistarCierreDiarioRequest
                    .builder()
                    .idCierre(ConstantValues.getIdCierre())
                    .idEstado(idEstado)
                    .idUsuario(peticionBaseCierre.getUsuarioEjecucionCierre())
                    .codigoError(codigoError)
                    .idOperacion(operacion)
                    .fechaUltimaEjecucion(peticionBaseCierre.getFechaProcesamientoCierre())
                    .horaInicio(peticionBaseCierre.getTiempoInicio().format(fomatter))
                    .horaFin("00:00:00")
                    .duracionEjecucion("N/D")
                    .build();

            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();
            return restTemplate.postForEntity(
                    config.getUrlOracle() + "insertRegistroCierre",
                    registarCierre,
                    RegistarCierreDiarioResponse.class).getBody();

        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException exception) {
            throw new CustomizeException(
                    exception,
                    peticionBaseCierre,
                    "El servicio de insercion en la tabla de diarios esta fallando");
        }

    }

    public RegistarCierreDiarioErrorResponse insertarError(
            PeticionBaseCierre peticionBaseCierre,
            String descripcion) throws CustomizeException {

        try {

            String fechaUltimaEjecucion = peticionBaseCierre.getFechaProcesamientoCierre();

            ErrorCierreRequest registarError = ErrorCierreRequest
                    .builder()
                    .idCierre(Integer.valueOf(peticionBaseCierre.getIdCierreDiario()))
                    .descripcion(descripcion)
                    .fecha(fechaUltimaEjecucion)
                    .build();

            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();
            return restTemplate.postForEntity(
                    config.getUrlOracle() + "insertError",
                    registarError,
                    RegistarCierreDiarioErrorResponse.class).getBody();

        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException exception) {
            throw new CustomizeException(
                    exception,
                    peticionBaseCierre,
                    "El servicio de insercion en la tabla de diarios esta fallando");
        }

    }

    public ObtenerPeticionCierreResponse getPeticionCierre() throws CustomizeException {

        try {

            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();
            ObtenerPeticionCierreRequest obtenerPeticionCierreRequest = ObtenerPeticionCierreRequest
                    .builder()
                    .idCierre(ConstantValues.getIdCierre().toString())
                    .build();
            ResponseEntity<ObtenerPeticionCierreResponse> informacionPeticionCierre = restTemplate.postForEntity(
                    config.getUrlOracle() + "getPeticion",
                    obtenerPeticionCierreRequest,
                    ObtenerPeticionCierreResponse.class
            );
            return informacionPeticionCierre.getBody();

        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException exception) {
            throw new CustomizeException(exception, new PeticionBaseCierre(), "Ocurrio un error al construir la peticion del cierre");
        }

    }

    public EstadoCierreResponse getEstadoCierre(PeticionBaseCierre peticionBaseCierre) throws CustomizeException {

        try {
            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();
            EstadoCierreRequest estadoCierreRequest = EstadoCierreRequest
                    .builder()
                    .idCierre(ConstantValues.getIdCierre())
                    .build();

            return restTemplate.postForEntity(
                    config.getUrlOracle() + "validarStatusCierre",
                    estadoCierreRequest,
                    EstadoCierreResponse.class).getBody();
        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException exception) {
            throw new CustomizeException(exception, peticionBaseCierre, "El servicio de obtener estado cierre esta fallando");
        }

    }

    public UpdateDiarioResponse updateDiario(
            PeticionBaseCierre peticionBaseCierre,
            Integer codigoError,
            Integer idEstado) throws CustomizeException {

        try {

            LocalTime horaFin = LocalTime.parse(new SimpleDateFormat(ConstantValues.getFormatoHora()).format(new Date()));
            String duracionEjecucion = String.valueOf(Duration.between(peticionBaseCierre.getTiempoInicio(), horaFin).getSeconds());
            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();

            UpdateDiarioRequest updateDiarioRequest = UpdateDiarioRequest
                    .builder()
                    .idCierre(Integer.valueOf(peticionBaseCierre.getIdCierreDiario()))
                    .estado(idEstado)
                    .codigoError(codigoError)
                    .horaFin(horaFin.format(fomatter))
                    .duracionEjecucion(duracionEjecucion)
                    .build();

            return restTemplate.postForEntity(config.getUrlOracle() + "updateRegistroCierre",
                    updateDiarioRequest,
                    UpdateDiarioResponse.class).getBody();

        } catch (NumberFormatException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException exception) {
            throw new CustomizeException(
                    exception,
                    peticionBaseCierre,
                    "Servicio de actualizacion de cierre esta arrojando error");
        }
    }

    public ErrorControladoResponse getErrorControlado(PeticionBaseCierre peticionBaseCierre) throws CustomizeException {
        try {

            ErrorControladoRequest requestErrorControlado = ErrorControladoRequest
                    .builder()
                    .idCodigo(Integer.valueOf(peticionBaseCierre.getCodigoStatus()))
                    .build();

            RestTemplate restTemplate = restTemplateFunctions.getRestTemplate();
            return restTemplate.postForEntity(
                    config.getUrlOracle() + "getErrorControlado",
                    requestErrorControlado,
                    ErrorControladoResponse.class).getBody();

        } catch (NumberFormatException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | RestClientException exception) {
            throw new CustomizeException(exception, peticionBaseCierre, "El servicio de obtencion de errores controladores esta fallando");
        }
    }

}
