import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dostoprimechatelnosti2 {
    private static BufferedReader reader = null;

    public static Map<Integer, List<Integer>> sequences;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        int count = 0;
        String[] firstLine = reader.readLine().split(" ");
        String[] secondLine = reader.readLine().split(" ");
        String[] threeLine = reader.readLine().split(" ");
        int firstLength = Integer.parseInt(firstLine[0]);
        int secondLength = Integer.parseInt(secondLine[0]);
        int threeLength = Integer.parseInt(threeLine[0]);
        List<Integer> firstArr = new ArrayList<Integer>();
        List<Integer> secondArr = new ArrayList<Integer>();
        List<Integer> threeArr = new ArrayList<Integer>();
        for (int i = 0; i < firstLength; i++) {
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

        List<Integer> preAnswer = new ArrayList<>();
        int intFlag = 0;
        boolean isFirst = true;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            List<Integer> first = sequences.get(i);
//[1 2]
            for (int z = 1; z <= 3; z++) {
                if (z == i) continue;
                preAnswer = new ArrayList<>(first);
                intFlag = 0;
                List<Integer> second = sequences.get(z);


                intFlag++;
                boolean isHaveSecond = false;
                int index = 0;
                for (int y = 0; y < first.size(); y++) {
                    for (int q = 0; q < second.size(); q++) {
                        if (first.get(y) == second.get(q)) {
                            isHaveSecond = true;
                            index =q;
                        }
//                        if (!isHaveSecond) break;
                    }
                    preAnswer.add(second.get(y));
                }

//                   [ 1 2 3]
                for (int x = 1; x <= 3; x++) {
                    if (x == i || x == z) continue;
                    count++;
                    List<Integer> last = sequences.get(x);
                    if (Objects.equals(second.get(second.size() - 1), last.get(0))) {
                        intFlag++;
                        for (int y = 1; y < last.size(); y++) {
                            preAnswer.add(last.get(y));
                        }
                    }
                    //                    [1 2 3 1]
                }
                if (intFlag == 2) {
                    if (isFirst) {
                        answer = preAnswer;
                        isFirst = false;
                    } else {
                        if (preAnswer.size() < answer.size()) {
                            answer = preAnswer;
                            preAnswer = new ArrayList<>(first);
                            intFlag = 0;
                        }
                    }
                }
            }
        }
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if (i != answer.size()) {
                System.out.print(" ");
            }
        }


    }


}

/*
3 1 2 3
3 1 2 3
3 1 2 3

2 1 1
2 1 1
2 1 1

3 1 99 1
5 1 98 1 2 1
3 1 97 1

5 1 2 3 4 5
4 5 10 11 12
5 5 6 7 8 9
 */