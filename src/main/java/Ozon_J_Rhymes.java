import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// не смог правильно понять задание
public class Ozon_J_Rhymes {
    private static BufferedReader reader = null;
    public static int n; // размер словаря
    public static int q; // количество запросов.

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());
        String[] storage = new String[n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            storage[i] = line;
        }
        q = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= q; i++) {
            String line = reader.readLine();
//            if (i == 3) {
//                System.out.println("");
//            /*
//            void
//            id
//             */
//            }
            int length = 0;
            String answer = "";
            for (int q = 0; q < n; q++) {
                String foo = storage[q];
                if (foo.equals(line)) continue;
                String bar = LCS(line, foo);
                int barLength = bar.length();
                if (barLength > length) {
                    length = barLength;
                    answer = foo;
                } else if (barLength == length) {
//                    if (barLength == foo.length()) {
//                        answer = foo;
//                    }
//                    System.out.println(foo.indexOf(bar));
//                    System.out.println(answer.indexOf(bar));
                    if (foo.indexOf(bar) < answer.indexOf(bar)) {
                        answer = foo;
                    }
                }
            }
            System.out.println(answer);
        }
//        System.out.println(LCS("task", "flask"));
//        System.out.println(LCS("task", "decide"));
//        System.out.println(LCS("task", "id"));
    }

    public static String LCS(String X, String Y) {
        int maxlen = 0;         // сохраняет максимальную длину LCS
        int m = X.length();
        int n = Y.length();
        int endingIndex = m;    // сохраняет конечный индекс LCS в `X`
        // `lookup[i][j]` сохраняет длину LCS подстроки
        // `Х[0…i-1]`, `Y[0…j-1]`
        int[][] lookup = new int[m + 1][n + 1];

        // заполняем интерполяционную таблицу снизу вверх
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // если текущий символ `X` и `Y` совпадают
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;

                    // обновляем максимальную длину и конечный индекс
                    if (lookup[i][j] > maxlen) {
                        maxlen = lookup[i][j];
                        endingIndex = i;
                    }
                }
            }
        }

        // вернуть самую длинную общую подстроку, имеющую длину `maxlen`
        return X.substring(endingIndex - maxlen, endingIndex);
    }
}
