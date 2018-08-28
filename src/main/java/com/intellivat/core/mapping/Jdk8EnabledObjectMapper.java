package com.intellivat.core.mapping;

import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * A Jackson {@code ObjectMapper} with JDK8 types support (i.e. Optionals, LocalDate).
 *
 * @author Daniel Rosowski
 */
public class Jdk8EnabledObjectMapper
    extends ObjectMapper {

    private static final long serialVersionUID = -8772865313909883785L;

    public Jdk8EnabledObjectMapper() {
        registerModule( new Jdk8Module() );
        registerModule( new LocalDateModule() );
        registerModule( new InstantModule() );
        registerModule( new GuavaModule() );
    }

    static class LocalDateModule
        extends SimpleModule {

        private static final long serialVersionUID = -241628890253191197L;

        public LocalDateModule() {
            addSerializer( LocalDate.class, LocalDateSerializer.INSTANCE );
            addDeserializer( LocalDate.class, LocalDateDeserializer.INSTANCE );
        }

    }

    static class InstantModule
        extends SimpleModule {

        private static final long serialVersionUID = -241628890253191197L;

        public InstantModule() {
            addSerializer( Instant.class, InstantSerializer.INSTANCE );
            addDeserializer( Instant.class, InstantDeserializer.INSTANT );
        }

    }
}
