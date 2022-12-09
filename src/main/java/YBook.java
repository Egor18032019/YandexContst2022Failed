import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class YBook {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int books = Integer.parseInt(br.readLine());
        String[] recordings = br.readLine().split(" ");
        double sum = 0;
        double min = 1001;
        double max = -1001;
        for (int i = 0; i < books; i++) {
            int current = Integer.parseInt(recordings[i]);
            if (current > max) max = current;
            if (current < min) min = current;

            if (current < 0) {

                for (int q = i; q < books; q++) {
                    current = Integer.parseInt(recordings[q]);
                    if (current > max) max = current;
                    if (current < min) min = current;

                }
                double answer = (Math.abs(max) + Math.abs(min)) / 2;
                System.out.println(answer);
                return;
            } else {
                sum = sum + current;
            }
        }

        System.out.println(sum);


    }
}

