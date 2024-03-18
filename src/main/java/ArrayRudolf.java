import java.util.Arrays;
import java.util.Scanner;

public class ArrayRudolf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
//            1,3,5,5,2
            boolean canMakeZero = false;
            int max = Arrays.stream(arr).max().getAsInt();
            if (max == 0) {
                System.out.println("YES");
                continue;
            }
            for (int j = 1; j < n - 1; j++) {
                if (arr[j] == 0) continue;
                if (arr[j] == max) {
                    canMakeZero = makeAllZero(arr, j);
                    if (canMakeZero) {
//                        System.out.println("YES");
                        break;
                    }
                }

            }


            System.out.println(canMakeZero ? "YES" : "NO");
        }

    }

    public static boolean makeAllZero(int[] arr, int i) {

        int[] arrForCorrect = arr.clone();

        if (arrForCorrect[i] == 0) return true;
        arrForCorrect[i - 1] = arrForCorrect[i - 1] - 1;
        arrForCorrect[i] = arrForCorrect[i] - 2;
        arrForCorrect[i + 1] = arrForCorrect[i + 1] - 1;

        if (arrForCorrect[i] < 0 || arrForCorrect[i - 1] < 0 || arrForCorrect[i + 1] < 0) {
            return false;
        }
        int max = Arrays.stream(arrForCorrect).max().getAsInt();
        if (max == 0) return true;
        for (int j = 1; j < arrForCorrect.length - 1; j++) {
            if (arrForCorrect[j] == 0) continue;
            if (arrForCorrect[j] < 0) return false;
            if (arrForCorrect[j] == max) {
                return makeAllZero(arrForCorrect, j);
            }
        }
        return false;
    }
}
/*
1
4
1 1 1 0

1
4
0 7 14 7

1
4
1 0 1 1

1
5
0 0 0 0 0





55
6
2 4 3 2 1 0
5
4 0 5 0 1
6
0 2 2 0 2 0
5
3 9 10 5 1
4
5 3 3 1
5
3 10 11 4 0
5
2 4 2 0 0
4
1 9 15 7
6
6 5 2 3 3 5
5
2 8 10 4 0
3
1 2 2
6
1 0 0 1 0 1
4
0 1 0 2
4
2 2 2 1
4
1 1 1 0
5
7 14 8 2 1
6
1 1 4 4 4 3
4
1 0 1 1
4
0 7 14 7
5
0 7 14 7 0
5
0 0 0 0 0
6
0 3 7 9 9 4
3
1 2 1
3
0 0 0
5
0 1 1 2 0
5
0 0 0 0 0
4
1 1 1 0
3
0 2 1
4
0 0 0 0
6
0 3 0 1 0 2
3
4 8 4
6
2 0 2 1 0 1
3
0 0 0
3
1 4 3
5
4 2 3 2 2
3
0 1 1
5
2 6 6 2 0
4
0 0 0 0



4
16
3811501 11374254 19415695 20395713 16477506 20905334 18630184 13262328 15502007 12009765 7976242 7475400 9277636 10475256 7321839 2514560
20
277533028 817762449 98381128 947536264 432786239 551321995 25053447 386913431 872011852 582245407 106676944 523311707 220083197 705670956 153890430 834166463 216371680 563438148 429169227 725988369
14
125974859 276679853 175559039 38728439 57500972 82854148 242772896 439313537 363047974 270892614 250093816 169728495 77921544 14674014
22
401076966 2213
 */