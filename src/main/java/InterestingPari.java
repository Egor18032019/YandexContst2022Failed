import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class InterestingPari {
    static BufferedReader reader = null;
    public static int n;
    public static Map<Integer, byte[]> storage;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }
    /*
    другое решение
    вложить всё в двухмерный массив
    и бежать по нему циклом
    сравнивая и потом заменяя
    aaa
    BBB
    abb
     */


    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        storage = new HashMap<>();
        HashSet<byte[]> unique = new HashSet<byte[]>();
        for (int i = 1; i <= n; i++) {
            byte[] line = reader.readLine().getBytes();
            if (!unique.contains(line)) {
                // проверка что бы в хранилище были все уникальные(если они одинаковые то они не по
                // по идеи не смогут стать интересными
                storage.put(i, line);
                unique.add(line);
            }
        }
        reader.close();
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
//                    //TODO спросить
//                    if (point.length != foo.length) break;
                    byte f = foo[i];
                    byte p = point[i];
                    if (f != p) {

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
// нашли же уже все пары то удаляем
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