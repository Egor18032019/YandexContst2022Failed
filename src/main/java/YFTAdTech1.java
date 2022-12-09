import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class YFTAdTech1 {
    private static BufferedReader reader = null;
    public static int N;
    public static int M;

    public static void main(String[] args) throws Exception {
        init();
        run();
        reader.close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));


    }

    private static void run() throws IOException {

        N = Integer.parseInt(reader.readLine());
        String[] url = new String[N];
        for (int i = 0; i < N; i++) {
            String token = reader.readLine();
            url[i] = token;
        }
        M = Integer.parseInt(reader.readLine());
        for (int i = 0; i < M; i++) {
            String token = reader.readLine();
            int count = 0;
            for (int q = 0; q < N; q++) {
                String foo = url[q];
                if (foo.startsWith(token)) {
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}