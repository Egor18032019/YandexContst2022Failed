import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class InterestingPari {
    static BufferedReader reader = null;
    public static int n;
    public static Map<Integer, Map<String, Integer>> storage;
    public static Map<String, int[]> storageSum;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        storage = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] line = reader.readLine().split("");
            storageSum = new HashMap<>();
            for (String word : line) {
                if (storageSum.containsKey(word)) {
                    int value = storageSum.get(word) + 1;
                    storageSum.put(word, value);
                } else {
                    storageSum.put(word, 1);
                }
            }
            storage.put(i, storageSum);
        }
        System.out.println(storageSum);
        System.out.println(storage);
        storageSum = null;
        // сложили всё в хрнилище
        /*
        Проходим циклами по хранилищу и сравниваем различия в ключах и в значение
         */
        int interesting = 0;
        for (int x = 1; x <= n; x++) {
            storageSum = storage.get(x);

            for (int z = 1; z <= n; z++) {
                if (z <= x) continue;
                Map<String, Integer> point = storage.get(z);
                /*
                Есть две мапы и мы должны их сравнивать до второго различия
                 */
                if (point.equals(storageSum)) continue;
//                boolean flag = true;
                boolean isInteresting = false;

                int intFlag = 0;
                for (Map.Entry<String, Integer> entry : storageSum.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();

                    if (point.containsKey(key)) {
                        Integer pointValue = point.get(key);
                        int diff = pointValue - value;

                        if (diff == 0) {

//                            flag = true;
                            continue;
                        } else {
                            if (diff == 1 || diff == -1) {
                                if (intFlag == 3) {
                                    intFlag = 4;
                                    break;
                                }
                                if (intFlag == 5) {
                                    intFlag = 4;
                                    break;
                                }
                                intFlag = 1;
                            } else {
                                intFlag = 4;
                            }
                        }
                        // 0 начало \ 1 стало интересно \ 3 было интересно \ 4 неинтересно \\ 5 не та буква
                    } else {
                        if (intFlag == 1) {
                            intFlag = 3;
                            continue;
                        }
                        if (intFlag == 5) {
                            intFlag = 4;
                            break;
                        }
                        intFlag = 5;


                    }
                }
                // и point всё хорошо ++
                if (intFlag == 1) interesting++;
                if (intFlag == 3) interesting++;
//                if (intFlag == 5) interesting++;
            }

            storage.remove(x);
        }
        System.out.println(interesting);
    }
}
/*
3
aaa
BBB
abb


 */