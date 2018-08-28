
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
 *         &lt;element name="shipFromLocation" type="{http://intellivat.com/invoice}location"/&gt;
 *         &lt;element name="shipToLocation" type="{http://intellivat.com/invoice}location"/&gt;
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
    "shipFromLocation",
    "shipToLocation"
})
@XmlRootElement(name = "shipmentLeg")
public class ShipmentLeg {

    @XmlElement(required = true)
    protected PretaxLocation shipFromLocation;
    @XmlElement(required = true)
    protected PretaxLocation shipToLocation;

    /**
     * Ruft den Wert der shipFromLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getShipFromLocation() {
        return shipFromLocation;
    }

    /**
     * Legt den Wert der shipFromLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setShipFromLocation(PretaxLocation value) {
        this.shipFromLocation = value;
    }

    /**
     * Ruft den Wert der shipToLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getShipToLocation() {
        return shipToLocation;
    }

    /**
     * Legt den Wert der shipToLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setShipToLocation(PretaxLocation value) {
        this.shipToLocation = value;
    }

}
