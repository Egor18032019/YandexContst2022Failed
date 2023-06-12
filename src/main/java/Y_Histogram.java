import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Y_Histogram {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {


        String line = reader.readLine();
        Map<Character, Integer> map = new TreeMap<>();
        int max = 0;
        StringBuilder sb = new StringBuilder();
        while (line != null && !line.isEmpty()) {
            char[] chars = line.toCharArray();
            for (char key : chars) {
                if (key != ' ') {
                    map.putIfAbsent(key, 0);
                    int count = map.get(key) + 1;
                    map.put(key, count);
                    if (count > max) max = count;
                }
            }
            line = reader.readLine();
        }
        for (int i = 0; i < max; i++) {
            for (Character c : map.keySet()) {
                if (map.get(c) > max - i - 1) sb.append('#');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        for (Character c : map.keySet()) sb.append(c);
        System.out.println(sb);

    }

}
