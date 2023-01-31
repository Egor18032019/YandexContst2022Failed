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
        long sum = 0;
        int[] storage = new int[n];
        TreeSet<Proc> busySet = new TreeSet<>();
        TreeSet<Proc> freeSet = new TreeSet<>();
        for (int row = 0; row < n; row++) {
            int key = Integer.parseInt(energy[row]);
            storage[row] = key;
        }
        Arrays.sort(storage);
        for (int q = 0; q < n; q++) {
            freeSet.add(new Proc(storage[q], 0));
        }
        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            long start = Integer.parseInt(stringTokenizer.nextToken()); // момент прихода
            long time = Integer.parseInt(stringTokenizer.nextToken()); // время ее выполнения.
            long workedTime = start + time;

            boolean addInBusySet = false; //
            if (busySet.size() > 0) {
                Proc procBusy = busySet.first();
                if (procBusy.getEndWorkTime() <= start) {
                    busySet.remove(procBusy);
                    // Освободился и его же вставляем в очередь
                    procBusy.setEndWorkTime(workedTime);
                    sum += (long) time * procBusy.getPower();
                    System.out.println(time);
                    System.out.println(procBusy.getPower());
                    busySet.add(procBusy);
                    addInBusySet = true;
                }

            }
            if (!addInBusySet) {
                if (freeSet.size() > 0) {
                    Proc procPower = freeSet.first();
                    freeSet.remove(procPower);

                    System.out.println(time);
                    System.out.println(procPower.getPower());
                    procPower.setEndWorkTime(workedTime);
                    sum += (long) time * procPower.getPower();
                    busySet.add(procPower);
                }
            }
        }
        System.out.println(sum);
    }


    static class Proc implements Comparable<Proc> {
        private final Integer power;
        private Long endWorkTime;

        public Proc(int power, long endWorkTime) {
            this.power = power;
            this.endWorkTime = endWorkTime;
        }

        public int getPower() {
            return power;
        }

        public long getEndWorkTime() {
            return endWorkTime;
        }

        public void setEndWorkTime(long endWorkTime) {
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