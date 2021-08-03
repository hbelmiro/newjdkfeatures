package com.thegreatapi.newjdkfeatures.jdk9;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Teste {


    @SuppressWarnings("unused")
    public static void main(String[] args) {

        System.out.println('[' +
                List.of("bla", "ble").stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(", "))
                + ']'
        );


    }
}