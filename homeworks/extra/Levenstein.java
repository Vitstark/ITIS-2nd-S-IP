package PROGA.extra;

public class Levenstein {
    private static int isEquals(char c1, char c2) {
        return c1 == c2? 0 : 1;
    }

    public static int levenstein(String s1, String s2) {
        int m = s1.length() + 1;
        int n = s2.length() + 1;

        int [][] tableOfRedaction = new int[m][n];

        for (int i = 1; i < m; i++) {
            tableOfRedaction[i][0] = i;
        }

        for (int j = 1; j < n; j++) {
            tableOfRedaction[0][j] = j  ;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int predStep1 = tableOfRedaction[i][j-1];
                int predStep2 = tableOfRedaction[i-1][j];
                tableOfRedaction[i][j] = Math.min(tableOfRedaction[i-1][j-1] +
                        isEquals(s1.charAt(i - 1), s2.charAt(j - 1)),
                        Math.min(predStep1, predStep2) + 1);
            }
        }
        int distanceOfRedaction = tableOfRedaction[s1.length()][s2.length()];
        return distanceOfRedaction;
    }

    public static void main(String[] args) {
        String s1 = "I love cats";
        String s2 = "I love";
        System.out.println(levenstein(s1, s2));
    }

}
