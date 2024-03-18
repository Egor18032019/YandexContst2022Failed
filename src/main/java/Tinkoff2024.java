import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tinkoff2024 {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
//        String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
//        for (String po : numbers) {
//            System.out.println(Arrays.toString(po.getBytes()));
//        }

        String line = reader.readLine();

//        line = line.replaceAll("code", "????");
        int start = line.indexOf("code");

        for (int i = start; i < line.length(); i++) {
            String sub = line.substring(i);
            boolean startCode = sub.startsWith("code");
            if (startCode) {

                boolean isFirst = true;

                for (int z = 4; z < sub.length(); z++) {
                    char bar = sub.charAt(z);
                    if (bar > 47 && bar < 58) {
                        if (isFirst) {
                            sub = "???@" + sub.substring(4);
                            isFirst = false;
                        }


                        sub = sub.replace(bar, '@');

                    } else {
                        String left = line.substring(0,i);
                        line = left + sub;
                        i = i+z-1;
                        break;
                    }

                }
            }
        }
//        System.out.println(line);
        System.out.println(line.replaceAll("@", ""));

    }
//            String[] tokenizer = line.split("code");
//            for (int i = 0; i < tokenizer.length; i++) {
//                String point = tokenizer[i];
//                if (isNumber(point)) {
//                    String bar = replaceAll(point,0);
//                    tokenizer[i] = bar;
//                } else {
//                    String bar = replaceEach(point);
//                    tokenizer[i] = bar;
//                }
//            }
//            System.out.println(Arrays.toString(tokenizer));


    public static String replaceEach(String point) {
        for (int q = 0; q < point.length(); q++) {
            char foo = point.charAt(q);
            if (foo > 47 && foo < 58) {
                point = point.replace(foo, '?');
            } else {
                break;
            }
        }
        return point;
    }

    public static String replaceAll(String point, int start) {

        StringBuilder bar = new StringBuilder();
        for (int z = start; z < point.length(); z++) {
            bar.append("?");
        }
        return bar.toString();
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
