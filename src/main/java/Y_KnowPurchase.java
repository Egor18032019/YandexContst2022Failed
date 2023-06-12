import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Y_KnowPurchase {
    private static BufferedReader reader = null;
    public static int N; // количество дней в исторических данных.


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        int startSum = 1;
        N = Integer.parseInt(reader.readLine());


        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine()); // цена одной акции Тындекса в рублях в
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        List<Integer> first = getMaxDiff(list);
        System.out.println(first);
        List<Integer> two = getMaxDiff(list);
        System.out.println(two);
        List<Integer> three = getMaxDiff(list);
        System.out.println(three);
        List<Integer> four = getMaxDiff(list);
        System.out.println(four);
    }

    // таки и не понял как так сделать
    public static List<Integer> getMaxDiff(List<Integer> list) {
        int diff = Integer.MIN_VALUE;
        int n = list.size();

        if (n == 0) {
            return null;
        }
        int max_so_far = list.get(n - 1);
        int last = n - 1;

        List<Integer> arr = new ArrayList<>();
        arr.add(null);
        arr.add(last);
        // обход массива справа и отслеживание максимального элемента
        for (int i = n - 2; i >= 0; i--) {
            // обновить `max_so_far`, если текущий элемент больше, чем
            // максимальный элемент
            if (list.get(i) == null) continue;
            if (list.get(i) >= max_so_far) {
                max_so_far = list.get(i);
                last = i;
            }
            // если текущий элемент меньше максимального элемента,
            // затем обновить разницу, если требуется
            else {
                if (diff < (max_so_far - list.get(i))) {
                    diff = max_so_far - list.get(i);
                    arr.remove(0);
                    arr.add(0, i);
                    arr.remove(1);
                    arr.add(1, last);
                }
            }
        }

        if (arr.get(0) != null) {
            int index = arr.get(0);
            list.set(index, null);
            index = arr.get(1);
            list.set(index, null);
            return arr;
        } else {
            return null;
        }
    }
}
//            int b = Integer.parseInt(stringTokenizer.nextToken()); // день покупки
//            int s = Integer.parseInt(stringTokenizer.nextToken()); // день продажи
