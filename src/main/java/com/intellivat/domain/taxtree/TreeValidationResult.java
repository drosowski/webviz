package com.intellivat.domain.taxtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code TreeValidationResult} holds a list of {@link TreeValidationError}s. An empty error list means the tree
 * validation was successfully passed.
 * 
 * @author Alex Rommel
 */
public class TreeValidationResult {

    private List<TreeValidationError> errors = new ArrayList<>();

    public TreeValidationResult() {}

    public List<TreeValidationError> getErrors() {
        return errors;
    }

    public void addError( TreeValidationError error ) {
        errors.add( error );
    }

    public void addError( Optional<TreeValidationError> error ) {
        if ( error.isPresent() ) {
            addError( error.get() );
        }
    }
}
