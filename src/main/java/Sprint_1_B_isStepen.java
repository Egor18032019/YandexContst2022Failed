import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_1_B_isStepen {
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
        while (n > 1) {
            if (n % 4 != 0) {
                System.out.println("False");
                break;
            }
            n = n / 4;
        }
        System.out.println("Yes");
    }
}
