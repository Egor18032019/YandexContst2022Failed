import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_3_B_FinalSort {
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
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());

//        Map<String, Integer> storage = new HashMap<>();
        ArrayList<Member> storage = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            String name = stringTokenizer.nextToken();
            int task = Integer.parseInt(stringTokenizer.nextToken());
            int penalty = Integer.parseInt(stringTokenizer.nextToken());
            Member man = new Member(name, task, penalty);
            storage.add(man);
        }
        // два варианта и самописный и нативный
//        quickSort(storage, 0, n - 1);
        storage.sort(new CandidateComparatorByGradeAndFine());

        System.out.println(storage);
    }

    public static void quickSort(ArrayList<Member> participants, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(participants, left, right);

            quickSort(participants, left, partitionIndex - 1);
            quickSort(participants, partitionIndex + 1, right);
        }
    }

    private static int partition(ArrayList<Member> participants, int left, int right) {
        Member pivot = participants.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            Member leftM = participants.get(j);
            if (compare(leftM, pivot)) {
                i++;
                // если левая больше пивота то
                swap(participants, i, j);
            }
        }

        swap(participants, i + 1, right);

        return i + 1;
    }

    private static void swap(ArrayList<Member> participants, int i, int j) {
        Member swapTemp = participants.get(i);
        participants.set(i, participants.get(j));
        participants.set(j, swapTemp);
    }

    private static boolean compare(Member left, Member pivot) {
        if (left.task > pivot.task) {
            return true;
        } else if (left.task < pivot.task) {
            return false;
        } else {
            if (left.penalty < pivot.penalty) {
                return true;
            } else if (left.penalty > pivot.penalty) {
                return false;
            } else {
                return left.name.compareTo(pivot.name) < 0;
            }
        }
    }

    static class Member {
        String name;
        int task;
        int penalty;

        public Member(String name, int task, int penalty) {
            this.name = name;
            this.task = task;
            this.penalty = penalty;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", task=" + task +
                    ", penalty=" + penalty +
                    '}';
        }
    }

    static class CandidateComparatorByGradeAndFine implements Comparator<Member> {
        @Override
        public int compare(Member c1, Member c2) {
            int result = c2.task - c1.task;
            if (result == 0) {
                result = c1.penalty - c2.penalty;
            }
            if (result == 0) {
                result = c1.name.compareTo(c2.name);
            }
            return result;
        }
    }
}
/*
5
a 4 100
g 6 1000
gosha 2 90
r 2 90
t 4 80


 */