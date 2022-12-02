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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, String> storage = new HashMap<>();
        char[] arr = new char[n];
        StringBuilder prefix = new StringBuilder();

//        generator(n, "", 0, 0);
//        int k = 0;
//        for (int i = 0; i < 10; i++) {
//            k = k++;
//        }
//        System.out.println(k);

    }

    // ( = open
    // ) = close
    public static void generator(int n, String arr, int open, int close) {
        if ((n * 2) == (open + close)) {
            System.out.println(arr);
            return;
        }

        if (open >= close) {
            generator(n, arr + "(", open, close + 1);
        } else {
            generator(n, arr + ")", open + 1, close);
        }

        if (close <= (n / 2)) {
            generator(n, arr + "(", open + 1, close);
        }


    }

}