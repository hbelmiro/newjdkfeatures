package com.thegreatapi.newjdkfeatures.jdk17;

@SuppressWarnings("InterfaceMayBeAnnotatedFunctional")
public interface SealedClasses {

    sealed interface Vehicle permits Car, Motorcycle {
        void run();
    }

//    Truck is not an allowed implementation
//    class Truck implements Vehicle {
//        @Override
//        public void run() {
//            System.out.println("Truck noise");
//        }
//    }

    final class Car implements Vehicle {
        @Override
        public void run() {
            System.out.println("Car noise");
        }
    }

    non-sealed class Motorcycle implements Vehicle {
        @Override
        public void run() {
            System.out.println("Motorcycle noise");
        }
    }

    class Quadricycle extends Motorcycle {
        @Override
        public void run() {
            System.out.println("Quadricycle noise");
        }
    }

    class CustomQuadricycle extends Quadricycle {
        @Override
        public void run() {
            System.out.println("Custom quadricycle noise");
        }
    }
}