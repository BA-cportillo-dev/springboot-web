
package infatlan.hn.srvbasa003.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para itemNota complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="itemNota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adicionalNota1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adicionalNota2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formatoNota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lineaNota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemNota", propOrder = {
    "adicionalNota1",
    "adicionalNota2",
    "formatoNota",
    "lineaNota"
})
public class ItemNota {

    protected String adicionalNota1;
    protected String adicionalNota2;
    protected String formatoNota;
    protected String lineaNota;

    /**
     * Obtiene el valor de la propiedad adicionalNota1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdicionalNota1() {
        return adicionalNota1;
    }

    /**
     * Define el valor de la propiedad adicionalNota1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdicionalNota1(String value) {
        this.adicionalNota1 = value;
    }

    /**
     * Obtiene el valor de la propiedad adicionalNota2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdicionalNota2() {
        return adicionalNota2;
    }

    /**
     * Define el valor de la propiedad adicionalNota2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdicionalNota2(String value) {
        this.adicionalNota2 = value;
    }

    /**
     * Obtiene el valor de la propiedad formatoNota.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatoNota() {
        return formatoNota;
    }

    /**
     * Define el valor de la propiedad formatoNota.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatoNota(String value) {
        this.formatoNota = value;
    }

    /**
     * Obtiene el valor de la propiedad lineaNota.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineaNota() {
        return lineaNota;
    }

    /**
     * Define el valor de la propiedad lineaNota.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineaNota(String value) {
        this.lineaNota = value;
    }

}
