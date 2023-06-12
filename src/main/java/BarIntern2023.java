import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BarIntern2023 {
    private static BufferedReader reader = null;
    public static int N; // высота
    public static int M; // ширина
    public static int K; // строки инг

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        List<char[]> glass = new ArrayList<>();
        Map<Integer, int[]> helpers = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char[] row = reader.readLine().toCharArray();
            int[] coordinates = new int[2];
            boolean flag = true;
            for (int q = 0; q < M; q++) {
                char point = row[q];
                if (point != '.' && point != '_') {
                    if (flag) {
                        coordinates[0] = q;
                        flag = false;
                    } else {
                        coordinates[1] = q;
                    }
                }

            }
            helpers.put(i, coordinates);
            glass.add(row);
        }
        K = Integer.parseInt(reader.readLine());
        int current = N - 2;
        // name count symbol.
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            String name = stringTokenizer.nextToken();
            int count = Integer.parseInt(stringTokenizer.nextToken());
            char symbol = stringTokenizer.nextToken().charAt(0);


            while (count > 0) {
                char[] layer = glass.get(current);
                int start = helpers.get(current)[0];
                int end = helpers.get(current)[1];
                for (int q = start + 1; q < end; q++) {
                    layer[q] = symbol;
                }
                current--;
                count--;
            }

        }


        for (int i = 0; i < N; i++) {
            char[] row = glass.get(i);
            for (int q = 0; q < M; q++) {
                System.out.print(row[q]);
            }
            System.out.println();
        }

    }
}
