import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ozon_CarNumbers {
    private static BufferedReader reader = null;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
//           R48FAO00OOO0OOA99OKA99OK
//            char[] arr = reader.readLine().toCharArray();
            String line = reader.readLine();
            List<String> answer = new ArrayList<>();
            int begin = 0;
            boolean flag = true;
            while (begin < line.length()) {
//                if (begin == 10) {
//
//                    System.out.println(begin);
//                }
                StringBuilder sb = new StringBuilder(5);
                String f = line.substring(begin, begin + 1);
                char first = f.charAt(0);
                if (first > 64 && first < 91) {
                    sb.append(f);
                } else {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                begin++;
                if (begin > line.length() - 1) {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                String s = line.substring(begin, begin + 1);
                char second = s.charAt(0);
                if (second > 47 && second < 58) {
                    sb.append(s);
                } else {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                begin++;
                if (begin > line.length() - 1) {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                String t = line.substring(begin, begin + 1);
                char three = t.charAt(0);
                if (three > 47 && three < 58) {
                    sb.append(t);
                } else if (three > 64 && three < 91) {
                    sb.append(t);
                    begin++;
                    if (begin > line.length() - 1) {
                        System.out.println("-");
                        flag = false;
                        break;
                    }
                    String fo2 = line.substring(begin, begin + 1);
                    char four2 = fo2.charAt(0);
                    if (four2 > 64 && four2 < 91) {
                        sb.append(fo2);
                        answer.add(sb.toString());
                        begin++;
                        continue;
                    } else {
                        System.out.println("-");
                        flag = false;
                        break;
                    }
                } else {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                begin++;
                if (begin > line.length() - 1) {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                String fo = line.substring(begin, begin + 1);
                char four = fo.charAt(0);
                if (four > 64 && four < 91) {
                    sb.append(fo);
                } else {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                begin++;
                if (begin > line.length() - 1) {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                String fif = line.substring(begin, begin + 1);
                char fife = fif.charAt(0);
                if (fife > 64 && fife < 91) {
                    sb.append(fif);
                } else {
                    System.out.println("-");
                    flag = false;
                    break;
                }
                answer.add(sb.toString());
//                System.out.print(sb);
                begin++;
            }
            if (flag) {
                for (String point : answer) {
                    System.out.print(point + " ");
                }
                System.out.println();
            }
        }
    }
}
/*
 буква-цифра-цифра  -буква-буква (примеры корректных номеров первого вида: R48FA, O00OO, A99OK);
 буква-цифра- буква-буква (примеры корректных номеров второго вида: T7RR, A9PQ, O0OO).
 */