package com.thegreatapi.newjdkfeatures.jdk11;

import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public interface MethodsForPredicate {

    public Predicate<String> predicateNot();

    class Jdk10 implements MethodsForPredicate {

        @Override
        public Predicate<String> predicateNot() {
            return text -> !text.isEmpty();
        }
    }

    class Jdk11 implements MethodsForPredicate {

        @Override
        public Predicate<String> predicateNot() {
            // Requires: import static java.util.function.Predicate.not;
            return not(String::isEmpty);
        }
    }
}