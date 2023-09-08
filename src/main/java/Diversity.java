import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Diversity {
    private static BufferedReader reader = null;
    public static long N;
    public static long M;
    public static int Q;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        N = Long.parseLong(firstLine[0]);
        M = Long.parseLong(firstLine[1]);
        Q = Integer.parseInt(firstLine[2]);
        String[] cardsA = reader.readLine().split(" ");
        String[] cardsB = reader.readLine().split(" ");
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        //Заполняем мапы первоначально диверсити
        for (int i = 0; i < cardsA.length; i++) {
            mapA.put(cardsA[i], mapA.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < cardsB.length; i++) {
            mapB.put(cardsB[i], mapB.getOrDefault(i, 0) + 1);
        }

        int dif = cardsA.length + cardsB.length;
        // пробегаем по мапам и считаем диверсити
        if (cardsA.length > cardsB.length) {
            for (String key : mapA.keySet()) {
                if (mapB.containsKey(key)) {
                    int a = mapA.get(key);
                    int b = mapB.get(key);
                    if (a == b) {

                        dif = dif - 2;
                    } else {
                        dif = dif + 2;
                    }
                }
            }
        } else {
            for (String key : mapB.keySet()) {
                if (mapA.containsKey(key)) {
                    int a = mapA.get(key);
                    int b = mapB.get(key);

                    if (a == b) {

                        dif = dif - 2;
                    } else {
                        dif = dif + 2;
                    }
                }
            }
        }
//        System.out.println(dif);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String[] line = reader.readLine().split(" ");
            String player = line[1];
            String type = line[0];
            String card = line[2];

            if (player.equals("A")) {
                if (type.equals("1")) {
                    mapA.put(card, mapA.getOrDefault(card, 0) + 1);
                    // добавили проверили есть ли в другой в том же кол-ве
                    if (mapB.containsKey(card) && (mapB.get(card) - mapA.get(card) == 0)) {
                        dif--;
                    } else {
                        dif++;
                    }
                } else {
                    // -1
                    mapA.put(card, mapA.getOrDefault(card, 0) - 1);
//
                    if (mapB.containsKey(card) && Objects.equals(mapB.get(card), mapA.get(card))) {
                        dif++;
                    } else {
                        dif--;
                    }
                }
            } else {
                if (type.equals("1")) {
                    mapB.put(card, mapB.getOrDefault(card, 0) + 1);
                    // добавили проверили есть ли в другой в том же кол-ве
                    if (mapA.containsKey(card) && (mapB.get(card) - mapA.get(card) == 0)) {
                        dif--;
                    } else {
                        dif++;
                    }
                } else {
                    // -1
                    mapB.put(card, mapA.getOrDefault(card, 0) - 1);

                    if (mapA.containsKey(card) && Objects.equals(mapB.get(card), mapA.get(card))) {
                        dif++;
                    } else {
                        dif--;
                    }
                }
            }
            if (i < (Q - 1)) {
                answer.append(dif).append(" ");
            } else {
                answer.append(dif);
            }
        }
        System.out.print(answer);
    }

// 5 4 5 6 7 8 9 10 9 8 9 8 7 6 5 6 5 4 3 4
// 5 4 5 6 7 8 9 10 9 8 9 8 7 6 5 6 7 6 5 6
// 5 4 5 6 7 8 9 10 9 8 7 6 5 4 3 2 3 2 1 0
}

/*
 Два друга A и B постоянно играют в коллекционную карточную игру (ККИ), поэтому у каждого игрока скопилась довольно большая коллекция карт.

Каждая карта в данной игре задаётся целым числом (одинаковые карты — одинаковыми числами, разные карты — разными).

Таким образом коллекцию можно представить как неупорядоченный набор целых чисел (с возможными повторениями).

После каждого изменения коллекций друзья вычисляют показатель разнообразия следующим образом:

    A и B выкладывают на стол все карты из своей коллекции в два раздельных ряда;
    Далее друзья итеративно делают следующее:
        Если среди лежащих на столе карт игрока A есть такая же карта, как и среди лежащих карт игрока B — каждый игрок убирает данную карту со стола;
        Если таковых совпадений нет — процесс заканчивается.
    Разнообразием коллекций друзья называют суммарное количество оставшихся карт на столе.

Даны начальные состояния коллекций игроков, а также Q изменений их коллекций. После каждого изменения необходимо вычислить разнообразие коллекций друзей.

Формат ввода
В первой строке через пробел заданы числа N, M, Q(1≤N,M,Q≤105) — количество карт в коллекциях игрока A и B и количество изменений соответственно.

Вторая строка содержит через пробел N целых чисел ai(1≤ai≤109) — карты в коллекции игрока A.

Третья строка содержит через пробел M целых чисел bj(1≤bj≤109) — карты в коллекции игрока B.

Далее на каждой из следующих Q строк описано изменение коллекции: через пробел заданы typekplayerkcardk(typek=±1;playerk∈(A,B);1≤cardk≤109) — тип k-го изменения, имя игрока и значение карты:

    Если type=1, то в коллекцию игрока player добавился экземпляр карты card;
    Если type=−1, то из коллекции игрока player удалился один экземпляр карты card.
    Гарантируется, что при запросе type=−1 хотя бы один экземпляр карты card присутствует в коллекции игрока player.

Формат вывода
Необходимо вывести через пробел Q целых чисел — разнообразие коллекций игроков A и B после k-го изменения.
Пример 1
Ввод
Вывод

2 5 10
1 2
1 2 3 4 5
1 A 3
1 A 4
1 A 5
1 A 6
1 A 7
-1 A 1
1 B 7
-1 A 6
-1 B 1
1 A 7



2 1 0 1 2 3 2 1 0 1

Пример 2
Ввод
Вывод

3 3 5
1000 2000 1001
1001 2001 1000
1 A 100000
-1 B 2001
1 B 2000
1 B 100001
1 A 1



3 2 1 2 3

Пример 3
Ввод
Вывод

3 3 20
1 6 7
2 4 5
1 A 2
1 B 1
1 B 8
1 B 5
1 A 3
1 A 2
1 B 10
1 A 9
1 A 8
1 B 7
-1 A 1
-1 B 5
-1 B 5
-1 B 4
-1 A 6
-1 A 8
-1 A 2
-1 B 8
-1 B 10
-1 A 2



5 4 5 6 7 8 9 10 9 8 9 8 7 6 5 6 5 4 3 4

Примечания
В первом примере после первого изменения коллекции следующие: 1,2,3 и 1,2,3,4,5, разнообразие - 2, т.к. игроки уберут общие карты 1,2,3, оставив 4,5.

Далее поочередно первому игроку добавляются 4,5, сокращая различие между коллекциями игроков на 1 в обоих случаях.

Четвёртое и пятое изменение добавляет первому игроку карты 6,7, которых нет у игрока B, поэтому разнообразие увеличивается на 1 в обоих случаях.

Шестое изменение увеличивает разнообразие, т.к. до него 1 была общей картой игроков.

Седьмое уменьшает добавлением общей 7-рки, восьмое уменьшает убиранием из коллекции A 6-рки, которой нет у B.

Девятое изменение приводит коллекции к одинаковому виду - разнообразие 0.

Последнее изменение добавляет ещё одну 7 игроку A, увеличивая разнообразие, т.к. у второго игрока 7 лишь одна.

Во втором примере на первом шаге коллекции 1000,2000,1001,100000 ; 1001,2001,1000 - на столе останутся 2000,100000 и 2001.

На втором шаге разнообразность понижается на 1, т.к. 2001 была только в коллекции второго игрока.

На третьем шаге второму игроку добавляется карта 2000, которая есть у первого игрока, поэтому разнообразие уменьшается до 1.

На четвёртом шаге разнообразие повышается при добавлении новой карты 100001 игроку B.

На пятом шаге разнообразие увеличивается, т.к. у второго игрока карт 1 нет.
 */