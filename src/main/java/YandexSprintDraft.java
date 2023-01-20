import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class YandexSprintDraft {
    private static BufferedReader reader = null;
    public static int n;
    public static int m;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= n; i++) {
//            Map<Integer, Integer> storage = new HashMap<>();
            List<int[]> storage = new ArrayList<>();
            stringTokenizer = new StringTokenizer(reader.readLine());
            stringTokenizer = new StringTokenizer(reader.readLine());

            int rows = Integer.parseInt(stringTokenizer.nextToken());
            int columns = Integer.parseInt(stringTokenizer.nextToken());
            if(rows==3&&columns==3){
                System.out.println();
            }
            for (int r = 1; r <= rows; r++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int[] arr = new int[columns];
                for (int c = 0; c < columns; c++) {
                    arr[c] = Integer.parseInt(stringTokenizer.nextToken());
                }
                storage.add(arr);
            }

            stringTokenizer = new StringTokenizer(reader.readLine());
            int click = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(reader.readLine());
            if(click==5){
                System.out.println();
            }
            for (int q = 1; q <= click; q++) {
                int colum = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                quickSort(storage, 0, storage.size() - 1, colum);
            }

            for (int[] point : storage) {
                System.out.println(Arrays.toString(point));
            }
            System.out.println();
        }
    }

    public static void quickSort(List<int[]> sortArr, int low, int high, int colum) {
        //завершить, если массив пуст или уже нечего делить
        if (sortArr.size() == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr.get(middle)[colum];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr.get(i)[colum] < border) i++;
            while (sortArr.get(j)[colum] > border) j--;
            if (i <= j) {
                int[] swapI = sortArr.get(i);
                int[] swapJ = sortArr.get(j);
                sortArr.remove(i);
                sortArr.add(i, swapJ);
                sortArr.remove(j);
                sortArr.add(j, swapI);
                i++;
                j--;
            }
        }
        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j, colum);
        if (high > i) quickSort(sortArr, i, high, colum);
    }
}
/*
3  количество наборов входных данных.

4 3    количество строк и столбцов в таблице.
3 4 1
2 2 5
2 4 2
2 2 1
3       количество кликов.
2 1 3 номера столбцов, по которым были осуществлены клики. Клики даны в порядке их совершения.

3 1
100
9
10
2
1 1

3 3
2 11 72
99 11 13
2 8 13
5
2 3 2 1 2

int sumForPay = 0;
            for (Map.Entry<Integer, Integer> entry : storage.entrySet()) {
                int price = entry.getKey();
                int count = entry.getValue();
                int o = count % 3;
                int kit = (count - o) / 3;
                sumForPay = sumForPay + ((2 * kit) + o) * price;
            }

         Map<Integer, Integer> result = new LinkedHashMap<>();
            storage.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue() )
                    .forEach(entry -> result.put(entry.getKey(), entry.getValue()));


 */