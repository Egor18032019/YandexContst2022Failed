import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_2_L_FibonachiModule {
    private static BufferedReader reader = null;
    public static int n;
    private static int k;

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
        k = Integer.parseInt(tokenizer.nextToken());

        int internCommit = fibonacci(n);
        long stepan = (long) Math.pow(10, k);
        int module = (int) (internCommit % (stepan));
        System.out.println(module);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
        // (1 + 1 )+ 1
    }
}