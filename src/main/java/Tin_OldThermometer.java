import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int[] arr = new int[n];
        boolean isPlus = false;
        boolean canAnswer = false;

        for (int row = 0; row < n; row++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int point = Integer.parseInt(stringTokenizer.nextToken());
            arr[row] = point;
            String foo = stringTokenizer.nextToken();
            boolean now = foo.equals(p);
            sum = sum + point;
            if (row == 0) {
                isPlus = now;
            } else {
                if (now != isPlus) {
                    canAnswer = true;
                    isPlus = now;
                    if (isPlus) {
                        plus = sum;
                    } else {
                        minus = sum;
                    }
                } else {
                    // если без перехода всё идет то
                    if (isPlus) {
                        if (sum < plus) {
                            plus = sum;
                        }
                    } else {
                        if (sum > minus) {
                            minus = sum;
                        }
                    }
                }

            }
        }
        int x = -(minus + plus - minus);

        if (canAnswer) {
            for (int t : arr) {
                x = x + t;
            }
            System.out.println(x);
        } else {
            System.out.println("inf");
        }
    }
}
/*
 -
 x+8+4
 x+8<0
 x+9>0


 */
