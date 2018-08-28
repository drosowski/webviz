
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * If the invoice is part of a chain transaction, then there are four Boolean (true/false) attributes which can
 *                 (!) be used to indicate the place of supply of each single invoice. "exported" can be set to true, if goods have been
 *                 exported with an earlier invoice of the complete transaction. "export" means that the present invoice will handle the
 *                 export. "imported" means that the goods have been imported to the jurisdiction of the destination with an earlier invoice.
 *                 Finally "import" indicates that the current invoice handles the input of the goods. The use of these attributes is optional,
 *                 but if used, then a more sophisticated tax decision logic can be built.
 *             
 * 
 * <p>Java-Klasse für chainTransaction element declaration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;element name="chainTransaction"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;attribute name="export" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *         &lt;attribute name="exported" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *         &lt;attribute name="import" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *         &lt;attribute name="imported" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "chainTransaction")
public class PretaxChainTransaction {

    @XmlAttribute(name = "export", required = true)
    protected boolean export;
    @XmlAttribute(name = "exported", required = true)
    protected boolean exported;
    @XmlAttribute(name = "import", required = true)
    protected boolean _import;
    @XmlAttribute(name = "imported", required = true)
    protected boolean imported;

    /**
     * Ruft den Wert der export-Eigenschaft ab.
     * 
     */
    public boolean isExport() {
        return export;
    }

    /**
     * Legt den Wert der export-Eigenschaft fest.
     * 
     */
    public void setExport(boolean value) {
        this.export = value;
    }

    /**
     * Ruft den Wert der exported-Eigenschaft ab.
     * 
     */
    public boolean isExported() {
        return exported;
    }

    /**
     * Legt den Wert der exported-Eigenschaft fest.
     * 
     */
    public void setExported(boolean value) {
        this.exported = value;
    }

    /**
     * Ruft den Wert der import-Eigenschaft ab.
     * 
     */
    public boolean isImport() {
        return _import;
    }

    /**
     * Legt den Wert der import-Eigenschaft fest.
     * 
     */
    public void setImport(boolean value) {
        this._import = value;
    }

    /**
     * Ruft den Wert der imported-Eigenschaft ab.
     * 
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * Legt den Wert der imported-Eigenschaft fest.
     * 
     */
    public void setImported(boolean value) {
        this.imported = value;
    }

}
