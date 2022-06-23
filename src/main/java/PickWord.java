
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
        in.close();
//        --- начали проверку--
        long time = System.currentTimeMillis();

        if (word.trim().isEmpty() || attempt.trim().isEmpty()) {
            System.out.println("correct");
        }

        char[] wordToArray = word.toCharArray();
        char[] attemptToArray = attempt.toCharArray();

        int lengthWord = wordToArray.length;

        String[] output = new String[lengthWord];

        for (int i = 0; i < lengthWord; i++) {
            if (wordToArray[i] == attemptToArray[i]) {
                output[i] = "correct";
                wordToArray[i] = '*';
                attemptToArray[i] = '*';
            }
        }
//              BBA wordToArray
//              A AA attemptToArray
//              * O  V ER wordToArray
//              * L  E AR attemptToArray

//                A *   CBC wordToArray
//                B * A CA attemptToArray
        for (int j = 0; j < lengthWord; j++) {
            if (attemptToArray[j] != '*') {
                for (int k = 0; k < lengthWord; k++) {
                    if (wordToArray[k] == '*') continue;
                    boolean isPresent = attemptToArray[j] == wordToArray[k];
                    if (isPresent) {
                        output[j] = "present";
                        wordToArray[k] = '*';
                        attemptToArray[j] = '*';
                        break;
//                        Каждую букву строки S можно использовать не более чем в одном совпадении типа correct или present.
                    }
                }
            }
            if (output[j] == null) {
                output[j] = "absent";
            }

            System.out.println(output[j]);
        }
        System.out.println("time - " + (System.currentTimeMillis() - time));
    }
}


