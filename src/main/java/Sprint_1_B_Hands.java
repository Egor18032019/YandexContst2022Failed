import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sprint_1_B_Hands {
    private static BufferedReader reader = null;
    public static int k;
    private static final int n = 4;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("");
            for (int z = 0; z < n; z++) {
                String token = line[z];
                if (token.equals(".")) {
                    continue;
                } else {
                    Integer key = Integer.valueOf(token);
                    if (storage.containsKey(key)) {
                        int value = storage.get(key);
                        storage.put(key, value + 1);
                    } else {
                        storage.put(key, 1);
                    }
                }
            }
        }
        int score = 0;
        int hands = k * 2;
        for (Map.Entry<Integer, Integer> entry : storage.entrySet()) {
            int iterator = entry.getValue();
            if (iterator <= hands) {
                score++;
            }
        }



        System.out.println(score);
    }
}
/*
3
1231
2..2
2..2
2..2

4
1111
9999
1111
9911

4
1111
1111
1111
1111

 */