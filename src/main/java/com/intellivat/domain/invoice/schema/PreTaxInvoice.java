
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="metaInfo" type="{http://intellivat.com/invoice}metaParamValues" minOccurs="0"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}documentInfo"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}header"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}mainLines"/&gt;
 *         &lt;element ref="{http://intellivat.com/invoice}ancillaryLines" minOccurs="0"/&gt;
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
    "metaInfo",
    "documentInfo",
    "header",
    "mainLines",
    "ancillaryLines"
})
@XmlRootElement(name = "preTaxInvoice")
public class PreTaxInvoice {

    protected MetaParamValues metaInfo;
    @XmlElement(required = true)
    protected PretaxDocumentInfo documentInfo;
    @XmlElement(required = true)
    protected PretaxHeader header;
    @XmlElement(required = true)
    protected MainLines mainLines;
    protected AncillaryLines ancillaryLines;

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
     * Ruft den Wert der documentInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxDocumentInfo }
     *     
     */
    public PretaxDocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    /**
     * Legt den Wert der documentInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxDocumentInfo }
     *     
     */
    public void setDocumentInfo(PretaxDocumentInfo value) {
        this.documentInfo = value;
    }

    /**
     * Ruft den Wert der header-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PretaxHeader }
     *     
     */
    public PretaxHeader getHeader() {
        return header;
    }

    /**
     * Legt den Wert der header-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PretaxHeader }
     *     
     */
    public void setHeader(PretaxHeader value) {
        this.header = value;
    }

    /**
     * Ruft den Wert der mainLines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MainLines }
     *     
     */
    public MainLines getMainLines() {
        return mainLines;
    }

    /**
     * Legt den Wert der mainLines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MainLines }
     *     
     */
    public void setMainLines(MainLines value) {
        this.mainLines = value;
    }

    /**
     * Ruft den Wert der ancillaryLines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AncillaryLines }
     *     
     */
    public AncillaryLines getAncillaryLines() {
        return ancillaryLines;
    }

    /**
     * Legt den Wert der ancillaryLines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AncillaryLines }
     *     
     */
    public void setAncillaryLines(AncillaryLines value) {
        this.ancillaryLines = value;
    }

}
