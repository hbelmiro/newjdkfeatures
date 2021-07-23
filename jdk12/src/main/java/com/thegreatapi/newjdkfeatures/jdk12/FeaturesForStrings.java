package com.thegreatapi.newjdkfeatures.jdk12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({"StringRepeatCanBeUsed", "unused"})
@FunctionalInterface
public interface FeaturesForStrings {

    String indentation(String s, int indentationSize);

    class Jdk8 implements FeaturesForStrings {

        @Override
        public String indentation(String s, int indentationSize) {
            return Stream.of(s.split(System.lineSeparator()))
                         .map(line -> {
                             StringBuilder stringBuilder = new StringBuilder();
                             for (int i = 0; i < indentationSize; i++) {
                                 stringBuilder.append(' ');
                             }
                             stringBuilder.append(line);
                             return stringBuilder.toString();
                         }).collect(Collectors.joining(System.lineSeparator()));
        }
    }

    class Jdk11 implements FeaturesForStrings {

        @Override
        public String indentation(String s, int indentationSize) {
            return s.lines()
                    .map(line -> " ".repeat(indentationSize) + line)
                    .collect(Collectors.joining(System.lineSeparator()));
        }
    }

    class Jdk12 implements FeaturesForStrings {

        @Override
        public String indentation(String s, int indentationSize) {
            return s.indent(indentationSize);
        }
    }
}