package com.intellivat.domain.taxtree;

import java.util.Optional;

/**
 * A {@code TreeValidationError} describes a validation error within a {@link TaxDecisionTree}.
 * 
 * @author Alex Rommel
 */
public class TreeValidationError {

    private Optional<TreeNode> node = Optional.empty();

    private String description;

    public TreeValidationError() {}

    public Optional<TreeNode> getNode() {
        return node;
    }

    public void setNodeId( TreeNode node ) {
        this.node = Optional.ofNullable( node );
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public static final class Builder {

        private TreeValidationError instance;

        public static Builder newError() {
            Builder builder = new Builder();
            builder.instance = new TreeValidationError();
            return builder;
        }

        public Builder withNodeId( TreeNode node ) {
            this.instance.setNodeId( node );
            return this;
        }

        public Builder withDescription( String description ) {
            this.instance.setDescription( description );
            return this;
        }

        public TreeValidationError build() {
            return instance;
        }
    }

}
