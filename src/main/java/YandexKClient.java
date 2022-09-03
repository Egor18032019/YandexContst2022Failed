//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class YandexKClient {
//    private static BufferedReader bufferedReader = null;
//
//
//    public static void main(String[] args) throws Exception {
//        init();
//        run();
//
//    }
//
//    private static void init() {
//        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    private static void run() throws IOException {
//        String firstLine = bufferedReader.readLine();
//        int zapiciInLog = Integer.parseInt(firstLine);
//        Map<String[], String[]> map = new HashMap<>();
//        Map<Integer, String[]> slovar = new HashMap<>();
//        Map<Integer, Integer> rakets = new HashMap<>();
//
//        for (int i = 0; i < zapiciInLog; i++) {
//            String[] line = bufferedReader.readLine().split(" ");
//            String[] key = new String[3];
//            key[0] = line[0];
//            key[1] = line[1];
//            key[2] = line[2];
//            String[] value = new String[2];
//            value[0] = line[3];
//            value[1] = line[4];
//            map.put(key, value);
//            Integer keyForSlovar = Integer.parseInt(line[0]) * 1000 + Integer.parseInt(line[1]) * 100 + Integer.parseInt(line[2]);
//            slovar.put(keyForSlovar, key);
//        }
//// отсортировать slovar  по ключу
//        // считаем время  берем значение со словаря и с него тащим значние с map
//        // проверяем букву
//        // сумируем и складываем в rakets
//        // выводим
//
//
//    }
//
//}
//}
