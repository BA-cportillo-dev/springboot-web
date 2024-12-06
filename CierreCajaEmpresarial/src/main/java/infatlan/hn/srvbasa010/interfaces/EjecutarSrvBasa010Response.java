
package infatlan.hn.srvbasa010.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ejecutarSrvBasa010Response complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ejecutarSrvBasa010Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespuestaSrvBasa010" type="{http://interfaces.srvbasa010.hn.infatlan/}RespuestaSrvBasa010" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ejecutarSrvBasa010Response", propOrder = {
    "respuestaSrvBasa010"
})
public class EjecutarSrvBasa010Response {

    @XmlElement(name = "RespuestaSrvBasa010")
    protected RespuestaSrvBasa010 respuestaSrvBasa010;

    /**
     * Obtiene el valor de la propiedad respuestaSrvBasa010.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaSrvBasa010 }
     *     
     */
    public RespuestaSrvBasa010 getRespuestaSrvBasa010() {
        return respuestaSrvBasa010;
    }

    /**
     * Define el valor de la propiedad respuestaSrvBasa010.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaSrvBasa010 }
     *     
     */
    public void setRespuestaSrvBasa010(RespuestaSrvBasa010 value) {
        this.respuestaSrvBasa010 = value;
    }

}
