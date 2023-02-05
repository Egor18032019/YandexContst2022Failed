import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Y_BestKeyboard {
    private static BufferedReader reader = null;
    public static int N; //количество клавиш на клавиатуре.
    public static int K; // количество символов в реферате.

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());
        Map<String, String> strorage = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        String[] threeLine = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            String key = stringTokenizer.nextToken();
            strorage.put(key, threeLine[i]);
        }
        K = Integer.parseInt(reader.readLine());
        int count = 0;
        String lastValue = "";
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < K; i++) {
            String key = stringTokenizer.nextToken();
            String value = strorage.get(key);
            if (lastValue.equals("")) {
                lastValue = value;
            } else {
                if (!lastValue.equals(value)) {
                    count++;
                    lastValue = value;
                }
            }
        }
        System.out.println(count);
    }

}
