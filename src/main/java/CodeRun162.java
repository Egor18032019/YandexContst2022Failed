import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeRun162 {
    private static BufferedReader reader = null;
    private static BufferedWriter writer = null;
    public static int N; //число
    public static int K; //  количество операций

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }

    private static void run() throws IOException {

        String[] arr = reader.readLine().split("");
        K = Integer.parseInt(reader.readLine());
        N = arr.length;
        List<String> list = recursionCombinations(new ArrayList<>(), arr, "", false, N);
        System.out.println(list);
//У Саши есть три любимых числа: 5,6,10.

    }

    // Функция для генерации комбинаций
    /*
List<String> list - лист, в который будут записываться комбинации
String[] array - массив, из чего лепить комбинации
String line - по умолчанию передавай "". Это переменная-помощник для рекурсии;
boolean duplicate - использовать ли повторения элементов (
допустим есть 1 2 без повторов 1 2 и 2 1
с повтором 1 1, 1 2, 2 2, 2 1
     */
    private static List<String> recursionCombinations(List<String> list, String[] array, String line, boolean duplicate, int length) {
        if (list != null && array != null && line != null) {
            if (length == 0) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(line.trim());
                }
            } else {
                for (int index = 0; index < array.length; index++) {
                    String[] nextArray = duplicate ? array : removeElementToArray(array, index);
                    String nextLine = line.concat(array[index]);
                    list = recursionCombinations(list, nextArray, nextLine, duplicate, length - 1);
                }
            }
        }
        return list;
    }

    private static <E> E[] removeElementToArray(E[] array, int index) {
        E[] result = array.clone();
        if (index < result.length - 1) {
            System.arraycopy(result, index + 1, result, index, result.length - index - 1);
        }
        return Arrays.copyOf(result, result.length - 1);
    }
}
