import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sprint_4_F_Group {
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
        String[] first = reader.readLine().split(" ");
        Map<String, int[]> storage = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            char[] stroke = first[i].toCharArray();
            Arrays.sort(stroke);
            String key = Arrays.toString(stroke);
            int[] value = storage.get(key);
            if (value == null) {
                value = new int[]{i};
                storage.put(key, value);
            } else {
                int l = value.length;
                int[] cur_value = new int[l + 1];
                System.arraycopy(value, 0, cur_value, 0, l);
                cur_value[l] = i;
                storage.put(key, cur_value);
            }
        }
        for (Map.Entry<String, int[]> entry : storage.entrySet()) {
            System.out.println(Arrays.toString(entry.getValue()));
        }
    }
}
/*
6
tan eat tea ate nat bat


 */