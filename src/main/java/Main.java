import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader = null;
    public static int N; //количество мест
    public static int M; //количество выделенных часов
//    минимальное количество печенек K

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]); // места
        M = Integer.parseInt(firstLine[1]); // время
        if (N > M) {
            System.out.println(0);
            return;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        int withCookies = 0;
        int sum = 0;
        List<Integer> allCookies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            int number = Integer.parseInt(line);
            if (number > max) max = number;
            if (number < min) min = number;

            if (number != 0) {
                sum = sum + number;
                withCookies++;
                allCookies.add(number);
            }
        }
//         int dif = M - N + 1;
        if (withCookies == M) {
            System.out.println(max);
            return;
        }
        if (withCookies == 0) {
            System.out.println(0);
            return;
        }

        int average = canEatAllCookies((sum / M), allCookies); //21
        System.out.println(average);
    }

    //. Последний статус: превышение лимита времени выполнения
    private static int canEatAllCookies(int average, List<Integer> allCookies) {
        int score = M;
// 33
        int maxDif = 1;

        for (int point : allCookies) {
            double x = point;
            double y = average;
            int foo = (int) Math.ceil(x / y);

            boolean isTrue = Double.compare(point, (average * foo)) > 0;
//            if (point > average * foo) {
            if (isTrue) {
                double up = point % average;
                double down = (int) Math.round(x / y);

                int diff = (int) Math.round(up / down);

                if (diff > maxDif) {
                    maxDif = diff;
                }
            }


            score = score - foo;
        }

        if (score >= 0) {
            return average;
        } else {
            return canEatAllCookies(average + maxDif, allCookies);
        }
    }
}