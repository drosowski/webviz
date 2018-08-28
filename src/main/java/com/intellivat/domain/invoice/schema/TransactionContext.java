
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
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
 *         &lt;element ref="{http://intellivat.com/invoice}chainTransaction" minOccurs="0"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}delivery" minOccurs="0"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}service" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="B2B"/&gt;
 *             &lt;enumeration value="B2C"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "chainTransaction",
    "delivery",
    "service"
})
@XmlRootElement(name = "transactionContext")
public class TransactionContext {

    protected PretaxChainTransaction chainTransaction;
    protected PretaxDelivery delivery;
    protected Service service;
    @XmlAttribute(name = "type", required = true)
    protected TransactionContext.TransactionContextType type;

    /**
     * Ruft den Wert der chainTransaction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxChainTransaction }
     *     
     */
    public PretaxChainTransaction getChainTransaction() {
        return chainTransaction;
    }

    /**
     * Legt den Wert der chainTransaction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxChainTransaction }
     *     
     */
    public void setChainTransaction(PretaxChainTransaction value) {
        this.chainTransaction = value;
    }

    /**
     * Ruft den Wert der delivery-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxDelivery }
     *     
     */
    public PretaxDelivery getDelivery() {
        return delivery;
    }

    /**
     * Legt den Wert der delivery-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxDelivery }
     *     
     */
    public void setDelivery(PretaxDelivery value) {
        this.delivery = value;
    }

    /**
     * Ruft den Wert der service-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getService() {
        return service;
    }

    /**
     * Legt den Wert der service-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setService(Service value) {
        this.service = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransactionContext.TransactionContextType }
     *     
     */
    public TransactionContext.TransactionContextType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionContext.TransactionContextType }
     *     
     */
    public void setType(TransactionContext.TransactionContextType value) {
        this.type = value;
    }


    /**
     * <p>Java-Klasse für null.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * <p>
     * <pre>
     * &lt;simpleType&gt;
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *     &lt;enumeration value="B2B"/&gt;
     *     &lt;enumeration value="B2C"/&gt;
     *   &lt;/restriction&gt;
     * &lt;/simpleType&gt;
     * </pre>
     * 
     */
    @XmlType(name = "")
    @XmlEnum
    public enum TransactionContextType {

        @XmlEnumValue("B2B")
        B_2_B("B2B"),
        @XmlEnumValue("B2C")
        B_2_C("B2C");
        private final String value;

        TransactionContextType(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        public static TransactionContext.TransactionContextType fromValue(String v) {
            for (TransactionContext.TransactionContextType c: TransactionContext.TransactionContextType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(v);
        }

    }

}
