import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_3_Cookies {
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
        n = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> storage = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            storage.put(Integer.valueOf(stringTokenizer.nextToken()), i);
        }
        m = Integer.parseInt(reader.readLine());
        stringTokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < m; i++) {
            Integer key = Integer.valueOf(stringTokenizer.nextToken());
            storage.remove(key);
        }

        System.out.println(n - storage.size());
    }
}
/*
2
1 2
3
2 1 3
=2

3
2 1 3
2
1 1
=1

 */