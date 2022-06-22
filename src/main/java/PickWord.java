
import java.util.Scanner;

/*
COVER
CLEAR

correct
absent
present
absent
correct
 */
public class PickWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        String attempt = in.nextLine();
        if (word.trim().isEmpty() || attempt.trim().isEmpty()) {
            System.out.println("correct");
        }
        char[] wordToArray = word.toCharArray();
        char[] attemptToArray = attempt.toCharArray();

        int lengthWord = wordToArray.length;

        String[] output = new String[lengthWord];
        char[] wordToArrayAfterCorrect = new char[lengthWord];
        char[] attemptToArrayAfterCorrect = new char[lengthWord];
// пробежали циклом и сравнили каждый знак
        for (int i = 0; i < lengthWord; i++) {
            if (wordToArray[i] == attemptToArray[i]) {
                output[i] = "correct";
            } else {
                wordToArrayAfterCorrect[i] = wordToArray[i];
                attemptToArrayAfterCorrect[i] = attemptToArray[i];

            }
        }
/*
+OVE+
+LEV+

correct
        absent
    present
        absent
correct
 */
//        System.out.println(wordToArrayAfterCorrect);
//        System.out.println(attemptToArrayAfterCorrect);

        for (int i = 0; i < lengthWord; i++) {
            for (int j = 0; j < lengthWord; j++) {

                if (attemptToArrayAfterCorrect[i] != 0) {
                    if (attemptToArrayAfterCorrect[i] == wordToArrayAfterCorrect[j]) {
                        output[i] = "present";
                        wordToArrayAfterCorrect[j]=0;
                        break;
//                        Каждую букву строки S можно использовать не более чем в одном совпадении типа correct или present.
                    }
                }

            }

            if (output[i] == null) {
                output[i] = "absent";
            }
            System.out.println(output[i]);
        }
    }


}