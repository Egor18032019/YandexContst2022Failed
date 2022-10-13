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

        List<Integer> preAnswer = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 1; i <= 3; i++) {
            List<Integer> first = sequences.get(i);
            preAnswer.addAll(first);
//[1 2]
            for (int z = 1; z <= 3; z++) {
                if (z == i) continue;
                List<Integer> second = sequences.get(z);
                if (Objects.equals(first.get(first.size() - 1), second.get(0))) {
                    for (int y = 1; y < second.size(); y++) {
                        preAnswer.add(second.get(y));
                    }
                }
//                   [ 1 2 3]
                for (int x = 1; x <= 3; x++) {
                    if (x == i || x == z) continue;
                    List<Integer> last = sequences.get(x);
                    if (Objects.equals(second.get(second.size() - 1), last.get(0))) {
                        for (int y = 1; y < last.size(); y++) {
                            preAnswer.add(last.get(y));
                        }
                    }//                    [1 2 3 1]
                }
            }
            if (preAnswer.size() > answer.size()) {
                answer = preAnswer;
            }
            preAnswer = new ArrayList<>();
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
