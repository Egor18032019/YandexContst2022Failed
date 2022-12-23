import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint_3_E_Home {
    private static BufferedReader reader = null;
    public static int n;
    public static int k;

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
        k = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(reader.readLine());
        int homesForSell = stringTokenizer.countTokens();
        int[] storage = new int[homesForSell];
        for (int i = 0; i < homesForSell; i++) {
            storage[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(storage);
        int count = 0;
        for (int i = 0; i < homesForSell; i++) {
            k = k - storage[i];
            if (k >= 0) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
/*
3 300
999 999 999
=0
3 1000
350 999 200
=2
3 1000
350 200 200
=3
 */