package com.thegreatapi.newjdkfeatures.jdk10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public interface Var {

    void doStuff() throws Exception;

    class Jdk9 implements Var {

        @Override
        public void doStuff() throws Exception {
            ExecutorService executorService = Executors.newSingleThreadExecutor();

            Future<Integer> futureValue = executorService.submit(() -> 42);
            System.out.println(futureValue.get());
        }
    }

    class Jdk10 implements Var {

        @Override
        public void doStuff() throws Exception {
            var executorService = Executors.newSingleThreadExecutor();

            Future<Integer> futureValue = executorService.submit(() -> 42);
            System.out.println(futureValue.get());
        }
    }
}
