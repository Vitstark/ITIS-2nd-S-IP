import java.util.List;
import java.util.stream.Stream;

public class P7 {

    public static boolean isPrime(int n) {
        List<Integer> list = Stream
                .iterate(2, x -> x + 1)
                .limit(n).toList();

        for (int i = 2; i * i < n + 0.5; i++) {
            int divider = i;
            list = list.stream()
                    .filter(x -> x % divider != 0)
                    .toList();
        }

        return list.stream().anyMatch(x -> x == n);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(4));
    }

}
