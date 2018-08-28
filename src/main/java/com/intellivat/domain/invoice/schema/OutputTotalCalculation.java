
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The total calculation applies to the invoice totals and to the invoice lines. It basically groups all calculated values in
 *                 three attributes: base (or net) amount, tax amount and total amount. The sum of base and tax amount should result in the
 *                 total amount. Dependent on the tax calculation level of the seller’s jurisdiction of the invoice the tax calculation takes
 *                 place either on totals per tax type and tax rate (default) or on invoice line level (exception). If the legally relevant
 *                 calculation is done on total levels, then the sum of all calculated line calculations will most likely result in rounding
 *                 differences, especially if the line’s amounts have been rounded. The best way to solve (hide) this mathematical problem is
 *                 not to print calculated line amounts on invoice line level. If the price type of the invoice is ‘NET’ print only the
 *                 baseAmount on the invoice line. If the price type is ‘GROSS_FIX’ or ‘GROSS_RECALC’ print only the totalAmount of the invoice
 *                 line. In the invoice totals section of your invoice you need always to print all three amount.
 *             
 * 
 * <p>Java-Klasse für totalCalculation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="totalCalculation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="baseAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalCalculation", propOrder = {
    "baseAmount",
    "taxAmount",
    "totalAmount"
})
@XmlSeeAlso({
    TaxRateCalculation.class
})
public class OutputTotalCalculation {

    @XmlElement(required = true)
    protected BigDecimal baseAmount;
    @XmlElement(required = true)
    protected BigDecimal taxAmount;
    @XmlElement(required = true)
    protected BigDecimal totalAmount;

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
     * Ruft den Wert der totalAmount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Legt den Wert der totalAmount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

}
