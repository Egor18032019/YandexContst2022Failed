import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EvenSub {
    private static Scanner reader = null;
    public static int n;
    public static int k;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new Scanner(System.in);
    }


    private static void run() throws IOException {
        n = reader.nextInt();
        k = reader.nextInt();
        int even = 0;
        Map<Integer, Boolean> all = new HashMap<>();
        Map<Integer, Integer> trash = new HashMap<>();
        int trashInt = 0;

        for (int i = 0; i < n; i++) {
            int iterable = reader.nextInt();
            if (iterable % 2 == 0) {
                even++;
                all.put(i, true);
                trashInt++;
                trash.put(i, trashInt);
            } else {
                trashInt++;
                trash.put(i, trashInt);
                all.put(i, false);

            }
        }

        reader.close();

        int maxCount = 0;
        for (int z = 0; z < n; z++) {
            int centerCount = 0;
            int centerK = k;

            int countTrash = trash.get(z);
            if (countTrash == z) continue;

            for (int i = z; i < n; i++) {
                boolean point = all.get(i);
                if (point) {
                    centerCount++;
                    if (centerCount == even) {
                        break;
                    }
                } else {
                    centerK = centerK - 1;
                    if (centerK >= 0) {
                        centerCount++;
                        if (centerCount == even) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
//            if (centerCount > maxCount) maxCount = centerCount;
//            maxCount = Math.max(centerCount, maxCount);
            maxCount = (maxCount > centerCount) ? maxCount : centerCount;
        }
        System.out.println(maxCount);

    }

}
/*
6 2
0 0 0 0 0 0

11 1
2 1 1 1 1 1 1 2 1 2 2

11 1
-2 1 1 1 1 2 1 -2 2 1 1

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