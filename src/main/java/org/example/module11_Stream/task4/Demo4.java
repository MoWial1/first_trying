package org.example.module11_Stream.task4;

import java.util.stream.Stream;

public class Demo4 {
    public static void main(String[] args) {
        ILinearCongruentMethod congruentMethod = (a, c, m) -> {
            if (m < 2L || a < 0L || c < 0L || m <= a || m <= c) throw new IllegalArgumentException();
            return Stream.iterate(a, x -> 1 * (a * x + c) % m);
        };

        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        int size = 15;

        congruentMethod.generateRandomNumbers(a, c, m)
                .limit(size)
                .forEach(System.out::println);
    }
}
