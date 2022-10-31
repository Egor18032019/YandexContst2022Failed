import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sprint_1_A_function {
    private static Scanner reader = null;
    public static int n = 4;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new Scanner(System.in);
    }


    private static void run() throws IOException {
        int a = reader.nextInt();
        int x = reader.nextInt();
        int b = reader.nextInt();
        int c = reader.nextInt();
        // y = ax*2+bx+c
        if (x == 0) {
            System.out.println(c);
            return;
        }
        int y = a * x * x + b * x + c;
        System.out.println(y);

    }
}
/*
-8 -5 -2 7

8 2 9 -10
 */