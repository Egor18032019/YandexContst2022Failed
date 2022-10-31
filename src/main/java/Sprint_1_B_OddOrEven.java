import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_1_B_OddOrEven {
    private static BufferedReader reader = null;
    public static int a;
    private static int b;
    private static int c;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        a = Integer.parseInt(tokenizer.nextToken()) % 2; //1
        b = Integer.parseInt(tokenizer.nextToken()) % 2; //0
        c = Integer.parseInt(tokenizer.nextToken()) % 2; //1

        boolean win = a == b && a == c;

        if (win) {
            System.out.println("WIN");
        } else {
            System.out.println("FALSE");
        }
    }
}