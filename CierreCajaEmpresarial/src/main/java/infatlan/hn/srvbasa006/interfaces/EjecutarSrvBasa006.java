
package infatlan.hn.srvbasa006.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ejecutarSrvBasa006 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ejecutarSrvBasa006">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeticionSrvBasa006" type="{http://interfaces.srvbasa006.hn.infatlan/}PeticionSrvBasa006" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ejecutarSrvBasa006", propOrder = {
    "peticionSrvBasa006"
})
public class EjecutarSrvBasa006 {

    @XmlElement(name = "PeticionSrvBasa006")
    protected PeticionSrvBasa006 peticionSrvBasa006;

    /**
     * Obtiene el valor de la propiedad peticionSrvBasa006.
     * 
     * @return
     *     possible object is
     *     {@link PeticionSrvBasa006 }
     *     
     */
    public PeticionSrvBasa006 getPeticionSrvBasa006() {
        return peticionSrvBasa006;
    }

    /**
     * Define el valor de la propiedad peticionSrvBasa006.
     * 
     * @param value
     *     allowed object is
     *     {@link PeticionSrvBasa006 }
     *     
     */
    public void setPeticionSrvBasa006(PeticionSrvBasa006 value) {
        this.peticionSrvBasa006 = value;
    }

}
