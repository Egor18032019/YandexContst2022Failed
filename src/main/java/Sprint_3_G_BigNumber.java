import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_3_G_BigNumber {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().split(" ");
            sort(array);
            for (int i = 0; i < n; i++) {
                System.out.print(array[i]);
            }
        }
    }

    public static void sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String itemToInsert = array[i];
            int j = i;
            while (j > 0 && compare(itemToInsert, array[j - 1])) {
                // если itemToInsert больше чем предыдущие , то меняем их местами
                array[j] = array[j - 1];
                j--;
            }
            array[j] = itemToInsert;
        }
    }

    public static boolean compare(String first, String second) {
        /*
        Если первая строка + вторая строка больше чем вторая строка + первая строка
        Причем .compareTo сравнивает так=> this.charAt(k)-другая строка.charAt(k)
        и чтобы получить булеан сравниваю с нулем
строки складываю чтобы одиноквая длина была
         */
        return first.concat(second).compareTo(second.concat(first)) > 0;
    }
}
/*
3
15 56 2
=56215

3
1 783 2
=78321

3
3 150 77
==773150
 */