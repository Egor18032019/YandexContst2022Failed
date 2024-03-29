import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ozon_G_Friends {
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
//        System.out.println(storage);
        for (int i = 1; i <= n; i++) {
            List<Integer> friends = storage.getOrDefault(i, new ArrayList<>(1));

            if (friends.size() == 0) {
                System.out.println(0);
                continue;
            }
            Map<Integer, Integer> possibleFriends = new TreeMap<>();
            for (int key : friends) {
                // 3,2
                //2=[1, 4, 5], 3=[4, 1]
                List<Integer> foo = storage.getOrDefault(key, new ArrayList<>(1));  //2=[1, 4, 5] $$ null
                if (foo.size() == 0) {
                    System.out.println(0);
                    continue;
                }
                for (int bar : foo) {
                    if (bar == i) {
                        continue;
                    }
                    boolean himHaveInYouList = storage.get(i).contains(bar);
                    if (himHaveInYouList) {
                        continue;
                    }
                    possibleFriends.put(bar, possibleFriends.getOrDefault(bar, 0) + 1);
                }

            }
//            System.out.println(possibleFriends);
            int maxFriends = 0;
            if (possibleFriends.size() == 0) {
                System.out.println(0);
                continue;
            }
            boolean flag = true;
// сортирую по значение ..
            Map<Integer, Integer> result = new LinkedHashMap<>();
            possibleFriends.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed() )
                    .forEach(entry -> result.put(entry.getKey(), entry.getValue()));
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                int value = entry.getValue();
                int idPossibleFriend = entry.getKey();
                if (value >= maxFriends) {
                    maxFriends = value;
                    flag = false;
                    System.out.print(idPossibleFriend + " ");
                }

            }
            if (flag) {
                System.out.println(0);
            } else {
                System.out.println(" ");
            }
        }

    }
}
    /*
    Частичное решение по времени не успеваю
 Сделать две очереди ?
 или одну  ?
1. в очередь падают обекты Проц и при каждом падение обьекта  пересчитываються занятые мощностя
или
2. В одной очереди свободные процессоры во второй занятые.
падает задача
из первой очереди проц забирается и вставляется во вторую
и всё равно придется как в первом случаи пересчитывать занятые мощностя
TODO обдумать как можно по другому

     */