import java.io.*;
import java.util.StringTokenizer;


public class HammingDistNew {
    public static void main(final String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = inputReader.nextInt();
        int q = inputReader.nextInt();

        for (int i = 0; i < q; ++i) {
            StringBuilder t = new StringBuilder();

            String s = inputReader.next();
            String d = inputReader.next();

            boolean flag = true;

            for (int j = 0; j < n; ++j) {
                if (s.charAt(j) == d.charAt(j)) {
                    t.append(s.charAt(j));
                } else {
                    if (flag) {
                        t.append(s.charAt(j));
                    } else {
                        t.append(d.charAt(j));
                    }

                    flag ^= true;
                }
            }

            printWriter.println(t);
        }

        printWriter.close();
    }

    public static class InputReader {
        public final BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public final String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        @SuppressWarnings("unused")
        public final int nextInt() {
            return Integer.parseInt(next());
        }

        @SuppressWarnings("unused")
        public final long nextLong() {
            return Long.parseLong(next());
        }
    }
}

