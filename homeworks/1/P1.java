package PROGA.homeworks.firstp;

import java.util.LinkedList;
import java.util.stream.*;
import java.util.List;

public class P1 {

    public static int task(List<Integer> list) {
        int sum = 0;
        sum = list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x).sum();
        return sum;
    }

}
