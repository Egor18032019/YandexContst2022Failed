import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_2_A_Monitoring {
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
        n = Integer.parseInt(tokenizer.nextToken()); //строки
        tokenizer = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(tokenizer.nextToken()); // столбцы

        String[][] arr = new String[m][n];
        Map<String, String> storage = new HashMap<>();
        for (int i = 0; i < n; i++) {

            String[] line = reader.readLine().split(" ");
            for (int s = 0; s < m; s++) {
                arr[s][i] = line[s];
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}


/*

4
3
1 2 3
0 2 6
7 4 1
2 7 0

      for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            String[] line = reader.readLine().split(" ");
            for (int s = 0; s < m; s++) {
                stringBuilder.append(s);
                stringBuilder.reverse();
                System.out.println(stringBuilder.toString());
                storage.put(stringBuilder.toString(), line[s]);
            }
        }
 */