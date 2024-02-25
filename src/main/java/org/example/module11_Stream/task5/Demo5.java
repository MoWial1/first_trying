package org.example.module11_Stream.task5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Demo5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream<T> tempStream = Stream.concat(
               Optional.ofNullable(first).orElseThrow(), Optional.ofNullable(second).orElseThrow()
        );
        Iterator<T> iterator = tempStream.iterator();

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                new Iterator<T>() {
                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public T next() {
                        return iterator.next();
                    }
                },
                Spliterator.ORDERED
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
