import java.io.*;

public class GeneratingBracket {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void close() throws IOException {
        bufferedReader.close();
    }

    private static int readLine() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
/*
заметка

10 6
5 7 4 7 8 7

 */

    private static void run() throws IOException {
        int n = readLine() * 2;
        if (n < 2) return;
        char[] chrs = new char[n];
        for (int i = 0; i < n / 2; i++) {
            chrs[i] = '(';
        }
        // (() )
        for (int i = n / 2; i < n; i++) {
            chrs[i] = ')';
        }

        System.out.println(chrs);
        do {
            int i = n - 1; //3
            int c = 0;

            while (i >= 0) {
                // что тут з херня ?
                boolean bar = chrs[i] == ')';
                int x = bar ? -1 : 1;
                c = c + x;
//                c += bar ? -1 : 1;
                boolean isBreak = (c < 0) && (chrs[i] == '(');
                if (isBreak) break;
                --i;
            }
            // в итоге
            // i c какого начинается ((
            if (i < 0) break;

            chrs[i] = ')';
            i++;
            int ind = i;
            for (; i < n; i++) {
                boolean foo = (i <= (n - ind + c) / 2 + ind);
                chrs[i] = foo ? '(' : ')';
            }
            System.out.println(chrs);
        } while (true);
    }
}
