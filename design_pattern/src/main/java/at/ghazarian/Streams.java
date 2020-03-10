package at.ghazarian;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        Stream.of(2, 8, 6, 3, 4, 5)
                .takeWhile(i -> i % 2 == 0) // sofern das erste Element gefunden, welches die Bedinung nicht erfüllt, wird der Stream abgebrochen.
                .forEach(System.out::println);
        System.out.println("---------------");
        Stream.of(2, 8, 6, 3, 4, 5)
                .dropWhile(i -> i % 2 == 0) // Die Verarbeitung wird erst gestartet, wenn die Bendingung zum ersten Mal zutrifft.
                .forEach(System.out::println);
        System.out.println("---------------");
        int[][] twodArray= {{1, 2, 3}, {5, 6, 7}};
        Stream.of(twodArray).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);
        System.out.println("---------------");

        System.out.println(IntStream.range(1, 9).reduce(7, (x, y) -> x));
    }
}
