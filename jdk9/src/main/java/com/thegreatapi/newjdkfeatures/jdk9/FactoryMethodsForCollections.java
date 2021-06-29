package com.thegreatapi.newjdkfeatures.jdk9;

import java.util.*;

@SuppressWarnings("unused")
public interface FactoryMethodsForCollections {

    List<Point> createList();

    Set<Point> createSet();

    Map<String, Point> createMap();

    @SuppressWarnings({"unused", "Java9CollectionFactory"})
    class Jdk8 implements FactoryMethodsForCollections {

        @Override
        public List<Point> createList() {
            List<Point> myList = new ArrayList<>();
            myList.add(new Point(1, 1));
            myList.add(new Point(2, 2));
            return Collections.unmodifiableList(myList);
        }

        @Override
        public Set<Point> createSet() {
            Set<Point> mySet = new HashSet<>();
            mySet.add(new Point(1, 1));
            mySet.add(new Point(2, 2));
            return Collections.unmodifiableSet(mySet);
        }

        @Override
        public Map<String, Point> createMap() {
            Map<String, Point> myMap = new HashMap<>();
            myMap.put("a", new Point(1, 1));
            myMap.put("b", new Point(2, 2));
            return Collections.unmodifiableMap(myMap);
        }
    }

    @SuppressWarnings("unused")
    class Jdk9 implements FactoryMethodsForCollections {

        @Override
        public List<Point> createList() {
            return List.of(
                    new Point(1, 1),
                    new Point(2, 2)
            );
        }

        @Override
        public Set<Point> createSet() {
            return Set.of(
                    new Point(1, 1),
                    new Point(2, 2)
            );
        }

        @Override
        public Map<String, Point> createMap() {
            return Map.of(
                    "a", new Point(1, 1),
                    "b", new Point(2, 2)
            );
        }
    }

    class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}