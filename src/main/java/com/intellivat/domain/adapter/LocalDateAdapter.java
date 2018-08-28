package com.intellivat.domain.adapter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter for JAXB to marshal and unmarshal a {@link LocalDate} to and from {@link String}.
 * 
 * @author Alex Rommel
 */
public class LocalDateAdapter
    extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal( String v ) {
        return LocalDate.parse( v );
    }

    @Override
    public String marshal( LocalDate v ) {
        return v.toString();
    }

}
