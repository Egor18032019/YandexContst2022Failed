import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tinkoff1 {
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
        int currentSizeColor = n;
        String[] tokenizer = reader.readLine().split(" ");
        String color = reader.readLine();
        int uglyWord = 0;
        for (int i = 0; i < tokenizer.length ; i++) {
            String currentWord = tokenizer[i];
            int lengthCurrentWord = currentWord.length() - 1;
            int start = n - currentSizeColor; // 9
            int finish = start + lengthCurrentWord;
            String colorForCurrenWord = color.substring(start, finish);
            currentSizeColor = currentSizeColor - lengthCurrentWord;

            if (!isBeat(colorForCurrenWord)) {
                uglyWord++;
            }
        }
        System.out.println(uglyWord);
    }

    private static boolean isBeat(String colorString) {
        for (int i = 0; i < colorString.length() - 1; i++) {
            // BB
            // YY
            if (colorString.charAt(i) == 'B') {
                if (colorString.charAt(i + 1) == 'B') return false;
            } else {
                if (colorString.charAt(i + 1) == 'Y') return false;
            }
        }

        return true;
    }
}