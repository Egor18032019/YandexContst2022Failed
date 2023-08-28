import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class HHLabyrinth {
    private static BufferedReader reader = null;
    /**
     * ширина лабиринта
     */
    public static int n;
    /**
     * высота лабиринта
     */
    public static int m;
    public static int x2;
    public static int y2;
    public static byte[][] pole;
    public static TreeSet<Integer> sortedSet;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /*
3 4
0 0
3 0
0 1 0 0
0 1 0 1
0 0 0 1

2 3
0 0
2 1
0 0 0
0 0 0
     */
    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]); //ширина лабиринта
        m = Integer.parseInt(firstLine[1]);//высота лабиринта
        String[] input = reader.readLine().split(" ");
        int x1 = Integer.parseInt(input[0]);
        int y1 = Integer.parseInt(input[1]);
        String[] output = reader.readLine().split(" ");
        x2 = Integer.parseInt(output[0]);
        y2 = Integer.parseInt(output[1]);
        pole = new byte[n][m];
        sortedSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            byte[] row = reader.readLine().getBytes(); // 0 1 0
            int index = 0;
            for (byte it : row) {
                if (it == ' ') {
                    continue;
                }
                pole[i][index] = it;
                index++;
            }
        }

        checkArr(pole, 0, x1, y1);

//        System.out.println(Arrays.deepToString(pole));
        if (!sortedSet.isEmpty()) {
            System.out.println(sortedSet.first());
        } else {
            System.out.println(0);
        }
    }


    public static void checkArr(byte[][] arr,
                                int step, int x1, int y1) {

        byte cell = arr[y1][x1];
        if (cell == 2) {
            return;
        }
        if (cell == 49) {
            return;
        }
        if (x1 == x2 && y1 == y2) {
//            System.out.println("дошли " + step);
            sortedSet.add(step);
            return;
        }

        arr[y1][x1] = 2;

        if ((y1 + 1) < n) {
            checkArr(arr, step + 1, x1, y1 + 1);
        }
        if ((y1 - 1) >= 0) {
            checkArr(arr, step + 1, x1, y1 - 1);
        }

        if ((x1 + 1) < m) {
            checkArr(arr, step + 1, x1 + 1, y1);

        }
        if ((x1 - 1) >= 0) {
            checkArr(arr, step + 1, x1 - 1, y1);
        }
    }

}