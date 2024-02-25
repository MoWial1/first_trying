package org.example.module11_Stream.task5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Demo5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> majorIterator =  new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                Random random = new Random();
                if (random.nextInt() % 2 == 0) {
                    return firstIterator.next();
                }
                return secondIterator.next();
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                majorIterator, Spliterator.ORDERED
        );

        return StreamSupport.stream(spliterator, false);
    }

//    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
//        Stream<T> tempStream = Stream.concat(
//                Optional.ofNullable(first).orElseThrow(),
//                Optional.ofNullable(second).orElseThrow());
//
//        List<T> shuffleList = new ArrayList<>(tempStream.toList());
//
//        Collections.shuffle(shuffleList);
//
//        return shuffleList.stream();
//    }

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(12, 2, 34, 4, 5, 67);
        Stream<Integer> secondStream = Stream.of(10, 210, 30, 407, 50, 60);

        Stream<Integer> zippedStream = zip(firstStream, secondStream);
        //Stream<Integer> zippedStream = zip(null, null);

        zippedStream.collect(Collectors.toList()).forEach(System.out::println);
    }
}
