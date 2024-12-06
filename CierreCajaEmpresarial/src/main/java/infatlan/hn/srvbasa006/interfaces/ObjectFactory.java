
package infatlan.hn.srvbasa006.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the infatlan.hn.srvbasa006.interfaces package. 
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

    private final static QName _EjecutarSrvBasa006_QNAME = new QName("http://interfaces.srvbasa006.hn.infatlan/", "ejecutarSrvBasa006");
    private final static QName _EjecutarSrvBasa006Response_QNAME = new QName("http://interfaces.srvbasa006.hn.infatlan/", "ejecutarSrvBasa006Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: infatlan.hn.srvbasa006.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EjecutarSrvBasa006 }
     * 
     */
    public EjecutarSrvBasa006 createEjecutarSrvBasa006() {
        return new EjecutarSrvBasa006();
    }

    /**
     * Create an instance of {@link EjecutarSrvBasa006Response }
     * 
     */
    public EjecutarSrvBasa006Response createEjecutarSrvBasa006Response() {
        return new EjecutarSrvBasa006Response();
    }

    /**
     * Create an instance of {@link RespuestaSrvBasa006 }
     * 
     */
    public RespuestaSrvBasa006 createRespuestaSrvBasa006() {
        return new RespuestaSrvBasa006();
    }

    /**
     * Create an instance of {@link PeticionBase }
     * 
     */
    public PeticionBase createPeticionBase() {
        return new PeticionBase();
    }

    /**
     * Create an instance of {@link PeticionSrvBasa006 }
     * 
     */
    public PeticionSrvBasa006 createPeticionSrvBasa006() {
        return new PeticionSrvBasa006();
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
     * Create an instance of {@link ItemDocumento }
     * 
     */
    public ItemDocumento createItemDocumento() {
        return new ItemDocumento();
    }

    /**
     * Create an instance of {@link RespuestaBase }
     * 
     */
    public RespuestaBase createRespuestaBase() {
        return new RespuestaBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarSrvBasa006 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.srvbasa006.hn.infatlan/", name = "ejecutarSrvBasa006")
    public JAXBElement<EjecutarSrvBasa006> createEjecutarSrvBasa006(EjecutarSrvBasa006 value) {
        return new JAXBElement<EjecutarSrvBasa006>(_EjecutarSrvBasa006_QNAME, EjecutarSrvBasa006 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarSrvBasa006Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.srvbasa006.hn.infatlan/", name = "ejecutarSrvBasa006Response")
    public JAXBElement<EjecutarSrvBasa006Response> createEjecutarSrvBasa006Response(EjecutarSrvBasa006Response value) {
        return new JAXBElement<EjecutarSrvBasa006Response>(_EjecutarSrvBasa006Response_QNAME, EjecutarSrvBasa006Response.class, null, value);
    }

}
