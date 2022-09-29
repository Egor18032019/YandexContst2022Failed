import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HHResume {

    private static BufferedReader bufferedReader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); //высота стопки
        int m = Integer.parseInt(firstLine[1]);//высота стопки
        int s = Integer.parseInt(firstLine[2]); // Маша устанавливает значение s максимальной суммы зарплат и

    }
}
/*
3 4 11
        1 1    :Далее максимальное из n и m (max(n, m)) строк, на каждой из которых один из вариантов:
        2 2    : два целых числа a и b через пробел (1≤a≤10 000, 1≤b≤10 000),
        3 3    : a и символ - через пробел (1≤a≤10 000)
        - 4    :- символ - и b через пробел (1≤b≤10 000)
a и b  это  числа зарплата a[0..n-1] для одной стопки, и b[0..m-1]
 */