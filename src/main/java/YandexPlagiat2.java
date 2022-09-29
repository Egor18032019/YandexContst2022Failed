import java.util.HashMap;
import java.util.Scanner;

public class YandexPlagiat2 {
    public static void solution() {
        Scanner scan = new Scanner(System.in);
        char[] first = scan.next().toCharArray();
        char[] second = scan.next().toCharArray();
        char[] res = new char[first.length];

        HashMap<Character, Integer> map = new HashMap<>();
        // Загоняем в мапу и если есть повторы то увеличиваем счетчик
        for (char c : first) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.replace(c, map.get(c) + 1);
        }
        // вторым циклом бежим и ищем P
        for (int i = 0; i < first.length; i++) {
            if (first[i] == second[i]) {

                res[i] = 'P';
                map.replace(second[i], map.get(second[i]) - 1);
            }
        }
// третьим циклом
        for (int i = 0; i < first.length; i++) {
            // если в результирующем массиве что то есть то идём дальше
            if (res[i] != 0) continue;
            // если в мапе есть такая буква и её ключ не равен нулю то
            // res добавляем S а ключ уменьшаем на 1
            if (map.containsKey(second[i]) && map.get(second[i]) != 0) {
                res[i] = 'S';
                map.replace(second[i], map.get(second[i]) - 1);
            } else res[i] = 'I';
        }

        for (char r : res) {
            System.out.print(r);
        }
    }
}
