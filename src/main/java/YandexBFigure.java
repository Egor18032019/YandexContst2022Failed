import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class YandexBFigure {

    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String f1 = bufferedReader.readLine();
        int displins = Integer.parseInt(f1);
        List<Vacancies> vacanciesList = new ArrayList<>();

        for (int i = 0; i < displins; i++) {
            Vacancies vacancies = new Vacancies();
            String[] vArr = bufferedReader.readLine().trim().split(",");
            vacancies.setNameVacancies(vArr[0]);
            vacancies.setNumberCandidates(Integer.parseInt(vArr[1]));
            vacanciesList.add(vacancies);
        }
        int numberOfCandidates = Integer.parseInt(bufferedReader.readLine());

        List<Candidate> candidatesList = new ArrayList<>();

        for (int i = 0; i < numberOfCandidates; i++) {
            String[] candidates = bufferedReader.readLine().trim().split(",");
            Candidate candidate = new Candidate();
            candidate.setName(candidates[0].trim());
            candidate.setVacancies(candidates[1].trim());
            candidate.setNumberCompletedTasks(Integer.parseInt(candidates[2]));
            candidate.setPenaltyPoints(Integer.parseInt(candidates[3]));
            candidatesList.add(candidate);

        }
        bufferedReader.close();


        // начинаем выбирать
        List<String> outListCandidates = new ArrayList<>();


        for (int i = 0; i < displins; i++) {

            String nameVacancies = vacanciesList.get(i).getNameVacancies();
            int numberVacancies = vacanciesList.get(i).getNumberCandidates();
            //TODO stream медленный ??
            List<Candidate> listOfSelected = candidatesList.stream().filter(
                    s -> s.getVacancies().equals(nameVacancies))
                    .sorted(
                            Comparator.comparing(
                                    Candidate::getNumberCompletedTasks)
                                    .reversed()
////                            При равенстве количества решенных задач кандидаты сравниваются по целочисленному штрафу
////                            - — чем он меньше, тем выше приоритет у кандидата.
                                    .thenComparing(Candidate::getPenaltyPoints)
                    )
                    .limit(numberVacancies)
                    .collect(Collectors.toList());

            for (Candidate candidate : listOfSelected) {
                outListCandidates.add(candidate.getName());
            }
        }

        Collections.sort(outListCandidates);
        for (String name : outListCandidates) {
            System.out.println(name);
        }
    }

    static class Candidate {
        private String name;
        private String vacancies;
        private int numberCompletedTasks;
        private int penaltyPoints;


        public int getPenaltyPoints() {
            return penaltyPoints;
        }

        public int getNumberCompletedTasks() {
            return numberCompletedTasks;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setVacancies(String vacancies) {
            this.vacancies = vacancies;
        }

        public void setNumberCompletedTasks(int numberCompletedTasks) {
            this.numberCompletedTasks = numberCompletedTasks;
        }

        public void setPenaltyPoints(int penaltyPoints) {
            this.penaltyPoints = penaltyPoints;
        }

        public String getVacancies() {
            return vacancies;
        }

        public String getName() {
            return name;
        }

    }

    static class Vacancies {
        private String nameVacancies;
        private int numberCandidates;

        public String getNameVacancies() {
            return nameVacancies;
        }

        public int getNumberCandidates() {
            return numberCandidates;
        }

        public void setNameVacancies(String nameVacancies) {
            this.nameVacancies = nameVacancies;
        }

        public void setNumberCandidates(int numberCandidates) {
            this.numberCandidates = numberCandidates;
        }

    }
}
