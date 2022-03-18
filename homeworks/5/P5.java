package PROGA.homeworks.fifthp;

import java.util.List;
import java.util.stream.Stream;

public class P5 {

    public static List<Integer> task(List<Integer> list) {

        Stream<Integer> stream = list.stream();
        stream = stream.filter(x -> x % 2 == 1)
                .flatMap(x -> Stream.generate(() -> x).limit(x));

        return stream.toList();
    }

}