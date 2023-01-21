import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint_3_F_Perimeter {
    private static BufferedReader reader = null;
    public static int n;
    public static void main(String[] args) throws Exception {
        init();
        run();
    }
    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int[] storage = new int[n];

        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(storage);
        int maxPerimeter = 0;
        for (int i = 0; i < n - 1; i++) {
            int index = n - 1;
            int sum = storage[i] + storage[i + 1];
            while (storage[index] >= sum) {
                index--;
            }
            if (index == i || index == (i + 1)) {
                continue;
            }
            int currenPerimeter = sum + storage[index];
            if (currenPerimeter > maxPerimeter) {
                maxPerimeter = currenPerimeter;
            }
        }
        System.out.println(maxPerimeter);
    }
}
/*
4
6 3 3 2
=8

6
5 3 7 2 8 3
=20

 */