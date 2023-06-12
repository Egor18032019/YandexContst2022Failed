import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Tin_Digital {
    private static BufferedReader reader = null;
    public static int n; // количество процов
    public static int m; // количество задач
    public static int t; // количество наборов входных данных.

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        String[] energy = reader.readLine().split(" "); //  3 2 6 4 в секунду
        Map<Integer, Integer> servers = new TreeMap<>(); // вроде авто сортировка по ключу из коробки
        Map<Integer, Integer> busySet = new TreeMap<>(); // вроде авто сортировка по ключу из коробки
        long sum = 0;
        for (int row = 0; row < n; row++) {
        }
    }
}
/*
1122334455002244668006677889900
 */