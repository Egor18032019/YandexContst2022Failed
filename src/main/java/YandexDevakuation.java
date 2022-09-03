import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YandexDevakuation {
    static char[][] field;
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] f1 = bufferedReader.readLine().split(" ");
        int stroke = Integer.parseInt(f1[0]); // 5
        int stolbs = Integer.parseInt(f1[1]);  // 8
        //Создали  многомерный массив
        field = new char[stroke][stolbs];
        boolean[] hasSlashesInStroke = new boolean[stroke];
        int XforS = 0;
        int YforS = 0;
// а если не брать 1 и и последнию ?
        for (int i = 0; i < stroke; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < stolbs; j++) {
                char c = line[j];

                if (c == 'S') {
                    XforS = j;
                    YforS = i;
                }
                field[i][j] = c;
            }
        }

        // заполнили и узнали где S
        bufferedReader.close();
        write(YforS, XforS);

        System.out.println(Arrays.deepToString(field));
    }

    public static void write(int y, int x) {
        System.out.println(field[0].length + " " + field.length);
        System.out.println(x + " " + y);
        if (x == 0 || x == field[0].length - 1 || y == 0 || y == field.length - 1) {
            return;
        }
        // смотрим по сторонам
        // up
        if (field[y - 1][x] == '.') {
            field[y - 1][x] = 'D';
            int vverx = y - 1;
            if (vverx > 0) {
                write(vverx, x);
            }
        }
        //bottom
        if (field[y + 1][x] == '.') {
            field[y + 1][x] = 'U';
            int bottom = y + 1;
            if (bottom < field[0].length - 1) {

                write(bottom, x);
            }
        }
        // right
        if (field[y][x + 1] == '.') {
            field[y][x + 1] = 'L';
            int right = x + 1;
            if (right < field[0].length - 1) {
                write(y, right);
            }
        }

        // left
        if (field[y][x - 1] == '.') {
            field[y][x - 1] = 'R';
            int left = x - 1;
            if (left > 0) {
                write(y, left);
            }
        }
    }
}
