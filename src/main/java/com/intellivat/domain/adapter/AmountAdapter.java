package com.intellivat.domain.adapter;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.intellivat.domain.Amount;

/**
 * Adapter for JAXB to marshal and unmarshal an {@link Amount} to and from {@link BigDecimal}.
 * 
 * @author Alex Rommel
 */
public class AmountAdapter
    extends XmlAdapter<BigDecimal, Amount> {

    @Override
    public Amount unmarshal( BigDecimal v ) {
        return Amount.valueOf( v );
    }

    @Override
    public BigDecimal marshal( Amount v ) {
        return v.getValue();
    }

}
