import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TInkoff4 {
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
        n = Integer.parseInt(reader.readLine());
//        BigDecimal
        int tre = n / 3; //
        double bar = n - 2;
        double foo = bar / n;
        double degrees = foo*180;
        double radians = Math.toRadians(degrees);
        double sinus = Math.sin(radians);
        double arr = 0.5 * sinus;

        System.out.println(arr);
//        double down = 2 * Math.sin(Math.PI / n);
//        double R = 1 /down;
        double R = (Math.sqrt(5) + 1)/2*1;
        double max = (3 * Math.sqrt(3) * R * R) / 4;
        System.out.println(max);
    }
}
