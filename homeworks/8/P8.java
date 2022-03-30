import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P8 {

    public static Map<Integer, List<Integer>> divisible(int n, List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toMap(k -> k % n, v -> Stream.of(v).toList(), (a,b) -> {
                    List<Integer> list = new ArrayList<>(a);
                    list.addAll(b);
                    return list;
                }));
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(divisible(5, list));
    }

}