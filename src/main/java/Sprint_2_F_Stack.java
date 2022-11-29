import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sprint_2_F_Stack {
    private static BufferedReader reader = null;
    public static int n;
    public static Stack<Integer> stack;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());

        stack = new Stack<>();
        Map<Integer, String> storage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "get_max":
                    get_max();
                    break;
                case "push":
                    Integer number = Integer.valueOf(tokenizer.nextToken());
                    push(number);
                    break;
                case "pop":
                    pop();
                    break;
            }
        }
    }

    public static void push(Integer x) {
        stack.push(x);
    }

    public static void pop() {
        if (stack.size() == 0) {
            System.out.println("error");
            return;
        }
        stack.pop();
    }

    public static void get_max() {
        if (stack.size() == 0) {
            System.out.println("None");
            return;
        }
        Integer max = stack.get(0);
        for (int i = 1; i < stack.size() - 1; i++) {
            Integer current = stack.get(i);
            if (current > max) max = current;
        }
        System.out.println(max);
    }
}
/*
8
get_max
push 7
pop
push -2
push -1
pop
get_max
get_max


 */