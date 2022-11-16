import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_1_HomeWork {
    private static BufferedReader reader = null;
    public static int input;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        input = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder("");
        while (input >= 2) {
            result.append(input % 2);
            input = input / 2;
        }
        result.append(input);
        System.out.println(result.reverse());
    }
}
/*
Как перевести число в десятичной системе в двоичную?
Из десятичной системы счисления:
    разделить число на основание переводимой системы счисления;
    найти остаток от деления целой части числа;
    записать все остатки от деления в обратном порядке;
 */