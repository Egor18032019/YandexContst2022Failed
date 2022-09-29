import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LettersForHashMap {
    public static final String CORRECT = "correct";
    public static final String PRESENT = "present";
    public static final String ABSENT = "absent";

    // O(n)
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s = reader.readLine().toCharArray();
        char[] q = reader.readLine().toCharArray();

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (q[i] != s[i]) {
                charMap.merge(s[i], 1, Integer::sum);
                // сложили то чему не равно
            }
        }

        for (int i = 0; i < q.length; i++) {
            if (q[i] == s[i]){
                System.out.println(CORRECT);
            } else {
                Integer count = charMap.get(q[i]);
                if (count != null && count > 0) {
                    System.out.println(PRESENT);
                    charMap.merge(q[i], -1, Integer::sum);
                } else {
                    System.out.println(ABSENT);
                }
            }
        }
    }
}
