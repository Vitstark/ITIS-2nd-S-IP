import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P6 {

    private static List<Integer> getRandomList(int n) {
        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(new Random().nextInt(2));
        }

        return list;
    }

    public static List<Double> task(int n) {
        List<Double> list = new ArrayList<>(2);
        List<Integer> randomList = getRandomList(n);

        double average = randomList.stream()
                .mapToInt(x -> x)
                .sum() * 1.0 / n;

        double dispersion = randomList
                .stream()
                .mapToInt(x -> x * x)
                .sum() * 1.0 / n - average * average;

        list.add(average);
        list.add(dispersion);
        return list;
    }

}
