
package infatlan.hn.srvbasa003.interfaces;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ItemServicios complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ItemServicios">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoMaxLocal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoMaxEtr" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="opcion1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcion2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcion3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcion4" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="opcion5" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="opcion6" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemServicios", propOrder = {
    "codigoServicio",
    "activo",
    "montoMaxLocal",
    "montoMaxEtr",
    "opcion1",
    "opcion2",
    "opcion3",
    "opcion4",
    "opcion5",
    "opcion6"
})
public class ItemServicios {

    protected String codigoServicio;
    protected String activo;
    protected BigDecimal montoMaxLocal;
    protected BigDecimal montoMaxEtr;
    protected String opcion1;
    protected String opcion2;
    protected String opcion3;
    protected BigDecimal opcion4;
    protected BigDecimal opcion5;
    protected BigDecimal opcion6;

    /**
     * Obtiene el valor de la propiedad codigoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Define el valor de la propiedad codigoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad activo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivo() {
        return activo;
    }

    /**
     * Define el valor de la propiedad activo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivo(String value) {
        this.activo = value;
    }

    /**
     * Obtiene el valor de la propiedad montoMaxLocal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoMaxLocal() {
        return montoMaxLocal;
    }

    /**
     * Define el valor de la propiedad montoMaxLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoMaxLocal(BigDecimal value) {
        this.montoMaxLocal = value;
    }

    /**
     * Obtiene el valor de la propiedad montoMaxEtr.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoMaxEtr() {
        return montoMaxEtr;
    }

    /**
     * Define el valor de la propiedad montoMaxEtr.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoMaxEtr(BigDecimal value) {
        this.montoMaxEtr = value;
    }

    /**
     * Obtiene el valor de la propiedad opcion1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcion1() {
        return opcion1;
    }

    /**
     * Define el valor de la propiedad opcion1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcion1(String value) {
        this.opcion1 = value;
    }

    /**
     * Obtiene el valor de la propiedad opcion2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcion2() {
        return opcion2;
    }

    /**
     * Define el valor de la propiedad opcion2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcion2(String value) {
        this.opcion2 = value;
    }

    /**
     * Obtiene el valor de la propiedad opcion3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcion3() {
        return opcion3;
    }

    /**
     * Define el valor de la propiedad opcion3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcion3(String value) {
        this.opcion3 = value;
    }

    /**
     * Obtiene el valor de la propiedad opcion4.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpcion4() {
        return opcion4;
    }

    /**
     * Define el valor de la propiedad opcion4.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpcion4(BigDecimal value) {
        this.opcion4 = value;
    }

    /**
     * Obtiene el valor de la propiedad opcion5.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpcion5() {
        return opcion5;
    }

    /**
     * Define el valor de la propiedad opcion5.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpcion5(BigDecimal value) {
        this.opcion5 = value;
    }

    /**
     * Obtiene el valor de la propiedad opcion6.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpcion6() {
        return opcion6;
    }

    /**
     * Define el valor de la propiedad opcion6.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpcion6(BigDecimal value) {
        this.opcion6 = value;
    }

}
