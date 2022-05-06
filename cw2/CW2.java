
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CW2 {
    // 1
    // Тесты для ToTest.method
    // Можно добавить ещё методов-тестов, если нужно
    @Test
    public void sample() {
        assertEquals(List.of(1), ToTest.method(List.of(1,2,3),2));
    }

    // 2
    // Скачать файлы
    public static void task2() throws IOException {
    }

    // 3
    // Работать с директорией
    public static int task3() throws IOException {
        return 0;
    }

    public static void main(String[] args) {
    }
}
