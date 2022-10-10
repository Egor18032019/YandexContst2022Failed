import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        for (String it : second) {
            Integer item = Integer.valueOf(it);
            if (item == 0) {
                all.add(true);
                even.add(item);
            } else {
                if (item % 2 == 0) {
                    even.add(item);
                    all.add(true);
                } else {
                    odd.add(item);
                    all.add(false);
                }
            }
        }
        /*
11 1
2 1 1 2 1 1 1 1 2 1 1
11 8 3 3 =>2
         */
        if (even.size() == n) {
            System.out.println(even.size());
            return;
        }
        if (odd.size() == n) {
            System.out.println(0);
            return;
        }
        /*
5 1
-1 2 4 3 0
5 2 3 1 =>3
         */
        int bar = even.size() - k;

//        if (bar <= 1) {
//            System.out.println(even.size());
//        } else {
//            if ((n - even.size() - k) <= 1) {
//                System.out.println(even.size());
//            } else {
//                System.out.println(even.size() - k);
//            }
//        }

        if ((even.size() - odd.size()) <= k) {
            System.out.println(even.size());
        } else {
            int count = 0;
            for (boolean point : all) {
                if (point) {
                    count++;
                    continue;
                } else {
                    k = k - 1;
                    count++;
                    if (k <= 0) {
                        break;
                    }
                }
            }
            System.out.println(count);
            return;
        }
    }
}
/*
6 2
0 0 0 0 0 0


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
 */