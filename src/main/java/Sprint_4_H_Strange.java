import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_4_H_Strange {
    private static BufferedReader reader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {

        Map<Character, Character> storage = new HashMap<>();
        Map<Character, Character> storageReverse = new HashMap<>();
        char[] first = reader.readLine().toCharArray();
        char[] second = reader.readLine().toCharArray();
        int length = first.length;
        if (first.length != second.length) {
            System.out.println("NO");
            return;
        }
        Set<Character> units = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char firstPoint = first[i];
            char secondPoint = second[i];
            if (!storage.containsKey(firstPoint) && !storageReverse.containsKey(secondPoint)) {
                storage.put(firstPoint, secondPoint);
                storageReverse.put(secondPoint, firstPoint);
            } else {
                if (storage.containsKey(firstPoint) && storageReverse.containsKey(secondPoint)) {
                    if (storage.get(firstPoint) ==secondPoint) {

                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    System.out.println("NO");
                    return;
                }

            }
        }
        System.out.println("Yes");
    }
}
/*
agg
xdd

agg
xda

agg
xdx

zxcvbnm
asdfghj
 */