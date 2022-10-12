import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class InterestingPari {
    static BufferedReader reader = null;
    public static int n;
    public static Map<Integer, byte[]> storage;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        storage = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            byte[] line = reader.readLine().getBytes();
            storage.put(i, line);
        }

        // сложили всё в хранилище
        /*
        Проходим циклами по хранилищу и сравниваем различия
         */
        int interesting = 0;
        for (int x = 1; x <= n; x++) {
            byte[] foo = storage.get(x);
            for (int z = 1; z <= n; z++) {
                if (z <= x) continue;
                byte[] point = storage.get(z);
                int intFlag = 0;
                for (int i = 0; i < point.length; i++) {
                    //TODO спросить
                    if (point.length != foo.length) break;
                    byte f = foo[i];
                    byte p = point[i];
                    if (f == p) {
                        continue;
                    } else {
                        // 0 начало \ 1 стало интересно \ 3 было интересно \ 4 неинтересно
                        if (intFlag == 1) {
                            intFlag = 4;
                            break;
                        }
                        intFlag = 1;
                    }
                }
                // и point всё хорошо ++
                if (intFlag == 1) interesting++;
            }
// нашли же уже все пары то удаяем
            storage.remove(x);
        }
        System.out.println(interesting);
    }
}
/*
3
aaa
BBB
abb


 */