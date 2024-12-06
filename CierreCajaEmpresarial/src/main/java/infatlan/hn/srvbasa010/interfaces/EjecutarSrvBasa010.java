
package infatlan.hn.srvbasa010.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ejecutarSrvBasa010 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ejecutarSrvBasa010">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeticionSrvBasa010" type="{http://interfaces.srvbasa010.hn.infatlan/}PeticionSrvBasa010" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ejecutarSrvBasa010", propOrder = {
    "peticionSrvBasa010"
})
public class EjecutarSrvBasa010 {

    @XmlElement(name = "PeticionSrvBasa010")
    protected PeticionSrvBasa010 peticionSrvBasa010;

    /**
     * Obtiene el valor de la propiedad peticionSrvBasa010.
     * 
     * @return
     *     possible object is
     *     {@link PeticionSrvBasa010 }
     *     
     */
    public PeticionSrvBasa010 getPeticionSrvBasa010() {
        return peticionSrvBasa010;
    }

    /**
     * Define el valor de la propiedad peticionSrvBasa010.
     * 
     * @param value
     *     allowed object is
     *     {@link PeticionSrvBasa010 }
     *     
     */
    public void setPeticionSrvBasa010(PeticionSrvBasa010 value) {
        this.peticionSrvBasa010 = value;
    }

}
