import java.util.*;
import java.io.*;

public class P9 {

    static String inputPath = "homeworks/P9/input.txt";
    static String outputPath = "homeworks/P9/output.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath));

        int numberOfLines = scanner.nextInt();
        int numberOfColumns = scanner.nextInt();
        scanner.nextLine();

        TableWriter table = new TableWriter(numberOfLines, numberOfColumns);
        table.read(scanner);
        table.write(printWriter);
    }

    static class TableWriter {
        int numberOfLines;
        int numberOfColumns;
        int [] lengthsOfColumns;
        String [][] wordsStorage;

        public TableWriter(int numberOfLines, int numberOfColumns) {
            this.numberOfLines = numberOfLines;
            this.numberOfColumns = numberOfColumns;
            lengthsOfColumns = new int[numberOfColumns];
            wordsStorage = new String[numberOfLines][numberOfColumns];
        }

        public void read(Scanner input) {
            for (int i = 0; i < numberOfLines; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    String word = input.nextLine();
                    wordsStorage[i][j] = word;
                    if (word.length() > lengthsOfColumns[j]) {
                        lengthsOfColumns[j] = word.length();
                    }
                }
            }
        }

        private void writeBorder(PrintWriter printWriter) {
            printWriter.print('+');
            for (int i = 0; i < numberOfColumns; i++) {
                for (int j = 0; j < lengthsOfColumns[i]; j++) {
                    printWriter.print('-');
                }
                printWriter.print('+');
            }
            printWriter.println();
        }

        private void writeSpaces(int numberOfSpaces, PrintWriter printWriter) {
            while (numberOfSpaces > 0) {
                printWriter.print(' ');
                numberOfSpaces--;
            }
        }

        public void write(PrintWriter printWriter) {
            writeBorder(printWriter);
            for (int i = 0; i < numberOfLines; i++) {
                printWriter.print('|');
                for (int j = 0; j < numberOfColumns; j++) {
                    printWriter.print(wordsStorage[i][j]);
                    writeSpaces(lengthsOfColumns[j] - wordsStorage[i][j].length(), printWriter);
                    printWriter.print('|');
                }
                printWriter.println();
                writeBorder(printWriter);
            }
            printWriter.close();
        }

    }

}
