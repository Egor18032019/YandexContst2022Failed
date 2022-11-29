import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_2_K_FibonachiIntern {
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

        int internCommit = fibonacci(n);
        System.out.println(internCommit);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
        // (1 + 1 )+ 1
    }

}
