import java.util.*;

public class MainDraft {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h, p, b;

        h = in.nextInt();

        p = in.nextInt();

        b = in.nextInt();
        boolean flag = false;


        if (h * h == (p * p) + (b * b)) {
            flag = true;
        }
        if (p * p == (h * h) + (b * b)) {
            flag = true;
        }
        if (b * b == (h * h) + (p * p)) {
            flag = true;
        }
        if (flag) {
            System.out.println("Является прямоугольным . ");
        } else {
            System.out.println("Не является прямоугольным.");
        }
    }
}
