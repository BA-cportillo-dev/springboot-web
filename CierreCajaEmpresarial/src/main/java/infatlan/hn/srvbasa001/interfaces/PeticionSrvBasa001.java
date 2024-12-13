
package infatlan.hn.srvbasa001.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PeticionSrvBasa001 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PeticionSrvBasa001">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.srvbasa001.hn.infatlan/}PeticionBase">
 *       &lt;sequence>
 *         &lt;element name="indicadorSimulacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coleccionPartidaPago" type="{http://interfaces.srvbasa001.hn.infatlan/}ItemPartidaPago" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionSrvBasa001", propOrder = {
    "indicadorSimulacion",
    "coleccionPartidaPago"
})
public class PeticionSrvBasa001
    extends PeticionBase
{

    @XmlElement(defaultValue = "false")
    protected String indicadorSimulacion;
    protected List<ItemPartidaPago> coleccionPartidaPago;

    /**
     * Obtiene el valor de la propiedad indicadorSimulacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorSimulacion() {
        return indicadorSimulacion;
    }

    /**
     * Define el valor de la propiedad indicadorSimulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorSimulacion(String value) {
        this.indicadorSimulacion = value;
    }

    /**
     * Gets the value of the coleccionPartidaPago property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coleccionPartidaPago property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColeccionPartidaPago().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPartidaPago }
     * 
     * 
     */
    public List<ItemPartidaPago> getColeccionPartidaPago() {
        if (coleccionPartidaPago == null) {
            coleccionPartidaPago = new ArrayList<ItemPartidaPago>();
        }
        return this.coleccionPartidaPago;
    }

}
