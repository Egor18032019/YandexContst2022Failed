import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_3_I_ConferencesLove {
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

        Map<String, Integer> storage = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            String key = stringTokenizer.nextToken();
            storage.put(key, storage.getOrDefault(key, 0) + 1);
        }

        k = Integer.parseInt(reader.readLine());
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(storage.entrySet());

        entries.sort(new MyComparator());

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            k--;
            if (k >= 0) {
//                System.out.println("ID =  " + entry.getKey() + " количество = " + entry.getValue());
                System.out.println(entry.getKey());
            }
        }
    }

    static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            int reverseValueCompared = Integer.compare(e2.getValue(), e1.getValue());
            if (reverseValueCompared == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return reverseValueCompared;
        }
    }
}
/*
7
3 2 1 3 2 1 4
3
=1 2 3

6
1 1 1 2 2 3
1
=1

 */