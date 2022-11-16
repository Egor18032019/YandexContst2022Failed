import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dostoprimechatelnosti {
    private static BufferedReader reader = null;
    public static final int NUMBER_GIRLS = 3;
    public static Map<Integer, Map<Integer, Integer>> all;
    public static Map<Integer, List<Integer>> sequences;

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
//        int maxLength = Math.max(Integer.parseInt(firstLine[0]), Math.max(Integer.parseInt(secondLine[0]), Integer.parseInt(threeLine[0])));
        int maxLength = 0;
        int fistLength = Integer.parseInt(firstLine[0]);
        int secondLength = Integer.parseInt(secondLine[0]);
        int threeLength = Integer.parseInt(threeLine[0]);
        int keyForMaxLength = 0;
        if (fistLength < secondLength) {
            maxLength = secondLength;
            keyForMaxLength = 2;
        } else {
            maxLength = fistLength;
            keyForMaxLength = 1;
        }
        if (threeLength > maxLength) {
            maxLength = threeLength;
            keyForMaxLength = 3;
        }

        List<Integer> firstArr = new ArrayList<Integer>();
        List<Integer> secondArr = new ArrayList<Integer>();
        List<Integer> threeArr = new ArrayList<Integer>();
        for (int i = 0; i < fistLength; i++) {
            firstArr.add(Integer.parseInt(firstLine[i + 1]));
        }
        for (int i = 0; i < secondLength; i++) {
            secondArr.add(Integer.parseInt(secondLine[i + 1]));
        }
        for (int i = 0; i < threeLength; i++) {
            threeArr.add(Integer.parseInt(threeLine[i + 1]));
        }
        sequences = new HashMap<>();
        sequences.put(1, firstArr);
        sequences.put(2, secondArr);
        sequences.put(3, threeArr);

        List<Integer> first = sequences.get(keyForMaxLength);
        List<Integer> preAnswer = new ArrayList<Integer>(first);

        List<Integer> answer = new ArrayList<Integer>();
        Map<Integer, Boolean> isGirlChecked = new HashMap<>();
        isGirlChecked.put(1, false);
        isGirlChecked.put(2, false);
        isGirlChecked.put(3, false);
        isGirlChecked.put(keyForMaxLength, true);


        for (int z = 1; z <= NUMBER_GIRLS; z++) {
            if (z == keyForMaxLength) continue;
            List<Integer> next = sequences.get(z);
            if (next.size() == 0) continue;
            if (preAnswer.get(first.size() - 1) == next.get(0)) {
                preAnswer.addAll(preAnswer.size() - 1, next);
                isGirlChecked.put(z, true);
            }
            if (next.get(next.size() - 1) == preAnswer.get(0)) {
                preAnswer.addAll(0, next);
                isGirlChecked.put(z, true);

            }

        }
        if (preAnswer.size() > answer.size()) {
            answer = preAnswer;
        }
        preAnswer = new ArrayList<>();

        System.out.println(answer.size());
        for (int i : answer) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
