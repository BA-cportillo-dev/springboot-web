
package infatlan.hn.srvbasa010.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RespuestaSrvBasa010 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RespuestaSrvBasa010">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.srvbasa010.hn.infatlan/}RespuestaBase">
 *       &lt;sequence>
 *         &lt;element name="cantidadCoincidencias" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="coleccionUnidadOrganizativa" type="{http://interfaces.srvbasa010.hn.infatlan/}UnidadOrganizativa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaSrvBasa010", propOrder = {
    "cantidadCoincidencias",
    "coleccionUnidadOrganizativa"
})
public class RespuestaSrvBasa010
    extends RespuestaBase
{

    @XmlElement(defaultValue = "0")
    protected int cantidadCoincidencias;
    protected List<UnidadOrganizativa> coleccionUnidadOrganizativa;

    /**
     * Obtiene el valor de la propiedad cantidadCoincidencias.
     * 
     */
    public int getCantidadCoincidencias() {
        return cantidadCoincidencias;
    }

    /**
     * Define el valor de la propiedad cantidadCoincidencias.
     * 
     */
    public void setCantidadCoincidencias(int value) {
        this.cantidadCoincidencias = value;
    }

    /**
     * Gets the value of the coleccionUnidadOrganizativa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coleccionUnidadOrganizativa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColeccionUnidadOrganizativa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnidadOrganizativa }
     * 
     * 
     */
    public List<UnidadOrganizativa> getColeccionUnidadOrganizativa() {
        if (coleccionUnidadOrganizativa == null) {
            coleccionUnidadOrganizativa = new ArrayList<UnidadOrganizativa>();
        }
        return this.coleccionUnidadOrganizativa;
    }

}
