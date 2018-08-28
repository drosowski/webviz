@XmlJavaTypeAdapters( {
    @XmlJavaTypeAdapter( value = LocalDateAdapter.class, type = LocalDate.class ),
    @XmlJavaTypeAdapter( value = AmountAdapter.class, type = Amount.class ),
} )
@javax.xml.bind.annotation.XmlSchema( namespace = "http://intellivat.com/invoice" )
package com.intellivat.domain.invoice;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.intellivat.domain.Amount;
import com.intellivat.domain.adapter.AmountAdapter;
import com.intellivat.domain.adapter.LocalDateAdapter;

