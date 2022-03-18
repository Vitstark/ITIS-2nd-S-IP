import java.util.function.Function;
import java.util.stream.*;
import java.util.List;

public class P2 {

    public static <T> int task(List<T> list, Function<T, Integer> f) {
        return list.stream()
                .map(f)
                .filter(x -> x % 2 == 1)
                .mapToInt(x -> x)
                .sum();
    }

}
