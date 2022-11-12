import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dostoprimechatelnosti_TaskA {

    private static BufferedReader reader = null;

    public static Map<Integer, Map<Integer, Integer>> all;
    public static Map<Integer, int[]> sequences;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        List<List<Integer>> ways = new ArrayList<>();

    }
}
