import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_4_D_Circles {
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

        Map<String, Integer> storage = new LinkedHashMap<>();
        //  LinkedMap  ?

        for (int i = 0; i < n; i++) {
            String stroke = reader.readLine();
            int count = storage.getOrDefault(stroke, 0);
            storage.put(stroke, count + 1);
        }
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
/*
8
Вы
Ри
На
На
Ку
Тя
ТА
ТА


 */