import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint_4_SubStringLengthMany {
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
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(reader.readLine());
        String mainString = stringTokenizer.nextToken();
        Map<String, Integer> storage = new HashMap<>();
        Map<String, Integer> position = new HashMap<>();
        for (int i = 0; i + n < mainString.length() - 1; i++) {
            String key = mainString.substring(i, n + i);
            int count = storage.getOrDefault(key, 0);
            if (count == 0) {
                position.put(key, i);
            }
            count++;
            storage.put(key, count);
// и с разу выводим если больше k раз
            if (count >= k) {
                System.out.print(position.get(key) + " ");

            }
        }

    }
}

/*
10 2
gggggooooogggggooooogggggssshaa
почему в задание ответ 0 5 ??
gggggooooogggggooooogggggssshaa
gggggooooo
0
gggggooooogggggooooogggggssshaa
 ggggooooog
            ggggooooog
1
gggggooooogggggooooogggggssshaa
  gggooooogg
            gggooooogg
2
gggggooooogggggooooogggggssshaa
   ggoooooggg
          ggoooooggg
3
gggggooooogggggooooogggggssshaa
    gooooogggg
              gooooogggg
4
gggggooooogggggooooogggggssshaa
     oooooggggg
5


3 4
allallallallallall

 */