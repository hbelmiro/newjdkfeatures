package com.thegreatapi.newjdkfeatures.jdk10;

import java.util.Optional;

@SuppressWarnings({"unused", "InterfaceMayBeAnnotatedFunctional"})
public interface MethodsForOptional {

    String orElseThrow();

    class Jdk9 implements MethodsForOptional {

        @SuppressWarnings("OptionalIsPresent")
        @Override
        public String orElseThrow() {
            Optional<String> optionalValue = getOptionalValue();
            if (optionalValue.isPresent()) {
                // Optional#get will be deprecated soon.
                // https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8140281
                return optionalValue.get();
            } else {
                return "another value";
            }
        }
    }

    class Jdk10 implements MethodsForOptional {

        @Override
        public String orElseThrow() {
            Optional<String> optionalValue = getOptionalValue();
            if (optionalValue.isPresent()) {
                return optionalValue.orElseThrow();
            } else {
                return "another value";
            }
        }
    }

    default Optional<String> getOptionalValue() {
        return Optional.ofNullable(null);
    }
}