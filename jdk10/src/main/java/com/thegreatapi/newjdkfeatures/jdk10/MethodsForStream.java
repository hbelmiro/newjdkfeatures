package com.thegreatapi.newjdkfeatures.jdk10;

import com.thegreatapi.newjdkfeatures.model.Point;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface MethodsForStream {

    List<String> toUnmodifiableList(Stream<String> stream);

    Set<String> toUnmodifiableSet(Stream<String> stream);

    Map<String, String> toUnmodifiableMap(Stream<Point> stream);

    @SuppressWarnings("FuseStreamOperations")
    class Jdk9 implements MethodsForStream {

        @Override
        public List<String> toUnmodifiableList(Stream<String> stream) {
            List<String> list = stream.collect(Collectors.toList());
            return Collections.unmodifiableList(list);
        }

        @Override
        public Set<String> toUnmodifiableSet(Stream<String> stream) {
            Set<String> set = stream.collect(Collectors.toSet());
            return Collections.unmodifiableSet(set);
        }

        @Override
        public Map<String, String> toUnmodifiableMap(Stream<Point> stream) {
            Map<String, String> map = stream.collect(Collectors.toMap(
                    point -> point.getX().toString(),
                    point -> point.getY().toString()));

            return Collections.unmodifiableMap(map);
        }
    }

    class Jdk10 implements MethodsForStream {

        @Override
        public List<String> toUnmodifiableList(Stream<String> stream) {
            return stream.collect(Collectors.toUnmodifiableList());
        }

        @Override
        public Set<String> toUnmodifiableSet(Stream<String> stream) {
            return stream.collect(Collectors.toUnmodifiableSet());
        }

        @Override
        public Map<String, String> toUnmodifiableMap(Stream<Point> stream) {
            return stream.collect(Collectors.toUnmodifiableMap(
                    point -> point.getX().toString(),
                    point -> point.getY().toString()));
        }
    }
}