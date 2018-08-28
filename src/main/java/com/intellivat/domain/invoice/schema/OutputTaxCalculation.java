
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The taxCalculation contains a baseAmount and a taxRateInPercent, which are used to calculate the taxAmount. The calculation
 *                 is done according to the price type set in the pre-tax invoice. In case of net prices the tax will be calculated on
 *                 the baseAmount. If the price-type is GROSS_FIX or GROSS_RECALC, then the tax will need to be calculated out of the
 *                 baseAmount. As a grouping criterion and as base for the identification of the applicable tax rate, the taxCalculation
 *                 element contains the tax rate indicator, which is identified by the UNSPSC code, which is set in the attribute
 *                 “unspscUsedForTaxRateLookup” and the seller jurisdiction.
 *             
 * 
 * <p>Java-Klasse für taxCalculation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="taxCalculation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="baseAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="taxRateInPercent" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="taxRateIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="unspscUsedForTaxRateLookup" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxCalculation", propOrder = {
    "baseAmount",
    "taxAmount",
    "taxRateInPercent"
})
@XmlSeeAlso({
    com.intellivat.domain.invoice.schema.InvoiceLineCalculationWrapper.SplitCalculation.class
})
public class OutputTaxCalculation {

    @XmlElement(required = true)
    protected BigDecimal baseAmount;
    @XmlElement(required = true)
    protected BigDecimal taxAmount;
    @XmlElement(required = true)
    protected BigDecimal taxRateInPercent;
    @XmlAttribute(name = "taxRateIndicator", required = true)
    protected String taxRateIndicator;
    @XmlAttribute(name = "unspscUsedForTaxRateLookup", required = true)
    protected String unspscUsedForTaxRateLookup;

    /**
     * Ruft den Wert der baseAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    /**
     * Legt den Wert der baseAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseAmount(BigDecimal value) {
        this.baseAmount = value;
    }

    /**
     * Ruft den Wert der taxAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * Legt den Wert der taxAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxAmount(BigDecimal value) {
        this.taxAmount = value;
    }

    /**
     * Ruft den Wert der taxRateInPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxRateInPercent() {
        return taxRateInPercent;
    }

    /**
     * Legt den Wert der taxRateInPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxRateInPercent(BigDecimal value) {
        this.taxRateInPercent = value;
    }

    /**
     * Ruft den Wert der taxRateIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxRateIndicator() {
        return taxRateIndicator;
    }

    /**
     * Legt den Wert der taxRateIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxRateIndicator(String value) {
        this.taxRateIndicator = value;
    }

    /**
     * Ruft den Wert der unspscUsedForTaxRateLookup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnspscUsedForTaxRateLookup() {
        return unspscUsedForTaxRateLookup;
    }

    /**
     * Legt den Wert der unspscUsedForTaxRateLookup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnspscUsedForTaxRateLookup(String value) {
        this.unspscUsedForTaxRateLookup = value;
    }

}
