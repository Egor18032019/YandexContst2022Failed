import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_4_G_Competiton {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] r = reader.readLine().split(" ");
            int sum = 0;
            HashMap<Integer, Integer> history = new HashMap<>();
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (r[i].equals("0")) {
                    sum -= 1;
                } else {
                    sum += 1;
                }

                if (sum == 0) {
                    result = i + 1;
                } else if (history.containsKey(sum)) {
                    result = Math.max(result, i - history.get(sum));
                    // длина минус -(дергаем из хранилища позицию на которой была такая разница,
                    // то есть от длины отнимаем номер позиции где наблюдалась уже такая сумма 0 и 1
                } else {
                    history.put(sum, i);
                    // складываем сумму и длину
                }
            }
            System.out.println(result);
        }
    }
}
/*
10
0 0 1 0 1 1 1 0 0 0

10
0 0 1 1 0 0 0 1 1 1

10
0 0 1 0 0 0 0 0 0 1
10
1 1 0 1 1 1 1 1 1 0
 */