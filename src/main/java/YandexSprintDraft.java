import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class YandexSprintDraft {
    private static BufferedReader reader = null;
    public static int n; // количество процессоров
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
        int[] storage = new int[n];
        TreeSet<Proc> procBusySet = new TreeSet<>();
        for (int row = 0; row < n; row++) {
            int key = Integer.parseInt(energy[row]);
//            servers.put(key, 0);
            storage[row] = key;
        }
//        Collections.sort(storage);
        Arrays.sort(storage);
        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken()); // момент прихода
            int time = Integer.parseInt(stringTokenizer.nextToken()); // время ее выполнения.
            int workedTime = start + time;
            if (procBusySet.size() == 0) {
                procBusySet.add(new Proc(storage[0], workedTime));
            } else {
                int setCount = procBusySet.size();
                for (int j = 0; j < setCount; j++) {
                    Proc procBusy = procBusySet.first();
                    if (procBusy.getEndWorkTime() <= start) {
                        procBusySet.remove(procBusy);
                    }else {
                        // берем следующий проци вставяем в очередь
                    }

                    int oldValue = entry.getValue();
                    boolean timeIsEnd = oldValue <= start;
                    if (timeIsEnd) {
                        sum = sum + (long) time * key;
//                    System.out.println(time * key);
                        servers.put(key, workedTime);
                        break;
                    }
                }

            }
            System.out.println(sum);
        }
    }

    static class Proc implements Comparable<Proc> {
        private Integer power;
        private Integer endWorkTime;

        public Proc(int power, int endWorkTime) {
            this.power = power;
            this.endWorkTime = endWorkTime;
        }

        public int getPower() {
            return power;
        }

        public int getEndWorkTime() {
            return endWorkTime;
        }

        public void setEndWorkTime(int endWorkTime) {
            this.endWorkTime = endWorkTime;
        }

        @Override
        public int compareTo(Proc o) {
            int result = this.endWorkTime.compareTo(o.endWorkTime);
            if (0 == result)
                result = this.power.compareTo(o.power);
            return result;
        }
    }
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


/*

 */