
package infatlan.hn.srvbasa006.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ItemDocumento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ItemDocumento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="correlativo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="centroCosto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="centroBeneficio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoCreditoDebito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuentaContable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="codigoAgencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemDocumento", propOrder = {
    "correlativo",
    "centroCosto",
    "centroBeneficio",
    "codigoCreditoDebito",
    "cuentaContable",
    "moneda",
    "monto",
    "codigoAgencia",
    "descripcion",
    "numeroReferencia"
})
public class ItemDocumento {

    protected long correlativo;
    @XmlElement(defaultValue = "")
    protected String centroCosto;
    @XmlElement(defaultValue = "")
    protected String centroBeneficio;
    @XmlElement(defaultValue = "")
    protected String codigoCreditoDebito;
    @XmlElement(defaultValue = "")
    protected String cuentaContable;
    @XmlElement(defaultValue = "")
    protected String moneda;
    @XmlElement(defaultValue = "0.00")
    protected Double monto;
    @XmlElement(defaultValue = "")
    protected String codigoAgencia;
    @XmlElement(defaultValue = "")
    protected String descripcion;
    @XmlElement(defaultValue = "")
    protected String numeroReferencia;

    /**
     * Obtiene el valor de la propiedad correlativo.
     * 
     */
    public long getCorrelativo() {
        return correlativo;
    }

    /**
     * Define el valor de la propiedad correlativo.
     * 
     */
    public void setCorrelativo(long value) {
        this.correlativo = value;
    }

    /**
     * Obtiene el valor de la propiedad centroCosto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroCosto() {
        return centroCosto;
    }

    /**
     * Define el valor de la propiedad centroCosto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroCosto(String value) {
        this.centroCosto = value;
    }

    /**
     * Obtiene el valor de la propiedad centroBeneficio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroBeneficio() {
        return centroBeneficio;
    }

    /**
     * Define el valor de la propiedad centroBeneficio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroBeneficio(String value) {
        this.centroBeneficio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCreditoDebito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCreditoDebito() {
        return codigoCreditoDebito;
    }

    /**
     * Define el valor de la propiedad codigoCreditoDebito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCreditoDebito(String value) {
        this.codigoCreditoDebito = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaContable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuentaContable() {
        return cuentaContable;
    }

    /**
     * Define el valor de la propiedad cuentaContable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuentaContable(String value) {
        this.cuentaContable = value;
    }

    /**
     * Obtiene el valor de la propiedad moneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneda(String value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad monto.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMonto(Double value) {
        this.monto = value;
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
     * Obtiene el valor de la propiedad numeroReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    /**
     * Define el valor de la propiedad numeroReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroReferencia(String value) {
        this.numeroReferencia = value;
    }

}
