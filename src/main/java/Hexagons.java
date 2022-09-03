
import java.util.Scanner;

public class Hexagons {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        String[] first = reader.nextLine().trim().split(" ");
        int height = Integer.parseInt(first[0]);
        int width = Integer.parseInt(first[1]);
        //Создали  многомерный массив
        char[][] field = new char[height][width];
        boolean[] hasSlashesInStroke = new boolean[width];
        // читаем и сразу заполняем двумерный массив сверху.
        // то есть переворачиваем по вертикали

        for (int i = 0; i < height; i++) {
            char[] line = reader.nextLine().toCharArray();

            for (int j = 0; j < width; j++) {
                char c = line[j];
                if (c == '\\' || c == '/') {
                    hasSlashesInStroke[j] = true;
                    // массив который показывает на каких местах по горизонтале есть //\\
                }
                field[height - 1 - i][width - 1 - j] = c;
            }
        }
        // Данные получили + заодно и перевернули и реадер закрыли
        reader.close();
        System.out.println("gorizont");
        for (char[] line : field) {
            System.out.println(line);
        }

        // отражаем по вертикали
        char savers;
        for (int gorizont = 0; gorizont < width; gorizont++) {
            if (!hasSlashesInStroke[gorizont]) {
                continue;
            }
            for (int vertical = height - 1; vertical >= 1; vertical--) {
                savers = field[vertical][gorizont];
                field[vertical][gorizont] = field[vertical - 1][gorizont];
                field[vertical - 1][gorizont] = savers;
                // если на этих местах есть \\/ то опускаем их в низ
            }
        }


        System.out.println("vert");
        for (char[] line : field) {
            System.out.println(line);
        }
    }
}
/*
5 8
########
#......#
#.#S#.##
##...###
########

 */
