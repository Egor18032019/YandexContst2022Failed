import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_1_TheMostLongStrgin {

    private static BufferedReader reader = null;
    public static int L;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        L = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int maxLength = 0;
        String longestWord = "";
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }
            System.out.println(longestWord);
            System.out.println(maxLength);

    }
}

/*
10
десять слов

 */