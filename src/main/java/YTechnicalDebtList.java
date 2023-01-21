import java.io.*;
import java.util.*;

public class YTechnicalDebtList {
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
        TreeSet<Integer> deadQueue = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            deadQueue.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(deadQueue);
        while (K != 0) {
            int current = deadQueue.first();
            deadQueue.remove(current);
            int diff = current - day;
            if (diff != 0) {
                K = K - 1;
            }
            day = day + diff;
            int nextValue = current + X;
            deadQueue.add(nextValue);
        }

        System.out.println(day);
    }


}
/*
6 1 10
1 1 1 1 1 1

 */