import java.util.List;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String firstLine = reader.nextLine();
        int count = Integer.parseInt(firstLine);
        long[] answerArr = new long[count];
        for (int i = 0; i < count; i++) {
            String[] numbers = reader.nextLine().trim().split(" ");
            long first = Long.parseLong(numbers[0]);
            long second = Long.parseLong(numbers[1]);
            long nod = givMeNOD(first, second);
//            System.out.println("nod " + nod);
            long factor;
            if (nod == 1) {
                factor = Math.max(first, second);
            } else {
                factor = giveMeFactor(Math.max(first, second) / nod);
            }
//            System.out.println("factor " + factor);
            long answer;
            if (first > second) {
                answer = second * factor;
//                System.out.println(givMeNOD(answer, first));
                answerArr[i] = givMeNOD(answer, first);
            } else {
                answer = first * factor;
//                System.out.println(givMeNOD(answer, second));
                answerArr[i] = givMeNOD(answer, second);
            }
        }
        reader.close();
        for (long i : answerArr){
            System.out.println(i);
        }
    }

    public static long givMeNOD(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return givMeNOD(n2, n1 % n2);
    }

    public static int giveMeFactor(long num) {
        int count = 2;
        while (num != 1) {
            if (num % count == 0) {
                num /= count;
            } else {
                count += 1;
            }
        }
        return count;
    }
}
/*
3     = кол-во заданий
A   B
5   1           = 5
12  54         = 18
500100 100500 = 500100
 */
// НОД(5,1) = 1 -> 1(число A) * на простое число == 5 (не B а именно простое число)
/*
 наибольшее значение НОД,
 которого можно добиться умножением ОДНОГО из чисел A и B на любое простое число.
 */
/*
12 54         = 18
НОД(12,54) = 6
То есть мы повышаем A или B что в итоге у них был высокий НОД

 */
