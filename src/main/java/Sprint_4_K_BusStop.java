import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_4_K_BusStop {
    private static BufferedReader reader = null;
    public static int n;
    public static int m;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, int[]> storage = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            int[] point = new int[]{x, y};
            storage.put(i, point);
        }
        m = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> diff = new HashMap<>();
        for (int i = 1; i <= m; i++) {
        stringTokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            for (int q = 1; q <= n; q++) {
                int[] points = storage.get(q);
                int xPoint = points[0];
                int yPoint = points[1];
                double distance = Math.sqrt(
                        Math.pow((xPoint - x), 2) + Math.pow((yPoint - y), 2)
                );
                if (distance <= 20) {
                    diff.put(q, diff.getOrDefault(q, 0) + 1);
                }
            }
        }
        System.out.println(diff);
    }
}
/*
3
-1 0
1 0
2 5
3
10 0
20 0
22 5

3
-1 0
1 0
0 5
3
10 0
20 0
20 5
 */
