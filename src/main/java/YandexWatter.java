import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YandexWatter {
    private static BufferedReader bufferedReader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String firstLine = bufferedReader.readLine();
        int zakazi = Integer.parseInt(firstLine);
        for (int i = 0; i < zakazi; i++) {
            String[] line = bufferedReader.readLine().split(" ");
//            10 100 1000
//            время начала и конца заказа и стоимость заказа соответственно.
        }
        int zaprosi = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < zakazi; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            // время начала и конца промежутка и тип запроса соответственно.
//            1 10 1
// 1 -начавших ? 2 - закончивших

        }
    }

}
