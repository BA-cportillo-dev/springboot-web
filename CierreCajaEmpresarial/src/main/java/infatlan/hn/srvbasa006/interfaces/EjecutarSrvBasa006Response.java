
package infatlan.hn.srvbasa006.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ejecutarSrvBasa006Response complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ejecutarSrvBasa006Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespuestaSrvBasa006" type="{http://interfaces.srvbasa006.hn.infatlan/}RespuestaSrvBasa006" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ejecutarSrvBasa006Response", propOrder = {
    "respuestaSrvBasa006"
})
public class EjecutarSrvBasa006Response {

    @XmlElement(name = "RespuestaSrvBasa006")
    protected RespuestaSrvBasa006 respuestaSrvBasa006;

    /**
     * Obtiene el valor de la propiedad respuestaSrvBasa006.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaSrvBasa006 }
     *     
     */
    public RespuestaSrvBasa006 getRespuestaSrvBasa006() {
        return respuestaSrvBasa006;
    }

    /**
     * Define el valor de la propiedad respuestaSrvBasa006.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaSrvBasa006 }
     *     
     */
    public void setRespuestaSrvBasa006(RespuestaSrvBasa006 value) {
        this.respuestaSrvBasa006 = value;
    }

}
