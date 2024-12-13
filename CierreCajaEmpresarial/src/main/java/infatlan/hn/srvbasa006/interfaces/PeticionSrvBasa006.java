
package infatlan.hn.srvbasa006.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PeticionSrvBasa006 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PeticionSrvBasa006">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.srvbasa006.hn.infatlan/}PeticionBase">
 *       &lt;sequence>
 *         &lt;element name="claseDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaContabilizacionTransaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaPosteo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaConversionMoneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionCabecera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coleccionItemDocumento" type="{http://interfaces.srvbasa006.hn.infatlan/}ItemDocumento" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionSrvBasa006", propOrder = {
    "claseDocumento",
    "fechaContabilizacionTransaccion",
    "fechaPosteo",
    "fechaConversionMoneda",
    "descripcionCabecera",
    "coleccionItemDocumento"
})
public class PeticionSrvBasa006
    extends PeticionBase
{

    @XmlElement(defaultValue = "")
    protected String claseDocumento;
    @XmlElement(defaultValue = "")
    protected String fechaContabilizacionTransaccion;
    @XmlElement(defaultValue = "")
    protected String fechaPosteo;
    @XmlElement(defaultValue = "")
    protected String fechaConversionMoneda;
    @XmlElement(defaultValue = "")
    protected String descripcionCabecera;
    protected List<ItemDocumento> coleccionItemDocumento;

    /**
     * Obtiene el valor de la propiedad claseDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaseDocumento() {
        return claseDocumento;
    }

    /**
     * Define el valor de la propiedad claseDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaseDocumento(String value) {
        this.claseDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaContabilizacionTransaccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaContabilizacionTransaccion() {
        return fechaContabilizacionTransaccion;
    }

    /**
     * Define el valor de la propiedad fechaContabilizacionTransaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaContabilizacionTransaccion(String value) {
        this.fechaContabilizacionTransaccion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPosteo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaPosteo() {
        return fechaPosteo;
    }

    /**
     * Define el valor de la propiedad fechaPosteo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaPosteo(String value) {
        this.fechaPosteo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaConversionMoneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaConversionMoneda() {
        return fechaConversionMoneda;
    }

    /**
     * Define el valor de la propiedad fechaConversionMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaConversionMoneda(String value) {
        this.fechaConversionMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionCabecera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionCabecera() {
        return descripcionCabecera;
    }

    /**
     * Define el valor de la propiedad descripcionCabecera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionCabecera(String value) {
        this.descripcionCabecera = value;
    }

    /**
     * Gets the value of the coleccionItemDocumento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coleccionItemDocumento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColeccionItemDocumento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemDocumento }
     * 
     * 
     */
    public List<ItemDocumento> getColeccionItemDocumento() {
        if (coleccionItemDocumento == null) {
            coleccionItemDocumento = new ArrayList<ItemDocumento>();
        }
        return this.coleccionItemDocumento;
    }

}
