import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_2_I_SizedQueue {
    private static BufferedReader reader = null;
    public static int commands;
    private static int currentSize = 0;
    private static int maxSize;
    private static int currentIndex;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        commands = Integer.parseInt(tokenizer.nextToken()); // 8
        tokenizer = new StringTokenizer(reader.readLine());
        maxSize = Integer.parseInt(tokenizer.nextToken()); // 2
        arr = new int[maxSize];
        currentIndex = 0;
        for (int i = 0; i < commands; i++) {

            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "peek":
                    peek();
                    break;
                case "push":
                    int number = Integer.parseInt(tokenizer.nextToken());
                    push(number);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
            }
        }
    }

    public static void push(int x) {
        if (currentSize == maxSize) {
            System.out.println("error");
            return;
        }
        arr[currentIndex] = x;
        currentIndex++;
        currentSize++;
    }

    public static void pop() {
        if (currentSize== 0) {
            System.out.println("error");
            return;
        }
        int deleteNumber = arr[currentIndex];
        arr[currentIndex] = 0;
        currentIndex--;
        System.out.println(deleteNumber);
        currentSize--;
    }

    public static void peek() {
        if (currentSize == 0) {
            System.out.println("None");
            return;
        }
        int fist = arr[0];
        System.out.println(fist);
    }

    public static void size() {
        System.out.println(currentSize);
    }
}
/*
8
2
peek
push 5
push 2
peek
size
size
push 1
size

 */