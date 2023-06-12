import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Y_Abracadabra {
    private static BufferedReader reader = null;
    public static int N;
    public static int K;

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
        K = Integer.parseInt(stringTokenizer.nextToken());
        char[] array = reader.readLine().toCharArray();  // abz
        stringTokenizer = new StringTokenizer(reader.readLine());
        int[] jump = new int[N];
        int[] position = new int[N];
        for (int i = 0; i < N; i++) {
            position[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        long allCount = 0;

        for (int x = 0; x < N; x++) {
            long count = 0;
            Map<Character, Integer> storage = new HashMap<>();
            Set<Character> answer = new HashSet<>();
            for (int i = 0; i < N; i++) {
                char key = array[i];
                storage.put(key, 1);
            }
            int i = 0;
            int index = x;
            while (i < K) {
                i++;
                char key = array[index];
                int value = storage.get(key);
                if (value == 1) {
                    answer.add(key);
                    count = count + answer.size();
                    storage.put(key, value + 1);
                } else {
                    int needJumpOn = jump[index];
                    int newPosition = key + (value - 1) * needJumpOn; //  а если меньше 97 ??
                    while (newPosition > 122) {
                        newPosition = 96 + newPosition % 122;
                    }
                    storage.put(key, value + 1);
                    char point = (char) newPosition;
                    answer.add(point);
                    count = count + answer.size();
                }
                index = position[index] - 1;
                System.out.println(count);
            }
            allCount = allCount + count;
        }
        System.out.println(allCount);
    }
}
/*

3 7
abz
3 1 2 позиция символа, который следует прочесть после чтения символа на i-й позиции.
4 0 3   сдвиг при повторном чтении символа на i-й позиции
 */