package com.intellivat.domain.invoice;

import com.intellivat.domain.rules.ParameterValue;

/**
 * Marks a reference to a field in the invoice that can be used as a {@code ParameterValue}. The {@link #getQueryPath()
 * queryPath} is an OGNL expression that describes the path to the field in the invoice. Two examples in the
 * PreTaxInvoice:
 * <ul>
 * <li>queryPath=header.seller.address</li>
 * <li>queryPath=header.transactionContext.chainTransaction</li>
 * </ul>
 *
 * @author Daniel Rosowski
 */
public interface InvoiceReference
    extends ParameterValue {

    String getQueryPath();

    void setQueryPath( String queryPath );

    void setType( Class<?> type );

    /**
     * The builder can be used to build objects implementing the interface {@code InvoiceReference}. Use the static
     * factory method {@link #newInvoiceReference(String, Class)}.
     *
     * @author Daniel Rosowski
     */
    final class Builder<T extends InvoiceReference> {
        private T instance;

        /**
         * Should only be instantiated through the static factory method!
         */
        private Builder() {}

        /**
         * Instantiates a new builder for the type given by the {@code clazz} parameter.
         *
         * @param referenceType
         * @return the builder
         */
        public static <T extends InvoiceReference> Builder<T> newInvoiceReference(String displayName, Class<T> referenceType ) {
            Builder<T> builder = new Builder<T>();
            try {
                builder.instance = referenceType.getDeclaredConstructor( String.class).newInstance(displayName );
            }
            catch ( Exception e ) {
                throw new IllegalArgumentException( "Problem building invoice reference!", e );
            }

            return builder;
        }

        /**
         * Assigns the given {@code queryPath} to the invoiceReference.
         *
         * @return the builder
         */
        public Builder<T> withQueryPath( String queryPath ) {
            instance.setQueryPath( queryPath );
            return this;
        }

        /**
         * Defines a invoice reference type.
         *
         * @param type
         * @return
         */
        public Builder<T> withType( Class<?> type ) {
            instance.setType( type );
            return this;
        }

        public T build() {
            return instance;
        }
    }
}
