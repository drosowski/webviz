
package com.intellivat.domain.invoice.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für messageCommunicationType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="messageCommunicationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="information"/&gt;
 *     &lt;enumeration value="warning"/&gt;
 *     &lt;enumeration value="error"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "messageCommunicationType")
@XmlEnum
public enum MessageCommunicationType {

    @XmlEnumValue("information")
    INFORMATION("information"),
    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("error")
    ERROR("error");
    private final String value;

    MessageCommunicationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageCommunicationType fromValue(String v) {
        for (MessageCommunicationType c: MessageCommunicationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
