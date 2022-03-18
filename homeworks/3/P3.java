import java.util.LinkedList;
import java.util.stream.*;
import java.util.List;

public class P3 {

    public static List<Integer> task(List<Integer> list) {

        Stream<Integer> stream = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x + x * x);

        return stream.toList();
    }

}
