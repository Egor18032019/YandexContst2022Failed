import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tinkoff3 {
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
        int currentSizeColor = n;
        int min = n;
        int foo = 1;
        int bar = 1;
        for (int i = 1; i <= n / 2; i++) {
            int A = i;
            int B = n - i;
            int current = (nok(A, B));
            if (current < min) {
                min = current;
                foo = A;
                bar = B;
            }
        }
        System.out.println(foo + " " + bar);

    }


    static int nod(int x, int y) { //  находиим наименьший общий делитель
        int tmp = x % y;
        x = y;
        y = tmp;
        if (tmp > 0) {
            return nod(x, y);
        } else {
            return x;
        }
    }

    static int nok(int x, int y) {// находим наименьшее общее кратное чисел
        return x * (y / nod(x, y));
    }
}
