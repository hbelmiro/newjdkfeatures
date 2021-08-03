package com.thegreatapi.newjdkfeatures.jdk14;

public interface EnhancedSwitch {

    int getValue(DayOfWeek dayOfWeek);

    @SuppressWarnings("EnhancedSwitchMigration")
    class Jdk8 implements EnhancedSwitch {

        @Override
        public int getValue(DayOfWeek dayOfWeek) {
            int value;

            switch (dayOfWeek) {
                case MONDAY:
                    value = 42;
                    break;
                case TUESDAY:
                    System.out.println("Today is your lucky day!");
                    value = 100;
                    break;
                case WEDNESDAY:
                case THURSDAY:
                case FRIDAY:
                    value = 12;
                    break;
                case SATURDAY:
                case SUNDAY:
                    System.out.println("Woohoo! It's weekend!");
                    value = 50;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + dayOfWeek);
            }

            return value;
        }
    }

    class Jdk14 implements EnhancedSwitch {
        @Override
        public int getValue(DayOfWeek dayOfWeek) {
            int value;

            value = switch (dayOfWeek) {
                case MONDAY -> 42;
                case TUESDAY -> {
                    System.out.println("Today is your lucky day!");
                    yield 100;
                }
                case WEDNESDAY, THURSDAY, FRIDAY -> 12;
                case SATURDAY, SUNDAY -> {
                    System.out.println("Woohoo! It's weekend!");
                    yield 50;
                }
            };

            return value;
        }
    }

    enum DayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
}