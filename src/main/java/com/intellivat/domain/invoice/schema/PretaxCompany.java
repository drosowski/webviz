
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * In case the seller or buyer information is not registered in IntelliVAT, the company section can be used to
 *                 give the location and if available the tax registration of the entity as input to IntelliVAT. For example if the calling
 *                 system is a web-shop and for taxing the shopping chart you may not have all details of the customer yet. In this case just
 *                 enter the country where you assume that your customer will probably order from (derived from IP address). This will enable
 *                 IntelliVAT to do a tax decision for the given location. In case of B2B it is also possible to send the tax registration
 *                 number as input to IntelliVAT, which may be required for a correct tax decision if a business orders from abroad.
 *             
 * 
 * <p>Java-Klasse für company complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="company"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="location" type="{http://intellivat.com/invoice}location"/&gt;
 *         &lt;element name="taxRegistrations" type="{http://intellivat.com/invoice}taxRegistrations" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "company", propOrder = {
    "location",
    "taxRegistrations"
})
public class PretaxCompany {

    @XmlElement(required = true)
    protected PretaxLocation location;
    protected TaxRegistrations taxRegistrations;

    /**
     * Ruft den Wert der location-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxLocation }
     *     
     */
    public PretaxLocation getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxLocation }
     *     
     */
    public void setLocation(PretaxLocation value) {
        this.location = value;
    }

    /**
     * Ruft den Wert der taxRegistrations-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TaxRegistrations }
     *     
     */
    public TaxRegistrations getTaxRegistrations() {
        return taxRegistrations;
    }

    /**
     * Legt den Wert der taxRegistrations-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRegistrations }
     *     
     */
    public void setTaxRegistrations(TaxRegistrations value) {
        this.taxRegistrations = value;
    }

}
