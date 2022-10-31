import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //    Ввод: натуральное число n
    //    Вывод: количество простых чисел строго меньше n
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int maxCount = 0;
//        maxCount = nativeCount(n);
//        maxCount = goodCount(n);
        maxCount = getLeastPrimesLinear(n);

        System.out.println(maxCount);
    }

    //O(n)
    public static int nativeCount(int n) {
        int maxCount = 0;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        for (int i = 2; i < n; i++) {
            boolean isNature = true;
            for (int q = 2; q < i; q++) {
                if (i % q == 0) {
                    isNature = false;
                }
            }
            if (isNature) {
                maxCount++;
            }

        }
        return maxCount;
    }

    //O(√n)
    public static int goodCount(int n) {
        int maxCount = 0;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        for (int i = 2; i < n; i++) {
            boolean isNature = true;
            for (int q = 2; q * q <= i; q++) {
                if (i % q == 0) {
                    isNature = false;
                }
            }
            if (isNature) {
                maxCount++;
            }

        }
        return maxCount;
    }

    public static int getLeastPrimesLinear(int n) {
    // очень хитрый алгоритм поиска простых чисел
        int length = n + 1;
        int[] lp = new int[length];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < length; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes.add(i);
            }
            for (int p : primes) {
                int x = p * i;
                if (p > lp[i] || x > n) break;
                lp[x] = p;
            }

        }
        return primes.size();
    }

}
/*

Дан массив неповторяющихся чисел, который был отсортирован, а затем циклически сдвинут на неизвестное число позиций.
Опишите без кода и псевдокода алгоритм поиска максимума в таком массиве
Оцените сложность предложенного алгоритма
Изменится ли сложность если массив содержит повторяющиеся числа?

Массив был отсортирован по возрастанию ?? если да то=>
либо левая, либо правая половины оказываются отсортированными.

Смотрим крайний левый a и крайний правый с
[1, 2, 3, 4, 5]
если a<с 1<5
То массив "правильный" и с будет максимум
если нет то

[3, 4, 5, 6, 1 ,2]

Смотрим значение в середине массива b
и проверяем какой массив "неправильный"
то есть сравниваем a>b  и b>c где false тот массив не правильный
Например:
[3, 4, 5, 1, 2]
a = 3 ; b=5; c=2;
b>c
то есть подмаcсив [5,1,2] "неправильный"
и далее таким же алгоритмом и перебираем пока не найдем массив из двух элементом и в котором левый (a)  будет максимум
Сложность O(log n)
или O(n) если есть повторяющие числа так как надо будет проверять оба подмассива




 */

