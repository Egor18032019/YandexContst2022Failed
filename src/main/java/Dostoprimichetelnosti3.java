import java.util.*;

public class Dostoprimichetelnosti3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstLine;
        List<String> secondLine;
        List<String> thirdLine;

        firstLine = fillList(scanner);
        secondLine = fillList(scanner);
        thirdLine = fillList(scanner);

        List<String> answerList;

        int[] sizeInits = new int[6];
        Map<Integer, List<String>> sequences = new HashMap<>();
        sequences.put(0, initAnswerLists(firstLine, secondLine, thirdLine));
        sequences.put(1, initAnswerLists(secondLine, firstLine, thirdLine));
        sequences.put(2, initAnswerLists(firstLine, thirdLine, secondLine));
        sequences.put(3, initAnswerLists(thirdLine, firstLine, secondLine));
        sequences.put(4, initAnswerLists(secondLine, thirdLine, firstLine));
        sequences.put(5, initAnswerLists(thirdLine, secondLine, firstLine));
        sizeInits[0] = sequences.get(0).size();
        sizeInits[1] = sequences.get(2).size();
        sizeInits[2] = sequences.get(3).size();
        sizeInits[3] = sequences.get(4).size();
        sizeInits[4] = sequences.get(5).size();
        sizeInits[5] = sequences.get(6).size();

        int minSize = Arrays.stream(sizeInits).filter(x -> x != 0).min().getAsInt();
        System.out.println(minSize);


    }

    private static List<String> initAnswerLists(List<String> firstList,
                                                List<String> secondList, List<String> thirdList) {
        List<String> tempAnswer = new ArrayList<>(mergeLists(firstList, secondList));
        if (tempAnswer.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(mergeLists(tempAnswer, thirdList));
    }

    private static List<String> fillList(Scanner scanner) {
        int size = scanner.nextInt();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scanner.next());
        }

        return list;
    }

    private static List<String> mergeLists(List<String> firstList, List<String> secondList) {
        int firstCount = numberMatchingValues(firstList, secondList);

        if (firstCount > 0) {
            firstList = firstList.subList(0, firstList.size() - firstCount);
            firstList.addAll(secondList);
            return firstList;
        }

        return new ArrayList<>();
    }

    private static int numberMatchingValues(List<String> firstList, List<String> secondList) {
        if (firstList.size() == 0) return 0;

        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            if (!firstList.get(i).equals(secondList.get(i)))
                return numberMatchingValues(firstList.subList(1, firstList.size()), secondList);
        }

        return firstList.size();
    }
}