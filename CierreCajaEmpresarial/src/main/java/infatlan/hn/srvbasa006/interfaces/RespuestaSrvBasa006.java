
package infatlan.hn.srvbasa006.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RespuestaSrvBasa006 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RespuestaSrvBasa006">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.srvbasa006.hn.infatlan/}RespuestaBase">
 *       &lt;sequence>
 *         &lt;element name="numeroDocumentoContable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anoFiscal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notaItemContable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaSrvBasa006", propOrder = {
    "numeroDocumentoContable",
    "anoFiscal",
    "notaItemContable"
})
public class RespuestaSrvBasa006
    extends RespuestaBase
{

    protected String numeroDocumentoContable;
    protected String anoFiscal;
    protected String notaItemContable;

    /**
     * Obtiene el valor de la propiedad numeroDocumentoContable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumentoContable() {
        return numeroDocumentoContable;
    }

    /**
     * Define el valor de la propiedad numeroDocumentoContable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumentoContable(String value) {
        this.numeroDocumentoContable = value;
    }

    /**
     * Obtiene el valor de la propiedad anoFiscal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnoFiscal() {
        return anoFiscal;
    }

    /**
     * Define el valor de la propiedad anoFiscal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnoFiscal(String value) {
        this.anoFiscal = value;
    }

    /**
     * Obtiene el valor de la propiedad notaItemContable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotaItemContable() {
        return notaItemContable;
    }

    /**
     * Define el valor de la propiedad notaItemContable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotaItemContable(String value) {
        this.notaItemContable = value;
    }

}
