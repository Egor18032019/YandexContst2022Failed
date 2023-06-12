import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sbtDeomnia {
    private static BufferedReader reader = null;
    public static int N; //длины
    public static int K; // не превосходит числа K


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] line = reader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        int count = 0;
        line = reader.readLine().split(" ");
        int[] arr = new int[N];
        int cursor = -1;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(line[i]);
            arr[i] = a;
            if (a <= K) {

                if (i > 0) {
                    int sum = 0;
                    for (int q = i; q > cursor; q--) {
                        int point = arr[q];
                        if (sum + point <= K) {
                            sum = sum + point;
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (sum > a) {

                        cursor = i;
                    }
                }else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
/*
C. Одержимый
ограничение по времени на тест
1.5 секунд
ограничение по памяти на тест
256 мегабайт
ввод
стандартный ввод
вывод
стандартный вывод

Игнат просто одержим интересными подотрезками массивов из целых неотрицательных чисел.

Интересным подотрезком массива [a1,…,aN]
он называет массив [al,al+1,…,ar−1,ar] (1≤l≤r≤N), в котором не более одного нулевого элемента, а сумма всех элементов не превосходит числа K

.

У Игната есть массив a
длины N

. Найдите количество интересных подотрезков этого массива.
Входные данные

В первой строке содержатся целые числа N
и K (1≤N≤105;0≤K≤109)

.

Во второй строке содержатся целые числа a1
, ..., aN (0≤ai≤109)

.
Выходные данные

Выведите количество интересных подотрезков массива.
Система оценки

В этой задаче 4 группы тестов.

Первая группа тестов стоит 3 балла, для нее выполняются ограничения N≤100
; 0≤ai≤105

.

Вторая группа тестов стоит 3 балла, для нее выполняются ограничения N≤2000
; 0≤ai≤109

.

Третья группа тестов стоит 2 балла, для нее выполняются ограничения N≤105
; 1≤ai≤109

.

Четвертая группа тестов стоит 2 балла, для нее выполняются ограничения N≤105
; 0≤ai≤109

.
Примеры
Входные данные
Скопировать

4 1
0 1 1 0

Выходные данные
Скопировать

6

Входные данные
Скопировать

4 4
1 2 3 4

Выходные данные
Скопировать

5

Примечание

В первом примере интересными являются четыре одноэлементных подотрезка, а также подотрезки [0,1]
и [1,0]

.

Во втором примере интересными являются четыре одноэлементных подотрезка, а также подотрезок [1,2]

.


 */