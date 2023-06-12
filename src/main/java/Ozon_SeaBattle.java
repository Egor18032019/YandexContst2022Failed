import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ozon_SeaBattle {
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
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int one = 4;
            int two = 3;
            int three = 2;
            int four = 1;
            boolean flag = true;

            while (stringTokenizer.hasMoreTokens()) {
                int point = Integer.parseInt(stringTokenizer.nextToken());
                if (point == 1) {
                    one--;
                }
                if (point == 2) {
                    two--;
                }
                if (point == 3) {
                    three--;
                }
                if (point == 4) {
                    four--;
                }
                if (one < 0 || two < 0 || three < 0 || four < 0) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
            if (flag) {

                System.out.println("YES");
            }
        }
    }
}
