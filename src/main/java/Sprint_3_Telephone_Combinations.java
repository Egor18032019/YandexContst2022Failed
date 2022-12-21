import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_3_Telephone_Combinations {
    public static char[] two = new char[]{'a', 'b', 'c'};
    public static char[] three = new char[]{'d', 'e', 'f'};
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        char[] foo = null;
        char[] bar = null;
        while (stringTokenizer.hasMoreTokens()) {
            switch (stringTokenizer.nextToken()) {
                case ("2"):
                    if (foo == null) {
                        foo = two;
                    } else {
                        bar = two;
                    }
                    break;
                case ("3"):
                    if (foo == null) {
                        foo = three;
                    } else {
                        bar = three;
                    }
                    break;
                default:
                    foo = new char[3];
                    bar = new char[3];

            }
        }
        generator(foo, bar, 0, 0);
    }

    public static void generator(char[] foo, char[] bar, int open, int close) {
        if (open > 2) return;
        System.out.println(foo[open] + "" + bar[close]);
        if (close < 2) {
            generator(foo, bar, open, close + 1);
        } else {
            generator(foo, bar, open + 1, 0);
        }
    }
}

/*
0 0
0 1
0 2
1 0
1 1
1 2
2 0
2 1
2 2

 */