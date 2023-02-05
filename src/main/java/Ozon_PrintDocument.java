import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ozon_PrintDocument {
    private static BufferedReader reader = null;
    public static int t;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        t = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(reader.readLine());
            stringTokenizer = new StringTokenizer(reader.readLine(),","); // 1 7 1
            int[] arr = new int[n];
            for (int q = 0; q < n; q++) {
                arr[q] = q + 1;
            }
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                System.out.println(token);
                int bar = Integer.parseInt(token);
                arr[bar - 1] = 0;
            }
// 1 2 3 0 0 5 6 0
            boolean flag = true;
            StringBuilder stringBuilder = new StringBuilder();
            for (int q = 0; q < n; q++) {
                int page = arr[q];
                if (q == 0) {
                    if (page != 0) {
                        stringBuilder.append(page);
                    }
                    continue;
                }
                if (page == 0 && arr[q - 1] != 0) {
                    stringBuilder.append("-")
                            .append(arr[q - 1]);
                    flag = false;
                }
                if (!flag && page != 0) {
                    stringBuilder.append(",")
                            .append(page);
                }
            }
            System.out.println(stringBuilder.toString());

        }
    }
}
