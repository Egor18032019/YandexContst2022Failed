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
        Map<Integer, Integer> workBook = new HashMap<>();
        Map<Integer, Integer> workBookForDiff = new HashMap<>();
        for (int i = 0; i <count; i++) {
            String[] stroke = reader.readLine().trim().split(" ");
//            System.out.println(i);
//            System.out.println(Arrays.toString(stroke));
            if (stroke[0].equals("1")) {
                int key = Integer.parseInt(stroke[3]);
                int values = Integer.parseInt(stroke[1]);
                int difference = Integer.parseInt(stroke[2]);
                workBook.put(key, values);
                workBookForDiff.put(key, difference);
                continue;
            }
            if (stroke[0].equals("2")) {
                int keyForRemove = Integer.parseInt(stroke[1]);
                workBook.remove(keyForRemove);
                continue;
            }
            if (stroke[0].equals("3")) {
                // найти и вывести меньший элемент в консоль
                int min = Collections.min(workBook.values());
//                System.out.println("min");
                System.out.println(min);
                Integer key = getKeytoValue(workBook, min);
                int newValues = workBook.get(key) + workBookForDiff.get(key);
                workBook.put(key, newValues);
                // Если таких прогрессий несколько,
                // то обрабатывается прогрессия, у которой минимальный идентификатор.
            } else {
                System.out.println("Что тут такое ?");
                System.out.println(Arrays.toString(stroke));
            }
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
