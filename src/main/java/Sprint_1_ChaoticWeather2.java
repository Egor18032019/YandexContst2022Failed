import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_1_ChaoticWeather2 {
    private static BufferedReader reader = null;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        String[] line = reader.readLine().split(" ");
        int result = 0;
        int prev;
        int next;
        boolean checkPrev;
        boolean checkNext;
        for (int i = 0; i < n; i++) {
            prev = i - 1;
            next = i + 1;
            if (prev >= 0) {
                checkPrev = Integer.parseInt(line[i]) > Integer.parseInt(line[prev]);
            } else {
                checkPrev = true;
            }
            if (next < n) {
                checkNext = Integer.parseInt(line[i]) > Integer.parseInt(line[next]);
            } else {
                checkNext = true;
            }
            if (checkPrev && checkNext) result++;
        }
        System.out.println(result);
    }
}