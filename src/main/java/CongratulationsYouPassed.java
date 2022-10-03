import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CongratulationsYouPassed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/InputFiles/input_test1.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/InputFiles/input_test2.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/InputFiles/input_test3.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/InputFiles/input_test4.txt"));

        // создаю карту вакансий , в которой ключ - название вакансии, значение - количество мест по этой вакансии
        Map<String, Integer> vacanciesMap = new HashMap<>();
        //  читаю общее количество вакансий
        int vacanciesValue = Integer.parseInt(reader.readLine());
        //  читаю по порядку каждую отдельную вакансию, согласно их количеству и гарантии о входных данных
        for (int i = 0; i < vacanciesValue; i++) {
            String[] vacancy = reader.readLine().split(",");
            //  складываю каждую вакансию в карту вакансий,
            //  < название вакансии, количество мест по этой вакансии >
            vacanciesMap.put(vacancy[0], Integer.parseInt(vacancy[1]));
        }
        // создаю карту претендентов на вакансию,
        // в которой ключ - наименование вакансии, значение - список кандатов претендующих на вакансию.
        Map<String, List<Candidate>> candidatesMap = new HashMap<>();
        //  читаю общее количество кандидатов
        int candidateValue = Integer.parseInt(reader.readLine());
        //  читаю по порядку каждого отдельного кандидата, согласно их количеству и гарантии о входных данных
        for (int i = 0; i < candidateValue; i++) {
            String[] candidateAsStringArray = reader.readLine().split(",");
            // создаю объект класса Candidate согалсно гарантии о входных данных
            Candidate candidate = new Candidate(
                    candidateAsStringArray[0],
                    candidateAsStringArray[1],
                    Integer.parseInt(candidateAsStringArray[2]),
                    Integer.parseInt(candidateAsStringArray[3]));
            //  складываю кандидатов в катру претендетов на вакансию
            //  <наименование вакансии, список кандатов претендующих на вакансию>
            candidatesMap.
                    computeIfAbsent(candidate.vacancy, k -> new ArrayList<>())
                    .add(candidate);
        }
        // создаю список для прошедших отбор кандидатов по всем вакансиям
        List<Candidate> result = new ArrayList<>();
        // перебираю карту вакансии
        for (Map.Entry<String, Integer> entry : vacanciesMap.entrySet()) {
            String currentVacancy = entry.getKey();
            int valueCandidate = entry.getValue();
            // проверяю, есть ли претенденты на вакансию
            if (currentVacancy != null && candidatesMap.get(currentVacancy) != null) {
                // заполняю список прошедших кандидатов
                candidatesMap.get(currentVacancy).stream().
                        // сортирую кандидатов Candidate.compareTo
                                sorted().
                        // ограничиваю количество вносимых в список прошедших кандидатов
                        // согласно количеству мест по вакансии
                                limit(valueCandidate).
                        forEach(result::add);
            }
        }
        // Вывожу итоговый список кандидатов с сортировкой по имени
        result.stream().
                sorted(Comparator.comparing(x -> x.name)).
                forEach(System.out::println);
    }

    static class Candidate implements Comparable<Candidate> {
        public String name;
        public String vacancy;
        public int solvedTasks;
        public int penaltyValue;

        public Candidate(String name, String vacancy, int solvedTasks, int penaltyValue) {
            this.name = name;
            this.vacancy = vacancy;
            this.solvedTasks = solvedTasks;
            this.penaltyValue = penaltyValue;
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.solvedTasks < o.solvedTasks) return 1;
            if (this.solvedTasks == o.solvedTasks) {
                if (this.penaltyValue > o.penaltyValue) return 1;
                if (this.penaltyValue == o.penaltyValue) return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}