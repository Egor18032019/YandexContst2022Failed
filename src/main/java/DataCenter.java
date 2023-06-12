import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DataCenter {
    private static BufferedReader reader = null;
    public static int N; //число дата-центров,
    public static int M; // число серверов в каждом из дата-центров
    public static int Q; //и число событий соответственно

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        Q = Integer.parseInt(stringTokenizer.nextToken());
        Map<Integer, int[]> dataCenters = new HashMap<>();
        Map<Integer, Integer> events = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int[] servers = new int[M];
            for (int s = 0; s < M; s++) {
                servers[s] = 1;
            }
            dataCenters.put(i, servers);
        }
        // {1:{1,1,1}

        for (int i = 0; i < Q; i++) {
            String[] line = reader.readLine().split(" ");
            String command = line[0];
            switch (command) {
                case "DISABLE":
                    int key = Integer.parseInt(line[1]);
                    int[] point = dataCenters.get(key);
                    int index = Integer.parseInt(line[2]) - 1;
                    point[index] = 0;
                    dataCenters.put(key, point);
                    break;
                case "RESET":
                    int keyServerForReset = Integer.parseInt(line[1]);
                    int[] pointForReset = dataCenters.get(keyServerForReset);
                    for (int s = 0; s < M; s++) {
                        pointForReset[s] = 1;
                    }
                    dataCenters.put(keyServerForReset, pointForReset);
                    int value = events.getOrDefault(keyServerForReset, 0) + 1;
                    events.put(keyServerForReset, value);
                    break;
                case "GETMAX":
                    int max = 0;
                    int numberDataCenter = 0;
                    for (int q = 1; q <= N; q++) {
                        int maxWorkServers = Arrays.stream(dataCenters.get(q)).sum();
                        int countReset = events.getOrDefault(q, 0);
                        if (countReset == 0) {
                            countReset = 1;
                        }
                        int foo = maxWorkServers * countReset;
                        if (max < foo) {
                            max = foo;
                            numberDataCenter = q;
                        }
                    }
                    System.out.println(numberDataCenter);
                    break;
                case "GETMIN":
                    int min = Integer.MAX_VALUE;
                    int numberDataCenterMin = 0;
                    for (int z = 1; z <= N; z++) {
                        int maxWorkServers = Arrays.stream(dataCenters.get(z)).sum();
                        int countReset = events.getOrDefault(z, 0);
                        if (countReset == 0) {
                            countReset = 1;
                        }
                        int foo = maxWorkServers * countReset;
                        if (min > foo) {
                            min = foo;
                            numberDataCenterMin = z;
                        }
                    }
                    System.out.println(numberDataCenterMin);
                    break;
                default:
            }
        }
    }


}
/*
Коля и дата-центры
Язык 	Ограничение времени 	Ограничение памяти 	Ввод 	Вывод
Все языки 	2.5 секунд 	512Mb 	стандартный ввод или input.txt 	стандартный вывод или output.txt
OpenJDK 17 + json 	4 секунды 	512Mb
C# (MS .NET 6.0 + ASP) 	4 секунды 	512Mb
Python 3.11.2 	4 секунды 	512Mb
Рано или поздно все крупные IT-компании создают свои дата-центры. Коля только устроился в такую компанию и еще не успел во всем разобраться. В его компании есть N дата-цетров,в каждом дата-центре установлено M серверов.

Из-за большой нагрузки серверы могут выключаться. Из-за спешки при постройке дата-центров включить только один сервер не получается, поэтому приходится перезагружать весь дата-центр. У каждого дата-центра есть два неотрицательных целочисленных параметра: Ri
 — число перезапусков i-го дата-центра и Ai  — число рабочих (не выключенных) серверов на текущий момент в i

-м дата-центре.

Коля получил задачу по сбору некоторых метрик, которые в будущем позволят улучшить работу дата-центов. Для этого Коля собрал данные о Q

событиях, произошедших за текущий день. Коля справился с этой задачей, но просит помочь и проверить свои результаты.
Формат ввода
В первой строке входных данных записано 3 положительных целых числа n
, m, q (1≤q≤105,1≤n⋅m≤106) — число дата-центров, число серверов в каждом из дата-центров и число событий соответственно.

В последующих q

строках записаны события, которые могут иметь один из следующих видов:

RESET i
— был перезагружен i-й дата-центр (1≤i≤n)

DISABLE i
j — в i-м дата-центре был выключен j-й сервер (1≤i≤n,1≤j≤m)

GETMAX — получить номер дата-центра с наибольшим произведением Ri∗Ai

GETMIN — получить номер дата-центра с наименьшим произведением Ri∗Ai

Формат вывода
На каждый запрос вида GETMIN или GETMAX выведите единственное положительное целое число — номер дата-центра, подходящий под условие. В случае неоднозначности ответа выведите номер наименьшего из дата-центров.
Пример 1
Ввод 	Вывод

3 3 12
DISABLE 1 2
DISABLE 2 1
DISABLE 3 3
GETMAX
RESET 1
RESET 2
DISABLE 1 2
DISABLE 1 3
DISABLE 2 2
GETMAX
RESET 3
GETMIN



1
2
1

Пример 2
Ввод 	Вывод

2 3 9
DISABLE 1 1
DISABLE 2 2
RESET 2
DISABLE 2 1
DISABLE 2 3
RESET 1
GETMAX
DISABLE 2 1
GETMIN



1
2

Примечания
Обратите внимание на 2 пример. DISABLE приходится для уже выключенного сервера.
В данном случае сервер по-прежнему остаётся выключенным.
 */