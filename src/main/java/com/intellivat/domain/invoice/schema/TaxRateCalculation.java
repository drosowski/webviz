
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The tax rate calculation is in most jurisdictions the legally relevant calculation of the tax amounts. It is done on invoice
 *                 totals level, grouped by tax type and tax rate indicator (simplified: tax rate). It basically states that the invoice
 *                 contains items and services, which should be taxed under tax type X with the rate of Y%. So all baseAmounts of invoiceLines
 *                 with which have the identical tax type and tax rate will be accumulated to a subtotal and then the tax calculation is
 *                 applied on this subtotal. With this method rounding errors can be easily avoided. If an invoice has only one tax type (e.g.
 *                 VAT) and only one rate, then there will be only one tax rate calculation necessary. But if the invoice contains items, which
 *                 are taxable with different tax rates and/or if the jurisdiction has more than one applicable tax type, then multiple
 *                 taxRateCalculations will be necessary.
 *             
 * 
 * <p>Java-Klasse für taxRateCalculation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="taxRateCalculation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://intellivat.com/invoice}totalCalculation"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taxRateInPercent" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="taxRateIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxRateCalculation", propOrder = {
    "taxRateInPercent"
})
public class TaxRateCalculation
    extends OutputTotalCalculation
{

    @XmlElement(required = true)
    protected BigDecimal taxRateInPercent;
    @XmlAttribute(name = "taxRateIndicator", required = true)
    protected String taxRateIndicator;

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

}
