import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeRun155 {
    private static BufferedReader reader = null;
    private static BufferedWriter writer = null;
    public static int N; //число
    public static int M; // число
    public static int Q; //и число

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");
        Map<String, Integer> storage = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String point = arr[i];
            if (storage.containsKey(point)) {
                storage.put(point, storage.get(point) + 1);
            } else {
                storage.put(point, 0);
            }
        }
        Collection<Integer> v = storage.values().stream().filter(
                        e -> e == 0
                ).
                collect(Collectors.toList());
        System.out.println(v.size());
    }
}
