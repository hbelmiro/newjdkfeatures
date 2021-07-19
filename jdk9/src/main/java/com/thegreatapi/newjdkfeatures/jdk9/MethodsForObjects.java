package com.thegreatapi.newjdkfeatures.jdk9;

import javax.annotation.Nullable;
import java.util.Objects;

@SuppressWarnings("unused")
public interface MethodsForObjects {

    String requireNonNullElse(@Nullable String value);

    String requireNonNullElseGet(@Nullable String value);

    class Jdk8 implements MethodsForObjects {

        @Override
        public String requireNonNullElse(@Nullable String value) {
            if (value != null) {
                return value;
            } else {
                String defaultValue = getDefaultValue();
                if (defaultValue != null) {
                    return defaultValue;
                } else {
                    throw new NullPointerException();
                }
            }
        }

        @Override
        public String requireNonNullElseGet(@Nullable String value) {
            if (value != null) {
                return value;
            } else {
                String defaultValue = getDefaultValue();
                if (defaultValue != null) {
                    return defaultValue;
                } else {
                    throw new NullPointerException();
                }
            }
        }
    }

    class Jdk9 implements MethodsForObjects {

        @Override
        public String requireNonNullElse(@Nullable String value) {
            return Objects.requireNonNullElse(value, getDefaultValue());
        }

        @Override
        public String requireNonNullElseGet(@Nullable String value) {
            return Objects.requireNonNullElseGet(value, this::getDefaultValue);
        }
    }

    default String getDefaultValue() {
        return "default value";
    }
}