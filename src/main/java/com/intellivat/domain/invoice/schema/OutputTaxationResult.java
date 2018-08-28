
package com.intellivat.domain.invoice.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 *                 This is the root element of the taxationResult, which has to be considered as an envelope of different taxation results
 *                 expressed in post-tax invoices. Normally one taxation request (pre-tax invoice) will result in only one post-tax invoice.
 *                 But if articles have been combined in one pre-tax invoice, which are taxable in different jurisdictions, then IntelliVAT
 *                 will group all invoice lines, which have an identical tax indicator and jurisdictions in one post-tax invoice. All resulting
 *                 post-tax invoices are attached to one taxation result. If you implement the further handling of the taxation result in the
 *                 invoicing system, please take care that your implementation is prepared to react on more than one post-tax invoice even if
 *                 it would be unlikely according to the business scenario. The transactionResult has the attribute transactionId, which
 *                 contains a unique string and can be used to identify a single transaction. It is strongly recommended to store the
 *                 IntelliVAT transactionId on each invoice, in order to facilitate the audit and error handling procedure.
 *             
 * 
 * <p>Java-Klasse für taxationResult element declaration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;element name="taxationResult"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="referenceTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *           &lt;element name="processingInfo"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="message" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;attribute name="type" type="{http://intellivat.com/invoice}messageCommunicationType" /&gt;
 *                             &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attribute name="status" type="{http://intellivat.com/invoice}messageCommunicationType" /&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="postTaxInvoices" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="postTaxInvoice" type="{http://intellivat.com/invoice}postTaxInvoice" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element ref="{http://intellivat.com/invoice}preTaxInvoice" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;attribute name="transactionId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "referenceTimestamp",
    "processingInfo",
    "postTaxInvoices",
    "preTaxInvoice"
})
@XmlRootElement(name = "taxationResult")
public class OutputTaxationResult {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar referenceTimestamp;
    @XmlElement(required = true)
    protected OutputTaxationResult.ProcessingInfo processingInfo;
    protected OutputTaxationResult.PostTaxInvoices postTaxInvoices;
    protected PreTaxInvoice preTaxInvoice;
    @XmlAttribute(name = "transactionId", required = true)
    protected String transactionId;

    /**
     * Ruft den Wert der referenceTimestamp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReferenceTimestamp() {
        return referenceTimestamp;
    }

    /**
     * Legt den Wert der referenceTimestamp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReferenceTimestamp(XMLGregorianCalendar value) {
        this.referenceTimestamp = value;
    }

    /**
     * Ruft den Wert der processingInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OutputTaxationResult.ProcessingInfo }
     *     
     */
    public OutputTaxationResult.ProcessingInfo getProcessingInfo() {
        return processingInfo;
    }

    /**
     * Legt den Wert der processingInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputTaxationResult.ProcessingInfo }
     *     
     */
    public void setProcessingInfo(OutputTaxationResult.ProcessingInfo value) {
        this.processingInfo = value;
    }

    /**
     * Ruft den Wert der postTaxInvoices-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OutputTaxationResult.PostTaxInvoices }
     *     
     */
    public OutputTaxationResult.PostTaxInvoices getPostTaxInvoices() {
        return postTaxInvoices;
    }

    /**
     * Legt den Wert der postTaxInvoices-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputTaxationResult.PostTaxInvoices }
     *     
     */
    public void setPostTaxInvoices(OutputTaxationResult.PostTaxInvoices value) {
        this.postTaxInvoices = value;
    }

    /**
     * Ruft den Wert der preTaxInvoice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PreTaxInvoice }
     *     
     */
    public PreTaxInvoice getPreTaxInvoice() {
        return preTaxInvoice;
    }

    /**
     * Legt den Wert der preTaxInvoice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PreTaxInvoice }
     *     
     */
    public void setPreTaxInvoice(PreTaxInvoice value) {
        this.preTaxInvoice = value;
    }

    /**
     * Ruft den Wert der transactionId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Legt den Wert der transactionId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
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
     *         &lt;element name="postTaxInvoice" type="{http://intellivat.com/invoice}postTaxInvoice" maxOccurs="unbounded"/&gt;
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
        "postTaxInvoice"
    })
    public static class PostTaxInvoices {

        @XmlElement(required = true)
        protected List<OutputPostTaxInvoice> postTaxInvoice;

        /**
         * Gets the value of the postTaxInvoice property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the postTaxInvoice property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPostTaxInvoice().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutputPostTaxInvoice }
         * 
         * 
         */
        public List<OutputPostTaxInvoice> getPostTaxInvoice() {
            if (postTaxInvoice == null) {
                postTaxInvoice = new ArrayList<OutputPostTaxInvoice>();
            }
            return this.postTaxInvoice;
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
     *         &lt;element name="message" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="type" type="{http://intellivat.com/invoice}messageCommunicationType" /&gt;
     *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="status" type="{http://intellivat.com/invoice}messageCommunicationType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "message"
    })
    public static class ProcessingInfo {

        protected List<OutputTaxationResult.ProcessingInfo.Message> message;
        @XmlAttribute(name = "status")
        protected MessageCommunicationType status;

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutputTaxationResult.ProcessingInfo.Message }
         * 
         * 
         */
        public List<OutputTaxationResult.ProcessingInfo.Message> getMessage() {
            if (message == null) {
                message = new ArrayList<OutputTaxationResult.ProcessingInfo.Message>();
            }
            return this.message;
        }

        /**
         * Ruft den Wert der status-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link MessageCommunicationType }
         *     
         */
        public MessageCommunicationType getStatus() {
            return status;
        }

        /**
         * Legt den Wert der status-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageCommunicationType }
         *     
         */
        public void setStatus(MessageCommunicationType value) {
            this.status = value;
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
         *       &lt;attribute name="type" type="{http://intellivat.com/invoice}messageCommunicationType" /&gt;
         *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class Message {

            @XmlValue
            protected String content;
            @XmlAttribute(name = "type")
            protected MessageCommunicationType type;
            @XmlAttribute(name = "code")
            protected String code;

            /**
             * Ruft den Wert der content-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContent() {
                return content;
            }

            /**
             * Legt den Wert der content-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContent(String value) {
                this.content = value;
            }

            /**
             * Ruft den Wert der type-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link MessageCommunicationType }
             *     
             */
            public MessageCommunicationType getType() {
                return type;
            }

            /**
             * Legt den Wert der type-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link MessageCommunicationType }
             *     
             */
            public void setType(MessageCommunicationType value) {
                this.type = value;
            }

            /**
             * Ruft den Wert der code-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Legt den Wert der code-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

        }

    }

}
