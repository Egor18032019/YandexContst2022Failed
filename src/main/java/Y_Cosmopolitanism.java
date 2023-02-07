import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Y_Cosmopolitanism {
    private static BufferedReader reader = null;
    public static int N;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> mapForProfit = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            int minProfit = Integer.parseInt(stringTokenizer.nextToken());
            mapForProfit.put(i, minProfit);
        }
        Map<Integer, String> mapForSchool = new HashMap<>();
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            String school = stringTokenizer.nextToken();
            mapForSchool.put(i, school);
        }
        Map<Integer, Boolean> mapForCrossing = new HashMap<>();
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            Boolean crossing = stringTokenizer.nextToken().equals("1");
            mapForCrossing.put(i, crossing);
        }


        int mans = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> MansMoney = new HashMap<>();
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= mans; i++) {
            int money = Integer.parseInt(stringTokenizer.nextToken());
            MansMoney.put(i, money);
        }
        Map<Integer, String> MansSchool = new HashMap<>();
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= mans; i++) {
            String school = stringTokenizer.nextToken();
            MansSchool.put(i, school);
        }
        Map<Integer, Integer> MansNations = new HashMap<>();
        stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= mans; i++) {
            int national = Integer.parseInt(stringTokenizer.nextToken());
            MansNations.put(i, national);
        }


        for (int i = 1; i <= mans; i++) {
            Map<Integer, Integer> myRatingCountry = new HashMap<>();
            for (int q = 1; q <= N; q++) {
                myRatingCountry.put(q, 0);
            }
            int nation = MansNations.get(i);
            if (nation != 0) {
                boolean canCrossing = mapForCrossing.get(nation);
                if (canCrossing) {
                    int value = myRatingCountry.get(nation) + 1;
                    myRatingCountry.put(nation, value);
                }
            }

            int myMoney = MansMoney.get(i);
            String mySchool = MansSchool.get(i);
            for (int q = 1; q <= N; q++) {
                String heySchool = mapForSchool.get(q);
                if (heySchool.equals("0")) {
// проверяем доходы
                    int needMoney = mapForProfit.get(q);
                    if (myMoney >= needMoney) {
                        int value = myRatingCountry.get(q) + 1;
                        // проверить образование
                        myRatingCountry.put(q, value);
                    }
                } else {
                    if (heySchool.equals(mySchool)) { // 0 0  or 1 1
                        int needMoney = mapForProfit.get(q);
                        if (myMoney >= needMoney) {
                            int value = myRatingCountry.get(q) + 1;
                            // проверить образование
                            myRatingCountry.put(q, value);
                        }
                    }
                }
            }

            Integer maxKey = 0;
            for (Integer key : myRatingCountry.keySet()) {
                if (myRatingCountry.get(key) == 0) continue;
                if (maxKey == 0 || myRatingCountry.get(key) > myRatingCountry.get(maxKey)) {
                    maxKey = key;
                }
            }

            System.out.println(maxKey);
        }


    }
}
