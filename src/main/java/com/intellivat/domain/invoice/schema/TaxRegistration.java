
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A tax registration consists of a jurisdiction code and the tax registration number of the company.
 *             
 * 
 * <p>Java-Klasse für taxRegistration complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="taxRegistration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jurisdictionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="registrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxRegistration", propOrder = {
    "jurisdictionCode",
    "registrationNumber"
})
public class TaxRegistration {

    @XmlElement(required = true)
    protected String jurisdictionCode;
    @XmlElement(required = true)
    protected String registrationNumber;

    /**
     * Ruft den Wert der jurisdictionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionCode() {
        return jurisdictionCode;
    }

    /**
     * Legt den Wert der jurisdictionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionCode(String value) {
        this.jurisdictionCode = value;
    }

    /**
     * Ruft den Wert der registrationNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Legt den Wert der registrationNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationNumber(String value) {
        this.registrationNumber = value;
    }

}
