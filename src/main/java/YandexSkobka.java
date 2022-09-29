import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YandexSkobka {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
// )()()()()

    private static void run() throws IOException {
        final char[] firstLine = bufferedReader.readLine().toCharArray();
        Map<Integer, Character> primer = new HashMap<>();
        for (int i = 0; i < firstLine.length; i++) {
            primer.put(i, firstLine[i]);
        }
        bufferedReader.close();
        Map<Integer, Character> onlySkobki = new HashMap<>();
        List<Integer> keys = new ArrayList<Integer>();
        for (int i = 0; i < primer.size(); i++) {
            char value = primer.get(i);
            if (value == '{' || value == '}') {
                onlySkobki.put(i, value);
                keys.add(i);
            }
        }
//        System.out.println(keys);

        if (onlySkobki.isEmpty()) {
//            System.out.println("Нет скобок");
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < keys.size(); i++) {
            StringBuilder str = new StringBuilder();
            int current = keys.get(i);
            for (int z = 0; z < keys.size(); z++) {
                int keyForSkobka = keys.get(z);
                if (keyForSkobka == current) continue;
                str.append(onlySkobki.get(keyForSkobka));
            }
            boolean rightSkobka = isRightSkobka(String.valueOf(str));
            if (rightSkobka) {
                System.out.println(current + 1);
                return;
            }
        }
        System.out.println(-1);
    }


    public static boolean isRightSkobka(String stroke) {
        String lastIteration = stroke;
        String currentIteration = stroke;
        do {
            lastIteration = currentIteration;
            // replaceALL ???
            currentIteration = lastIteration.replace("{}", "");
        } while (currentIteration.length() < lastIteration.length());

        return currentIteration.length() == 0;
    }


}
