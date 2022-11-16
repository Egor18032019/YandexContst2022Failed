import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint_1_L_ExtraLetter {

    private static BufferedReader reader = null;
    public static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] tokenArr = reader.readLine().split("");

        Set<String> storage = new HashSet<>();

        for (int i = 0; i < tokenArr.length; i++) {
            String token = tokenArr[i];
            System.out.println(token);
            storage.add(token);
        }
        String[] tokenArrDiff = reader.readLine().split("");
        for (int i = 0; i < tokenArrDiff.length; i++) {
            String token = tokenArrDiff[i];
            if (!storage.contains(token)) {
                System.out.println(token);
                break;
            }
        }
    }
}
