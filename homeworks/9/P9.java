package PROGA.homeworks.P9;

import java.util.*;
import java.io.*;

public class P9 {

    static String inputPath = "src/PROGA/homeworks/P9/input.txt";
    static String outputPath = "src/PROGA/homeworks/P9/output.txt";

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
        String [][] tableOfStings;

        public TableWriter(int numberOfLines, int numberOfColumns) {
            this.numberOfLines = numberOfLines;
            this.numberOfColumns = numberOfColumns;
            lengthsOfColumns = new int[numberOfColumns];
            tableOfStings = new String[numberOfLines][numberOfColumns];
        }

        public void read(Scanner input) {
            for (int i = 0; i < numberOfLines; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    String word = input.nextLine();
                    tableOfStings[i][j] = word;
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

        private int getNumberOfSpaces(int maxLength, String string) {
            int numberOfSpaces = maxLength - string.length();
            return numberOfSpaces;
        }

        private void writeSpaces(int numberOfSpaces, PrintWriter printWriter) {
            while (numberOfSpaces > 0) {
                printWriter.print(' ');
                numberOfSpaces--;
            }
        }

        private void writeLine(int numberOfLine, PrintWriter printWriter) {
            printWriter.print('|');
            for (int i = 0; i < numberOfColumns; i++) {
                String string = tableOfStings[numberOfLine][i];
                int numberOfSpaces = getNumberOfSpaces(lengthsOfColumns[i], string);
                printWriter.print(tableOfStings[numberOfLine][i]);
                writeSpaces(numberOfSpaces, printWriter);
                printWriter.print('|');
            }
        }

        public void write(PrintWriter printWriter) {
            writeBorder(printWriter);
            for (int i = 0; i < numberOfLines; i++) {
                writeLine(i, printWriter);
                printWriter.println();
                writeBorder(printWriter);
            }
            printWriter.close();
        }

    }

}
