import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Y_Abracadabra {
    private static BufferedReader reader = null;
    public static int N;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> mapForProfit = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {


        }
    }
}
