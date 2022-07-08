import java.util.Scanner;

public class NumericalPuzzles {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String firstLine = reader.nextLine();
        int count = Integer.parseInt(firstLine);
//        String[] stroke = reader.nextLine().trim().split("");
        String doubles = reader.nextLine().trim();
        reader.close();
        System.out.println(mediana(count, doubles));
    }

    private static StringBuilder mediana(int count, String doubles) {
        StringBuilder result = new StringBuilder();
        int c0 = 0;
        int c1 = 0;

        for (int i = 0; i < count; i++) {
            if (doubles.charAt(i) == '0')
                c0++;
            else
                c1++;
            if (i == 0) result.append("-1");
            else if (doubles.charAt(i) == '0' && c0 > c1 && i!=(count-1))
                result.append(" ").append("1");
            else if (doubles.charAt(i) == '1' && c1 > c0 && i!=(count-1))
                result.append(" ").append("1");
            else if (i==1 &&c1 == c0)
                result.append(" ").append("-1");
            else
                for (int j = 0; j <= i - 1; j++) {
                    int cs0 = 0;
                    int cs1 = 0;
                    String subline = doubles.substring(j, i + 1);
                    for (int k = 0; k < subline.length(); k++) {
                        if (subline.charAt(k) == '0')
                            cs0++;
                        else
                            cs1++;
                    }
                    if (doubles.charAt(i) == '0' && cs0 > cs1) {
                        result.append(" ").append(j + 1);
                        break;
                    } else if (doubles.charAt(i) == '1' && cs1 > cs0) {
                        result.append(" ").append(j + 1);
                        break;
                    } else if (doubles.charAt(i) == '1' && cs1 < cs0) {
                        result.append(" ").append("-1");
                        break;
                    }
                    else if (doubles.charAt(i) == '0' && cs0 < cs1) {
                        result.append(" ").append("-1");
                        break;
                    }
                }
        }
        return result;
    }

}
