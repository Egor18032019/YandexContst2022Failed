import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YandexPlagiat {

    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String f1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        bufferedReader.close();
        char[] firstLine = f1.toCharArray();
        char[] secondLine = s2.toCharArray();
        int length = firstLine.length;
        String[] answer = new String[length];
        boolean[] secondBoolean = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (firstLine[i] == secondLine[i]) {
                answer[i] = "P";
                firstLine[i] = '*';
                secondBoolean[i] = true;
            }
        }

        for (int s = 0; s < length; s++) {

            if (!secondBoolean[s] ) {
                for (int f = 0; f < length; f++) {
                    if (firstLine[f] == '*') {
                        continue;
                    }
                    boolean isPresent =firstLine[f] == secondLine[s];
                    if (isPresent) {
                        answer[s] = "S";
                        firstLine[f] = '*';
                        break;
                    }
                }
            }
            if (answer[s] == null) {
                answer[s] = "I";
            }
            System.out.print(answer[s]);
        }
    }
}
