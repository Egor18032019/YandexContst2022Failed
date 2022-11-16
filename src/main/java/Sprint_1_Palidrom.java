import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_1_Palidrom {
    private static BufferedReader reader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String line = reader.readLine();
        // заменим пробелы и в один регистр
        char[] chars = line.toLowerCase().replaceAll("\\W", "").toCharArray();
        int length = chars.length - 1;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i]) {
                System.out.println("True");
                break;
            }
        }
        System.out.println("False");
    }
}
/*
 saippuakivikauppias

bavab
 */