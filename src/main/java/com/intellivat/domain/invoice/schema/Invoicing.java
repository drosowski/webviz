
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The invoicing section of the post-tax invoice contains all information, which (from a tax perspective) is relevant to print
 *                 on the invoice. Some of the attributes, which IntelliVAT returns, are optional to put on the invoice. These attributes will
 *                 be marked as optional.
 *             
 * 
 * <p>Java-Klasse für invoicing complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="invoicing"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="invoiceLines"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="invoiceLine" type="{http://intellivat.com/invoice}invoiceLine" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="totals"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="taxTypeTotals" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="noTax" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="taxRateTotals" type="{http://intellivat.com/invoice}taxRateCalculation" maxOccurs="unbounded"/&gt;
 *                               &lt;element name="total" type="{http://intellivat.com/invoice}totalCalculation"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/choice&gt;
 *                           &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="invoiceTotal" type="{http://intellivat.com/invoice}totalCalculation"/&gt;
 *                     &lt;element name="noTaxInvoiceTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="invoiceTaxTotalInLocalCurrency" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="localCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="taxRegistrations" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="sellerTaxRegistration" type="{http://intellivat.com/invoice}taxRegistration" minOccurs="0"/&gt;
 *                   &lt;element name="buyerTaxRegistration" type="{http://intellivat.com/invoice}taxRegistration" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="taxIndicatorComments" type="{http://intellivat.com/invoice}taxIndicatorComments" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoicing", propOrder = {
    "invoiceLines",
    "totals",
    "taxRegistrations",
    "taxIndicatorComments"
})
public class Invoicing {

    @XmlElement(required = true)
    protected Invoicing.InvoiceLines invoiceLines;
    @XmlElement(required = true)
    protected Invoicing.Totals totals;
    protected List<Invoicing.TaxRegistrations> taxRegistrations;
    protected List<OutputTaxIndicatorComments> taxIndicatorComments;

    /**
     * Ruft den Wert der invoiceLines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Invoicing.InvoiceLines }
     *     
     */
    public Invoicing.InvoiceLines getInvoiceLines() {
        return invoiceLines;
    }

    /**
     * Legt den Wert der invoiceLines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Invoicing.InvoiceLines }
     *     
     */
    public void setInvoiceLines(Invoicing.InvoiceLines value) {
        this.invoiceLines = value;
    }

    /**
     * Ruft den Wert der totals-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Invoicing.Totals }
     *     
     */
    public Invoicing.Totals getTotals() {
        return totals;
    }

    /**
     * Legt den Wert der totals-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Invoicing.Totals }
     *     
     */
    public void setTotals(Invoicing.Totals value) {
        this.totals = value;
    }

    /**
     * Gets the value of the taxRegistrations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxRegistrations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxRegistrations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Invoicing.TaxRegistrations }
     * 
     * 
     */
    public List<Invoicing.TaxRegistrations> getTaxRegistrations() {
        if (taxRegistrations == null) {
            taxRegistrations = new ArrayList<Invoicing.TaxRegistrations>();
        }
        return this.taxRegistrations;
    }

    /**
     * Gets the value of the taxIndicatorComments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxIndicatorComments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxIndicatorComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputTaxIndicatorComments }
     * 
     * 
     */
    public List<OutputTaxIndicatorComments> getTaxIndicatorComments() {
        if (taxIndicatorComments == null) {
            taxIndicatorComments = new ArrayList<OutputTaxIndicatorComments>();
        }
        return this.taxIndicatorComments;
    }


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
     *         &lt;element name="invoiceLine" type="{http://intellivat.com/invoice}invoiceLine" maxOccurs="unbounded"/&gt;
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
        "invoiceLine"
    })
    public static class InvoiceLines {

        @XmlElement(required = true)
        protected List<OutputInvoiceLine> invoiceLine;

        /**
         * Gets the value of the invoiceLine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the invoiceLine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInvoiceLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutputInvoiceLine }
         * 
         * 
         */
        public List<OutputInvoiceLine> getInvoiceLine() {
            if (invoiceLine == null) {
                invoiceLine = new ArrayList<OutputInvoiceLine>();
            }
            return this.invoiceLine;
        }

    }


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
     *         &lt;element name="sellerTaxRegistration" type="{http://intellivat.com/invoice}taxRegistration" minOccurs="0"/&gt;
     *         &lt;element name="buyerTaxRegistration" type="{http://intellivat.com/invoice}taxRegistration" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sellerTaxRegistration",
        "buyerTaxRegistration"
    })
    public static class TaxRegistrations {

        protected TaxRegistration sellerTaxRegistration;
        protected TaxRegistration buyerTaxRegistration;
        @XmlAttribute(name = "taxTypeCode")
        @XmlSchemaType(name = "anySimpleType")
        protected String taxTypeCode;

        /**
         * Ruft den Wert der sellerTaxRegistration-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link TaxRegistration }
         *     
         */
        public TaxRegistration getSellerTaxRegistration() {
            return sellerTaxRegistration;
        }

        /**
         * Legt den Wert der sellerTaxRegistration-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link TaxRegistration }
         *     
         */
        public void setSellerTaxRegistration(TaxRegistration value) {
            this.sellerTaxRegistration = value;
        }

        /**
         * Ruft den Wert der buyerTaxRegistration-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link TaxRegistration }
         *     
         */
        public TaxRegistration getBuyerTaxRegistration() {
            return buyerTaxRegistration;
        }

        /**
         * Legt den Wert der buyerTaxRegistration-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link TaxRegistration }
         *     
         */
        public void setBuyerTaxRegistration(TaxRegistration value) {
            this.buyerTaxRegistration = value;
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

    }


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
     *         &lt;element name="taxTypeTotals" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="noTax" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="taxRateTotals" type="{http://intellivat.com/invoice}taxRateCalculation" maxOccurs="unbounded"/&gt;
     *                     &lt;element name="total" type="{http://intellivat.com/invoice}totalCalculation"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/choice&gt;
     *                 &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;choice&gt;
     *           &lt;element name="invoiceTotal" type="{http://intellivat.com/invoice}totalCalculation"/&gt;
     *           &lt;element name="noTaxInvoiceTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="invoiceTaxTotalInLocalCurrency" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="localCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "taxTypeTotals",
        "invoiceTotal",
        "noTaxInvoiceTotal",
        "invoiceTaxTotalInLocalCurrency"
    })
    public static class Totals {

        @XmlElement(required = true)
        protected List<Invoicing.Totals.TaxTypeTotals> taxTypeTotals;
        protected OutputTotalCalculation invoiceTotal;
        protected BigDecimal noTaxInvoiceTotal;
        protected Invoicing.Totals.InvoiceTaxTotalInLocalCurrency invoiceTaxTotalInLocalCurrency;

        /**
         * Gets the value of the taxTypeTotals property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the taxTypeTotals property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTaxTypeTotals().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Invoicing.Totals.TaxTypeTotals }
         * 
         * 
         */
        public List<Invoicing.Totals.TaxTypeTotals> getTaxTypeTotals() {
            if (taxTypeTotals == null) {
                taxTypeTotals = new ArrayList<Invoicing.Totals.TaxTypeTotals>();
            }
            return this.taxTypeTotals;
        }

        /**
         * Ruft den Wert der invoiceTotal-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link OutputTotalCalculation }
         *     
         */
        public OutputTotalCalculation getInvoiceTotal() {
            return invoiceTotal;
        }

        /**
         * Legt den Wert der invoiceTotal-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link OutputTotalCalculation }
         *     
         */
        public void setInvoiceTotal(OutputTotalCalculation value) {
            this.invoiceTotal = value;
        }

        /**
         * Ruft den Wert der noTaxInvoiceTotal-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getNoTaxInvoiceTotal() {
            return noTaxInvoiceTotal;
        }

        /**
         * Legt den Wert der noTaxInvoiceTotal-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setNoTaxInvoiceTotal(BigDecimal value) {
            this.noTaxInvoiceTotal = value;
        }

        /**
         * Ruft den Wert der invoiceTaxTotalInLocalCurrency-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Invoicing.Totals.InvoiceTaxTotalInLocalCurrency }
         *     
         */
        public Invoicing.Totals.InvoiceTaxTotalInLocalCurrency getInvoiceTaxTotalInLocalCurrency() {
            return invoiceTaxTotalInLocalCurrency;
        }

        /**
         * Legt den Wert der invoiceTaxTotalInLocalCurrency-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Invoicing.Totals.InvoiceTaxTotalInLocalCurrency }
         *     
         */
        public void setInvoiceTaxTotalInLocalCurrency(Invoicing.Totals.InvoiceTaxTotalInLocalCurrency value) {
            this.invoiceTaxTotalInLocalCurrency = value;
        }


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
         *         &lt;element name="localCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
            "localCurrencyCode",
            "exchangeRate",
            "amount"
        })
        public static class InvoiceTaxTotalInLocalCurrency {

            @XmlElement(required = true)
            protected String localCurrencyCode;
            @XmlElement(required = true)
            protected BigDecimal exchangeRate;
            @XmlElement(required = true)
            protected BigDecimal amount;

            /**
             * Ruft den Wert der localCurrencyCode-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocalCurrencyCode() {
                return localCurrencyCode;
            }

            /**
             * Legt den Wert der localCurrencyCode-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocalCurrencyCode(String value) {
                this.localCurrencyCode = value;
            }

            /**
             * Ruft den Wert der exchangeRate-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getExchangeRate() {
                return exchangeRate;
            }

            /**
             * Legt den Wert der exchangeRate-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setExchangeRate(BigDecimal value) {
                this.exchangeRate = value;
            }

            /**
             * Ruft den Wert der amount-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Legt den Wert der amount-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;choice&gt;
         *         &lt;element name="noTax" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
         *         &lt;sequence&gt;
         *           &lt;element name="taxRateTotals" type="{http://intellivat.com/invoice}taxRateCalculation" maxOccurs="unbounded"/&gt;
         *           &lt;element name="total" type="{http://intellivat.com/invoice}totalCalculation"/&gt;
         *         &lt;/sequence&gt;
         *       &lt;/choice&gt;
         *       &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "noTax",
            "taxRateTotals",
            "total"
        })
        public static class TaxTypeTotals {

            protected Object noTax;
            protected List<TaxRateCalculation> taxRateTotals;
            protected OutputTotalCalculation total;
            @XmlAttribute(name = "taxTypeCode")
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
             * Gets the value of the taxRateTotals property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the taxRateTotals property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTaxRateTotals().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TaxRateCalculation }
             * 
             * 
             */
            public List<TaxRateCalculation> getTaxRateTotals() {
                if (taxRateTotals == null) {
                    taxRateTotals = new ArrayList<TaxRateCalculation>();
                }
                return this.taxRateTotals;
            }

            /**
             * Ruft den Wert der total-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link OutputTotalCalculation }
             *     
             */
            public OutputTotalCalculation getTotal() {
                return total;
            }

            /**
             * Legt den Wert der total-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link OutputTotalCalculation }
             *     
             */
            public void setTotal(OutputTotalCalculation value) {
                this.total = value;
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

        }

    }

}
