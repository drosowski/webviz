
package com.intellivat.domain.invoice.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * If a seller or buyer is directly entered into the interface and not identified by a company reference, then
 *                 all known tax registrations of shall be sent to IntelliVAT. If the buyer is a private person (B2C) then the list shall be
 *                 empty.
 *             
 * 
 * <p>Java-Klasse für taxRegistrations complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="taxRegistrations"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taxRegistration" type="{http://intellivat.com/invoice}taxRegistration" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxRegistrations", propOrder = {
    "taxRegistration"
})
public class TaxRegistrations {

    @XmlElement(required = true)
    protected List<TaxRegistration> taxRegistration;

    /**
     * Gets the value of the taxRegistration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxRegistration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxRegistration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxRegistration }
     * 
     * 
     */
    public List<TaxRegistration> getTaxRegistration() {
        if (taxRegistration == null) {
            taxRegistration = new ArrayList<TaxRegistration>();
        }
        return this.taxRegistration;
    }

}
