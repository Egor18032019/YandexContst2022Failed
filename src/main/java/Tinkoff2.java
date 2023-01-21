import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tinkoff2 {
    private static BufferedReader reader = null;
    public static int a; // ценность
    public static int b; // ценность
    public static int c; // ценность

    public static int x;
    public static int y;
    public static int z;
    public static int sum;


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
        sum = x * a + y * b + z * c;
        List<int[]> list = new ArrayList<>();
        Set<String> storage = new HashSet<>();

        generator(0, 0, 0, storage);
        System.out.println(storage.toString());
        System.out.println(storage.size() + "size");
    }

    public static void generator(int x, int y, int z, Set<String> storage) {
        int currentSum = x * a + y * b + z * c;
        if (sum == currentSum) {
//            из условия не ясно почему 28 а не
            if (x  % a == 0) {
                if (y % b == 0) {
                    if (z  % c == 0) {
                        storage.add(x * a + "" + y * b + "" + z * c);

                    }
                }
            }
            return;
        }

        if (currentSum < sum) {
            generator(x + 1, y, z, storage);
            generator(x, y + 1, z, storage);
            generator(x, y, z + 1, storage);
        }
    }
}
