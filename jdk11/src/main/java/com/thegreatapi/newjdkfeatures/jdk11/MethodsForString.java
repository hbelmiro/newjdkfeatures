package com.thegreatapi.newjdkfeatures.jdk11;

public interface MethodsForString {

    boolean isBlank(String s);

    class Jdk10 implements MethodsForString {

        @Override
        public boolean isBlank(String s) {
            return s.trim().isEmpty();
        }
    }

    class Jdk11 implements MethodsForString {

        @Override
        public boolean isBlank(String s) {
            return s.isBlank();
        }
    }
}