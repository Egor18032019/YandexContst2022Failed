import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint_3_M_GoldenMedium {
    private static BufferedReader reader = null;
    public static int n;
    public static int m;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(reader.readLine());
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] mergeArr = new int[n + m];

        int l = 0;
        int r = 0;
        int index = 0;
        while (l < arrN.length && r < arrM.length) {
            if (arrN[l] < arrM[r]) {
                mergeArr[index] = arrN[l];
                l++;
            } else {
                mergeArr[index] = arrM[r];
                r++;
            }
            index++;

        }
        // если один массив закончился раньше чем второй
        while (l < arrN.length) {
            mergeArr[index] = arrN[l];
            l++;
            index++;
        }
        while (r < arrM.length) {
            mergeArr[index] = arrM[r];
            r++;
            index++;
        }
        int length = mergeArr.length / 2; //4   2 3
        if (mergeArr.length % 2 == 0) {
            double sum = mergeArr[length] + mergeArr[length - 1];
            double mid = sum / 2;
            System.out.println(mid);
        } else {
            System.out.println(mergeArr[length]);
        }
    }
}

/*
2
1
1 3
2
=2
2
2
1 2
3 4
=2.5
8
10
0 0 0 1 3 3 5 10
4 4 5 7 7 7 8 9 9 10
=5
 */