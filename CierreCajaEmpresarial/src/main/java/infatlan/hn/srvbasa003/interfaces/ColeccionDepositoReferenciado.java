
package infatlan.hn.srvbasa003.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para coleccionDepositoReferenciado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="coleccionDepositoReferenciado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoTransaccionCanal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoTransaccionTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionTipoReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionTransaccionTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicadorTransaccionDebito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coleccionDepositoReferenciado", propOrder = {
    "codigoTransaccionCanal",
    "codigoTransaccionTipo",
    "descripcionTipoReferencia",
    "descripcionTransaccionTipo",
    "indicadorTransaccionDebito",
    "tipoReferencia"
})
public class ColeccionDepositoReferenciado {

    protected String codigoTransaccionCanal;
    protected String codigoTransaccionTipo;
    protected String descripcionTipoReferencia;
    protected String descripcionTransaccionTipo;
    protected String indicadorTransaccionDebito;
    protected String tipoReferencia;

    /**
     * Obtiene el valor de la propiedad codigoTransaccionCanal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoTransaccionCanal() {
        return codigoTransaccionCanal;
    }

    /**
     * Define el valor de la propiedad codigoTransaccionCanal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoTransaccionCanal(String value) {
        this.codigoTransaccionCanal = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoTransaccionTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoTransaccionTipo() {
        return codigoTransaccionTipo;
    }

    /**
     * Define el valor de la propiedad codigoTransaccionTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoTransaccionTipo(String value) {
        this.codigoTransaccionTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionTipoReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionTipoReferencia() {
        return descripcionTipoReferencia;
    }

    /**
     * Define el valor de la propiedad descripcionTipoReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionTipoReferencia(String value) {
        this.descripcionTipoReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionTransaccionTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionTransaccionTipo() {
        return descripcionTransaccionTipo;
    }

    /**
     * Define el valor de la propiedad descripcionTransaccionTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionTransaccionTipo(String value) {
        this.descripcionTransaccionTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad indicadorTransaccionDebito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorTransaccionDebito() {
        return indicadorTransaccionDebito;
    }

    /**
     * Define el valor de la propiedad indicadorTransaccionDebito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorTransaccionDebito(String value) {
        this.indicadorTransaccionDebito = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoReferencia() {
        return tipoReferencia;
    }

    /**
     * Define el valor de la propiedad tipoReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoReferencia(String value) {
        this.tipoReferencia = value;
    }

}
