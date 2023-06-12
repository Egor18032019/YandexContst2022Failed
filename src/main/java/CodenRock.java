import java.util.Scanner;

public class CodenRock {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        while (sc.hasNextLine()) { // get the input
            // your code
            char[] line = sc.nextLine().toCharArray();
            StringBuilder response = new StringBuilder();
response.append(line).append("→");
            int pozition = 0;
            for (int i = 0; i < line.length; i++) {
                int count = 1;
                char point = line[i];
                if ((i + 1) >= line.length) {
                    response.append(",");
                    response.append(count);
                    response.append(point);
                    break;
                }
                for (int q = i + 1; q < line.length; q++) {
                    if (line[q] == point) {
                        count++;
                    } else {
                        i = q-1;
                        break;
                    }
                }
                if (pozition != 0) {
                    response.append(",");
                }
                response.append(count);
                response.append(point);
                pozition = 2;
            }


            System.out.println(response);

        }
    }
}