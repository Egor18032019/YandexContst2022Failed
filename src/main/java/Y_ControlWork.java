import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Y_ControlWork {
    private static BufferedReader reader = null;
    public static int N; //количество учеников
    public static int K; // количество заданий
    public static int rowPetia; // ряд
    public static int position; // слева 1  или справа 2

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {

        N = Integer.parseInt(reader.readLine());


        K = Integer.parseInt(reader.readLine());
        rowPetia = Integer.parseInt(reader.readLine());
        position = Integer.parseInt(reader.readLine());
        int numberPetia = rowPetia * 2;
        if (position == 1) numberPetia--;
        while (numberPetia > K) {
            numberPetia = numberPetia - K;
        }

        // 1
        int numberVasia = numberPetia + K;
        if (numberVasia > N) {
            System.out.println(-1);
            return;
        } else {
            int rowVasia = 0;
            int versus = 0;
            int count = 2;
            while (rowVasia == 0 || rowVasia == rowPetia) {
                if (numberVasia % count == 0) {
                    rowVasia = numberVasia / count;
                    versus = 2;
                } else {
                    rowVasia = (numberVasia + 1) / count;
                    versus = 1;
                }
                count = count + 2;
            }

            System.out.println(rowVasia + " " + versus);
        }
    }

}

/*
4
2
2
2

= 1.2
 */