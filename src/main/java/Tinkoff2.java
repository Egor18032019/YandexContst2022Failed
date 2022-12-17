import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Tinkoff2 {
    private static BufferedReader reader = null;
    public static int a;
    public static int b;
    public static int c;
    public static int x;
    public static int y;
    public static int z;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] vault = reader.readLine().split(" ");
        a = Integer.parseInt(vault[0]);
        b = Integer.parseInt(vault[1]);
        c = Integer.parseInt(vault[2]);
        String[] money = reader.readLine().split(" ");
        x = Integer.parseInt(money[0]);
        y = Integer.parseInt(money[1]);
        z = Integer.parseInt(money[2]);
        int sum = x * a + y * b + z * c;
        Set<Integer> storage = new HashSet<>();

        for (int r = 0; r < 3; r++) {
            int[] arr = new int[3];
            for (int i = 0; i < sum; i++) {
                arr[r] = i * a;
                if (arr[r] > sum) {
                    arr[r] = 0;
                }
            }
            for (int t = 1; t < 3; t++) {

                for (int y = 0; y < 3; y++) {

                }
            }

        }
    }
}
