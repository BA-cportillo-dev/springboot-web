package hn.bancatlan.cierrecajaempresarial.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hn.bancatlan.cierrecajaempresarial.entity.CAECIE;
import hn.bancatlan.cierrecajaempresarial.entity.CAEPAR;
import hn.bancatlan.cierrecajaempresarial.repository.CAECIERepo;
import hn.bancatlan.cierrecajaempresarial.repository.CAEPARRepo;
import hn.bancatlan.cierrecajaempresarial.utils.commons.GestionCierre;
import hn.bancatlan.cierrecajaempresarial.utils.commons.UtilidadesGenerales;

@Service
public class CreaCierreService {
    @Autowired
    private CAECIERepo caeCieRepo;

    @Autowired
    private CAEPARRepo caeparRepo;

    @Autowired
    private GestionCierre gestionCierre;

    @Autowired
    private UtilidadesGenerales utilidadesGenerales;

    @Autowired
    BitacoraService bitacoraService;

    @Transactional
    public BigDecimal numeroCierre(CAEPAR parametros, String usuarioEjecucion , String fechaCierre){

        if (parametros != null) {
            if (parametros.getPARHOY() == null || parametros.getPARHOY().isEmpty() || !parametros.getPARHOY().equals(utilidadesGenerales.fechaActual())) {
                actualizarParametros(parametros);
            }

            // Incrementar el contador
            parametros.setPARHCC(parametros.getPARHCC().add(BigDecimal.ONE));

            // Guardar cambios en la base de datos
            parametros = caeparRepo.save(parametros);
        } else {
            // Crear nuevos parámetros si no existen
            parametros = crearNuevoParametro();
            caeparRepo.saveAndFlush(parametros);
        }

        BigDecimal numeroCierre = generaNumeroCierre(parametros);
        return creaCierre(numeroCierre, usuarioEjecucion, fechaCierre);
    }

    private void actualizarParametros(CAEPAR parametros) {
        String fechaHoy = utilidadesGenerales.fechaActual();
        BigDecimal diaJuliano = new BigDecimal(LocalDate.now().getDayOfYear());

        parametros.setPARHOY(fechaHoy);
        parametros.setPARHJU(diaJuliano);
        parametros.setPARHCC(BigDecimal.ZERO);
        parametros.setPARHCO(BigDecimal.ZERO);
    }

    private CAEPAR crearNuevoParametro() {
        String fechaHoy = utilidadesGenerales.fechaActual();
        BigDecimal diaJuliano = new BigDecimal(LocalDate.now().getDayOfYear());

        CAEPAR parametros = new CAEPAR();
        parametros.setPARNUM(BigDecimal.ONE);
        parametros.setPARNOI("Banco Atlántida S.A.");
        parametros.setPARNOA("Caja Empresarial v3");
        parametros.setPARHOY(fechaHoy);
        parametros.setPARHJU(diaJuliano);
        parametros.setPARHCO(BigDecimal.ZERO);
        parametros.setPARHCC(BigDecimal.ONE);

        //Evitanto enviar parámetros nulos:
        parametros.setPAREST(BigDecimal.ZERO);
        parametros.setPARINFO("");
        parametros.setPARCON("");
        parametros.setPARBLM(BigDecimal.ZERO);
        parametros.setPARCAC(BigDecimal.ZERO);
        parametros.setPARMOL("");
        parametros.setPARCAU("");
        parametros.setPARESP("");
        parametros.setPARHCA(BigDecimal.valueOf(2179));

        return parametros;
    }

    public BigDecimal generaNumeroCierre(CAEPAR parametros){
        BigDecimal anio = new BigDecimal(gestionCierre.getParteFecha(parametros.getPARHOY(), "anio"));
        
        return anio.multiply(new BigDecimal(10000000))
                   .add(parametros.getPARHJU().multiply(new BigDecimal(10000)))
                   .add(parametros.getPARHCC());
    }

    public BigDecimal creaCierre(BigDecimal numeroCierre, String usuarioEjecucion , String fechaCierre){
        // Validación de parámetros
        usuarioEjecucion = utilidadesGenerales.truncate(usuarioEjecucion, 10);
        if (numeroCierre == null || usuarioEjecucion == null || fechaCierre == null) {
            return BigDecimal.ZERO;
        }

        //Verifica que no exista el cierre:
        Optional<CAECIE> cierre = caeCieRepo.getCierreExiste(numeroCierre);

        if (cierre.isPresent()) {
            bitacoraService.insertarEnBitacora(String.format("ERROR, Registro ya existe en CaECie: %s", numeroCierre), "ERRORFATAL");
            return BigDecimal.ZERO;
        }

        //Inserta el nuevo cierre:
        CAECIE cierreInsert = new CAECIE(numeroCierre, fechaCierre, utilidadesGenerales.horaActual(), usuarioEjecucion, "Cierre Caja Empresarial v3", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(100));

        CAECIE cierreNuevo = caeCieRepo.saveAndFlush(cierreInsert);

        return cierreNuevo.getCIENUM();
    }
}
