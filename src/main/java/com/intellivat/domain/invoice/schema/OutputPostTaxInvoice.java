
package com.intellivat.domain.invoice.schema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.migesok.jaxb.adapter.javatime.LocalDateXmlAdapter;


/**
 * 
 *                 The postTaxInvoice correlates with an invoice, which has to be created using the IntelliVAT result. It contains an info
 *                 element and an invoicing element.
 *             
 * 
 * <p>Java-Klasse für postTaxInvoice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="postTaxInvoice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="info"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="taxDecisions"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="taxDecision" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="taxIndicator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="sellerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="buyerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="invoiceDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="invoiceCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="localCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="invoicing" type="{http://intellivat.com/invoice}invoicing"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sequenceNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postTaxInvoice", propOrder = {
    "info",
    "invoicing"
})
public class OutputPostTaxInvoice {

    @XmlElement(required = true)
    protected OutputPostTaxInvoice.Info info;
    @XmlElement(required = true)
    protected Invoicing invoicing;
    @XmlAttribute(name = "sequenceNumber", required = true)
    protected int sequenceNumber;

    /**
     * Ruft den Wert der info-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OutputPostTaxInvoice.Info }
     *     
     */
    public OutputPostTaxInvoice.Info getInfo() {
        return info;
    }

    /**
     * Legt den Wert der info-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputPostTaxInvoice.Info }
     *     
     */
    public void setInfo(OutputPostTaxInvoice.Info value) {
        this.info = value;
    }

    /**
     * Ruft den Wert der invoicing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Invoicing }
     *     
     */
    public Invoicing getInvoicing() {
        return invoicing;
    }

    /**
     * Legt den Wert der invoicing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Invoicing }
     *     
     */
    public void setInvoicing(Invoicing value) {
        this.invoicing = value;
    }

    /**
     * Ruft den Wert der sequenceNumber-Eigenschaft ab.
     * 
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Legt den Wert der sequenceNumber-Eigenschaft fest.
     * 
     */
    public void setSequenceNumber(int value) {
        this.sequenceNumber = value;
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
     *         &lt;element name="taxDecisions"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="taxDecision" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="taxIndicator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="sellerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="buyerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="invoiceDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="invoiceCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="localCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
        "taxDecisions",
        "invoiceDate",
        "invoiceCurrencyCode",
        "localCurrencyCode"
    })
    public static class Info {

        @XmlElement(required = true)
        protected OutputPostTaxInvoice.Info.TaxDecisions taxDecisions;
        @XmlElement(required = true, type = String.class)
        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        @XmlSchemaType(name = "date")
        protected LocalDate invoiceDate;
        @XmlElement(required = true)
        protected String invoiceCurrencyCode;
        protected String localCurrencyCode;

        /**
         * Ruft den Wert der taxDecisions-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link OutputPostTaxInvoice.Info.TaxDecisions }
         *     
         */
        public OutputPostTaxInvoice.Info.TaxDecisions getTaxDecisions() {
            return taxDecisions;
        }

        /**
         * Legt den Wert der taxDecisions-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link OutputPostTaxInvoice.Info.TaxDecisions }
         *     
         */
        public void setTaxDecisions(OutputPostTaxInvoice.Info.TaxDecisions value) {
            this.taxDecisions = value;
        }

        /**
         * Ruft den Wert der invoiceDate-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public LocalDate getInvoiceDate() {
            return invoiceDate;
        }

        /**
         * Legt den Wert der invoiceDate-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceDate(LocalDate value) {
            this.invoiceDate = value;
        }

        /**
         * Ruft den Wert der invoiceCurrencyCode-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceCurrencyCode() {
            return invoiceCurrencyCode;
        }

        /**
         * Legt den Wert der invoiceCurrencyCode-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceCurrencyCode(String value) {
            this.invoiceCurrencyCode = value;
        }

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
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="taxDecision" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="taxIndicator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="sellerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="buyerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
            "taxDecision"
        })
        public static class TaxDecisions {

            @XmlElement(required = true)
            protected List<OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision> taxDecision;

            /**
             * Gets the value of the taxDecision property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the taxDecision property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTaxDecision().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision }
             * 
             * 
             */
            public List<OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision> getTaxDecision() {
                if (taxDecision == null) {
                    taxDecision = new ArrayList<OutputPostTaxInvoice.Info.TaxDecisions.TaxDecision>();
                }
                return this.taxDecision;
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
             *         &lt;element name="taxIndicator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="sellerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="buyerJurisdiction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *       &lt;/sequence&gt;
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
                "taxIndicator",
                "sellerJurisdiction",
                "buyerJurisdiction"
            })
            public static class TaxDecision {

                @XmlElement(required = true)
                protected String taxIndicator;
                @XmlElement(required = true)
                protected String sellerJurisdiction;
                @XmlElement(required = true)
                protected String buyerJurisdiction;
                @XmlAttribute(name = "taxTypeCode")
                protected String taxTypeCode;

                /**
                 * Ruft den Wert der taxIndicator-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTaxIndicator() {
                    return taxIndicator;
                }

                /**
                 * Legt den Wert der taxIndicator-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTaxIndicator(String value) {
                    this.taxIndicator = value;
                }

                /**
                 * Ruft den Wert der sellerJurisdiction-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSellerJurisdiction() {
                    return sellerJurisdiction;
                }

                /**
                 * Legt den Wert der sellerJurisdiction-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSellerJurisdiction(String value) {
                    this.sellerJurisdiction = value;
                }

                /**
                 * Ruft den Wert der buyerJurisdiction-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBuyerJurisdiction() {
                    return buyerJurisdiction;
                }

                /**
                 * Legt den Wert der buyerJurisdiction-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBuyerJurisdiction(String value) {
                    this.buyerJurisdiction = value;
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

}
