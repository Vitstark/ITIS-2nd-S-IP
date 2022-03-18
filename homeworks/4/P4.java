package PROGA.homeworks.fourthp;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class P4 {

    public static List<Integer> task(List<Integer> list) {

        Stream<Integer> stream = list.stream();
        stream = stream.filter(x -> x % 2 == 1)
                .flatMap(x -> Stream.of(x, x));

        return stream.toList();
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 21; i++) {
            list.add(i);
        }

        System.out.println(task(list));
    }

}
