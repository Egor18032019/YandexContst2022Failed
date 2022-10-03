import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WalkIdeal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        final String firstLine = reader.readLine();

        String stroke = firstLine.replaceAll("[A-Za-zА-Яа-я-+-=-\\s]", "");
        reader.close();
        if (stroke.isEmpty()) {
//            System.out.println("Нет скобок");
            System.out.println(-1);
            return;
        }


        String typeBracket = giveMeRightStroke(stroke);
        if (typeBracket.length() > 1) {
//            System.out.println("одной скобкой не обойдешься");
            System.out.println(-1);
            return;
        }

        // теперь бежим по строке и ищем  скобку по индексу
        int curentIndexForFirstLine = firstLine.indexOf(typeBracket);
        char[] arrCharStringForFirstLine = firstLine.toCharArray();

        for (int i = 0; i < firstLine.length(); i++) {
            boolean isWalk;
            if (typeBracket.equals("}")) {
                isWalk = arrCharStringForFirstLine[i] == '}';
            } else {
                isWalk = arrCharStringForFirstLine[i] == '{';
            }
            if (!isWalk) continue;
            String workedFirstLine = firstLine.substring(0, i) + firstLine.substring(i + 1);

            String workedStroke = workedFirstLine.replaceAll("[A-Za-zА-Яа-я-+-=-\\s]", "");

            boolean isindexWell = giveMeRightStroke(workedStroke).length() == 0;
            if (isindexWell) {
                curentIndexForFirstLine = i;
                break;
            }
        }
// ()()()(())(()()
//        System.out.println("curentIndexForFirstLine");
        System.out.println(curentIndexForFirstLine + 1);

    }

    public static String giveMeRightStroke(String stroke) {
        String lastIteration = stroke;
        String currentIteration = stroke;
        do {
            lastIteration = currentIteration;
            currentIteration = lastIteration.replace("{}", "");
        } while (currentIteration.length() < lastIteration.length());

        return currentIteration;
    }

    public static String giveMeStroke(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //+, −, ∗, ∕, =;
            if (s.charAt(i) == '+') {
                continue;
            }
            if (s.charAt(i) == '-') {
                continue;
            }
            if (s.charAt(i) == '*') {
                continue;
            }
            if (s.charAt(i) == '/') {
                continue;
            }
            if (s.charAt(i) == '=') {
                continue;
            }
            if (s.charAt(i) == ' ') {
                continue;
            }

            boolean isSkobka = !Character.isLetterOrDigit(s.charAt(i));
            if (isSkobka)
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
