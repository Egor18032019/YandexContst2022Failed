import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class i10n {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        int count = Integer.parseInt(firstLine);
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            String stroke = reader.readLine().trim();
            words[i] = stroke;
        }
        reader.close();

        Map<String, Integer> workBook = new HashMap<>();
        Map<String, Integer> saveWorkBook = new HashMap<>();
//        Map<String, Integer> workBook = new TreeMap<>( );
        for (int iterator = 0; iterator < count; iterator++) {
            String word = words[iterator];
            int start = 1;
            int end = word.length() - 1;
            rec(workBook, start, end, iterator, words, saveWorkBook);
        }
/*
4
aaaaa
aabaa
aacaa
aavaa
 */
//        System.out.println(workBook.toString());
        workBook.entrySet()
                .stream()
                .sorted(
//                        Map.Entry.<String, Integer>comparingByValue().reversed()
                        Map.Entry.comparingByValue()
                )
                .forEach(e -> System.out.println(e.getKey()));
    }

    public static void rec(Map<String, Integer> workBook, int start, int end, int iterator,
                           String[] words, Map<String, Integer> saveWorkBook) {

        String word = words[iterator];
        int wordLength = end - start;
        String bar = word.substring(0, start) + wordLength + word.substring(end);
        boolean isKeyUse = !saveWorkBook.containsKey(bar);
        if (isKeyUse) {
            workBook.put(bar, iterator);
            saveWorkBook.put(bar, iterator);
        } else {
            if (workBook.containsKey(bar)) {
                int index= workBook.get(bar);
                workBook.remove(bar);
                start++;
                end--;
                String key = words[index];
                boolean isMiddle = end - start <= 0;
                if (isMiddle) {
                    workBook.put(key, index);
                    workBook.put(word, iterator);
                    saveWorkBook.put(key, index);
                    saveWorkBook.put(word, iterator);
                } else {
                    rec(workBook, start, end, index, words, saveWorkBook);
                    rec(workBook, start, end, iterator, words, saveWorkBook);
                }
            } else {
                start++;
                end--;
                boolean isMiddle = end - start <= 0;
                if (isMiddle) {
                     workBook.put(word, iterator);
                     saveWorkBook.put(word, iterator);
                } else {
                     rec(workBook, start, end, iterator, words, saveWorkBook);
                }
             }
        }
    }
}
