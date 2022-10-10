import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dostoprimechatelnosti {
    private static BufferedReader reader = null;

    public static Map<Integer, Map<Integer, Integer>> all;
    public static Map<Integer, int[]> sequences;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        String[] secondLine = reader.readLine().split(" ");
        String[] threeLine = reader.readLine().split(" ");
        int[] firstArr = new int[firstLine.length - 1];
        for (int i = 0; i < firstLine.length - 1; i++) {
            firstArr[i] = Integer.parseInt(firstLine[i + 1]);
        }
        int[] secondArr = new int[secondLine.length - 1];
        for (int i = 0; i < secondLine.length - 1; i++) {
            secondArr[i] = Integer.parseInt(secondLine[i + 1]);
        }
        int[] threeArr = new int[threeLine.length - 1];
        for (int i = 0; i < threeLine.length - 1; i++) {
            threeArr[i] = Integer.parseInt(threeLine[i + 1]);
        }
        sequences = new HashMap<>();
        sequences.put(1, firstArr);
        sequences.put(2, secondArr);
        sequences.put(3, threeArr);

        List<Integer> preAnswer = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 1; i <= 3; i++) {
            int[] first = sequences.get(i);
            Integer[] fooArray = Arrays.stream(first).boxed().toArray(Integer[]::new);
            Collections.addAll(preAnswer, fooArray);

            for (int z = 1; z <= 3; z++) {
                if (z == i) continue;
                int[] second = sequences.get(z);
                if (first[first.length - 1] == second[0]) {
                    if ((second.length - 1) >= 1) {
                        int[] addLast = new int[second.length - 1];
                        System.arraycopy(second, 1, addLast, 0, second.length - 1);
                        Integer[] barArray = Arrays.stream(addLast).boxed().toArray(Integer[]::new);
                        Collections.addAll(preAnswer, barArray);
                    }
                }

                for (int x = 1; x <= 3; x++) {
                    if (x == i || x == z) continue;
                    int[] last = sequences.get(x);
                    if (second[second.length - 1] == last[0]) {
                        if ((last.length - 1) >= 1) {
                            int[] addLast = new int[last.length - 1];
                            System.arraycopy(last, 1, addLast, 0, last.length - 1);
                            Integer[] lastArray = Arrays.stream(addLast).boxed().toArray(Integer[]::new);
                            Collections.addAll(preAnswer, lastArray);
                        }
                    }
                }
            }
            if (preAnswer.size() > answer.size()) {
                answer = preAnswer;
            }
            preAnswer = new ArrayList<>();
        }
        System.out.println(answer.size());
        for (int i : answer) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
