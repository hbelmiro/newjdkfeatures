package com.thegreatapi.newjdkfeatures.jdk16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface MethodsForStream {

    void toList(Stream<String> stream);

    @SuppressWarnings("SimplifyStreamApiCallChains")
    class Jdk15 implements MethodsForStream {

        @Override
        public void toList(Stream<String> stream) {
            List<String> list = stream.collect(Collectors.toUnmodifiableList());
        }
    }

    class Jdk16 implements MethodsForStream {

        @Override
        public void toList(Stream<String> stream) {
            List<String> list = stream.toList();
        }
    }
}