import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Ozon_I_Sheduler {
    private static BufferedReader reader = null;
    public static int n; // количество процов
    public static int m; // количество задач
    public static int t; // количество наборов входных данных.

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        String[] energy = reader.readLine().split(" "); //  3 2 6 4 в секунду
        Map<Integer, Integer> servers = new TreeMap<>(); // вроде авто сортировка по ключу из коробки
        long sum = 0;
        for (int row = 0; row < n; row++) {
            int key = Integer.parseInt(energy[row]);
            servers.put(key, 0);
        }
        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken()); // момент прихода
            int time = Integer.parseInt(stringTokenizer.nextToken()); // время ее выполнения.

            for (Map.Entry<Integer, Integer> entry : servers.entrySet()) {
//  2 3 4 6
                int key = entry.getKey();
                int workedTime = start + time;
                int oldValue = entry.getValue();
                boolean timeIsEnd = oldValue <= start;
                if (timeIsEnd) {
                    sum = sum + (long) time * key;
                    System.out.println(time);
                    System.out.println(key);
                    servers.put(key, workedTime);
                    break;
                }
            }

        }
        System.out.println(sum);
    }

    /*
    Частичное решение по времени не успеваю
 Сделать две очереди ?
 или одну  ?
1. в очередь падают обекты Проц и при каждом падение обьекта  пересчитываються занятые мощностя
или
2. В одной очереди свободные процессоры во второй занятые.
падает задача
из первой очереди проц забирается и вставляется во вторую
и всё равно придется как в первом случаи пересчитывать занятые мощностя
TODO обдумать как можно по другому

     */


}
/*

 */