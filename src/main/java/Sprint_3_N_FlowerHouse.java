import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_3_N_FlowerHouse {
    private static BufferedReader reader = null;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());

//        Map<String, Integer> storage = new HashMap<>();
//        LinkedList<int[]> storage = new LinkedList<>();
        ArrayList<int[]> storage = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] region = new int[2];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            region[0] = Integer.parseInt(stringTokenizer.nextToken());
            region[1] = Integer.parseInt(stringTokenizer.nextToken());
            storage.add(region);
        }
        for (int i = 0; i < n; i++) {
            int[] region = storage.get(i);
            if (region == null) continue;
            storage.set(i, null);
            int spotStart = region[0];
            int spotEnd = region[1];
            for (int w = i + 1; w < n; w++) {
                int[] area = storage.get(w);
                if (area == null) continue;

                int areaStart = area[0];
                int areaEnd = area[1];
                // 1 5  / 5
                if (spotEnd == areaStart) {
                    spotEnd = areaEnd;

                    storage.set(w, null);
                    continue;
                }
                if (spotStart == areaStart && spotEnd == areaEnd) {
// ничего не делаю
                    storage.set(w, null);
                    continue;
                }
                if (spotEnd >= areaStart) {
                    if (spotStart < areaStart) {
                        // 2 4 / 3 4
                        if (spotEnd <= areaEnd) {
                            // 1 5   / 2 7
                            spotEnd = areaEnd; // 1 5
                        }
                        storage.set(w, null);
                    } else {
                        if (spotStart < areaEnd) {
                            // 3 > 4 no 7>3
                            spotStart = areaStart; // 1 5
                            storage.set(w, null);
                            if (spotEnd < areaEnd) {
                                // 7 8 / 6 10
                                spotEnd = areaEnd;
                            }
                        }

                    }
                }
            }
            region[0] = spotStart;
            region[1] = spotEnd;
            storage.set(i, region);
        }
        storage.sort((Comparator.nullsFirst(Comparator.comparingInt(o -> o[0]))));
        for (int[] foo : storage) {
            System.out.println(Arrays.toString(foo));
        }
    }
}
/*
4
7 8
7 8
2 3
6 10

4
2 3
5 6
3 4
3 4

6
1 3
3 5
4 6
5 6
2 4
7 10

 */