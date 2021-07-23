package com.thegreatapi.newjdkfeatures.jdk12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class FeaturesForStringsTest {

    private static Stream<Arguments> indentationSource() {
        return Stream.of(
                Arguments.of(new FeaturesForStrings.Jdk8()),
                Arguments.of(new FeaturesForStrings.Jdk11()),
                Arguments.of(new FeaturesForStrings.Jdk12())
        );
    }

    @ParameterizedTest
    @MethodSource("indentationSource")
    void indentation(FeaturesForStrings featuresForStrings) {
        String s = "This is" + System.lineSeparator()
                + "a multiline" + System.lineSeparator()
                + "text";

        String expected = "    This is" + System.lineSeparator()
                + "    a multiline" + System.lineSeparator()
                + "    text" + System.lineSeparator();

        assertThat(featuresForStrings.indentation(s, 4))
                .isEqualTo(expected);
    }
}