package com.thegreatapi.newjdkfeatures.jdk9;

import java.lang.StackWalker.StackFrame;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

@SuppressWarnings("unused")
public interface StackWalkerApi {

    List<Class<?>> INTERESTING_CLASSES = List.of();

    Optional<Class<?>> findClassInStack();

    class Jdk8 implements StackWalkerApi {

        public Class<?> findClassInStackBAD() throws ClassNotFoundException {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            return Class.forName(stackTraceElement.getClassName());
        }

        @Override
        public Optional<Class<?>> findClassInStack() {
            List<String> interestingClassNames = INTERESTING_CLASSES.stream()
                                                                    .map(Class::getName)
                                                                    .collect(Collectors.toList());

            return Arrays.stream(Thread.currentThread().getStackTrace())
                         .map(StackTraceElement::getClassName)
                         .filter(interestingClassNames::contains)
                         .findFirst()
                         .map(className -> {
                             try {
                                 return Class.forName(className);
                             } catch (ClassNotFoundException e) {
                                 throw new RuntimeException(e);
                             }
                         });
        }
    }

    class Jdk9 implements StackWalkerApi {

        @Override
        public Optional<Class<?>> findClassInStack() {
            return StackWalker.getInstance(RETAIN_CLASS_REFERENCE)
                              .walk(stackFrameStream -> stackFrameStream.<Class<?>>map(StackFrame::getDeclaringClass)
                                                                        .filter(INTERESTING_CLASSES::contains)
                                                                        .findFirst());
        }
    }
}