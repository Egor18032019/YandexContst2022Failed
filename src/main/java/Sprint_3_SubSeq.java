import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_3_SubSeq {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String s = reader.readLine();
        String t = reader.readLine();
        boolean result = true;
        int indexS = 0;
        int indexT = 0;
        while (result) {
            // abc
            // ahbgdcu
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++; // если знак равен то переходим к следующему
                if (indexS >= s.length()) { // проверка на длину
                    break;
                }
            }
            indexT++;
            if (indexT >= t.length()) {
                result = false;
                break;
            }
        }
        System.out.println(result);

    }
}
/*
abc
ahbgdcu

abcp
ahpc
 */