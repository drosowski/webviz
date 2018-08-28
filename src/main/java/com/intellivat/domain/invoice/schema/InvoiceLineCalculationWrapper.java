
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 An invoiceLineCalculationWrapper is needed, because there are three different possibilities how information regarding the
 *                 line’s tax calculation may need to be documented in the post-tax invoice. The standard way is a ‘lineCalculation” which
 *                 applies when any kind of tax applies to a mainLine of a pre-tax invoice, or to an ancillaryLine, if all mainline share the
 *                 same tax rate. If the pre-tax invoice contains mainLines where items will be taxed with different tax rates and it contains
 *                 ancillary lines, then the invoiceLineCalculation will have the structure of a splitCalculation. The third and easy structure
 *                 is if no tax applies on the invoice. In this case a noTax structure used as calculation element of the invoiceLine.
 *             
 * 
 * <p>Java-Klasse für invoiceLineCalculationWrapper complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="invoiceLineCalculationWrapper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="noTax" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="lineCalculation" type="{http://intellivat.com/invoice}taxCalculation"/&gt;
 *         &lt;element name="splitCalculation" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://intellivat.com/invoice}taxCalculation"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="splitFactor" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="taxTypeCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceLineCalculationWrapper", propOrder = {
    "noTax",
    "lineCalculation",
    "splitCalculation"
})
public class InvoiceLineCalculationWrapper {

    protected Object noTax;
    protected OutputTaxCalculation lineCalculation;
    protected List<InvoiceLineCalculationWrapper.SplitCalculation> splitCalculation;
    @XmlAttribute(name = "taxTypeCode", required = true)
    protected String taxTypeCode;

    /**
     * Ruft den Wert der noTax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getNoTax() {
        return noTax;
    }

    /**
     * Legt den Wert der noTax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setNoTax(Object value) {
        this.noTax = value;
    }

    /**
     * Ruft den Wert der lineCalculation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OutputTaxCalculation }
     *     
     */
    public OutputTaxCalculation getLineCalculation() {
        return lineCalculation;
    }

    /**
     * Legt den Wert der lineCalculation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputTaxCalculation }
     *     
     */
    public void setLineCalculation(OutputTaxCalculation value) {
        this.lineCalculation = value;
    }

    /**
     * Gets the value of the splitCalculation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splitCalculation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplitCalculation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLineCalculationWrapper.SplitCalculation }
     * 
     * 
     */
    public List<InvoiceLineCalculationWrapper.SplitCalculation> getSplitCalculation() {
        if (splitCalculation == null) {
            splitCalculation = new ArrayList<InvoiceLineCalculationWrapper.SplitCalculation>();
        }
        return this.splitCalculation;
    }

    /**
     * Ruft den Wert der taxTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    /**
     * Legt den Wert der taxTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxTypeCode(String value) {
        this.taxTypeCode = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://intellivat.com/invoice}taxCalculation"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="splitFactor" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "splitFactor"
    })
    public static class SplitCalculation
        extends OutputTaxCalculation
    {

        @XmlElement(required = true)
        protected BigDecimal splitFactor;

        /**
         * Ruft den Wert der splitFactor-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSplitFactor() {
            return splitFactor;
        }

        /**
         * Legt den Wert der splitFactor-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSplitFactor(BigDecimal value) {
            this.splitFactor = value;
        }

    }

}
