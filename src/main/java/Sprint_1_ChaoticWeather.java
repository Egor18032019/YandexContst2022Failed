import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_1_ChaoticWeather {
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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        Map<Integer, Integer> storage = new HashMap<>();
        Map<Integer, Integer> storageForBiggest = new HashMap<>();
        List<Integer> answerList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(tokenizer.nextToken());
            if (i == 0) {
                storage.put(i, temp);
                answerList.add(temp);
                continue;
            }
            storage.put(i, temp);
            int key = i - 1;

            int prev = storage.get((key));

            if (temp > prev && !answerList.isEmpty()) {

                storageForBiggest.put(i, temp);
                if (!storageForBiggest.containsKey(key)) {
                    answerList.remove(answerList.size() - 1);
                }
                answerList.add(temp);
            } else {
                storageForBiggest.remove(i);
            }
        }
        System.out.println(answerList.size());
    }
}
/*
7
-1 -10 -8 0 2 0 5

5
1 2 5 4 8
 */