import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YandexAlchemy {
    private static BufferedReader bufferedReader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String firstLine = bufferedReader.readLine();
        int count = Integer.parseInt(firstLine);
        Map<Integer, int[]> slovar = new HashMap<>();
        int[] value = new int[2];
        // это А
        value[0] = 1;
        value[1] = 0;
        slovar.put(1, value);

        // это B
        value = new int[2];
        value[0] = 0;
        value[1] = 1;

        slovar.put(2, value);

        for (int i = 3; i <= count; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int[] valueNew = new int[2];

            int ingridients = Integer.parseInt(line[0]);
            for (int q = 1; q <= ingridients; q++) {
                Integer key = Integer.valueOf(line[q]);
                int[] bar = slovar.get(key);
//[0,1]
                if (bar != null) {
                    valueNew[0] = valueNew[0] + bar[0];
                    valueNew[1] = valueNew[1] + bar[1];

                } else {
                    valueNew[0] = 0;
                    valueNew[1] = 0;
                }
            }
            slovar.put(i, valueNew);
        }


        String zapros = bufferedReader.readLine();
        int countTiran = Integer.parseInt(zapros);
        for (int t = 0; t < countTiran; t++) {
            String[] line = bufferedReader.readLine().split(" ");
            Integer numberZelia = Integer.parseInt(line[2]);
            int countA = Integer.parseInt(line[0]);
            int countB = Integer.parseInt(line[1]);
            int[] v = slovar.get(numberZelia);
            if (v[0] == 0 && v[1] == 0) {
                System.out.print(0);
                continue;
            }
            if (v[0] <= countA && v[1] <= countB) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }

        }
    }
}
/*
7       общее количество ингредиентов и рецептов производных зелий

Зелья - 7-2=5
3 - 1 1 2 - зелье 3
2 - 1 3   - зелье 4
3 - 4 3 4 - зелье 5
1 - 7     - зелье 6
1 - 6     - зелье 7

3 - количество вопросов Тирании
A B
8 4     5
9 2     5
10 10   6



 */