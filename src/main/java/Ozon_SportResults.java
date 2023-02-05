import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ozon_SportResults {
    private static BufferedReader reader = null;
    public static int t;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        t = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(reader.readLine());
            Map<Integer, Integer> storage = new HashMap<>();
            stringTokenizer = new StringTokenizer(reader.readLine()); // 20 10 20 30
            int index = 0;
            while (stringTokenizer.hasMoreTokens()) {
                storage.put(index, Integer.valueOf(stringTokenizer.nextToken()));
                index++;
            }
            Map<Integer, Integer> sortedByValue = storage.entrySet()
                    .parallelStream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));
            // 10 20 20 30
            int[] arr = new int[n];
            int oldValue = 0;
            int place = 1;
            int currentPlace = 1;
//            if (n == 3) {
//                System.out.println();
//            }
            for (Map.Entry<Integer, Integer> entry : sortedByValue.entrySet()) {
                int value = entry.getValue();
                int arrIndex = entry.getKey();
                int diff = value - oldValue;
                if (diff == 0 || diff == 1) {
                    arr[arrIndex] = currentPlace;
                    place++;
                } else {
                    arr[arrIndex] = place;
                    currentPlace = place;
                    place++;
                }
                oldValue = value;
            }
//            System.out.println(Arrays.toString(arr));
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}