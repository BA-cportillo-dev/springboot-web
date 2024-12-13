
package infatlan.hn.srvbasa010.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the infatlan.hn.srvbasa010.interfaces package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EjecutarSrvBasa010Response_QNAME = new QName("http://interfaces.srvbasa010.hn.infatlan/", "ejecutarSrvBasa010Response");
    private final static QName _EjecutarSrvBasa010_QNAME = new QName("http://interfaces.srvbasa010.hn.infatlan/", "ejecutarSrvBasa010");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: infatlan.hn.srvbasa010.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EjecutarSrvBasa010 }
     * 
     */
    public EjecutarSrvBasa010 createEjecutarSrvBasa010() {
        return new EjecutarSrvBasa010();
    }

    /**
     * Create an instance of {@link EjecutarSrvBasa010Response }
     * 
     */
    public EjecutarSrvBasa010Response createEjecutarSrvBasa010Response() {
        return new EjecutarSrvBasa010Response();
    }

    /**
     * Create an instance of {@link PeticionBase }
     * 
     */
    public PeticionBase createPeticionBase() {
        return new PeticionBase();
    }

    /**
     * Create an instance of {@link ItemError }
     * 
     */
    public ItemError createItemError() {
        return new ItemError();
    }

    /**
     * Create an instance of {@link ParametroAdicional }
     * 
     */
    public ParametroAdicional createParametroAdicional() {
        return new ParametroAdicional();
    }

    /**
     * Create an instance of {@link RespuestaSrvBasa010 }
     * 
     */
    public RespuestaSrvBasa010 createRespuestaSrvBasa010() {
        return new RespuestaSrvBasa010();
    }

    /**
     * Create an instance of {@link UnidadOrganizativa }
     * 
     */
    public UnidadOrganizativa createUnidadOrganizativa() {
        return new UnidadOrganizativa();
    }

    /**
     * Create an instance of {@link PeticionSrvBasa010 }
     * 
     */
    public PeticionSrvBasa010 createPeticionSrvBasa010() {
        return new PeticionSrvBasa010();
    }

    /**
     * Create an instance of {@link RespuestaBase }
     * 
     */
    public RespuestaBase createRespuestaBase() {
        return new RespuestaBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarSrvBasa010Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.srvbasa010.hn.infatlan/", name = "ejecutarSrvBasa010Response")
    public JAXBElement<EjecutarSrvBasa010Response> createEjecutarSrvBasa010Response(EjecutarSrvBasa010Response value) {
        return new JAXBElement<EjecutarSrvBasa010Response>(_EjecutarSrvBasa010Response_QNAME, EjecutarSrvBasa010Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarSrvBasa010 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.srvbasa010.hn.infatlan/", name = "ejecutarSrvBasa010")
    public JAXBElement<EjecutarSrvBasa010> createEjecutarSrvBasa010(EjecutarSrvBasa010 value) {
        return new JAXBElement<EjecutarSrvBasa010>(_EjecutarSrvBasa010_QNAME, EjecutarSrvBasa010 .class, null, value);
    }

}
