import java.util.*;
import java.util.stream.Collectors;

public class CongratulationsYouPassed {
    public static void main(String[] args) {
        CongratulationsYouPassed congratulationsYouPassed = new CongratulationsYouPassed();
        congratulationsYouPassed.writeCandidate();
    }

    public void writeCandidate() {
        Scanner reader = new Scanner(System.in);
//            2
        int numberOfVacancies = Integer.parseInt(reader.nextLine());
        //            ceo,1
//            co_founder,1
        List<Vacancies> vacanciesList = new ArrayList<>();


        for (int i = 0; i < numberOfVacancies; i++) {
            String[] vacancies = reader.nextLine().trim().split(",");
            Vacancies vac = new Vacancies();
            vac.setNameVacancies(vacancies[0]);
            vac.setNumberCandidates(Integer.parseInt(vacancies[1]));
            vacanciesList.add(vac);
        }
//            3
        int numberOfCandidates = Integer.parseInt(reader.nextLine());

//            arcady_volozh,ceo,6,100
//            elon_musk,ceo,5,0
//            ilya_segalovich,co_founder,6,10
        List<Candidate> candidatesList = new ArrayList<>();
        for (int i = 0; i < numberOfCandidates; i++) {
            String[] candidates = reader.nextLine().trim().split(",");
            Candidate candidate = new Candidate();
            candidate.setName(candidates[0]);
            candidate.setVacancies(candidates[1]);
            candidate.setNumberCompletedTasks(Integer.parseInt(candidates[2]));
            candidate.setPenaltyPoints(Integer.parseInt(candidates[3]));
            candidatesList.add(candidate);
        }
// прочитали ввод
        reader.close();
// на каждую вакансию было предложено 6 задач одинаковой ценности.
        List<String> outListCandidates = new ArrayList<>();
        for (int i = 0; i < numberOfVacancies; i++) {
            String nameVacancies = vacanciesList.get(i).getNameVacancies();
            int numberVacancies = vacanciesList.get(i).getNumberCandidates();

            List<Candidate> listOfSelected = candidatesList.stream().filter(
                    s -> s.getVacancies().equals(nameVacancies))
                    .sorted(
                            Comparator.comparing(Candidate::getNumberCompletedTasks)
                                    .reversed()
                                    .thenComparing(Candidate::getPenaltyPoints)
                    ).limit(numberVacancies).collect(Collectors.toList());
//            System.out.println(listOfSelected.toString());
            for (Candidate candidate : listOfSelected) {
                outListCandidates.add(candidate.getName());
            }
        }
        Collections.sort(outListCandidates);
        for (String name : outListCandidates) {
            System.out.println(name);
        }

    }

    class Candidate {
        private String name;
        private String vacancies;
        private int numberCompletedTasks;
        private int penaltyPoints;


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

        public int getNumberCompletedTasks() {
            return numberCompletedTasks;
        }

        public int getPenaltyPoints() {
            return penaltyPoints;
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "name='" + name + '\'' +
                    ", vacancies='" + vacancies + '\'' +
                    ", numberCompletedTasks=" + numberCompletedTasks +
                    ", penaltyPoints=" + penaltyPoints +
                    '}';
        }
    }

    class Vacancies {
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

        @Override
        public String toString() {
            return "Vacancies{" +
                    "nameVacancies='" + nameVacancies + '\'' +
                    ", numberCandidates=" + numberCandidates +
                    '}';
        }
    }
}