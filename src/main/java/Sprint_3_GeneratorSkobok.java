import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_3_GeneratorSkobok {
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
         n = Integer.parseInt(reader.readLine());

        generator(n, "(", 1, 0);

    }
    // ( = open
    // ) = close
    public static void generator(int n, String arr, int open, int close) {
        if ((n * 2) == (open + close)) {
            System.out.println(arr);
            return;
        }

        if (open < n) {
            generator(n, arr + "(", open + 1, close);
        }
        if (close < open) {
            generator(n, arr + ")", open, close + 1);
        }

    }
}