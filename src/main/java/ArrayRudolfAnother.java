import java.util.Scanner;

public class ArrayRudolfAnother {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int index = 0; index < t; index++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int i = 1; i < n - 1; i++) {
                //и сравниваем
                // - что предыдущий меньше или !!!равен!!! чем через один
                // и
                // настоящий
                /*
                1
                4
                0 7 14 7
                 */
                if (arr[i - 1] <= arr[i + 1] && arr[i] >= 2 * arr[i - 1]) {

                    arr[i + 1] -= arr[i - 1];
                    arr[i] -= 2 * arr[i - 1];
                    arr[i - 1] = 0;
                }

            }

            boolean allZeros = true;
            for (int value : arr) {
                if (value != 0) {
                    allZeros = false;
                    break;
                }
            }

            if (allZeros) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
