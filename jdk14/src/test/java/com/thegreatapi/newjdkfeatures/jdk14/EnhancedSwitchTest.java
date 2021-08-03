package com.thegreatapi.newjdkfeatures.jdk14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnhancedSwitchTest {

    public static Stream<Arguments> getValueSource() {
        return Stream.of(
                Arguments.of(EnhancedSwitch.DayOfWeek.MONDAY, 42),
                Arguments.of(EnhancedSwitch.DayOfWeek.TUESDAY, 100),
                Arguments.of(EnhancedSwitch.DayOfWeek.WEDNESDAY, 12),
                Arguments.of(EnhancedSwitch.DayOfWeek.THURSDAY, 12),
                Arguments.of(EnhancedSwitch.DayOfWeek.FRIDAY, 12),
                Arguments.of(EnhancedSwitch.DayOfWeek.SATURDAY, 50),
                Arguments.of(EnhancedSwitch.DayOfWeek.SUNDAY, 50)
        );
    }

    @ParameterizedTest
    @MethodSource("getValueSource")
    void getValue(EnhancedSwitch.DayOfWeek day, int expectedResult) {
        assertEquals(expectedResult, new EnhancedSwitch.Jdk8().getValue(day));
        assertEquals(expectedResult, new EnhancedSwitch.Jdk14().getValue(day));
    }
}