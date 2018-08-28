
package com.intellivat.domain.invoice.schema;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://intellivat.com/invoice}unitPrice"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}quantity"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}transactionContext" minOccurs="0"/&gt;
 *         &lt;element name="metaInfo" type="{http://intellivat.com/invoice}metaParamValues" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "unitPrice",
    "quantity",
    "transactionContext",
    "metaInfo"
})
@XmlRootElement(name = "ancillaryLine")
public class AncillaryLine {

    @XmlElement(required = true)
    protected BigDecimal unitPrice;
    @XmlElement(required = true)
    protected BigDecimal quantity;
    protected TransactionContext transactionContext;
    protected MetaParamValues metaInfo;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Ruft den Wert der unitPrice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Legt den Wert der unitPrice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitPrice(BigDecimal value) {
        this.unitPrice = value;
    }

    /**
     * Ruft den Wert der quantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Legt den Wert der quantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
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

    /**
     * Ruft den Wert der metaInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MetaParamValues }
     *     
     */
    public MetaParamValues getMetaInfo() {
        return metaInfo;
    }

    /**
     * Legt den Wert der metaInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaParamValues }
     *     
     */
    public void setMetaInfo(MetaParamValues value) {
        this.metaInfo = value;
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

}
