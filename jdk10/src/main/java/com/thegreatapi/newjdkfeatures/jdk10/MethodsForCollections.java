package com.thegreatapi.newjdkfeatures.jdk10;

import java.util.*;

@SuppressWarnings("unused")
public interface MethodsForCollections {

    List<String> copyList(List<String> originalList);

    Set<String> copySet(Set<String> originalList);

    Map<String, String> copyMap(Map<String, String> originalList);

    @SuppressWarnings("Java9CollectionFactory")
    class Jdk9 implements MethodsForCollections {

        @Override
        public List<String> copyList(List<String> originalList) {
            return Collections.unmodifiableList(new ArrayList<>(originalList));
        }

        @Override
        public Set<String> copySet(Set<String> originalSet) {
            return Collections.unmodifiableSet(new HashSet<>(originalSet));
        }

        @Override
        public Map<String, String> copyMap(Map<String, String> originalMap) {
            return Collections.unmodifiableMap(new HashMap<>(originalMap));
        }
    }

    class Jdk10 implements MethodsForCollections {

        @Override
        public List<String> copyList(List<String> originalList) {
            return List.copyOf(originalList);
        }

        @Override
        public Set<String> copySet(Set<String> originalSet) {
            return Set.copyOf(originalSet);
        }

        @Override
        public Map<String, String> copyMap(Map<String, String> originalMap) {
            return Map.copyOf(originalMap);
        }
    }
}