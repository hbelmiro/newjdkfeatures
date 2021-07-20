package com.thegreatapi.newjdkfeatures.jdk10;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"unused", "EmptyTryBlock"})
public interface Var {

    void doStuff() throws IOException;

    class Jdk9 implements Var {

        @Override
        public void doStuff() throws IOException {
            Map<Integer, String> map = new HashMap<>();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream("anyString".getBytes().length)) {
                //...
            }
        }
    }

    class Jdk10 implements Var {

        @Override
        public void doStuff() throws IOException {
            var map = new HashMap<Integer, String>();
            var executorService = Executors.newSingleThreadExecutor();
            try (var outputStream = new ByteArrayOutputStream("anyString".getBytes().length)) {
                //...
            }
        }
    }
}
