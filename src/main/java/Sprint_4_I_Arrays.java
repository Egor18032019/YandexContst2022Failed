import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_4_I_Arrays {
    private static BufferedReader reader = null;
    public static int n;
    public static int k;
    public static Map<Integer, Integer> storage;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        storage = new HashMap<>();

        n = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        k = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(stringTokenizer.nextToken());
            storage.put(i, value);
        }
        String[] second = reader.readLine().split(" ");
        int maxLength = 0;
        int index = 0;
        while (index < k) {
            int fistNumber = Integer.parseInt(second[index]);

            if (storage.containsValue(fistNumber)) {
                List<Integer> points = new ArrayList<>();
                points.add(fistNumber);
                index = giveMeLength(points, fistNumber, second, index);
                System.out.println("index - " + index);
                System.out.println(points);
                maxLength = Math.max(maxLength, points.size());
            }

        }
        System.out.println(maxLength);
    }

    public static int giveMeLength(List<Integer> points, int fistNumber, String[] second, int index) {
        if (second.length < index + 2) return fistNumber;
        int foo = Integer.parseInt(second[index + 1]);
        int center = storage.getOrDefault(fistNumber, 257);
        int left = center - 1;
        int right = center + 1;
        if (foo == storage.getOrDefault(left, 256) || foo == storage.getOrDefault(right, 256)) {
            points.add(foo);
            return giveMeLength(points, foo, second, index + 1);
        }
        return index + 1;
    }

}
/*
5
1 2 3 2 1
5
3 2 1 5 6

5
1 2 3 2 1
5
3 3 1 2 6


6
1 2 5 0 0 6
6
3 2 1 5 6 0
 */