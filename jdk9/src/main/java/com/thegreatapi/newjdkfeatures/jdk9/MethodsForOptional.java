package com.thegreatapi.newjdkfeatures.jdk9;

import java.time.Instant;
import java.util.Optional;

@SuppressWarnings("unused")
public interface MethodsForOptional {

    void ifPresentOrElse();

    void or();

    private static Optional<String> getWebsite() {
        if (Instant.now().toEpochMilli() % 2 == 0) {
            return Optional.of("thegreatapi.com");
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> getTwitterHandle() {
        if (Instant.now().toEpochMilli() % 2 == 0) {
            return Optional.of("helber_belmiro");
        } else {
            return Optional.empty();
        }
    }

    class Jdk8 implements MethodsForOptional {

        @Override
        public void ifPresentOrElse() {
            Optional<String> website = getWebsite();

            if (website.isPresent()) {
                System.out.println(website.get());
            } else {
                System.err.println("A website wasn't set");
            }
        }

        @Override
        public void or() {
            Optional<String> contact = getWebsite();

            if (!contact.isPresent()) {
                contact = getTwitterHandle();
            }

            contact.ifPresent(System.out::println);
        }
    }

    @SuppressWarnings("unused")
    class Jdk9 implements MethodsForOptional {

        @Override
        public void ifPresentOrElse() {
            getWebsite().ifPresentOrElse(
                    System.out::println,
                    () -> System.err.println("A website wasn't set")
            );
        }

        @Override
        public void or() {
            getWebsite().or(MethodsForOptional::getTwitterHandle)
                        .ifPresent(System.out::println);
        }
    }
}