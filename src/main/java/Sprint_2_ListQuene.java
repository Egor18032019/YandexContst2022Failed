import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_2_ListQuene {
    private static BufferedReader reader = null;
    private static int n;
    private static Node<Integer> head;
    private static Node<Integer> tail;
    private static int sizeQuene = 0;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    static class Node<Integer> {
        public Node<Integer> next;
        public int value;

        public Node(Node<Integer> next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "get":
                    get();
                    break;
                case "put":
                    int number = Integer.parseInt(tokenizer.nextToken());
                    put(number);
                    break;
                case "size":
                    size();
                    break;
            }
        }


    }

    public static void put(int number) {
        sizeQuene++;
        if (head == null) {
            Node<Integer> current = new Node<>(null, number);
            tail = current;
            head = current;
        } else {
            Node<Integer> newNode = new Node<>(null, number);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void get() {
        if (head == null) {
            System.out.println("error");
            return;
        }
        sizeQuene--;
        System.out.println(head.value);
        head = head.next;
    }

    public static void size() {
        System.out.println(sizeQuene);
    }
}
/*
10
put -34
put -23
get
size
get
size
get
get
put 80
size

 */