import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class skbFamousArtist {
    private static BufferedReader reader = null;
    public static int N; //количество дней


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int positionMax = 0;
        int positionMin = 0;
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(line[i]);
            if (a >= max) {
                max = a;
                positionMax = i;
            }
            if (a < min) {
                min = a;
                positionMin = i;
            }

        }
        System.out.println((positionMax+1) + " " +( positionMin+1));
    }
}