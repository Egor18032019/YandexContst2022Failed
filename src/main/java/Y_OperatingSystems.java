import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://contest.yandex.ru/contest/45468/problems/6/
public class Y_OperatingSystems {
    private static BufferedReader reader = null;
    public static int M; //количество секторов на жестком диске
    public static int N; // количество разделов,


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        M = Integer.parseInt(reader.readLine());
        N = Integer.parseInt(reader.readLine());


        Map<Integer, Integer> strorage = new HashMap<>();
        int[] arr = new int[M];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            String[] line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            strorage.put(i, (b - a));
            boolean isNewSystem = true;
            for (int q = a; q <= b; q++) {
                arr[q] = i;
            }
        }

        int currentSystem = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == currentSystem) {

            }

        }

        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
}