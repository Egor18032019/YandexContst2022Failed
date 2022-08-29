import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Draft {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        String seckondLine = reader.readLine();
        reader.close();
        int first = Integer.parseInt(firstLine);
        int seckond = Integer.parseInt(seckondLine);
        System.out.println(first + seckond);

        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        System.out.println(i1 + i2);
        int k = 0;
        for (int i = 0; i < 10; i++) {
            k = k++;
        }
        System.out.println(k);

        List<String> numbers = new ArrayList(Arrays.asList("first", "second", "third"));
        for (String number : numbers) {
            if ("third".equals(number)) {
                numbers.add("fourth");
            }
        }
        System.out.println(numbers.size());
    }



}
