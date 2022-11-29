import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sprint_2_G_StakMaxEffective {
    private static BufferedReader reader = null;
    public static int n;
    public static Node<Integer> storage;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
// тут именно за O(1) надо найити max element
    // в процессе раздумья принял решение что нужно решать через список

    static class Node<Integer> {
        public Integer value;
        public Integer currentMax;
        public Node<Integer> prev;

        public Node(Integer value, Integer currentMax, Node<Integer> prev) {
            this.value = value;
            this.currentMax = currentMax;
            this.prev = prev;
        }
    }

    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());


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
        if (storage == null) {
            storage = new Node<>(x, x, null);
        } else {
            Integer max = Math.max(x, storage.currentMax);
            Node<Integer> newNode = new Node<>(x, max, storage);
            storage = newNode;
        }
    }

    public static void pop() {
        if (storage == null) {
            System.out.println("error");
            return;
        }
        Node<Integer> prev = storage.prev;
        storage = prev;
    }

    public static void get_max() {
        if (storage == null) {
            System.out.println("None");
            return;
        }
        Integer max = storage.currentMax;
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

10
pop
pop
push 4
push -5
push 7
pop
pop
get_max
pop
get_max


 */