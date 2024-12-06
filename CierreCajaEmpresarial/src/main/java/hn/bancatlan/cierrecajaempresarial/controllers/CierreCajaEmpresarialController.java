package hn.bancatlan.cierrecajaempresarial.controllers;

import hn.bancatlan.cierrecajaempresarial.exception_handlers.exception_classes.CustomizeException;
import hn.bancatlan.cierrecajaempresarial.services.CierreCajaEmpresarialService;
import hn.bancatlan.cierrecajaempresarial.utils.commons.ConstantValues;
import hn.bancatlan.cierrecajaempresarial.utils.commons.GestionCierre;
import hn.bancatlan.cierrecajaempresarial.utils.commons.UtilResponses;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionCierreManual;
import hn.bancatlan.cierrecajaempresarial.utils.responses_cierre.ResponseBaseCierre;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;

@Validated
@RestController
@RequestMapping()
public class CierreCajaEmpresarialController {

    @Autowired
    CierreCajaEmpresarialService cierreContableService;

    @Autowired
    GestionCierre gestionCierre;

    @Autowired
    UtilResponses utilResponses;

    String nombreCierre = "CierreCajaEmpresarial";

    private static final Logger logger = LoggerFactory.getLogger(CierreCajaEmpresarialController.class);

    @GetMapping("/ping")
    public ResponseEntity<String> servicioActivo() {
        return new ResponseEntity<>(nombreCierre, HttpStatus.OK);
    }

    //Creación de ENDPOINTS para ejecutar el cierre (llamado a los métodos del CierreCajaEmpresarialService):
    //ENDPOINT Ejecución Automática:
    @PostMapping(value = "ejecucionAutomaticaCierreCajaEmpresarial", produces = {"application/json", "text/xml"})
    public ResponseEntity<ResponseBaseCierre> ejecucionAutoCierreCajaEmpresarial(HttpServletRequest request)
            throws CustomizeException, ParseException {

        Integer idOperacion = 7;

        logger.info("Inicio el cierre automático");
        
        LocalTime horaInicio = LocalTime.parse(new SimpleDateFormat(ConstantValues.getFormatoHora()).format(new Date()));
        PeticionBaseCierre peticionBaseCierreAutomatico = gestionCierre.generarPeticionCierre(
                "",
                "",
                "",
                horaInicio,
                idOperacion);
        
        String msg = "Peticion del Cierre Automático:" +  peticionBaseCierreAutomatico.toString();
        logger.info(msg);
        cierreContableService.ejecutarCierre(peticionBaseCierreAutomatico, idOperacion);
        logger.info("El cierre esta finalizando");
        return utilResponses.generarRespuesta(peticionBaseCierreAutomatico);

    }

    //ENDPOINT Ejecución Manual:
    @PostMapping(value = "ejecucionManualCierreCajaEmpresarial", produces = {"application/json", "text/xml"}, consumes = "application/json")
    public ResponseEntity<ResponseBaseCierre> ejecucionManualCierreCajaEmpresarial(
            @RequestBody PeticionCierreManual peticionCierreManual,
            HttpServletRequest request
    ) throws ParseException, CustomizeException {

        Integer idOperacion = 6;

        logger.info("Inicio el cierre manual");
        LocalTime horaInicio = LocalTime.parse(new SimpleDateFormat(ConstantValues.getFormatoHora()).format(new Date()));
        PeticionBaseCierre peticionBaseCierreManual = gestionCierre.generarPeticionCierre(
                peticionCierreManual.getUsuario(),
                peticionCierreManual.getIpUsuario(),
                peticionCierreManual.getFechaExeCierre(),
                horaInicio,
                idOperacion);

        String msg = "Peticion del Cierre Manual:" +  peticionBaseCierreManual.toString();
        logger.info(msg);
        cierreContableService.ejecutarCierre(peticionBaseCierreManual, idOperacion);
        logger.info("El cierre esta finalizando");
        return utilResponses.generarRespuesta(peticionBaseCierreManual);

    }

}
