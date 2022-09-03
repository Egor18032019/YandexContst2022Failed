import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class YandexShifr {
    private static BufferedReader bufferedReader = null;
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();


    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String firstLine = bufferedReader.readLine();
        int shifr = Integer.parseInt(firstLine);

        for (int i = 0; i < shifr; i++) {
            String[] line = bufferedReader.readLine().split(",");
            int countFIO = giveMeCountFIO(line[0], line[1], line[2]);

            int sumDaysAndMonth = giveMeSumDaysAndMonth(line[3], line[4]);

            int indexFirst = fistWordIndex(line[0]);
            //Полученные числа суммируются.
            int sum = countFIO + sumDaysAndMonth + indexFirst;

            System.out.print(giveMeAnotherSystem(sum) + " ");
        }
        bufferedReader.close();
    }

    public static int giveMeCountFIO(String f, String name, String o) {
        //Подсчитывается количество различных символов в ФИО (регистр важен, А и а — разные символы
//            Volozh Arcady Yurievich -> 16
        Set<Character> foo = new HashSet<>();
        int count = 0;
        char[] fArr = f.toCharArray();
        for (char w : fArr) {
            if (foo.add(w)) {
                count++;
            }
        }
        char[] nameArr = name.toCharArray();
        for (char n : nameArr) {
            if (foo.add(n)) {
                count++;
            }
        }
        char[] oArr = o.toCharArray();
        for (char t : oArr) {
            if (foo.add(t)) {
                count++;
            }
        }
        return count;
    }

    public static int giveMeSumDaysAndMonth(String day, String month) {
//Берётся сумма цифр в дне и месяце рождения, умноженная на 64.
        String[] days = day.split("");
        int sumDays = 0;
        for (String d : days) {
            sumDays = sumDays + Integer.parseInt(d);
        }
        String[] months = month.split("");
        int sumMonths = 0;
        for (String m : months) {
            sumMonths = sumMonths + Integer.parseInt(m);
        }
        return (sumDays + sumMonths) * 64;
    }

    public static int fistWordIndex(String a) {
        char foo = a.toLowerCase().charAt(0);
//        Для первой (по позиции в слове) буквы фамилии определяется её номер в алфавите (в 1-индексации), умноженный на 256 (регистр буквы не важен).
        int contA = 0;
        for (char q : alphabet) {
            contA++;
            if (foo == q) {
                break;
            }
        }
        return contA * 256;
    }

    public static String giveMeAnotherSystem(int sum) {
        String answer = Integer.toHexString(sum);


        return answer.substring(1).toUpperCase();
    }
}
/*

50 7 25 3632 A
50 7 26 3632 C

14 21 30 3632 A
14 23 52 3632 B
15 0   5 3632 C

14 21 30 212372 A
14 21 40 212372 B
14 23 52 212372 S

- 10+20 +60 +52 = 142

 */