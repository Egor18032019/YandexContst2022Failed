import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_3_G_Cloakroom {
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
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        Map<String, Integer> sortedRoom = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = stringTokenizer.nextToken();
            sortedRoom.put(key, sortedRoom.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < sortedRoom.getOrDefault("0", 0); i++) {
            System.out.print("0");
            System.out.print(" ");
        }
        for (int i = 0; i < sortedRoom.getOrDefault("1", 0); i++) {
            System.out.print("1");
            System.out.print(" ");
        }
        for (int i = 0; i < sortedRoom.getOrDefault("2", 0); i++) {
            System.out.print("2");
            System.out.print(" ");
        }
    }
}
/*
можно сделать еще 3 листа и в них складывать
7
0 2 1 2 0 0 1

5
2 1 2 0 1

5
2 1 2 2 1
 */