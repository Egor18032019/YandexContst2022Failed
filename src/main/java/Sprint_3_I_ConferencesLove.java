import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint_3_I_ConferencesLove {
    private static BufferedReader reader = null;
    public static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        n = Integer.parseInt(reader.readLine());

    }
}
