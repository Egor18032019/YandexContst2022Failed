import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HammingDist {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = reader.readLine();
        String[] line = firstLine.split(" ");
        int points = Integer.parseInt(line[0]);
        int count = Integer.parseInt(line[1]);


        for (int i = 0; i < count; i++) {
            Map<String, Integer> storageForCount = new HashMap<>();
            Map<String, Integer> storage = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            String[] stroke = reader.readLine().trim().split(" ");
            String[] strokeF = stroke[0].trim().split("");
            String[] strokeS = stroke[1].trim().split("");
            int sumZero = 0;
            int sumOne = 0;
            for (int a = 0; a < points; a++) {
                String x = strokeF[a];
                String y = strokeS[a];
                if (x.equals("0")) sumZero++;
                if (x.equals("1")) sumOne++;
                if (y.equals("0")) sumZero++;
                if (y.equals("1")) sumOne++;
                storage.put(x, storage.getOrDefault(x, 0) + 1);
                storage.put(y, storage.getOrDefault(y, 0) + 1);
                boolean isZeroMore = (sumZero + storageForCount.getOrDefault("0", 0)) >= (sumOne + storageForCount.getOrDefault("1", 0));
                if (a == 2) {
                    System.out.println("here");
                }
                int valueZero = storageForCount.getOrDefault("0", 0);
                int valueOne = storageForCount.getOrDefault("1", 0);

                if (valueZero >= valueOne) {
                    if (storage.getOrDefault("1", 0) > 0) {
                        stringBuilder.append("1");
                        int value = storageForCount.getOrDefault("1", 0) + 1;
                        storageForCount.put("1", value);
                        int foo = storage.get("1") - 1;
                        storage.put("1", foo);
                    } else {
                        stringBuilder.append("0");
                        int value = storageForCount.getOrDefault("0", 0) + 1;
                        storageForCount.put("0", value);
                        int foo = storage.get("0") - 1;
                        storage.put("0", foo);
                    }

                } else {
                    if (storage.getOrDefault("0", 0) > 0) {
                        stringBuilder.append("0");
                        int value = storageForCount.getOrDefault("0", 0) + 1;
                        storageForCount.put("0", value);
                        int foo = storage.get("0") - 1;
                        storage.put("0", foo);


                    } else {
                        stringBuilder.append("1");
                        int value = storageForCount.getOrDefault("1", 0) + 1;
                        storageForCount.put("1", value);
                        int foo = storage.get("1") - 1;
                        storage.put("1", foo);
                    }
                }
            }
            System.out.println(stringBuilder);

        }


    }

}
/*
Расстояние Хэмминга (кодовое расстояние) — число позиций,
в которых соответствующие символы двух слов одинаковой длины различны.
В более общем случае расстояние Хэмминга применяется для строк одинаковой длины любых q-ичных алфавитов
 и служит метрикой различия (функцией, определяющей расстояние в метрическом пространстве) объектов
 одинаковой размерности.
x*y<=x*z + y*z


0z 1x 000
0z 0y 110
01100

01 0 00
01 1 00
001 10


--
11111
00000
01010
 */