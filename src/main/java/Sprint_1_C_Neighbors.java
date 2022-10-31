import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_1_C_Neighbors {
    private static BufferedReader reader = null;
    public static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(tokenizer.nextToken());
        String[][] arr = new String[n][m];
        Map<Integer, String> storage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String point = reader.readLine();
            storage.put(i, point);
        }
        int key = Integer.parseInt(reader.readLine());
        String[] value = storage.get(key).split(" ");
        int keyLines = Integer.parseInt(reader.readLine());
        String valueForUp = storage.get(key - 1);
        String up = "";
        if (valueForUp != null) {
            up = valueForUp.split(" ")[keyLines];
        }

        String valueForDown = storage.get(key + 1);
        String down = "";
        if (valueForDown != null) {
            down = valueForDown.split(" ")[keyLines];
        }
        int keyForLeft = keyLines - 1;
        String left = "";
        if (keyForLeft > 0) {
            left = value[keyForLeft];
        }
        int keyForRight = keyLines + 1;
        String right = "";
        if (keyForLeft < (value.length)) {
            right = value[keyForRight];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(right).append(up).append(left).append(down);
        System.out.println(stringBuilder.toString());

        /*
        что то типа этого надо сделать
        ArrayList<Integer> neighbours = new ArrayList<>();
    neighbours.add(left) и остальное
    потом сорт и показать
            Collections.sort(neighbours);
         */
    }
}
/*
4
3
1 2 3
0 2 6
7 4 1
2 7 0
3
0

4
3
1 2 3
0 2 6
7 4 1
2 7 0
0
0
 */