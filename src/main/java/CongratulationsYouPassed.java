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
        List<Vacancies> vacanciesList = new ArrayList<>();

// Парсим следущий ввод -> делам список вакансий
        //            ceo,1
        //            co_founder,1
        for (int i = 0; i < numberOfVacancies; i++) {
            String[] vacancies = reader.nextLine().trim().split(",");
            Vacancies vac = new Vacancies();
            vac.setNameVacancies(vacancies[0]);
            vac.setNumberCandidates(Integer.parseInt(vacancies[1]));
            vacanciesList.add(vac);
        }
//          число участвовавших в отборочном соревновании кандидатов
//            3
        int numberOfCandidates = Integer.parseInt(reader.nextLine());

        List<Candidate> candidatesList = new ArrayList<>();
        // Парсим ввод -> делаем список кандидатов
//            arcady_volozh,ceo,6,100
//            elon_musk,ceo,5,0
//            ilya_segalovich,co_founder,6,10
        for (int i = 0; i < numberOfCandidates; i++) {
            String[] candidates = reader.nextLine().trim().split(",");
            Candidate candidate = new Candidate();
            candidate.setName(candidates[0].trim());
            candidate.setVacancies(candidates[1].trim());
            candidate.setNumberCompletedTasks(Integer.parseInt(candidates[2]));
            candidate.setPenaltyPoints(Integer.parseInt(candidates[3]));
            candidate.setFinalyPoint(Integer.parseInt(candidates[2])*100 + Integer.parseInt(candidates[3]));
            candidatesList.add(candidate);
        }
// прочитали ввод и закрыли
        reader.close();
        long time = System.currentTimeMillis();
//        ------ Начинаем выбирать ---------
// на каждую вакансию было предложено 6 задач одинаковой ценности.
        List<String> outListCandidates = new ArrayList<>();

        for (int i = 0; i < numberOfVacancies; i++) {

            String nameVacancies = vacanciesList.get(i).getNameVacancies();
            int numberVacancies = vacanciesList.get(i).getNumberCandidates();
// ceo,1
            List<Candidate> listOfSelected = candidatesList.stream().filter(
                    s -> s.getVacancies().equals(nameVacancies))
                    .sorted(
                            Comparator.comparing(
                                    Candidate::getFinalyPoint)
//                                    .reversed()
////                            При равенстве количества решенных задач кандидаты сравниваются по целочисленному штрафу
////                            - — чем он меньше, тем выше приоритет у кандидата.
//                                    .thenComparing(Candidate::getPenaltyPoints)
                    )
                    .limit(numberVacancies)
                    .collect(Collectors.toList());
            System.out.println(listOfSelected.toString());
            for (Candidate candidate : listOfSelected) {
                outListCandidates.add(candidate.getName());
            }

        }
        System.out.println("time - " + (System.currentTimeMillis() - time));


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
        private int finalyPoint;

        public int getFinalyPoint() {
            return finalyPoint;
        }

        public void setFinalyPoint(int finalyPoint) {
            this.finalyPoint = finalyPoint;
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
                    ", finalyPoint=" + finalyPoint +
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