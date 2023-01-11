import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_4_E_SubStrokeArray {
    static final int NO_OF_CHARS = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();

        int n = string.length();
        int cur_len = 1;
        int max_len = 1;
        int prev_index;
        int i;
        int[] visited = new int[NO_OF_CHARS];

        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        visited[string.charAt(0)] = 0;
/*
Заполняем массив -1 и потом циклом бежим по массиву
 */
        for (i = 1; i < n; i++) {
            char foo = string.charAt(i);
            prev_index = visited[foo];
            if (prev_index == -1) {
                cur_len++;
            } else {
                if (cur_len > max_len) {
                    max_len = cur_len;
                }

            }
            visited[foo] = i;
        }

        if (cur_len > max_len) {
            max_len = cur_len;
        }

        System.out.println(max_len);
    }
}
