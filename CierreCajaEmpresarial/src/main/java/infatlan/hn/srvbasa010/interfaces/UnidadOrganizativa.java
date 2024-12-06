
package infatlan.hn.srvbasa010.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para UnidadOrganizativa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UnidadOrganizativa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idInterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idExterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inicioPeriodoVigencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finPeriodoVigencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoSucursal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoAgencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreSucursal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnidadOrganizativa", propOrder = {
    "idInterno",
    "idExterno",
    "inicioPeriodoVigencia",
    "finPeriodoVigencia",
    "descripcion",
    "codigoSucursal",
    "codigoAgencia",
    "nombreSucursal",
    "codigoRegion",
    "nombreRegion"
})
public class UnidadOrganizativa {

    @XmlElement(defaultValue = "")
    protected String idInterno;
    @XmlElement(defaultValue = "")
    protected String idExterno;
    @XmlElement(defaultValue = "")
    protected String inicioPeriodoVigencia;
    @XmlElement(defaultValue = "")
    protected String finPeriodoVigencia;
    @XmlElement(defaultValue = "")
    protected String descripcion;
    @XmlElement(defaultValue = "")
    protected String codigoSucursal;
    @XmlElement(defaultValue = "")
    protected String codigoAgencia;
    @XmlElement(defaultValue = "")
    protected String nombreSucursal;
    @XmlElement(defaultValue = "")
    protected String codigoRegion;
    @XmlElement(defaultValue = "")
    protected String nombreRegion;

    /**
     * Obtiene el valor de la propiedad idInterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdInterno() {
        return idInterno;
    }

    /**
     * Define el valor de la propiedad idInterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdInterno(String value) {
        this.idInterno = value;
    }

    /**
     * Obtiene el valor de la propiedad idExterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdExterno() {
        return idExterno;
    }

    /**
     * Define el valor de la propiedad idExterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdExterno(String value) {
        this.idExterno = value;
    }

    /**
     * Obtiene el valor de la propiedad inicioPeriodoVigencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicioPeriodoVigencia() {
        return inicioPeriodoVigencia;
    }

    /**
     * Define el valor de la propiedad inicioPeriodoVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicioPeriodoVigencia(String value) {
        this.inicioPeriodoVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad finPeriodoVigencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinPeriodoVigencia() {
        return finPeriodoVigencia;
    }

    /**
     * Define el valor de la propiedad finPeriodoVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinPeriodoVigencia(String value) {
        this.finPeriodoVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoSucursal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    /**
     * Define el valor de la propiedad codigoSucursal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSucursal(String value) {
        this.codigoSucursal = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoAgencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAgencia() {
        return codigoAgencia;
    }

    /**
     * Define el valor de la propiedad codigoAgencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAgencia(String value) {
        this.codigoAgencia = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSucursal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSucursal() {
        return nombreSucursal;
    }

    /**
     * Define el valor de la propiedad nombreSucursal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSucursal(String value) {
        this.nombreSucursal = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoRegion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRegion() {
        return codigoRegion;
    }

    /**
     * Define el valor de la propiedad codigoRegion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRegion(String value) {
        this.codigoRegion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreRegion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreRegion() {
        return nombreRegion;
    }

    /**
     * Define el valor de la propiedad nombreRegion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreRegion(String value) {
        this.nombreRegion = value;
    }

}
