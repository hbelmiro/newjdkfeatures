package com.thegreatapi.newjdkfeatures.jdk11;

import java.util.stream.Stream;

public interface MethodsForString {

    boolean isBlank(String s);

    String repeat(String s);

    Stream<String> lines(String s);

    class Jdk10 implements MethodsForString {

        @Override
        public boolean isBlank(String s) {
            return s.trim().isEmpty();
        }

        @Override
        public String repeat(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        }

        @Override
        public Stream<String> lines(String s) {
            return Stream.of(s.split(System.lineSeparator()));
        }
    }

    class Jdk11 implements MethodsForString {

        @Override
        public boolean isBlank(String s) {
            return s.isBlank();
        }

        @Override
        public String repeat(String s) {
            return s.repeat(4);
        }

        @Override
        public Stream<String> lines(String s) {
            return s.lines();
        }
    }
}