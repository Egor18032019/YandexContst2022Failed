//import java.io.*;
//import java.util.Map;
//
//public class NumericalPuzzles {
//    private static BufferedReader br;
//    private static BufferedWriter bw;
//    private static long[][] numArr;
//    private static int n;
//
//    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new FileReader("input.txt"));
//        bw = new BufferedWriter(new FileWriter("output.txt"));
////        System.out.println(simpleNumbers(54));
////        System.out.println(greatestCommonDivisor2(500100,100500));
//
////        Map<Long, Integer> map_NOD = factorization(500100);
////        for (Map.Entry<Long, Integer> entry : map_NOD.entrySet()) {
////            System.out.println(entry.getKey() + ":" + entry.getValue());
////        }
//        reedFile();
//        run();
//    }
//
//    private static void run() throws IOException {
//        for (int i = 0; i < n; i++) {
//            long A = numArr[i][0];
//            long B = numArr[i][1];
////            System.out.println(A + " " + B);
//            Map<Long, Integer> map_NOD = factorization(greatestCommonDivisor2(A, B));
//            Map<Long, Integer> map_A = factorization(A);
//            Map<Long, Integer> map_B = factorization(B);
//            for(Map.Entry<Long,Integer> entry_NOD : map_NOD.entrySet()){
//                Long key = entry_NOD.getKey();
//                if (map_A.containsKey(key)) {
//                    map_A.put(key, (map_A.get(key) - entry_NOD.getValue()));
//                }
//                if (map_B.containsKey(key)) {
//                    map_B.put(key, (map_B.get(key) - entry_NOD.getValue()));
//                }
//            }
//            Long max_A = maxKeyinMap(map_A);
//            Long max_B = maxKeyinMap(map_B);
//            long maxNOD = 0;
//            if (max_A > max_B) {
//                maxNOD = greatestCommonDivisor2(A, B * max_A);
//            }
//            else if (max_B > max_A) {
//                maxNOD = greatestCommonDivisor2(A * max_B, B);
//            }
//            bw.write(String.valueOf(maxNOD));
//            bw.newLine();
//        }
//        bw.close();
//    }
//
//    private static void reedFile() throws IOException {
//        n = Integer.parseInt(br.readLine());
////        if (n < 1 || n > 20) return;
//        numArr = new long[n][2];
//        for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            String[] strArr = str.split(" ");
//            for (int j = 0; j < strArr.length; j++) {
//                numArr[i][j] = Integer.parseInt(strArr[j]);
//            }
//        }
//        br.close();
////        for (int i = 0; i < numArr.length; i++) {
////            for (int j = 0; j < numArr[i].length; j++) {
////                System.out.print(numArr[i][j] + " ");
////            }
////            System.out.println();
////        }
//    }
//
//    private static Map<Long, Integer> factorization(long number) { // разложение на множители
//        Map<Long, Integer> map = new LinkedHashMap<>();
//        for (long i = 2; i <= number; i++) {
//            for (int j = 1; ; j++) {
//                if (number == 1) {
//                    break;
//                }
//                else if (number % i == 0) {
//                    map.put(i, j);
//                    number = number / i;
//                }
//                else {
//                    break;
//                }
//            }
//        }
//        return map;
//    }
//3
//12 54
//    private static Long maxKeyinMap(Map<Long,Integer> map) {
//        Long max = 0l;
//        for(Map.Entry<Long,Integer> entry : map.entrySet()){
//            if (entry.getValue() > 0 && entry.getKey() > max) {
//                max = entry.getKey();
//            }
//        }
//        return max;
//    }
//
//    private static long greatestCommonDivisor2(long a,
//                                               long b) { // Алгоритм Евклида для нахождения НОД (двух чисел)(https://www.youtube.com/watch?v=CVBe39P2hwk&t=1s).
//        long nod = 1;
//        if (a == b) { // Если числа равны, возвращаем любое из них.
//            nod = b;
//        }
//        if (b > a) { // Если b > a, меняем их местами.
//            long c = a;
//            a = b;
//            b = c;
//        }
//        if (a > b) { // Пусть а > b.
//            long r1 = a % b; // a = b * q1 + r1 (r1 остаток от деления, который < b).
//            if (r1 == 0) {
//                nod = b;
//            }
//            else { //(r1 != 0). // b = r1 * q2 + r2 (r2 остаток от деления, который < r1).
//                nod = greatestCommonDivisor2(b, r1); // рекурсия.
//            }
//        }
//        return nod;
//    }
//}
