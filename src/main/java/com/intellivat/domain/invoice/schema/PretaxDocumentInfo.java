
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * In the documentInfo section it is possible to enter the language in which IntelliVAT shall return any messages
 *                 belongimg to the exception handling (so errors, warnings or information), and it is possible to set a referenceTimestamp.
 *                 For details please have a look in the documentation of these elements.
 *             
 * 
 * <p>Java-Klasse für documentInfo element declaration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;element name="documentInfo"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://intellivat.com/invoice}communicationLanguage"/&gt;
 *           &lt;element ref="{http://intellivat.com/invoice}referenceTimestamp" minOccurs="0"/&gt;
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
    "communicationLanguage",
    "referenceTimestamp"
})
@XmlRootElement(name = "documentInfo")
public class PretaxDocumentInfo {

    @XmlElement(required = true)
    protected String communicationLanguage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar referenceTimestamp;

    /**
     * Ruft den Wert der communicationLanguage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationLanguage() {
        return communicationLanguage;
    }

    /**
     * Legt den Wert der communicationLanguage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationLanguage(String value) {
        this.communicationLanguage = value;
    }

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

}
