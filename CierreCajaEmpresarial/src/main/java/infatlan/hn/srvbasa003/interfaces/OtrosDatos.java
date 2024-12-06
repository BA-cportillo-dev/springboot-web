
package infatlan.hn.srvbasa003.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para otrosDatos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="otrosDatos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoRol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="periodoValido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "otrosDatos", propOrder = {
    "codigoCliente",
    "codigoRol",
    "periodoValido"
})
public class OtrosDatos {

    protected String codigoCliente;
    protected String codigoRol;
    protected String periodoValido;

    /**
     * Obtiene el valor de la propiedad codigoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Define el valor de la propiedad codigoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCliente(String value) {
        this.codigoCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoRol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRol() {
        return codigoRol;
    }

    /**
     * Define el valor de la propiedad codigoRol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRol(String value) {
        this.codigoRol = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoValido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoValido() {
        return periodoValido;
    }

    /**
     * Define el valor de la propiedad periodoValido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoValido(String value) {
        this.periodoValido = value;
    }

}
