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
        stringTokenizer = new StringTokenizer(reader.readLine());
        long sum = 0;
        TreeSet<Proc> busySet = new TreeSet<>();
        TreeSet<Proc> freeSet = new TreeSet<>();
        for (int row = 0; row < n; row++) {
            int key = Integer.parseInt(stringTokenizer.nextToken());
            freeSet.add(new Proc(key, 0));
        }

        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            long start = Long.parseLong(stringTokenizer.nextToken()); // момент прихода
            long time = Long.parseLong(stringTokenizer.nextToken()); // время ее выполнения.
            long workedTime = start + time;

            if (busySet.size() > 0) {
                int setCount = busySet.size();
                for (int j = 0; j < setCount; j++) {
                    Proc busy = busySet.first();
                    if (busy.getEndWorkTime() <= start) {
                        busySet.remove(busy);
                        busy.setEndWorkTime(0);
                        freeSet.add(busy);
                    } else {
                        break;
                    }
                }
            }
            if (freeSet.size() > 0) {
                Proc free = freeSet.first();
                freeSet.remove(free);
                free.setEndWorkTime(workedTime);
                sum += time * free.getPower();
                busySet.add(free);
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
            if (0 == result) {
                result = this.power.compareTo(o.power);
            }
            return result;
        }
    }
}
/*

 */


/*

 */