import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_1_K_ListFormula {
    private static BufferedReader reader = null;
    public static int X;
    private static int K;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        X = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        K = Integer.parseInt(reader.readLine());
        int numberX = 0;
        int foo = 1;
        for (int i = 1; i < X; i++) {
            foo = foo * 10;
        }

        for (int i = X; i > 0; i--) {
            int number = Integer.parseInt(tokenizer.nextToken());
            numberX = numberX + (number * foo);
            foo = foo / 10;

        }

        System.out.println(numberX + K);
    }
}
/*
4
1 2 0 0
34



 */