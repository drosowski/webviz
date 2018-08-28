
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * If the transaction is about the sales and delivery of goods, then the attributes of this element are used to
 *                 define more details about the transaction. Most important is the sender and receiver location, so from where the goods are
 *                 delivered to which destination. In case of sales in a store both locations would be the store location. If goods are sent
 *                 from or to a warehouse, it can be specified whether the goods are delivered out of or into bond. This information can be in
 *                 the tax decision. The attributes "outOfBond" and"intoBond" should be set to “true”, if either the sales comes out of bond,
 *                 or in analogously if good are put in bond on the buying side. The tax treatment will be impacted especially if goods are
 *                 sold out of bond. If you are using IntelliVAT for supporting inter-company invoicing, then the information, if goods are
 *                 delivered into bond, may have impact on how the transaction is booked on the buyer side. Please set these attributes by
 *                 default to “false”.
 *             
 * 
 * <p>Java-Klasse für delivery element declaration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;element name="delivery"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="senderLocation" type="{http://intellivat.com/invoice}location"/&gt;
 *           &lt;element name="receiverLocation" type="{http://intellivat.com/invoice}location"/&gt;
 *           &lt;element ref="{http://intellivat.com/invoice}shipmentLeg" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;attribute name="intoBond" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *         &lt;attribute name="outOfBond" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "senderLocation",
    "receiverLocation",
    "shipmentLeg"
})
@XmlRootElement(name = "delivery")
public class PretaxDelivery {

    @XmlElement(required = true)
    protected PretaxLocation senderLocation;
    @XmlElement(required = true)
    protected PretaxLocation receiverLocation;
    protected ShipmentLeg shipmentLeg;
    @XmlAttribute(name = "intoBond")
    protected Boolean intoBond;
    @XmlAttribute(name = "outOfBond")
    protected Boolean outOfBond;

    /**
     * Ruft den Wert der senderLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getSenderLocation() {
        return senderLocation;
    }

    /**
     * Legt den Wert der senderLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setSenderLocation(PretaxLocation value) {
        this.senderLocation = value;
    }

    /**
     * Ruft den Wert der receiverLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getReceiverLocation() {
        return receiverLocation;
    }

    /**
     * Legt den Wert der receiverLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setReceiverLocation(PretaxLocation value) {
        this.receiverLocation = value;
    }

    /**
     * Ruft den Wert der shipmentLeg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentLeg }
     *     
     */
    public ShipmentLeg getShipmentLeg() {
        return shipmentLeg;
    }

    /**
     * Legt den Wert der shipmentLeg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentLeg }
     *     
     */
    public void setShipmentLeg(ShipmentLeg value) {
        this.shipmentLeg = value;
    }

    /**
     * Ruft den Wert der intoBond-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIntoBond() {
        if (intoBond == null) {
            return false;
        } else {
            return intoBond;
        }
    }

    /**
     * Legt den Wert der intoBond-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIntoBond(Boolean value) {
        this.intoBond = value;
    }

    /**
     * Ruft den Wert der outOfBond-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOutOfBond() {
        if (outOfBond == null) {
            return false;
        } else {
            return outOfBond;
        }
    }

    /**
     * Legt den Wert der outOfBond-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutOfBond(Boolean value) {
        this.outOfBond = value;
    }

}
