import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Tin_OldThermometer {
    private static BufferedReader reader = null;
    public static int n; // количество наблюдений


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        final String p = "0+";
        final String m = "-";
        n = Integer.parseInt(reader.readLine());
        int minus = 0;
        int plus = 0;
        int sum = 0;
        int [] arr = new
        for (int row = 0; row < n; row++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int point = Integer.parseInt(stringTokenizer.nextToken());
            String foo = stringTokenizer.nextToken();
            sum = sum + point;
            if (foo.equals(p)) {
                plus = sum;
            } else {
                minus = sum;
            }
        }
        int x = plus - minus;
        System.out.println(plus);
        System.out.println(minus);
        System.out.println(x);
    }
}
