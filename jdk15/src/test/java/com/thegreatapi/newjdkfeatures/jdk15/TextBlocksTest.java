package com.thegreatapi.newjdkfeatures.jdk15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class TextBlocksTest {

    @Test
    void getSql() {
        var jdk14 = new TextBlocks.jdk14();
        var jdk15 = new TextBlocks.jdk15();

        assertThat(jdk14.getSql())
                .isEqualTo(jdk15.getSql());
    }
}