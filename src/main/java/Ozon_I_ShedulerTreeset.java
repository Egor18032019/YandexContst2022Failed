import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Ozon_I_ShedulerTreeset {
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
        TreeSet<Proc> busySet = new TreeSet<>();
        TreeSet<Proc> freeSet = new TreeSet<>();
        for (int row = 0; row < n; row++) {
            int key = Integer.parseInt(energy[row]);
//            servers.put(key, 0);
            storage[row] = key;
//            freeSet.add(new)
        }
        Arrays.sort(storage);
        for (int q = 0; q < n; q++) {
            freeSet.add(new Proc(storage[q], 0));
        }
//        Collections.sort(storage);
        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken()); // момент прихода
            int time = Integer.parseInt(stringTokenizer.nextToken()); // время ее выполнения.
            int workedTime = start + time;

            boolean addInBusySet = false;
            if (busySet.size() > 0) {
                int setCount = busySet.size();
                for (int j = 0; j < setCount; j++) {
                    Proc procBusy = busySet.first();
                    if (procBusy.getEndWorkTime() <= start) {
                        busySet.remove(procBusy);
                        // Освободился и его же вставляем в очередь
                        procBusy.setEndWorkTime(workedTime);
                        sum += (long) time * procBusy.getPower();
                        busySet.add(procBusy);
                        addInBusySet = true;
                    } else {
                        break;
                    }
                }
            }
            if (!addInBusySet) {
                if (freeSet.size() > 0) {
                    Proc procPower = freeSet.first();
                    freeSet.remove(procPower);

                    sum += (long) time * procPower.getPower();
//                    System.out.println(sum);

                    busySet.add(new Proc(procPower.getPower(), workedTime));
                }
            }
        }
        System.out.println(sum);
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
