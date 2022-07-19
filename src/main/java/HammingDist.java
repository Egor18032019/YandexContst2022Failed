import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HammingDist {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        String [] line = firstLine.split(" ");
        int points = Integer.parseInt(line[0]);
        int count = Integer.parseInt(line[1]);
        List<int[]> arrRec = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] stroke = reader.readLine().trim().split(" ");
            String[] strokeF = stroke[0].trim().split("");
            String[] strokeS = stroke[0].trim().split("");

            for (int a = 0; a < points; a++) {
                int x = Integer.parseInt(strokeF[0]);
                int y = Integer.parseInt(strokeS[1]);
                System.out.println( hammingDistance(x,y));
            }
        }


    }


    public static int hammingDistance(int x, int y) {
        if(x == y) { return 0; }
        // Это суждение очень важно, оно может сэкономить большую часть памяти и повысить эффективность
        return Integer.bitCount(x^y);
    }
}
/*
Расстояние Хэмминга (кодовое расстояние) — число позиций,
в которых соответствующие символы двух слов одинаковой длины различны.
В более общем случае расстояние Хэмминга применяется для строк одинаковой длины любых q-ичных алфавитов
 и служит метрикой различия (функцией, определяющей расстояние в метрическом пространстве) объектов одинаковой размерности.

01000 00110
01100
 */