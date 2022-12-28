import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_3_J_Bubble {

    private static BufferedReader reader = null;
    public static int n;


    public static void main(String[] args) throws IOException {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());

        Map<String, Integer> storage = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        sort(arr);
    }

    public static void sort(int[] array) {
        int temp;
        String str;
        boolean switched = false;
        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    switched = true;
                    counter++;
                }
            }
            if (switched) {
                StringBuilder out = new StringBuilder();
                for (int j = 0; j < array.length; j++) {
                    out.append(array[j]).append(" ");
                }
                System.out.println(out);
            }
            switched = false;
        }

        if (counter == 0) {
            str = Arrays.toString(array);
            str = str.substring(1, str.length() - 1);
            System.out.println(str.replaceAll(",", ""));
        }
    }
}