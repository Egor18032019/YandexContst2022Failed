import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first= Integer.parseInt(reader.readLine());
        int second= Integer.parseInt(reader.readLine());
        int sum = first +second;
        System.out.println(sum);
        int answer = first*second;
        System.out.println(answer);
    }


}