import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class YandexSprintDraft {
    private static BufferedReader reader = null;
    public static int n; // количество пользователей
    public static int m; //  количество пар друзей

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
        m = Integer.parseInt(stringTokenizer.nextToken());
        Map<Integer, List<Integer>> storage = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String[] friends = reader.readLine().split(" ");
            int x = Integer.parseInt(friends[0]);
            int y = Integer.parseInt(friends[1]);
            if (storage.containsKey(x)) {
                storage.get(x).add(y);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(y);
                storage.put(x, value);
            }
            if (storage.containsKey(y)) {
                storage.get(y).add(x);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(x);
                storage.put(y, value);
            }
        }
        System.out.println(storage);
        for (int i = 1; i <= n; i++) {

        }
    }

    public static boolean crossroad(List<Long> store, Map<Long, Long> storage, int z) {


        for (int i = 0; i < n - 1; i++) {
            Long keyRight = storage.get(store.get(i));  //    23:59:58
            Long valueLeft = store.get(i + 1); //       23:59:58
//            if (z == 3) {
//                System.out.println("compareTo");
//                System.out.println(keyRight.compareTo(valueLeft));
//            }
//            if (keyRight >= valueLeft) return false;
            if (keyRight.compareTo(valueLeft) >= 0) return false;
        }
        return true;
    }

}
/*
8 6

4 3
3 1
1 2
2 4
2 5

6 8



4 => 1 => 5,
3 => 2 => 3,
2 => 3 => 2,
1 => 4 = 1
1 => 5 = 1 ??? не понятно не тут не с 1
0 =>6  = 0
0 0
0 0
У каждого пользователя этой сети не более 5 друзей
y не является другом x и не совпадает с x
;
у пользователя y
и у пользователя x
есть хотя бы один общий друг;

не существует такого пользователя y′
, который удовлетворяет первым двум ограничениям,
и у которого строго больше общих друзей с x, чем у y с x.
8 10

3 2
2 4
1 2
1 3
1 4
1 8
4 3
5 6
7 6
5 7

0  2
8
8
8
0
0
0
2 3 4



 */