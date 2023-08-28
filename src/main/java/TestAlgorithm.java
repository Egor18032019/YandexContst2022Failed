import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.LongStream;

public class TestAlgorithm {
    public static void main(String[] args) {
        //test 1_000 cycles n = 5, 15, 20;
        test(1_000, 5);
        test(1_000, 15);
        test(1_000, 20);

        System.out.println("\n##################################################################################################\n");

        //test 10_000 cycles n = 5, 15, 20;
        test(10_000, 5);
        test(10_000, 15);
        test(10_000, 20);

        System.out.println("\n##################################################################################################\n");

        //test 100_000 cycles n = 5, 15, 20;
        test(100_000, 5);
        test(100_000, 15);
        test(100_000, 20);

        System.out.println("\n##################################################################################################\n");

        //test 1_000_000 cycles n = 5, 15, 20;
        test(1_000_000, 5);
        test(1_000_000, 15);
        test(1_000_000, 20);
    }

    private static void test(int cycles, int n) {
        System.out.printf("Performance test: cycles = %d; n = %d:\n", cycles, n);
        printPerformance("factorialRecursion()", cycles, n, Factorial::factorialRecursion);
        printPerformance("factorialCycle()", cycles, n, Factorial::factorialCycle);
        printPerformance("factorialStream()", cycles, n, Factorial::factorialStream);
        printPerformance("factorialTree()", cycles, n, Factorial::factorialTree);
        printPerformance("factorialPowPrimeNumber()", cycles, n, Factorial::factorialPowPrimeNumber);
        printPerformance("factorialGamma()", cycles, n, Factorial::factorialGamma);
        System.out.println();
    }

    private static void printPerformance(String name, int count, int n, Function<Integer, Long> function) {
        long res = 0;
        long start = System.currentTimeMillis();
        for (int index = 1; index <= count; index++) {
            res = function.apply(n);
        }
        String time = String.format("spent time: %s sec.;", parseMs(System.currentTimeMillis() - start));
        String info = String.format("result = %d;", res);
        System.out.printf("%8s%-30s%-40s%s\n", "", name + ":", info, time);
    }

    private static String parseMs(long time) {
        String sec = String.valueOf(time / 1000);
        String ms = String.valueOf(time % 1000);
        while (ms.length() < 3) {
            ms = "0".concat(ms);
        }
        return sec + "." + ms;
    }
}

/**
 * Генерация комбинаций
 */
class Factorial {
    private static void checkN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format("Factorial not may bee negative: %d;\n", n));
        }
    }

    static long factorialRecursion(int n) {
        checkN(n);
        return n != 0 && n != 1 ? n * factorialRecursion(n - 1) : 1;
    }

    static long factorialCycle(int n) {
        checkN(n);
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static long factorialGamma(int n) {
        checkN(n);
        if (n == 0) {
            return 1;
        }
        double result = Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
        return Math.round(result * (1.0 + 1.0 / (Math.sqrt(52 * Math.E) * n)));
    }

    static long factorialStream(int n) {
        checkN(n);
        return n != 0 && n != 1 ? LongStream.rangeClosed(2, n).reduce(1, (res, num) -> res * num) : 1;
    }

    static long factorialTree(int n) {
        checkN(n);
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return n;
        }
        return factorialTree(2, n);
    }

    static long factorialPowPrimeNumber(int n) {
        long result = 1;
        if (n == 2) {
            result = n;
        } else if (n != 0 && n != 1) {
            boolean[] prime = algorithmEratosthenes(n);
            for (int index = 2; index <= n; index++) {
                if (prime[index]) {
                    int pow = 0;
                    int k = n / index;
                    while (k > 0) {
                        pow += k;
                        k /= index;
                    }
                    result *= Math.pow(index, pow);
                }
            }
        }
        return result;
    }

    private static boolean[] algorithmEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, prime.length, true);
        int result = 0;
        int cursor = 2;
        while (result <= n) {
            result = cursor << 1;
            if (result <= n) {
                for (int index = result; index <= n; index += cursor) {
                    prime[index] = false;
                }
                cursor++;
            }
            while (!prime[cursor]) {
                cursor++;
            }
        }
        return prime;
    }

    private static long factorialTree(long start, long end) {
        if (start > end)
            return 1;
        if (start == end)
            return start;
        if (end - start == 1)
            return start * end;
        long m = (start + end) / 2;
        return factorialTree(start, m) * factorialTree(m + 1, end);
    }

}