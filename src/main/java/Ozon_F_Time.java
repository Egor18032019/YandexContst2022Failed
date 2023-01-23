import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ozon_F_Time {
    private static BufferedReader reader = null;
    public static int t;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        t = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= t; i++) {
            String test = reader.readLine();
            n = Integer.parseInt(test);
//            System.out.println("n = " + n);
            List<Long> store = new ArrayList<>();
            Map<Long, Long> storage = new TreeMap<>();
            boolean isYes = true;
            for (int r = 1; r <= n; r++) {
                String[] timeLine = reader.readLine().split("-");
                if (!isYes) continue;
                String left = timeLine[0];
                String right = timeLine[1];

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date dateLeft = null;
                Date dateRight = null;
                try {
                    dateLeft = sdf.parse(left);
                } catch (ParseException e) {
                    System.out.println("NO");
                    isYes = false;
                }
                try {
                    dateRight = sdf.parse(right);
                } catch (ParseException e) {
                    System.out.println("NO");
                    isYes = false;

                }
                if (isYes) {
                    Long leftL = dateLeft.getTime();
                    Long righL = dateRight.getTime();
                    if (leftL <= righL) {
                        store.add(leftL);
                        storage.put(leftL, righL);
                    } else {
                        System.out.println("NO");
                        isYes = false;

                    }
                }
            }
            if (isYes) {
//                System.out.println("проверяем на пересечение");
                Collections.sort(store);

                boolean isCrossroad = crossroad(store, storage, i);
                if (isCrossroad) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

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
2
00:00:00-23:59:58
23:59:58-23:59:59

int sumForPay = 0;
            for (Map.Entry<Integer, Integer> entry : storage.entrySet()) {
                int price = entry.getKey();
                int count = entry.getValue();
                int o = count % 3;
                int kit = (count - o) / 3;
                sumForPay = sumForPay + ((2 * kit) + o) * price;
            }

         Map<Integer, Integer> result = new LinkedHashMap<>();
            storage.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue() )
                    .forEach(entry -> result.put(entry.getKey(), entry.getValue()));


 */