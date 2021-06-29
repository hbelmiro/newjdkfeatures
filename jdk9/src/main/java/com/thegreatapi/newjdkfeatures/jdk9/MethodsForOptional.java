package com.thegreatapi.newjdkfeatures.jdk9;

import java.time.Instant;
import java.util.Optional;

@SuppressWarnings("unused")
public interface MethodsForOptional {

    void ifPresentOrElse();

    void or();

    private static Optional<String> getWebSite() {
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

    private static void handleExistingWebSite(String webSite) {
        System.out.println(webSite);
    }

    class Jdk8 implements MethodsForOptional {

        @Override
        public void ifPresentOrElse() {
            Optional<String> webSite = getWebSite();

            if (webSite.isPresent()) {
                handleExistingWebSite(webSite.get());
            } else {
                System.err.println("A web site wasn't set");
            }
        }

        @Override
        public void or() {
            Optional<String> contact = getWebSite();

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
            getWebSite().ifPresentOrElse(
                    MethodsForOptional::handleExistingWebSite,
                    () -> System.err.println("A web site wasn't set")
            );
        }

        @Override
        public void or() {
            getWebSite().or(MethodsForOptional::getTwitterHandle)
                        .ifPresent(System.out::println);
        }
    }
}