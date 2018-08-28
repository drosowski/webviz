package com.intellivat.domain.masterdata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Let's a {@link Masterdata} define which of it's fields in which order should be shown in the user interface.
 *
 * @author Lukas Taake
 *         Created on 14.10.15.
 */

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
public @interface ViewableFields {
    String[] value();
}
