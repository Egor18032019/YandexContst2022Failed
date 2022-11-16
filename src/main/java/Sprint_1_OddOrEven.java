import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_1_OddOrEven {
    private static BufferedReader reader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int fist = Integer.parseInt(tokenizer.nextToken()) % 2;
        int second = Integer.parseInt(tokenizer.nextToken()) % 2;
        int three = Integer.parseInt(tokenizer.nextToken()) % 2;
        boolean isWin = fist == second && fist == three;
        System.out.println(isWin);
    }
}
