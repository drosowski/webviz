package com.intellivat.domain.invoice;

/**
 * The line reference is similar to the {@link InvoiceReference}, except that it needs the current line number in order
 * to determine the value denoted by the reference. The line number is passed as an argument in the
 * {@code InvoiceAccessor}.
 * 
 * @author Daniel Rosowski
 */
public interface LineReference
    extends InvoiceReference {

    static final String LINE_NUMBER_ARG_NAME = "lineNumber";
}
