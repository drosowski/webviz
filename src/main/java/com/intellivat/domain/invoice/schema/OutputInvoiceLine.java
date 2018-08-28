
package com.intellivat.domain.invoice.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Each invoiceLine IntelliVAT returns in a post-tax invoice is attached to a superior invoiceLines element. An invoiceLine
 *                 contains three sections of information: firstly the “transactionContext”, secondly the “calculation” and finally the
 *                 “lineTotal”.
 *             
 * 
 * <p>Java-Klasse für invoiceLine complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="invoiceLine"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}transactionContext"/&gt;
 *         &lt;element name="calculation" type="{http://intellivat.com/invoice}invoiceLineCalculationWrapper" maxOccurs="unbounded"/&gt;
 *         &lt;element name="lineTotal" type="{http://intellivat.com/invoice}totalCalculation"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="MAIN"/&gt;
 *             &lt;enumeration value="ANCILLARY"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="preTaxLineRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="unspscUsedForTaxDecision" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceLine", propOrder = {
    "transactionContext",
    "calculation",
    "lineTotal"
})
public class OutputInvoiceLine {

    @XmlElement(required = true)
    protected TransactionContext transactionContext;
    @XmlElement(required = true)
    protected List<InvoiceLineCalculationWrapper> calculation;
    @XmlElement(required = true)
    protected OutputTotalCalculation lineTotal;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "type", required = true)
    protected OutputInvoiceLine.InvoiceLineType type;
    @XmlAttribute(name = "preTaxLineRef", required = true)
    protected String preTaxLineRef;
    @XmlAttribute(name = "unspscUsedForTaxDecision", required = true)
    protected String unspscUsedForTaxDecision;

    /**
     * 
     *                         The transactionContext attached to the invoice line repeats the values, which have been sent in the pre-tax invoice
     *                         for this line. For transparency reasons IntelliVAT returns the line’s transaction context, because it could have
     *                         overwritten the transactionContext set on the header of the pre-tax invoice. So if a invoice line is taxed
     *                         differently from all other invoice lines and is assigned to a separate post-tax invoice, then it is very likely that
     *                         a different transactionContext had been set for this line. The structure of the transactionContext corresponds to
     *                         the pre-tax invoice’s transaction context.
     *                     
     * 
     * @return
     *     possible object is
     *     {@link TransactionContext }
     *     
     */
    public TransactionContext getTransactionContext() {
        return transactionContext;
    }

    /**
     * Legt den Wert der transactionContext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionContext }
     *     
     */
    public void setTransactionContext(TransactionContext value) {
        this.transactionContext = value;
    }

    /**
     * Gets the value of the calculation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calculation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalculation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLineCalculationWrapper }
     * 
     * 
     */
    public List<InvoiceLineCalculationWrapper> getCalculation() {
        if (calculation == null) {
            calculation = new ArrayList<InvoiceLineCalculationWrapper>();
        }
        return this.calculation;
    }

    /**
     * Ruft den Wert der lineTotal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OutputTotalCalculation }
     *     
     */
    public OutputTotalCalculation getLineTotal() {
        return lineTotal;
    }

    /**
     * Legt den Wert der lineTotal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputTotalCalculation }
     *     
     */
    public void setLineTotal(OutputTotalCalculation value) {
        this.lineTotal = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OutputInvoiceLine.InvoiceLineType }
     *     
     */
    public OutputInvoiceLine.InvoiceLineType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputInvoiceLine.InvoiceLineType }
     *     
     */
    public void setType(OutputInvoiceLine.InvoiceLineType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der preTaxLineRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreTaxLineRef() {
        return preTaxLineRef;
    }

    /**
     * Legt den Wert der preTaxLineRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreTaxLineRef(String value) {
        this.preTaxLineRef = value;
    }

    /**
     * Ruft den Wert der unspscUsedForTaxDecision-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnspscUsedForTaxDecision() {
        return unspscUsedForTaxDecision;
    }

    /**
     * Legt den Wert der unspscUsedForTaxDecision-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnspscUsedForTaxDecision(String value) {
        this.unspscUsedForTaxDecision = value;
    }


    /**
     * <p>Java-Klasse für null.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p>
     * <pre>
     * &lt;simpleType&gt;
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *     &lt;enumeration value="MAIN"/&gt;
     *     &lt;enumeration value="ANCILLARY"/&gt;
     *   &lt;/restriction&gt;
     * &lt;/simpleType&gt;
     * </pre>
     * 
     */
    @XmlType(name = "")
    @XmlEnum
    public enum InvoiceLineType {

        MAIN,
        ANCILLARY;

        public String value() {
            return name();
        }

        public static OutputInvoiceLine.InvoiceLineType fromValue(String v) {
            return valueOf(v);
        }

    }

}
