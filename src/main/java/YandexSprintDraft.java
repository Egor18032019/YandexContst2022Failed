import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class YandexSprintDraft {
    private static BufferedReader reader = null;
    public static int t; // количество наборов входных данных.

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        t = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken()); // строк
            int m = Integer.parseInt(stringTokenizer.nextToken()); // символов в каждой
            String[][] storage = new String[n][m];
            Map<String, int[]> symbols = new HashMap<>();
            for (int row = 0; row < n; row++) {
                String[] line = reader.readLine().split(""); // если памяти будт нехватать превести в байты
                for (int column = 0; column < m; column++) {
                    String point = line[column];
                    if (!symbols.containsKey(point)) {
                        int[] nm = new int[]{row, column};
                        symbols.put(point, nm);
                    }
                    if (row % 2 == 0 && column % 2 != 0) {
                        if (!point.equals(".")) {
                            System.out.println("NO");
                            return;
                        }
                    }
                    if (column % 2 == 0 && row % 2 != 0) {
                        if (!point.equals(".")) {
                            System.out.println("NO");
                            return;
                        }
                    }
                    storage[row][column] = point;
                }
            }

            Set<String> thisSymbolsCheck = new HashSet<>();
            boolean isChek = check(storage, thisSymbolsCheck);
            if (isChek) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    public static boolean check(String[][] arr, Set<String> thisSymbolsCheck) {
        for (int row = 0; row < arr.length; row++) {

            for (int column = 0; column < arr[0].length; column++) {
                String point = arr[row][column];
                if (point.equals(".")) continue;
                if (thisSymbolsCheck.add(point)) {
                    checkArr(arr, point, row, column);
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    public static void checkArr(String[][] arr, String point, int row, int column) {
        int n = arr.length;
        int m = arr[0].length;


        if ((column - 1) >= 0) {
            String cell = arr[row][column - 1];
            if (cell.equals(".")) {
                checkArr(arr, point, row, column - 1);
            }
            if (Objects.equals(cell, point)) {
                arr[row][column - 1] = "1";
                checkArr(arr, point, row, column - 1);
            }
        }
        if ((column + 1) < m) {
            String cell = arr[row][column + 1];
            if (cell.equals(".")) {
                checkArr(arr, point, row, column + 1);
            }
            if (Objects.equals(cell, point)) {
                arr[row][column + 1] = "1";
                checkArr(arr, point, row, column + 1);
            }
        }
        if ((row + 1) < n && (column + 1) < m) {
            String cell = arr[row + 1][column + 1];

            if (Objects.equals(cell, point)) {
                arr[row + 1][column + 1] = "1";
                checkArr(arr, point, row + 1, column + 1);
            }
        }
        if ((row + 1) < n && (column - 1) >= 0) {
            String cell = arr[row + 1][column - 1];

            if (Objects.equals(cell, point)) {
                arr[row + 1][column - 1] = "1";
                checkArr(arr, point, row + 1, column - 1);
            }
        }

    }

}
/*
R.R.R.G
.Y.G.G.
B.Y.V.V
 */