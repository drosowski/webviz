
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}ancillaryLine"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ancillaryLine"
})
@XmlRootElement(name = "ancillaryLines")
public class AncillaryLines {

    @XmlElement(required = true)
    protected AncillaryLine ancillaryLine;

    /**
     * Ruft den Wert der ancillaryLine-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AncillaryLine }
     *     
     */
    public AncillaryLine getAncillaryLine() {
        return ancillaryLine;
    }

    /**
     * Legt den Wert der ancillaryLine-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AncillaryLine }
     *     
     */
    public void setAncillaryLine(AncillaryLine value) {
        this.ancillaryLine = value;
    }

}
