import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Y_GoodLine {
    private static BufferedReader reader = null;
    public static int N; //количество различных букв


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());


        Map<Integer, Integer> strorage = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int count = Integer.parseInt(reader.readLine());
            max = max + count;
            strorage.put(i, count);
        }


        int sum = -1;
        Integer key = 1;
        int[] arr = new int[max];
        int point = 0;
        while (strorage.size() > 0) {
            boolean storageHaveThisKey = strorage.containsKey(key);
            if (!storageHaveThisKey) {
                key++;
                continue;
            }
            int size = strorage.size();

            if (point == 0) {
                sum = sum + 1;

            } else {
                if (arr[point - 1] < key) {
                    sum = sum + 1;
                }
            }
            int value = strorage.get(key) - 1;
            arr[point] = key;
            point++;

            if (value == 0) {
                strorage.remove(key);
            } else {
                strorage.put(key, value);
            }
            for (int q = 1; q < size; q++) {
                int nextKey = key + q;
                boolean storageHaveThisNextKey = strorage.containsKey(nextKey);
                if (!storageHaveThisNextKey) {
                    continue;
                }
                sum = sum + 1;
                value = strorage.get(nextKey) - 1;
                arr[point] = nextKey;
                point++;
                if (value == 0) {
                    strorage.remove(nextKey);
                } else {
                    strorage.put(nextKey, value);
                }
            }


        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
}
/*
2
3
4

aaa
bbbb
abababb
 */