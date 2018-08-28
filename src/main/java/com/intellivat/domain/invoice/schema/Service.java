
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
 *         &lt;element name="serviceProviderLocation" type="{http://intellivat.com/invoice}location"/&gt;
 *         &lt;element name="serviceLocation" type="{http://intellivat.com/invoice}location"/&gt;
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
    "serviceProviderLocation",
    "serviceLocation"
})
@XmlRootElement(name = "service")
public class Service {

    @XmlElement(required = true)
    protected PretaxLocation serviceProviderLocation;
    @XmlElement(required = true)
    protected PretaxLocation serviceLocation;

    /**
     * Ruft den Wert der serviceProviderLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getServiceProviderLocation() {
        return serviceProviderLocation;
    }

    /**
     * Legt den Wert der serviceProviderLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setServiceProviderLocation(PretaxLocation value) {
        this.serviceProviderLocation = value;
    }

    /**
     * Ruft den Wert der serviceLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getServiceLocation() {
        return serviceLocation;
    }

    /**
     * Legt den Wert der serviceLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setServiceLocation(PretaxLocation value) {
        this.serviceLocation = value;
    }

}
