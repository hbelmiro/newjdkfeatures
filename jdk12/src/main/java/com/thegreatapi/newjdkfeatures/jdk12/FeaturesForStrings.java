package com.thegreatapi.newjdkfeatures.jdk12;

@SuppressWarnings({"StringRepeatCanBeUsed", "unused"})
@FunctionalInterface
public interface FeaturesForStrings {

    String indentation(String s, int indentationSize);

    class Jdk8 implements FeaturesForStrings {

        @Override
        public String indentation(String s, int indentationSize) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < indentationSize; i++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(s);
            return stringBuilder.toString();
        }
    }

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