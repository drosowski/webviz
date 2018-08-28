package com.intellivat.domain.rules;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ContextEntry {

    private final Parameter parameter;

    private final ParameterValue parameterValue;

    @JsonCreator
    public ContextEntry(@JsonProperty("parameter") Parameter parameter,
                        @JsonProperty("parameterValue") ParameterValue parameterValue) {
        this.parameter = parameter;
        this.parameterValue = parameterValue;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public ParameterValue getParameterValue() {
        return parameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContextEntry that = (ContextEntry) o;

        if (parameter != null ? !parameter.equals(that.parameter) : that.parameter != null) return false;
        if (parameterValue != null ? !parameterValue.equals(that.parameterValue) : that.parameterValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parameter != null ? parameter.hashCode() : 0;
        result = 31 * result + (parameterValue != null ? parameterValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContextEntry{" +
                "parameter=" + parameter +
                ", parameterValue=" + parameterValue +
                '}';
    }
}
