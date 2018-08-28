
package com.intellivat.domain.invoice.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 *                 The taxIndicatorComments is a list of comments, which should be printed on the invoice in order to explain the applicable
 *                 tax treatment to the buyer - and also a tax auditor. Most comments are legally relevant so they have to be printed on the
 *                 invoice. Please prepare for UTF-8 since the texts are in the jurisdictions language, which can contain special local
 *                 characters or have completely own fonts like Cyrillic or Chinese.
 *             
 * 
 * <p>Java-Klasse für taxIndicatorComments complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="taxIndicatorComments"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taxIndicatorComment" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="locale" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="taxTypeCode" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="taxIndicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxIndicatorComments", propOrder = {
    "taxIndicatorComment"
})
public class OutputTaxIndicatorComments {

    @XmlElement(required = true)
    protected List<OutputTaxIndicatorComments.TaxIndicatorComment> taxIndicatorComment;
    @XmlAttribute(name = "taxTypeCode")
    @XmlSchemaType(name = "anySimpleType")
    protected String taxTypeCode;
    @XmlAttribute(name = "taxIndicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String taxIndicator;

    /**
     * Gets the value of the taxIndicatorComment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxIndicatorComment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxIndicatorComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputTaxIndicatorComments.TaxIndicatorComment }
     * 
     * 
     */
    public List<OutputTaxIndicatorComments.TaxIndicatorComment> getTaxIndicatorComment() {
        if (taxIndicatorComment == null) {
            taxIndicatorComment = new ArrayList<OutputTaxIndicatorComments.TaxIndicatorComment>();
        }
        return this.taxIndicatorComment;
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
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="locale" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TaxIndicatorComment {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "locale", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String locale;

        /**
         * Ruft den Wert der value-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Legt den Wert der value-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Ruft den Wert der locale-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocale() {
            return locale;
        }

        /**
         * Legt den Wert der locale-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocale(String value) {
            this.locale = value;
        }

    }

}
