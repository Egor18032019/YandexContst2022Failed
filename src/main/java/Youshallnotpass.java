import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Youshallnotpass {
    private static BufferedReader reader = null;
    public static int N; //количество  в секунду
    public static int K; // записей лога запроса


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        K = Integer.parseInt(firstLine[1]);
// 2147483647
        Map<String, Long> storage = new HashMap<>();
        Map<String, Long> nextTimeStorage = new HashMap<>();
        Map<String, Integer> countStorage = new HashMap<>();
        for (int i = 0; i < K; i++) {
            String line = reader.readLine();
            String[] arr = line.split(" ");
            // 1676217286000 AYjcyMzY3ZDhiNmJkNTY
            Long value = Long.parseLong(arr[0]);
            //1676217286000
            String key = arr[1]; //AYjcyMzY3ZDhiNmJkNTY
            if (!storage.containsKey(key)) {
                storage.put(key, value);
                nextTimeStorage.put(key, value + 1000);
                countStorage.put(key, N - 1);
                System.out.println(line);
            } else {
                if (value.compareTo(nextTimeStorage.get(key)) >= 0) {
                    nextTimeStorage.put(key, value + 1000);
                    countStorage.put(key, N - 1);
                    System.out.println(line);
                } else {
                    int count = countStorage.get(key);
                    if (count != 0) {
                        countStorage.put(key, countStorage.get(key) - 1);
                        System.out.println(line);
                    }
                }
            }
        }

    }
}
/*
Пример 1
Ввод
1 1
1679981968781 0fdc847ecc495d6dd584
Вывод
1679981968781 0fdc847ecc495d6dd584
Пример 2
Ввод
2 4
1679982033000 441079aa62dc3cd57df3
1679982033998 441079aa62dc3cd57df3
1679982033999 441079aa62dc3cd57df3
1679982034000 441079aa62dc3cd57df3
Вывод
1679982033000 441079aa62dc3cd57df3
1679982033998 441079aa62dc3cd57df3
1679982034000 441079aa62dc3cd57df3
 */