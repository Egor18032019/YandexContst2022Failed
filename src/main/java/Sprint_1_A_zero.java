import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sprint_1_A_zero {
    private static Scanner reader = null;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new Scanner(System.in);
    }


    private static void run() throws IOException {
        n = reader.nextInt();
        Map<Integer, Integer> street = new HashMap<>();
        // номер дома и расстояние до ближайшего нуля
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int home = reader.nextInt();
            if (home == 0) {
                street.put(i, home);
                counter = 0;
                if (i != 0) {
                    street.put(i - 1, 1);
                }
            } else {
                counter++;
                street.put(i, counter);
            }
        }
        for (int i = 0; i < n; i++) {
            int value = street.get(i);
            System.out.println(value);
        }
    }
}
/*
5
0 1 4 9 0

6
0 7 9 4 8 20

 */