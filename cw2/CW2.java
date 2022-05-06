
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CW2 {
    // 1
    // Тесты для ToTest.method
    // Можно добавить ещё методов-тестов, если нужно
    List<Integer> list1;
    List<Integer> list2;
    List<Integer> list3;
    List<Integer> list4;
    List<Integer> list5;


    @BeforeAll
    public void init() {
        list1 = List.of();
        list2 = List.of(1, 2, 3, 4, 5, 6);
        list3 = List.of(9, 8, 7, 6);
        list4 = List.of(0, 1, null, 5, 6, 9, 0);
        list5 = null;
    }

    @Test
    public void incorrectTest() {
        assertNotEquals(List.of(1), ToTest.method(List.of(0,0,0),2));
        assertNotEquals(List.of(0, 1, 2, 3), ToTest.method(List.of(1, 1, 1, 1, 1, 1), 2));
    }

    @Test
    public void correctTest() {
        assertEquals(List.of(0, 4, 9, 15), ToTest.method(list2, 3));
        assertEquals(List.of(0, 9, 17, 24, 30), ToTest.method(list3, 4));
    }

    @Test
    public void differentNTest() {
        assertEquals(List.of(0), ToTest.method(list2, 0));
        assertEquals(List.of(0), ToTest.method(list1, 10));
        assertEquals(List.of(0), ToTest.method(list2, -10));
    }

    @Test
    public void nullElementTest() {
        assertEquals(List.of(0, 6, 15, 15), ToTest.method(list4, 3));
        assertEquals(List.of(null, null, null, null, null, null), ToTest.method(list4, 5));
    }

    @Test
    public void nullListTest() {
        assertThrows(NullPointerException.class, () -> ToTest.method(null, 0));
    }

    // 2
    // Скачать файлы
    public static void task2() throws IOException {
        URL url = new URL("https://cataas.com/cat/gif");
        OutputStream outStream = Files.newOutputStream(Path.of("wrong.txt"));
        PrintWriter printer = new PrintWriter(outStream);
        Path input = Path.of("input.txt");
        Files.lines(input)
                .map(x -> x.split(" +"))
                .filter(x -> {
                    if (x.length == 1) {
                        return true;
                    }
                    for (String string : x) {
                        printer.print(string + " ");
                    }
                    printer.println();
                    return false;
                })
                .forEach(strings -> {
                    try (InputStream inputStream = url.openStream()) {
                        Files.copy(inputStream, Path.of(strings[0] + ".gif"),
                                StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        printer.close();
    }

    // 3
    // Работать с директорией
    public static int task3() throws IOException {
        int sum = 0;
        try (Scanner sc = new Scanner(new FileInputStream("dir.txt"))) {
            sum = (int) Files.walk(Path.of(sc.nextLine()), 2)
                    .filter(x -> Files.isRegularFile(x))
                    .filter(x -> {
                        String fileName = x.getFileName().toString();
                        if (fileName.length() >= 3 && fileName.startsWith("lib")) {
                            return true;
                        }
                        return false;
                    })
                    .mapToLong(x -> {
                        try {
                            return Files.size(x);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return 0l;
                    })
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
