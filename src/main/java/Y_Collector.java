import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Y_Collector {
    private static BufferedReader reader = null;
    public static int N; //количество наклеек у Диего.
    public static int K; // количество коллекционеров,

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
        int[] storage = new int[N];
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            storage[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(reader.readLine());
        K = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(reader.readLine());
        Arrays.sort(storage);
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());

            int left = 0;
            int right = storage.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (storage[mid] >= number) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);

        }
    }
}
