import java.util.*;
import java.util.stream.Collectors;

public class YandexYouPassed2 {
    public static class Competitor {
        private String name;
        private int performance;
        private int penalty;

        public Competitor(String name, int performance, int penalty) {
            this.name = name;
            this.performance = performance;
            this.penalty = penalty;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPerformance() {
            return performance;
        }

        public void setPerformance(int performance) {
            this.performance = performance;
        }

        public int getPenalty() {
            return penalty;
        }

        public void setPenalty(int penalty) {
            this.penalty = penalty;
        }
    }

    public static void solution() {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> competitions = new HashMap<>();
        List<Competitor> res = new ArrayList<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String[] comp = scan.next().split(",");
            competitions.put(comp[0], Integer.parseInt(comp[1]));
        }
        int k = scan.nextInt();
        HashMap<String, List<Competitor>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String[] competitors = scan.next().split(",");
            Competitor competitor = new Competitor(competitors[0], Integer.parseInt(competitors[2]), Integer.parseInt(competitors[3]));
            if (!map.containsKey(competitors[1])) {
                List<Competitor> list = new ArrayList<>();
                list.add(competitor);
                map.put(competitors[1], list);
            } else {
                map.get(competitors[1]).add(competitor);
                map.replace(competitors[1], map.get(competitors[1]));
            }
        }
        for (String c : competitions.keySet()) {
            res.addAll(map.get(c).stream().sorted(
                            Comparator.comparingInt(Competitor::getPerformance)
                                    .reversed()
                                    .thenComparingInt(Competitor::getPenalty))
                    .limit(competitions.get(c)).collect(Collectors.toList()));
        }
        for (Competitor com : res.stream().sorted(Comparator.comparing(Competitor::getName)).collect(Collectors.toList())) {
            System.out.println(com.getName());
        }

    }
}
