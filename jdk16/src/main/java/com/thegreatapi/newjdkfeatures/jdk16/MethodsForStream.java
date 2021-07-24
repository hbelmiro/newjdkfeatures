package com.thegreatapi.newjdkfeatures.jdk16;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface MethodsForStream {

    void toList(Stream<String> stream);

    @SuppressWarnings("FuseStreamOperations")
    class Jdk8 implements MethodsForStream {

        @Override
        public void toList(Stream<String> stream) {
            List<String> list = Collections.unmodifiableList(stream.collect(Collectors.toList()));
        }
    }

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