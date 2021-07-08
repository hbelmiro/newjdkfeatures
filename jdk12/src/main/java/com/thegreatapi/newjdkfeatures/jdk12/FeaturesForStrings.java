package com.thegreatapi.newjdkfeatures.jdk12;

public interface FeaturesForStrings {

    String indentation(String s, int indentationSize);

    class Jdk11 implements FeaturesForStrings {

        @Override
        public String indentation(String s, int indentationSize) {
            return " ".repeat(indentationSize) + s;
        }
    }

    class Jdk12 implements FeaturesForStrings {

        @Override
        public String indentation(String s, int indentationSize) {
            return s.indent(indentationSize);
        }
    }
}