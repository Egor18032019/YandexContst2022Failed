import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ElectronTable {
    static BufferedReader reader = null;
    public static int n;
    public static Map<String, Integer> storageCell;
    public static Map<String, String> storageSum;

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
        storageCell = new HashMap<>();
        storageSum = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] line = reader.readLine().split(" ");
            int foo = Integer.parseInt(line[0]);
            String key = "C" + i;
            String value = line[1];
            if (foo == 1) {
                Integer inValue = null;
                try {
                    inValue = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    System.out.println("не число");
                }
                if (inValue != null) {
                    storageCell.put(key, inValue);
                } else {
                    // можно убрать
//                    storageCell.put(key, 0);
                    storageSum.put(key, value);
                }
            } else {
//                storageCell.put(key, 0);
                storageSum.put(key, value);
            }
        }

        for (int z = 1; z <= n; z++) {
            String key = "C" + z;

            if (storageSum.containsKey(key)) {
                sumFromFormula(storageSum.get(key));
            } else {
                Integer foo = storageCell.get(key);
                System.out.println(foo);
            }
        }

    }

    private static void sumFromFormula(String s) {
        String[] formula = s.split("");
        String[] oldFormula = null;
        /*
        Сначала ищем на *
        Нашли посчитали сумму
        В строке вырезали посчитанное и вставили сумму ??
         */
        int random = 0;
        do {
            oldFormula = formula;
            for (int i = 0; i < formula.length; i++) {
                if (Objects.equals(formula[i], "*")) {
                    String firstCell = formula[i - 2] + formula[i - 1];
                    String secondCell = formula[i + 1] + formula[i + 2];

                    Integer first = storageCell.getOrDefault(firstCell, null);
                    Integer second = storageCell.getOrDefault(secondCell, null);
                    if (first == null || second == null) {
                        // first =C1  second = 8
                        // first =null  second = null
                        if (first == null && second != null) {
//                             8+C1+C2
                            // first =8  second = C2
                            Integer inValue = null;
                            try {
                                inValue = Integer.valueOf(firstCell);
                            } catch (NumberFormatException e) {
                                System.out.println(-1);
                                n = 0;
                                return;
                            }

                            int value = inValue * second;
                            String keyD = "D" + random;
                            random++;
                            storageCell.put(keyD, value);
                            int newLength = formula.length - 4;
//                            System.out.println("newLength " + newLength);
                            String[] preFormula = new String[newLength];

                            int count = 0;
                            for (int z = 0; z < formula.length; z++) {
                                if (z == (i - 2)) {
                                    preFormula[count] = keyD;
                                    count++;
                                }
                                if (z == i || z == (i - 1) || z == (i - 2) || z == (i + 1) || z == (i + 2)) {
//                                    System.out.println("Пропускаем " + z);
                                } else {
                                    preFormula[count] = formula[z];
                                    count++;
                                }
                            }
                            formula = preFormula;

                        }

                        if (second == null && first != null) {
//                             C1+8+C2
                            // first =C1  second = 8
                            Integer inValue = null;
                            try {
                                inValue = Integer.valueOf(secondCell);
                            } catch (NumberFormatException e) {
                                System.out.println(-1);
                                n = 0;
                                return;
                            }
                            int value = inValue * first;
                            int newLength = formula.length - 4;
//                            System.out.println("newLength " + newLength);
                            String[] preFormula = new String[newLength];

                            int count = 0;
                            for (int z = 0; z < formula.length; z++) {
                                if (z == (i - 2)) {
                                    preFormula[count] = String.valueOf(value);
                                    count++;
                                }
                                if (z == i || z == (i - 1) || z == (i - 2) || z == (i + 1) || z == (i + 2)) {
//                                    System.out.println("Пропускаем " + z);
                                    continue;
                                } else {
                                    preFormula[count] = formula[z];
                                    count++;
                                }
                            }
                            formula = preFormula;

                        }
                        if (first == null && second == null) {
                            //                     9*8+C2
                            // first =9  second = 8
                            Integer inValueFirst = null;
                            Integer inValueSecond = null;
                            try {
                                inValueFirst = Integer.valueOf(firstCell);
                            } catch (NumberFormatException e) {
                                System.out.println(-1);
                                n = 0;
                                return;
                            }
                            try {
                                inValueSecond = Integer.valueOf(secondCell);
                            } catch (NumberFormatException e) {
                                System.out.println(-1);
                                n = 0;
                                return;
                            }
                            int value = inValueFirst * inValueSecond;
                            int newLength = formula.length - 4;
//                            System.out.println("newLength " + newLength);
                            String[] preFormula = new String[newLength];

                            int count = 0;
                            for (int z = 0; z < formula.length; z++) {
                                if (z == (i - 2)) {
                                    preFormula[count] = String.valueOf(value);
                                    count++;
                                }
                                if (z == i || z == (i - 1) || z == (i - 2) || z == (i + 1) || z == (i + 2)) {
//                                    System.out.println("Пропускаем " + z);
                                    continue;
                                } else {
                                    preFormula[count] = formula[z];
                                    count++;
                                }
                            }
                            formula = preFormula;

                        }

                    } else {
//                    C1+XXXXX+C2
                        int value = first * second;
                        String keyD = "D" + random;

                        storageCell.put(keyD, value);
                        int newLength = formula.length - 3;
//                        System.out.println("newLength " + newLength);
                        String[] preFormula = new String[newLength];

                        int count = 0;
                        for (int z = 0; z < formula.length; z++) {
                            if (z == (i - 2)) {
                                preFormula[count] = "D";
                                count++;
                            }
                            if (z == (i - 1)) {
                                preFormula[count] = String.valueOf(random);
                                count++;
                                random++;
                            }
                            if (z == i || z == (i - 1) || z == (i - 2) || z == (i + 1) || z == (i + 2)) {
//                                System.out.println("Пропускаем " + z);
                                continue;
                            } else {
                                preFormula[count] = formula[z];
                                count++;
                            }
                        }
                        formula = preFormula;
                    }
                }
            }

        } while (formula.length != oldFormula.length);
//        System.out.println(Arrays.toString(formula));

        // а теперь сложение и вычитание
        do {
            oldFormula = formula;
            for (int i = 0; i < formula.length; i++) {
                if (Objects.equals(formula[i], "+")) {
                    String firstCell = formula[i - 2] + formula[i - 1];
                    String secondCell = formula[i + 1] + formula[i + 2];

                    Integer first = storageCell.getOrDefault(firstCell, null);
                    Integer second = storageCell.getOrDefault(secondCell, null);
                    if (first == null || second == null) {
                        System.out.println(-1);
                        n = 0;
                        return;
                    }
//                    C1+XXXXX+C2
                    int value = first + second;
                    String keyD = "D" + random;

                    storageCell.put(keyD, value);
                    int newLength = formula.length - 3;
//                    System.out.println("newLength " + newLength);
                    String[] preFormula = new String[newLength];

                    int count = 0;
                    for (int z = 0; z < formula.length; z++) {
                        if (z == (i - 2)) {
                            preFormula[count] = "D";
                            count++;
                        }
                        if (z == (i - 1)) {
                            preFormula[count] = String.valueOf(random);
                            count++;
                            random++;
                        }
                        if (z == i || z == (i - 1) || z == (i - 2) || z == (i + 1) || z == (i + 2)) {
//                            System.out.println("Пропускаем " + z);
                            continue;
                        } else {
                            preFormula[count] = formula[z];
                            count++;
                        }
                    }
                    formula = preFormula;

                }
            }

        } while (formula.length != oldFormula.length);
//        System.out.println(Arrays.toString(formula));
        if (formula.length > 2) {
            System.out.println(-1);
            return;
        }
        String key = formula[0] + formula[1];
        int answer = storageCell.get(key);
        System.out.println(answer);
    }
}

        /*
3
1 2
1 11
2 C1+C1*C2+C2


3
2 C2*C2
2 C1*C1
1 3
      */
