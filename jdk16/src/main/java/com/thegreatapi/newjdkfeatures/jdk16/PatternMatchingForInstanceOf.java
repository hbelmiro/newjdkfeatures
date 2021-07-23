package com.thegreatapi.newjdkfeatures.jdk16;

@FunctionalInterface
public interface PatternMatchingForInstanceOf {

    void printLength(Object o);

    class Jdk15 implements PatternMatchingForInstanceOf {

        @Override
        public void printLength(Object o) {
            if (o instanceof String) {
                System.out.println("The object has length = " + ((String) o).length());
            } else {
                System.out.println("It's not possible to get the object's length");
            }
        }
    }

    class Jdk16 implements PatternMatchingForInstanceOf {

        @Override
        public void printLength(Object o) {
            if (o instanceof String s) {
                System.out.println("The object has length = " + s.length());
            } else {
                System.out.println("It's not possible to get the object's length");
            }
        }
    }
}