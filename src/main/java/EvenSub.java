import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenSub {
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
        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        k = Integer.parseInt(firstLine[1]);
        String[] second = reader.readLine().split(" ");
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Boolean> all = new ArrayList<>();
        Map<Integer, Integer> maxOddIndex = new HashMap<>();
// key = index  value= количество
        boolean isSec = false;
        int index = -1;
        for (int x = 0; x < second.length; x++) {
            String it = second[x];
            Integer item = Integer.valueOf(it);
            if (item == 0) {
                all.add(true);
                even.add(item);
                if (!isSec) {
                    index = x;
                    isSec = true;
                    maxOddIndex.put(index, 1);
                } else {
                    int value = maxOddIndex.get(index) + 1;
                    maxOddIndex.put(index, value);
                }
            } else {
                if (item % 2 == 0) {
                    even.add(item);
                    all.add(true);
                    if (!isSec) {
                        index = x;
                        isSec = true;
                        maxOddIndex.put(index, 1);
                    } else {
                        int value = maxOddIndex.get(index) + 1;
                        maxOddIndex.put(index, value);
                    }
                } else {
                    odd.add(item);
                    all.add(false);
                    isSec = false;
                }
            }
        }

        if (even.size() == n) {
            System.out.println(even.size());
            return;
        }
        if (odd.size() == n) {
            System.out.println(0);
            return;
        }
        int maxIndex = maxOddIndex.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        if ((odd.size() - even.size()) <= k) {
            System.out.println(even.size());
        } else {

            int maxCount = 0;
            for (int z = 0; z < n; z++) {

                int preMaxCount = giveMeMax(z, even, all);

                if (preMaxCount > maxCount) maxCount = preMaxCount;
            }

            System.out.println(maxCount);
            return;
        }
    }

    public static int giveMeMax(int left, List<Integer> even, List<Boolean> all) {
        int centerCount = 0;
        int centerK = k;
        for (int i = left; i < all.size(); i++) {
            boolean point = all.get(i);
            if (point) {
                centerCount++;
                if (centerCount >= even.size()) {
                    break;
                }
            } else {
                centerK = centerK - 1;
                if (centerK >= 0) {
                    centerCount++;
                    if (centerCount >= even.size()) {
                        break;
                    }
                } else {
                    break;
                }

            }


        }


        return centerCount;
    }
}
/*
6 2
0 0 0 0 0 0

11 1
2 1 1 1 1 1 1 2 1 2 2

11 1
2 1 1 1 1 2 1 2 2 1 1

20 2
2 1 1 1 2 1 2 2 1 2 1 1 1 1 1 1 1 1 1 2


6 2
1 1 1 1 1 1

7 2
1 2 1 2 1 1 1
7 5 2 2 =>2

6 2
1 2 1 2 1 1
6 4 2 2 =>2

6 2
1 2 1 2 1 2   2 1 1 1 2 2
6 3 3 2 =>3


11 1
2 1 1 2 1 1 1 1 2 1 1
11 8 3 1 =>2

11 1
2 2 1 2 1 1 1 1 1 1 1
11 8 3 1 =>3

11 2
2 1 1 2 1 1 1 1 2 1 1
11 8 3 3 =>3

11 1
1 1 1 2 2 1 2 1 1 1 1
 */