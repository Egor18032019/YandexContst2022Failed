import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Arithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        int count = Integer.parseInt(firstLine);
        // Если таких прогрессий несколько,
        // то обрабатывается прогрессия, у которой минимальный идентификатор.
        Map<Integer, Integer> workBook = new TreeMap<>();
        Map<Integer, Integer> workBookForDiff = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] stroke = reader.readLine().trim().split(" ");

//            if (stroke[0].equals("1")) {
            if (stroke.length == 4) {
                Integer key = Integer.valueOf(stroke[3]);
                Integer values = Integer.valueOf(stroke[1]);
                Integer difference = Integer.valueOf(stroke[2]);
                workBook.put(key, values);
                workBookForDiff.put(key, difference);
                continue;
            }
            if (stroke.length == 2) {
                Integer keyForRemove = Integer.valueOf(stroke[1]);
                workBook.remove(keyForRemove);
                workBookForDiff.remove(keyForRemove);
                continue;
            }
//            if (stroke.length == 1) {
            // остальные случаи выше
            int min = Collections.min(workBook.values());
            //предварительно заменив стартовый элемент в прогрессии на следующей в ней.
            Integer key = getKeytoValue(workBook, min);
            int newValues = workBook.get(key) + workBookForDiff.get(key);
            workBook.put(key, newValues);
            // найти и вывести меньший элемент в консоль
            System.out.println(min);
        }
        reader.close();

    }

    public static Integer getKeytoValue(Map<Integer, Integer> map, Integer someValue) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(someValue))
                return entry.getKey();
        }
        return null;
    }


}
