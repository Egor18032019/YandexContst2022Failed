import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YTechnicalDebt {
    private static BufferedReader reader = null;
    public static int N; // задач
    public static int X; // дней
    public static int K; // а на K-й раз садится и решает все задачи разом (даже те, у которых не настал дедлайн).

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(reader.readLine());
        int day = 0;
        int[] deadQueue = new int[N];
        for (int i = 0; i < N; i++) {
            deadQueue[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(deadQueue);
//        System.out.println(Arrays.toString(deadQueue));

        while (K != 0) {
            int current = deadQueue[0];
            int diff = current - day;
            if (diff != 0) {
                K = K - 1;
            }
            day = day + diff;
            deadQueue[0] = current + X;
            Arrays.sort(deadQueue);

        }

        System.out.println(day);
    }
}
/*
6 1 2
9 2 3 3 4 5

 */