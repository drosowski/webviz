@XmlJavaTypeAdapters( {
    @XmlJavaTypeAdapter( value = LocalDateAdapter.class, type = LocalDate.class ),
    @XmlJavaTypeAdapter( value = AmountAdapter.class, type = Amount.class ),
} )
@javax.xml.bind.annotation.XmlSchema( namespace = "http://intellivat.com/invoice/pretax" )
package com.intellivat.domain.invoice.enriched;

import com.intellivat.domain.adapter.AmountAdapter;
import com.intellivat.domain.adapter.LocalDateAdapter;
import com.intellivat.domain.Amount;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;

