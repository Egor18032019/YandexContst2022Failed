import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ComplexArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String stroke = reader.readLine().trim();
        reader.close();
        stroke = stroke.replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "");
        String[] foo = stroke.split(",");
        Map<String, Integer> workBook = new HashMap<>();
        int maxValue = 0;
        for (String s : foo) {
            if (workBook.containsKey(s)) {
                int values = workBook.get(s);
                values++;
                if (values>maxValue){
                maxValue = values;
                }
                workBook.put(s, values);
            } else {
                workBook.put(s, 0);
            }
        }

//        System.out.println(workBook.toString());
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : workBook.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                Integer point = Integer.valueOf(entry.getKey());
                answer.add(point);
            }
        }
        answer.sort(
                Comparator.comparingInt(a -> a)
        );
        for (Integer it : answer) {
            System.out.print(it + " ");
        }

    }
}
