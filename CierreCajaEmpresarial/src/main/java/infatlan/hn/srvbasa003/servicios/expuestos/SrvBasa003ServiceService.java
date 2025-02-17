
package infatlan.hn.srvbasa003.servicios.expuestos;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SrvBasa003ServiceService", targetNamespace = "http://expuestos.servicios.srvbasa003.hn.infatlan/", wsdlLocation = "http://srvbasa.bancatlan.hn:30003/SRVBASA003-1.0/ServicioSrvBasa003Interfaz?wsdl")
public class SrvBasa003ServiceService
    extends Service
{

    private final static URL SRVBASA003SERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException SRVBASA003SERVICESERVICE_EXCEPTION;
    private final static QName SRVBASA003SERVICESERVICE_QNAME = new QName("http://expuestos.servicios.srvbasa003.hn.infatlan/", "SrvBasa003ServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://srvbasa.bancatlan.hn:30003/SRVBASA003-1.0/ServicioSrvBasa003Interfaz?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SRVBASA003SERVICESERVICE_WSDL_LOCATION = url;
        SRVBASA003SERVICESERVICE_EXCEPTION = e;
    }

    public SrvBasa003ServiceService() {
        super(__getWsdlLocation(), SRVBASA003SERVICESERVICE_QNAME);
    }

    public SrvBasa003ServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SRVBASA003SERVICESERVICE_QNAME, features);
    }

    public SrvBasa003ServiceService(URL wsdlLocation) {
        super(wsdlLocation, SRVBASA003SERVICESERVICE_QNAME);
    }

    public SrvBasa003ServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SRVBASA003SERVICESERVICE_QNAME, features);
    }

    public SrvBasa003ServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SrvBasa003ServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioSrvBasa003Interfaz
     */
    @WebEndpoint(name = "SrvBasa003ServicePort")
    public ServicioSrvBasa003Interfaz getSrvBasa003ServicePort() {
        return super.getPort(new QName("http://expuestos.servicios.srvbasa003.hn.infatlan/", "SrvBasa003ServicePort"), ServicioSrvBasa003Interfaz.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioSrvBasa003Interfaz
     */
    @WebEndpoint(name = "SrvBasa003ServicePort")
    public ServicioSrvBasa003Interfaz getSrvBasa003ServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://expuestos.servicios.srvbasa003.hn.infatlan/", "SrvBasa003ServicePort"), ServicioSrvBasa003Interfaz.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SRVBASA003SERVICESERVICE_EXCEPTION!= null) {
            throw SRVBASA003SERVICESERVICE_EXCEPTION;
        }
        return SRVBASA003SERVICESERVICE_WSDL_LOCATION;
    }

}
