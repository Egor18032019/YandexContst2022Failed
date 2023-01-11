import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Sprint_4_E_SubStroke {
    private static BufferedReader reader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String stroke = reader.readLine();
        int length = stroke.length() - 1;
        int bigLengthUnicStroke = 0;
        for (int i = 0; i < length; i++) {
            int count = 1;
            char foo = stroke.charAt(i);
            Set<Character> storage = new HashSet<>();
            storage.add(foo);
            for (int q = i + 1; q < length; q++) {
                char bar = stroke.charAt(q);
                if (storage.add(bar)) {
                    count++;
                } else {
                    if (count > bigLengthUnicStroke) bigLengthUnicStroke = count;
                    break;
                }
            }
        }
        System.out.println(bigLengthUnicStroke);
    }
}
/*
abcabcbb

bbbbb

bbbbba
 */