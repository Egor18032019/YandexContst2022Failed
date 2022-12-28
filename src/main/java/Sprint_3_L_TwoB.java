import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_3_L_TwoB {
    private static BufferedReader reader = null;
    public static int n;
    /**
     * стоимость велосипеда
     */
    public static int s;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        s = Integer.parseInt(reader.readLine());
        int workedS = s;
        int count = 2;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                return;
            }
            int moneyDay = Integer.parseInt(stringTokenizer.nextToken());
            workedS = workedS - moneyDay;
            if (workedS <= 0) {
                System.out.println(i + 2);
                workedS = s - workedS;
                count--;
            }
        }
        if (workedS > 0) {
            System.out.println("-1");
        }
    }
}
/*
6
1 2 4 4 6 8
3
// не понял ничего почему в итоге такой ответ должен быть
6
1 2 4 4 4 4
3

6
1 2 4 4 4 4
10
 */