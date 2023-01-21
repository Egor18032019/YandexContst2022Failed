import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_3_Broken_Array {
    private static BufferedReader reader = null;
    public static int n;
    public static int k;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int[] storage = new int[n];
        int index = 0;
        while (stringTokenizer.hasMoreTokens()) {
            storage[index] = Integer.parseInt(stringTokenizer.nextToken());
            index++;
        }
        rec(storage, 0, n - 1);
    }

    public static void rec(int[] arr, int left, int right) {
        // 19 21 100 101 1 4 5 7 12
        int center = (left + right) / 2;
        if (arr[center] == k) {
            System.out.println(center);
            return;
        }
        // 19 21 100 101 1 4 5 7 12
        // 5
        if (k > arr[center]) {
            if (arr[right] > k) {
                rec(arr, center + 1, right);
            } else {
                // 7 8 1 2 3 4 5
                // 1 2 3 4 5
                rec(arr, left, center - 1);
            }
        } else {
            // 19 21 100 101  1  4 5 7 12
            // 21
            if (arr[left] > k) {
                // 19 21 100 101  1  4 5 7 12
                // 7
                rec(arr, center + 1, right);
            } else {
                rec(arr, left, center - 1);
            }
        }
    }
}
/*
9
5
19 21 100 101 1 4 5 7 12
 */