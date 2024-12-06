package hn.bancatlan.cierrecajaempresarial.utils.srvbasa_router;

import hn.bancatlan.cierrecajaempresarial.dto.consumos.requests.ConsumoMicroservicio01;
import hn.bancatlan.cierrecajaempresarial.dto.consumos.requests.ConsumoMicroservicio01PartidaDoble;
import hn.bancatlan.cierrecajaempresarial.dto.consumos.requests.ConsumoMicroservicio06;
import hn.bancatlan.cierrecajaempresarial.utils.commons.ConstantValues;
import hn.bancatlan.cierrecajaempresarial.utils.requests_cierre.PeticionBaseCierre;
import infatlan.hn.srvbasa001.interfaces.ItemNotaPago;
import infatlan.hn.srvbasa001.interfaces.ItemPartidaPago;
import infatlan.hn.srvbasa001.interfaces.PeticionSrvBasa001;
import infatlan.hn.srvbasa001.interfaces.RespuestaSrvBasa001;
import infatlan.hn.srvbasa001.servicios.expuestos.ServicioSrvBasa001Interfaz;
import infatlan.hn.srvbasa001.servicios.expuestos.SrvBasa001ServiceService;
import infatlan.hn.srvbasa003.interfaces.PeticionSrvBasa003;
import infatlan.hn.srvbasa003.interfaces.RespuestaSrvBasa003;
import infatlan.hn.srvbasa003.servicios.expuestos.ServicioSrvBasa003Interfaz;
import infatlan.hn.srvbasa003.servicios.expuestos.SrvBasa003ServiceService;
import infatlan.hn.srvbasa006.interfaces.ItemDocumento;
import infatlan.hn.srvbasa006.interfaces.ParametroAdicional;
import infatlan.hn.srvbasa006.interfaces.PeticionSrvBasa006;
import infatlan.hn.srvbasa006.interfaces.RespuestaSrvBasa006;
import infatlan.hn.srvbasa006.servicios.expuestos.ServicioSrvBasa006Interfaz;
import infatlan.hn.srvbasa006.servicios.expuestos.SrvBasa006ServiceService;
import infatlan.hn.srvbasa010.interfaces.PeticionSrvBasa010;
import infatlan.hn.srvbasa010.interfaces.RespuestaSrvBasa010;
import infatlan.hn.srvbasa010.servicios.expuestos.ServicioSrvBasa010Interfaz;
import infatlan.hn.srvbasa010.servicios.expuestos.SrvBasa010ServiceService;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SRVBASARouter {

    private RespuestaSrvBasa001 respuestaSrvBasa001;
    private RespuestaSrvBasa001 respuestaDoblePartida;
    private RespuestaSrvBasa003 respuestaSrvBasa003;
    private RespuestaSrvBasa006 respuestaSrvBasa006;
    private RespuestaSrvBasa010 respuestaSrvBasa010;

    public boolean ejecutarBasa001(
            ConsumoMicroservicio01 consumoMicro01,
            PeticionBaseCierre requestBaseCierre
    ) {

        SrvBasa001ServiceService srvBasa001Service = new SrvBasa001ServiceService();
        ServicioSrvBasa001Interfaz portSrvBasa001 = srvBasa001Service.getSrvBasa001ServicePort();
        PeticionSrvBasa001 peticionSrvBasa001 = new PeticionSrvBasa001();

        peticionSrvBasa001.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        peticionSrvBasa001.setCodigoCanal(requestBaseCierre.getCodigoCanal());
        peticionSrvBasa001.setCodigoPais(requestBaseCierre.getCodigoPais());
        peticionSrvBasa001.setCodigoBanco(requestBaseCierre.getCodigoBanco());
        peticionSrvBasa001.setUsuarioPeticion(requestBaseCierre.getUsuarioPeticion());
        peticionSrvBasa001.setDireccionIPPeticion(requestBaseCierre.getDireccionIp());
        peticionSrvBasa001.setCodigoCoreBanking(requestBaseCierre.getCodigoCoreBanking());

        ItemPartidaPago itemPartidoPago = new ItemPartidaPago();

        itemPartidoPago.setSucursalOrigen(consumoMicro01.getSucursalOrigen());
        itemPartidoPago.setFormaPago(consumoMicro01.getFormaPago());
        itemPartidoPago.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        itemPartidoPago.setPartidaDebito(ConstantValues.getLiteralFalse());
        itemPartidoPago.setMonedaTransaccion(consumoMicro01.getMonedaTransaccion());
        itemPartidoPago.setMontoTransaccion(consumoMicro01.getMontoTransaccion());
        itemPartidoPago.setImpresoLibreta(ConstantValues.getLiteralFalse());
        itemPartidoPago.setNumeroCuenta(consumoMicro01.getNumeroCuenta());
        itemPartidoPago.setMonedaParaCuenta(consumoMicro01.getMonedaTransaccion());

        ItemNotaPago itemNotaPago1 = new ItemNotaPago();

        itemNotaPago1.setTipoNotaPago(consumoMicro01.getTipoNotaPago());
        itemNotaPago1.setTextoNotaPago(consumoMicro01.getTextoNotaPago());
        itemPartidoPago.getColeccionNotaPago().add(itemNotaPago1);

        peticionSrvBasa001.getColeccionPartidaPago().add(itemPartidoPago);

        try {
            respuestaSrvBasa001 = portSrvBasa001.ejecutarSrvBasa001(peticionSrvBasa001);

            this.setRespuestaSrvBasa001(respuestaSrvBasa001);

            return respuestaSrvBasa001.getCodigoMensaje().equals("00");
        } catch (Exception ex) {
            return false;
        }

    }

    public boolean doblePartida(
            ConsumoMicroservicio01PartidaDoble consumoMicro01PartidaDoble,
            PeticionBaseCierre requestBaseCierre
    ) {

        SrvBasa001ServiceService srvBasa001Service = new SrvBasa001ServiceService();
        ServicioSrvBasa001Interfaz portSrvBasa001 = srvBasa001Service.getSrvBasa001ServicePort();
        PeticionSrvBasa001 peticionSrvBasa001 = new PeticionSrvBasa001();

        peticionSrvBasa001.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        peticionSrvBasa001.setCodigoCanal(requestBaseCierre.getCodigoCanal());
        peticionSrvBasa001.setCodigoPais(requestBaseCierre.getCodigoPais());
        peticionSrvBasa001.setCodigoBanco(requestBaseCierre.getCodigoBanco());
        peticionSrvBasa001.setUsuarioPeticion(requestBaseCierre.getUsuarioPeticion());
        peticionSrvBasa001.setDireccionIPPeticion(requestBaseCierre.getDireccionIp());
        peticionSrvBasa001.setCodigoCoreBanking(requestBaseCierre.getCodigoCoreBanking());

        //Partida para el Débito:
        ItemPartidaPago itemPartidoPago = new ItemPartidaPago();

        itemPartidoPago.setSucursalOrigen(consumoMicro01PartidaDoble.getSucursalDebito());
        itemPartidoPago.setFormaPago("DB");
        itemPartidoPago.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        itemPartidoPago.setPartidaDebito(ConstantValues.getLiteralFalse());
        itemPartidoPago.setMonedaTransaccion(consumoMicro01PartidaDoble.getMonedaTransaccion());
        itemPartidoPago.setMontoTransaccion(consumoMicro01PartidaDoble.getMontoTransaccion());
        itemPartidoPago.setImpresoLibreta(ConstantValues.getLiteralFalse());
        itemPartidoPago.setNumeroCuenta(consumoMicro01PartidaDoble.getCuentaDebito());
        itemPartidoPago.setMonedaParaCuenta(consumoMicro01PartidaDoble.getMonedaTransaccion());

        ItemNotaPago itemNotaPago1 = new ItemNotaPago();

        itemNotaPago1.setTipoNotaPago(consumoMicro01PartidaDoble.getTipoNotaPago());
        itemNotaPago1.setTextoNotaPago(consumoMicro01PartidaDoble.getTextoNotaPago());
        itemPartidoPago.getColeccionNotaPago().add(itemNotaPago1);

        peticionSrvBasa001.getColeccionPartidaPago().add(itemPartidoPago);

        //Partida para el Crédito:
        ItemPartidaPago itemPartidoPago2 = new ItemPartidaPago();

        itemPartidoPago2.setSucursalOrigen(consumoMicro01PartidaDoble.getSucursalCredito());
        itemPartidoPago2.setFormaPago("CR");
        itemPartidoPago2.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        itemPartidoPago2.setPartidaDebito(ConstantValues.getLiteralFalse());
        itemPartidoPago2.setMonedaTransaccion(consumoMicro01PartidaDoble.getMonedaTransaccion());
        itemPartidoPago2.setMontoTransaccion(consumoMicro01PartidaDoble.getMontoTransaccion());
        itemPartidoPago2.setImpresoLibreta(ConstantValues.getLiteralFalse());
        itemPartidoPago2.setNumeroCuenta(consumoMicro01PartidaDoble.getCuentaCredito());
        itemPartidoPago2.setMonedaParaCuenta(consumoMicro01PartidaDoble.getMonedaTransaccion());

        ItemNotaPago itemNotaPago2 = new ItemNotaPago();

        itemNotaPago2.setTipoNotaPago(consumoMicro01PartidaDoble.getTipoNotaPago());
        itemNotaPago2.setTextoNotaPago(consumoMicro01PartidaDoble.getTextoNotaPago());
        itemPartidoPago2.getColeccionNotaPago().add(itemNotaPago2);

        peticionSrvBasa001.getColeccionPartidaPago().add(itemPartidoPago2);

        try {
            respuestaDoblePartida = portSrvBasa001.ejecutarSrvBasa001(peticionSrvBasa001);

            this.setRespuestaDoblePartida(respuestaDoblePartida);

            return respuestaDoblePartida.getCodigoMensaje().equals("00");
        } catch (Exception ex) {
            return false;
        }

    }

    public boolean ejecutarBasa003(String tipoBusqueda, String numeroCuenta, PeticionBaseCierre requestBaseCierre) {

        SrvBasa003ServiceService srvBasa003Service = new SrvBasa003ServiceService();
        ServicioSrvBasa003Interfaz portSrvBasa003 = srvBasa003Service.getSrvBasa003ServicePort();
        PeticionSrvBasa003 peticionSrvBasa003 = new PeticionSrvBasa003();

        peticionSrvBasa003.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        peticionSrvBasa003.setCodigoCanal(requestBaseCierre.getCodigoCanal());
        peticionSrvBasa003.setCodigoPais(requestBaseCierre.getCodigoPais());
        peticionSrvBasa003.setCodigoBanco(requestBaseCierre.getCodigoBanco());
        peticionSrvBasa003.setUsuarioPeticion(requestBaseCierre.getUsuarioPeticion());
        peticionSrvBasa003.setDireccionIPPeticion(requestBaseCierre.getDireccionIp());
        peticionSrvBasa003.setCodigoCoreBanking(requestBaseCierre.getCodigoCoreBanking());
        peticionSrvBasa003.setTipoBusqueda(tipoBusqueda);
        peticionSrvBasa003.setValorBusqueda(numeroCuenta);

        try {
            respuestaSrvBasa003 = portSrvBasa003.ejecutarSrvBasa003(peticionSrvBasa003);

            this.setRespuestaSrvBasa003(respuestaSrvBasa003);

            return respuestaSrvBasa003.getCodigoMensaje().equals("00");
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean ejecutarBasa006(
            ConsumoMicroservicio06 requestMicro06,
            PeticionBaseCierre requestBaseCierre
    ) {

        SrvBasa006ServiceService srvBasa006Service = new SrvBasa006ServiceService();
        ServicioSrvBasa006Interfaz portSrvBasa006 = srvBasa006Service.getSrvBasa006ServicePort();
        PeticionSrvBasa006 peticionSrvBasa006 = new PeticionSrvBasa006();

        SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = fechaFormato.format(new Date());

        peticionSrvBasa006.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        peticionSrvBasa006.setCodigoCanal(requestBaseCierre.getCodigoCanal());
        peticionSrvBasa006.setCodigoPais(requestBaseCierre.getCodigoPais());
        peticionSrvBasa006.setCodigoBanco(requestBaseCierre.getCodigoBanco());
        peticionSrvBasa006.setUsuarioPeticion(requestBaseCierre.getUsuarioPeticion());
        peticionSrvBasa006.setDireccionIPPeticion(requestBaseCierre.getDireccionIp());
        peticionSrvBasa006.setCodigoCoreBanking(requestBaseCierre.getCodigoCoreBanking());

        ParametroAdicional paraAd = new ParametroAdicional();

        paraAd.setNumeroLinea(0);
        paraAd.setValor("0");
        peticionSrvBasa006.getParametroAdicionalColeccion().add(paraAd);

        peticionSrvBasa006.setClaseDocumento("SA");
        peticionSrvBasa006.setFechaContabilizacionTransaccion(fechaActual);
        peticionSrvBasa006.setFechaConversionMoneda(fechaActual);
        peticionSrvBasa006.setFechaPosteo(fechaActual);
        peticionSrvBasa006.setDescripcionCabecera("");

        ItemDocumento itemDocumento = new ItemDocumento();

        itemDocumento.setCorrelativo(00000001);
        itemDocumento.setCentroBeneficio("");
        itemDocumento.setCodigoCreditoDebito("");
        itemDocumento.setCentroCosto(requestMicro06.getCentroCosto());
        itemDocumento.setCodigoAgencia(requestMicro06.getSucursalDebito());
        itemDocumento.setCuentaContable(requestMicro06.getCuentaDebito());
        itemDocumento.setDescripcion(requestMicro06.getDescripcion());
        itemDocumento.setMoneda(requestMicro06.getMoneda());
        itemDocumento.setMonto(requestMicro06.getMonto());
        itemDocumento.setNumeroReferencia("");
        peticionSrvBasa006.getColeccionItemDocumento().add(itemDocumento);

        ItemDocumento itemDocumento1 = new ItemDocumento();

        itemDocumento1.setCorrelativo(00000002);
        itemDocumento1.setCentroBeneficio("");
        itemDocumento1.setCodigoCreditoDebito("");
        itemDocumento1.setCentroCosto(requestMicro06.getCentroCosto());
        itemDocumento1.setCodigoAgencia(requestMicro06.getSucursalCredito());
        itemDocumento1.setCuentaContable(requestMicro06.getCuentaCredito());
        itemDocumento1.setDescripcion(requestMicro06.getDescripcion());
        itemDocumento1.setMoneda(requestMicro06.getMoneda());
        itemDocumento1.setMonto(requestMicro06.getMonto() * -1);
        itemDocumento1.setNumeroReferencia("");
        peticionSrvBasa006.getColeccionItemDocumento().add(itemDocumento1);

        try {
            respuestaSrvBasa006 = portSrvBasa006.ejecutarSrvBasa006(peticionSrvBasa006);

            this.setRespuestaSrvBasa006(respuestaSrvBasa006);

            return respuestaSrvBasa006.getCodigoMensaje().equals("00");
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean ejecutarBasa010(String codigoAgencia, String codigoSucursal, PeticionBaseCierre requestBaseCierre) {

        SrvBasa010ServiceService srvBasa010Service = new SrvBasa010ServiceService();
        ServicioSrvBasa010Interfaz portSrvBasa010 = srvBasa010Service.getSrvBasa010ServicePort();
        PeticionSrvBasa010 peticionSrvBasa010 = new PeticionSrvBasa010();

        peticionSrvBasa010.setCodigoTransaccion(requestBaseCierre.getCodigoTransaccion());
        peticionSrvBasa010.setCodigoCanal(requestBaseCierre.getCodigoCanal());
        peticionSrvBasa010.setCodigoPais(requestBaseCierre.getCodigoPais());
        peticionSrvBasa010.setCodigoBanco(requestBaseCierre.getCodigoBanco());
        peticionSrvBasa010.setUsuarioPeticion(requestBaseCierre.getUsuarioPeticion());
        peticionSrvBasa010.setDireccionIPPeticion(requestBaseCierre.getDireccionIp());
        peticionSrvBasa010.setCodigoCoreBanking(requestBaseCierre.getCodigoCoreBanking());
        peticionSrvBasa010.setCodigoAgencia(codigoAgencia);
        peticionSrvBasa010.setCodigoSucursal(codigoSucursal);

        try {
            respuestaSrvBasa010 = portSrvBasa010.ejecutarSrvBasa010(peticionSrvBasa010);

            this.setRespuestaSrvBasa010(respuestaSrvBasa010);

            return respuestaSrvBasa010.getCodigoMensaje().equals("00");
        } catch (Exception ex) {
            return false;
        }
    }

    //Getters y Setters para obtener las respuestas de los microservicios:
    public RespuestaSrvBasa001 getRespuestaSrvBasa001() {
        return respuestaSrvBasa001;
    }

    public void setRespuestaSrvBasa001(RespuestaSrvBasa001 respuestaSrvBasa001) {
        this.respuestaSrvBasa001 = respuestaSrvBasa001;
    }

    public RespuestaSrvBasa001 getRespuestaDoblePartida() {
        return respuestaDoblePartida;
    }

    public void setRespuestaDoblePartida(RespuestaSrvBasa001 respuestaDoblePartida) {
        this.respuestaDoblePartida = respuestaDoblePartida;
    }

    public RespuestaSrvBasa003 getRespuestaSrvBasa003() {
        return respuestaSrvBasa003;
    }

    public void setRespuestaSrvBasa003(RespuestaSrvBasa003 respuestaSrvBasa003) {
        this.respuestaSrvBasa003 = respuestaSrvBasa003;
    }

    public RespuestaSrvBasa006 getRespuestaSrvBasa006() {
        return respuestaSrvBasa006;
    }

    public void setRespuestaSrvBasa006(RespuestaSrvBasa006 respuestaSrvBasa006) {
        this.respuestaSrvBasa006 = respuestaSrvBasa006;
    }

    public RespuestaSrvBasa010 getRespuestaSrvBasa010() {
        return respuestaSrvBasa010;
    }

    public void setRespuestaSrvBasa010(RespuestaSrvBasa010 respuestaSrvBasa010) {
        this.respuestaSrvBasa010 = respuestaSrvBasa010;
    }
}
