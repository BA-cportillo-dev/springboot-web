
package infatlan.hn.srvbasa003.servicios.expuestos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import infatlan.hn.srvbasa003.interfaces.ObjectFactory;
import infatlan.hn.srvbasa003.interfaces.PeticionSrvBasa003;
import infatlan.hn.srvbasa003.interfaces.RespuestaSrvBasa003;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioSrvBasa003Interfaz", targetNamespace = "http://interfaces.srvbasa003.hn.infatlan/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioSrvBasa003Interfaz {


    /**
     * 
     * @param peticionSrvBasa003
     * @return
     *     returns infatlan.hn.srvbasa003.interfaces.RespuestaSrvBasa003
     */
    @WebMethod
    @WebResult(name = "RespuestaSrvBasa003", targetNamespace = "")
    @RequestWrapper(localName = "ejecutarSrvBasa003", targetNamespace = "http://interfaces.srvbasa003.hn.infatlan/", className = "infatlan.hn.srvbasa003.interfaces.EjecutarSrvBasa003")
    @ResponseWrapper(localName = "ejecutarSrvBasa003Response", targetNamespace = "http://interfaces.srvbasa003.hn.infatlan/", className = "infatlan.hn.srvbasa003.interfaces.EjecutarSrvBasa003Response")
    public RespuestaSrvBasa003 ejecutarSrvBasa003(
        @WebParam(name = "PeticionSrvBasa003", targetNamespace = "")
        PeticionSrvBasa003 peticionSrvBasa003);

}
