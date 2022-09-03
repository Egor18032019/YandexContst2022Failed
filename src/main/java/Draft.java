import java.util.Scanner;

public class Draft {
    public static void main(String[] args) {

        Scanner bufferedReader = new Scanner(System.in);
        String f1 = bufferedReader.nextLine();
        String s2 = bufferedReader.nextLine();
        bufferedReader.close();
        char[] firstLine = f1.toCharArray();
        char[] secondLine = s2.toCharArray();

        int length = firstLine.length;
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            if (firstLine[i] == secondLine[i]) {
                answer[i] = "P";
                firstLine[i] = '*';
                secondLine[i] = '*';
            }
        }
        for (int s = 0; s < length; s++) {
            if (secondLine[s] != '*') {
                for (int f = 0; f < length; f++) {
                    if (firstLine[f] == '*') {
                        continue;
                    }
                    if (firstLine[f] == secondLine[s]) {
                        answer[s] = "S";
                        firstLine[f] = '*';
                        break;
                    }
                }
            }
            if (answer[s] == null) {
                answer[s] = "I";
            }
            System.out.print(answer[s]);
        }
    }
}