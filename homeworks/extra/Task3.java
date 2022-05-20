import java.util.*;

public class Main {

    static int dist(String file1, String file2) {

        int numberOfEqualsWords = 0;

        List<String> list1 = Arrays.stream(file1
                        .split("\\W+"))
                .distinct()
                .sorted()
                .toList();

        List<String> list2 = Arrays.stream(file2
                        .split("\\W+"))
                .distinct()
                .sorted()
                .toList();

        ListIterator<String> it1 = list1.listIterator();
        ListIterator<String> it2 = list2.listIterator();

        String str1 = it1.next();
        String str2 = it2.next();

        while (it1.hasNext() || it2.hasNext()) {
            int resultOfCompare = str1.compareTo(str2);
            if (resultOfCompare == 0) {
                numberOfEqualsWords++;
                if (!it1.hasNext()) {
                    str2 = it2.next();
                    continue;
                }
                if (!it2.hasNext()) {
                    str1 = it1.next();
                    continue;
                }
                str1 = it1.next();
                str2 = it2.next();
                continue;
            }

            if (resultOfCompare < 0) {
                str1 = it1.next();
            } else {
                str2 = it2.next();
            }
        }

        return numberOfEqualsWords;
    }
}