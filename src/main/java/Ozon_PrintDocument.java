import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ozon_PrintDocument {
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
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        t = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(reader.readLine());
            stringTokenizer = new StringTokenizer(reader.readLine(), ","); // 1 7 1
            int[] arr = new int[n];
            for (int q = 0; q < n; q++) {
                arr[q] = q + 1;
            }
            Set<Integer> save = new HashSet<>();
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                if (token.contains("-")) {
                    String f = token.substring(0, token.indexOf("-"));
                    String s = token.substring(token.indexOf("-") + 1, token.length());
                    int first = Integer.parseInt(f);
                    int second = Integer.parseInt(s);
                    save.add(first);
                    save.add(second);
                    for (int z = first - 1; z <= second - 1; z++) {
                        arr[z] = 0;
                    }

                } else {
                    int bar = Integer.parseInt(token);
                    arr[bar - 1] = 0;
                    save.add(bar);

                }
            }
            System.out.println(save.toString());
//            [7] c 7 до n  и с 0 до 7
//            [1, 7] с 1 до 7 и 7 до n
//            [1, 5, 7]
            for (Integer s : save) {
                giveMePages(arr, s);
            }


        }
    }

    public static void giveMePages(int[] arr, int number) {
        System.out.println("number " + number);
// [0, 2, 3, 4, 5, 6, 0, 8]
        //[0, 0, 0, 0, 0, 6, 0, 8]

        StringBuilder stringBuilder = new StringBuilder();
        boolean isOpen = false;
        for (int q = number; q < n; q++) {
            boolean open = false;
            boolean flag = false;
            int page = arr[q];
            if (page == 0) {
                if (!open) {
                    continue;
                } else {
                    stringBuilder.append("-")
                            .append(arr[q - 1]);
                    open = false;
                }
            } else {
                if (!open) {
                    if (!flag) {
                        stringBuilder.append(page);
                        isOpen = true;
                        open = true;
                        flag = true;
                    } else {
                        stringBuilder.append(",")
                                .append(page);
                        open = true;
                    }
                } else {
                    continue;
                }
            }


        }
        if (number==1){
            System.out.println();
        }
        for (int q = 0; q < number; q++) {
            boolean open = false;
            boolean flag = false;
            int page = arr[q];
            if (page == 0) {
                if (!open) {
                    continue;
                } else {
                    stringBuilder.append("-")
                            .append(arr[q - 1]);
                    open = false;
                }
            } else {
                if (!open) {
                    if (!flag) {
                        stringBuilder.append(page);
                        open = true;
                        flag = true;
                    } else {
                        stringBuilder.append(",")
                                .append(page);
                        open = true;
                    }
                } else {
                    if (isOpen) {
                        stringBuilder.append(",")
                                .append(page);
                        isOpen = false;
                    }


                }
            }


        }
        System.out.println(stringBuilder.toString());
    }
}
