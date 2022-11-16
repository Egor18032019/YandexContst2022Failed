import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_2_Polsk_Calculate {
    private static BufferedReader reader = null;
    public static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        // 2 1 + 3 *

        String[] line = reader.readLine().split(" ");
        System.out.println(Arrays.toString(line));
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < line.length; i++) {
            String command = line[i];

            switch (command) {
                case "+":
                    Integer fist = deque.removeFirst();
                    Integer second = deque.removeFirst();
                    Integer foo = second + fist;
                    deque.addFirst(foo);
                    break;
                case "-":
                    Integer fistM = deque.removeFirst();
                    Integer secondM = deque.removeFirst();
                    Integer fooM = secondM - fistM;
                    deque.addFirst(fooM);
                    // 10 8 -
                    break;
                case "*":
                    Integer fistU = deque.removeFirst();
                    Integer secondU = deque.removeFirst();
                    Integer fooU = fistU * secondU;
                    deque.addFirst(fooU);
                    break;
                case "/":
                    Integer fistD = deque.removeFirst();
                    Integer secondD = deque.removeFirst();
                    Integer fooD = secondD / fistD;
                    deque.addFirst(fooD);
                    break;
                default:
                    deque.addFirst(Integer.valueOf(command));
            }
        }
        System.out.println(deque.getFirst());
    }
}
/*
10 2 4 * -  /2
2 1 + 3 *   /9
7 2 + 4 * 2 + /38
 */