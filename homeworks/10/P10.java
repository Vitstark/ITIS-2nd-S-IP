package PROGA.homeworks.P10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P10 {

    public static void main(String[] args) throws IOException {
        if (args[0] == null) {
            System.out.println("Enter source path");
        }
        Path sourcePath = Path.of(args[0]);
        Files.walk(sourcePath)
                .filter(Files::isRegularFile)
                .filter(x -> {
                    int indexOfDot = x.toString().lastIndexOf('.');
                    String fileExtension = x.toString().substring(indexOfDot);
                    return fileExtension.equals(".java");
                })
                .forEach(x -> {
                    try {
                        System.out.println(x + " " + Files.lines(x).count());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

    }
}
