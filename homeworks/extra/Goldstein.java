package PROGA.extra;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Goldstein {

    public static long go(int number) {
        long numberOfIterations = 0;
        long scale = 2;
        List<Integer> listOfBits = interpret(number);
        while (!isZero(listOfBits)) {
            scale++;
            changeNumbers(listOfBits, (int) scale);
            ListIterator<Integer> listIterator = listOfBits.listIterator();
            Integer value = listIterator.next();
            while(value == 0) {
                value = listIterator.next();
            }
            listIterator.set(--value);
            if (value == 0) {
                listIterator.previous();
                while (listIterator.hasPrevious()) {
                    listIterator.previous();
                    listIterator.set((int) (scale - 1));
                }
            }
            numberOfIterations++;
        }
        System.out.println(listOfBits);
        return numberOfIterations;
    }

    private static List<Integer> interpret(int number) {
        List<Integer> listOfBits = new ArrayList<>();
        while (number > 0) {
            listOfBits.add(number % 2);
            number /= 2;
        }
        return listOfBits;
    }

    private static boolean isZero(List<Integer> listOfBits) {
        return 0 == listOfBits
                .stream()
                .mapToInt(x -> x.intValue())
                .sum();
    }

    private static void changeNumbers(List<Integer> listOfBits, int scale) {
        for (int i = listOfBits.size() - 1; i >= 0; i--) {
            int value = listOfBits.get(i);
            if (value != 0) {
                listOfBits.set(i, 0);
                int newPosition = i / (scale - 1) * pow(scale, scale) + i % (scale - 1);
                if (newPosition >= listOfBits.size()) {
                    for (int j = listOfBits.size(); j <= newPosition; j++) {
                        listOfBits.add(0);
                    }
                }
                    listOfBits.set(newPosition, value);
            }
        }
    }

    private static int pow(int number, int scale) {
        int result = 1;
        for (int i = 0; i < scale; i++) {
            result *= number;
        }
        return result;
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println(Goldstein.go(3));
    }
}