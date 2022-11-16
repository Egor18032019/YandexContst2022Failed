import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_2_A_DEK {

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

    public static class DEK {
        private String[] storage;
        private int maxSize;
        private int back;
        private int front;
        private int size;

        public DEK(int maxSize) {
            this.maxSize = maxSize;
            this.storage = new String[maxSize];
            if (maxSize % 2 == 0) {
                front = maxSize / 2 - 1; // 0 1 2
                back = front + 1; // 2 3
            } else {
                front = maxSize / 2; // 0 1 2
                back = front + 1; // 3 4
            }
        }

        public void push_back(String value) {

            if (maxSize > size) {
                if (size == 0) {
                    this.storage[back] = value;
                    front = back;
                } else {
                    this.back++;
                    this.storage[back] = value;
                }
                size++;
            } else {
                System.out.println("Error");
            }
        }

        public void push_front(String value) {

            if (maxSize > size) {
                if (size == 0) {
                    back = front;
                    this.storage[front] = value;
                } else {
                    this.front--; // когда <0
                    this.storage[front] = value;
                }
                size++;
            } else {
                System.out.println("Error");
            }
        }

        public String pop_back() {
            String answer = this.storage[back];
            if (answer.isEmpty() || size == 0) {
                System.out.println("Error");
            } else {

                this.storage[back] = "";
                size--;
                back--;

                System.out.println(answer);
            }
            return answer;
        }

        public String pop_front() {

            String answer = this.storage[front];
            if (answer.isEmpty() || size == 0) {
                System.out.println("Error");
            } else {

                this.storage[front] = "";
                size--;
                front++;
                System.out.println(answer);
            }
            return answer;
        }
    }

    private static void run() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken()); // команды
        tokenizer = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(tokenizer.nextToken()); //емкость

        DEK dek = new DEK(m);

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
             switch (command) {
                case "push_front":
                    dek.push_front(tokenizer.nextToken());
                    break;
                case "push_back":
                    dek.push_back(tokenizer.nextToken());
                    break;
                case "pop_back":
                    dek.pop_back();
                    break;
                case "pop_front":
                    dek.pop_front();
                    break;
            }

        }
    }
}
/*
4
4
push_front 861
push_front -819
pop_back
pop_back



4
4
push_back 861
pop_front
push_front -819
pop_back


9
9
push_front -1
pop_front
push_front -2
push_back 861
push_back 11
push_front -3
pop_back
pop_back
pop_front

9
9
push_front -1
push_back 861
pop_front
pop_back
push_front -2
push_front -3
push_back 11
push_front -3
pop_back
pop_front


 */