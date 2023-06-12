import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Y_Perfectionism {
    private static BufferedReader reader = null;
    public static int N; //количество скульптур
    public static int X; // идеальное количество льда в скульптуре.
    public static int T; // оставшееся количество минут до наступления праздника

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
        T = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, Integer> strorage = new HashMap<>();

        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(stringTokenizer.nextToken());
            strorage.put(i, value);
        }
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        int counter = T;

        if (strorage.containsValue(X)) {
            count++;
            counter--;
            answer.add(strorage.get(X));
        }
        int foo = X;
        int bar = X;
        while (counter != 0) {  // 2
            foo = foo + 1;
            bar = bar - 1;
            counter--;
            // 5    -> 3 4 5 6 7
            // 5    -> 1 4 5 6 7
            if (strorage.containsValue(foo)) {
                count++;
                Stream<Integer> keyStream = keys(strorage, foo);
                int key = keyStream.findFirst().get();
                answer.add(key);
                strorage.remove(key);
                foo = 0;
                bar = 0;
            }
            if (answer.size() >= T) {
                break;
            }
            if (strorage.containsValue(bar)) {
                count++;
                Stream<Integer> keyStream = keys(strorage, bar);
                int key = keyStream.findFirst().get();
                answer.add(key);
                strorage.remove(key);
                foo = 0;
                bar = 0;
            }
            if (answer.size() >= T) {
                break;
            }
        }
        System.out.println(count);
        for (Integer integer : answer) {
            System.out.print(integer);
            System.out.print(" ");

        }
    }

    public static <K, V> Stream<Integer> keys(Map<Integer, Integer> map, Integer value) {
        return map.entrySet()
                .stream()
                .filter(entry ->
                        value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }
}
