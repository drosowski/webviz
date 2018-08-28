package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.Arrays;
import java.util.Objects;

/**
 * Representation of the "United Nations Standard Products and Services Code" (UNSPSC) code.
 */
@ViewableFields( { "title", "classification" } )
public class Unspsc
    implements Masterdata {

    public static final Unspsc NONE = new Unspsc("00999999", "NONE", new UnspscClassification(UnspscClass.SERVICE, "NONE"));

    public static final String ROOT = "00000000";

    private static final int MIN_PARTS = 4;

    private static final int PART_SIZE = 2;

    // Represent the parts of an unspsc: ss.ff.cc.oo.mm (Segment, Family, Class, cOmmodity, custoM)
    private final byte[] structure;

    private final String code;

    private final String title;

    private final UnspscClassification classification;

    @JsonCreator
    public Unspsc( @JsonProperty( "code" ) String code,
                   @JsonProperty( "title" ) String title,
                   @JsonProperty( "classification" ) UnspscClassification classification ) {
        this.structure = parse( code );
        this.code = parse( structure );
        this.title = title;
        this.classification = classification;
    }

    public Unspsc( byte[] structure, String title, UnspscClassification classification ) {
        this.title = title;
        this.classification = classification;
        this.code = parse( structure );
        this.structure = parse( code );
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public UnspscClassification getClassification() {
        return classification;
    }

    @JsonIgnore
    public boolean isRoot() {
        return ROOT.equals( code );
    }

    @Override
    public String toString() {
        return "[Code '" + code + ", Title '" + title + "' Classification '" + classification + "']";
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Unspsc unspsc = (Unspsc) o;
        return Objects.equals( code, unspsc.code ) &&
            Objects.equals( title, unspsc.title ) &&
            Objects.equals( classification, unspsc.classification );
    }

    @Override
    public int hashCode() {
        return Objects.hash( code, title, classification );
    }

    @Override
    public String masterdataKey() {
        return code;
    }


    /**
     * Returns the UNSPSC code / masterdata key for the parent unspsc, e. g. "43000000" for "43020000" and "00000000"
     * for "12000000"
     *
     * @return
     */
    @JsonIgnore
    public String getParentUnspscMasterdataKey() {
        return getParentUnspscMasterdataKey( structure, 1 );
    }

    /**
     * Returns the UNSPSC code / masterdata key for the nth parent unspsc, e. g. "43000000" for "43021133" and n=3 and
     * "00000000" for "12000000" and n=5
     *
     * @param n Number of hierarchy levels to step up
     * @return
     */
    @JsonIgnore
    public String getParentUnspscMasterdataKey( int n ) {
        return getParentUnspscMasterdataKey( structure, n );
    }

    /**
     * Returns the UNSPSC code / masterdata key for the parent unspsc, e. g. "43000000" for "43020000" and "00000000"
     * for "12000000"
     *
     * @param code The unspsc to find a parent to
     * @return
     */
    @JsonIgnore
    public static String getParentUnspscMasterdataKey( String code ) {
        return getParentUnspscMasterdataKey( code, 1 );
    }

    /**
     * Returns the UNSPSC code / masterdata key for the nth parent unspsc, e. g. "43000000" for "43021133" and n=3 and
     * "00000000" for "12000000" and n=5
     *
     * @param code The unspsc to find a parent to
     * @param n Number of hierarchy levels to step up
     * @return
     */
    @JsonIgnore
    public static String getParentUnspscMasterdataKey( String code, int n ) {
        return getParentUnspscMasterdataKey( parse( code ), n );
    }

    /**
     * Returns the UNSPSC code / masterdata key for the nth parent unspsc, e. g. "43000000" for "43021133" and n=3 and
     * "00000000" for "12000000" and n=5
     *
     * @param code The unspsc to find a parent to
     * @param n Number of hierarchy levels to step up. Must be greater than or equal to 0.
     * @return
     */
    @JsonIgnore
    public static String getParentUnspscMasterdataKey( byte[] code, int n ) {
        int firstEmptyField;
        for ( firstEmptyField = 0; firstEmptyField < code.length; firstEmptyField++ ) {
            if ( code[firstEmptyField] == 0 ) {
                break;
            }
        }
        if ( firstEmptyField == 0 ) {
            firstEmptyField = 1;
        }
        if ( n > firstEmptyField ) {
            n = firstEmptyField;
        }
        if ( n < 0 ) {
            throw new IllegalArgumentException( "Parameter n must be greater than or equal to 0!" );
        }
        return parse( Arrays.copyOfRange( code, 0, firstEmptyField - n ) );
    }

    /**
     * Split the String into two-digit parts and put them into a byte array so that the first field is the segment, the
     * second one the family and so on.
     *
     * @param code The string code to parse
     * @return
     */
    public static byte[] parse( String code ) {

        String[] tokens =
            Iterables.toArray(
                Splitter
                    .fixedLength( PART_SIZE )
                    .split( code ),
                String.class
                );
        if ( "".equals( tokens[0] ) ) {
            tokens[0] = "0";
        }
        byte[] result = new byte[Math.max( tokens.length, MIN_PARTS )];
        for ( int i = 0; i < tokens.length; i++ ) {
            result[i] = Byte.valueOf( tokens[i] );
        }

        // Fill up (4312____ -> 43120000)
        for ( int missingDigits = MIN_PARTS - tokens.length; missingDigits > 0; missingDigits-- ) {
            result[tokens.length + missingDigits - 1] = 0;
        }
        return result;
    }

    /**
     * Joins the array fields to one string.
     *
     * @param code
     * @return
     */
    public static String parse( byte[] code ) {
        StringBuilder sCode = new StringBuilder();
        for ( byte part : code ) {
            if ( part < ( Math.pow( 10, ( PART_SIZE - 1 ) ) ) ) {
                sCode.append( 0 );
            }
            sCode.append( part );
        }

        // Fill up (4312 -> 43120000)
        for ( int missingDigits = ( MIN_PARTS * PART_SIZE ) - sCode.length(); missingDigits > 0; missingDigits-- ) {
            sCode.append( 0 );
        }
        return sCode.toString();
    }
}
