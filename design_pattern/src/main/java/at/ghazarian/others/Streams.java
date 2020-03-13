package at.ghazarian.others;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        Stream.of(2, 8, 6, 3, 4, 5)
                .takeWhile(i -> i % 2 == 0) // Solang die Bedingung zutrifft wird bearbeitet.
                .forEach(System.out::println);
        System.out.println("---------------");
        Stream.of(2, 8, 6, 3, 4, 5)
                .dropWhile(i -> i % 2 == 0) // Solange die Bedingung zutrifft wird nicht verarbeitet.
                .forEach(System.out::println);
        System.out.println("---------------");
        int[][] twodArray= {{1, 2, 3}, {5, 6, 7}};
        Stream.of(twodArray).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);
        System.out.println("---------------");
        SomeClass[][] twodArraySomeClass= {{new SomeClass(1,1), new SomeClass(2,2)}, {new SomeClass(3,3), new SomeClass(4,4)}};
        Stream.of(twodArraySomeClass).flatMap(x -> Arrays.stream(x)).forEach(x -> System.out.println(x.x));
        System.out.println("---------------");

        System.out.println(IntStream.range(1, 9).reduce(7, (x, y) -> x));
    }

    @AllArgsConstructor
    static class SomeClass {
        int x, y;
    }
}
