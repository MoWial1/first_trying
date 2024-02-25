package org.example.module11_Stream.task4;

import java.util.stream.Stream;

@FunctionalInterface
public interface ILinearCongruentMethod {
    Stream<Long> generateRandomNumbers(long a, long c, long m);
}
