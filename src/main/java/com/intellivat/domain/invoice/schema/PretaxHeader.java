
package com.intellivat.domain.invoice.schema;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.migesok.jaxb.adapter.javatime.LocalDateXmlAdapter;


/**
 * An invoice usually consists of one header and one to many lines. The header information contains all elements
 *                 which are unique for one invoice, like the seller, buyer, the currency and the date. Technically the header element is a
 *                 container for all unique parts of an invoice.
 *             
 * 
 * <p>Java-Klasse für header element declaration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;element name="header"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;choice&gt;
 *             &lt;element name="seller" type="{http://intellivat.com/invoice}company"/&gt;
 *             &lt;element name="seller-ref" type="{http://intellivat.com/invoice}companyRef"/&gt;
 *           &lt;/choice&gt;
 *           &lt;choice&gt;
 *             &lt;element name="buyer" type="{http://intellivat.com/invoice}company"/&gt;
 *             &lt;element name="buyer-ref" type="{http://intellivat.com/invoice}companyRef"/&gt;
 *           &lt;/choice&gt;
 *           &lt;element name="invoiceCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element ref="{http://intellivat.com/invoice}priceInfo"/&gt;
 *           &lt;element name="invoiceDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *           &lt;element name="invoiceLanguage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element ref="{http://intellivat.com/invoice}transactionContext"/&gt;
 *         &lt;/sequence&gt;
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
    "seller",
    "sellerRef",
    "buyer",
    "buyerRef",
    "invoiceCurrencyCode",
    "priceInfo",
    "invoiceDate",
    "invoiceLanguage",
    "transactionContext"
})
@XmlRootElement(name = "header")
public class PretaxHeader {

    protected PretaxCompany seller;
    @XmlElement(name = "seller-ref")
    protected CompanyRef sellerRef;
    protected PretaxCompany buyer;
    @XmlElement(name = "buyer-ref")
    protected CompanyRef buyerRef;
    @XmlElement(required = true)
    protected String invoiceCurrencyCode;
    @XmlElement(required = true)
    protected PriceInfo priceInfo;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    @XmlSchemaType(name = "date")
    protected LocalDate invoiceDate;
    @XmlElement(required = true)
    protected String invoiceLanguage;
    @XmlElement(required = true)
    protected TransactionContext transactionContext;

    /**
     * Ruft den Wert der seller-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxCompany }
     *     
     */
    public PretaxCompany getSeller() {
        return seller;
    }

    /**
     * Legt den Wert der seller-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxCompany }
     *     
     */
    public void setSeller(PretaxCompany value) {
        this.seller = value;
    }

    /**
     * Ruft den Wert der sellerRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompanyRef }
     *     
     */
    public CompanyRef getSellerRef() {
        return sellerRef;
    }

    /**
     * Legt den Wert der sellerRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyRef }
     *     
     */
    public void setSellerRef(CompanyRef value) {
        this.sellerRef = value;
    }

    /**
     * Ruft den Wert der buyer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxCompany }
     *     
     */
    public PretaxCompany getBuyer() {
        return buyer;
    }

    /**
     * Legt den Wert der buyer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxCompany }
     *     
     */
    public void setBuyer(PretaxCompany value) {
        this.buyer = value;
    }

    /**
     * Ruft den Wert der buyerRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompanyRef }
     *     
     */
    public CompanyRef getBuyerRef() {
        return buyerRef;
    }

    /**
     * Legt den Wert der buyerRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyRef }
     *     
     */
    public void setBuyerRef(CompanyRef value) {
        this.buyerRef = value;
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
     * Ruft den Wert der priceInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceInfo }
     *     
     */
    public PriceInfo getPriceInfo() {
        return priceInfo;
    }

    /**
     * Legt den Wert der priceInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceInfo }
     *     
     */
    public void setPriceInfo(PriceInfo value) {
        this.priceInfo = value;
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
     * Ruft den Wert der invoiceLanguage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceLanguage() {
        return invoiceLanguage;
    }

    /**
     * Legt den Wert der invoiceLanguage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceLanguage(String value) {
        this.invoiceLanguage = value;
    }

    /**
     * Ruft den Wert der transactionContext-Eigenschaft ab.
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

}
