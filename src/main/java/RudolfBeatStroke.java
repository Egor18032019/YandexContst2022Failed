import java.util.Scanner;

public class RudolfBeatStroke {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
//            System.out.println("i - " + i + " t = " + t);

            String stroke = scanner.nextLine();
            String stroke1 = scanner.nextLine();
            if (n < 3) {
                System.out.println(0);
                continue;
            }
//            System.out.println("stroke1 - " + stroke1);
            System.out.println(symbolForDelete(stroke1, n));
        }
    }


    public static int symbolForDelete(String stroke, int n) {

        int answer = 0;
        //идем по строке и проверяем буквы
        for (int i = 0; i < n - 2; i++) {
            if (stroke.charAt(i) == 'm' && stroke.charAt(i + 1) == 'a' && stroke.charAt(i + 2) == 'p') {
// + чтобы следующие в конце
 //mapie
                if (i + 3 < n && i + 4 < n) {
                    if (stroke.charAt(i + 3) == 'i' && stroke.charAt(i + 4) == 'e') i = i + 4;
                    else i = i + 2;
                    answer++;
                } else {
                    answer++;
                    i = i + 2;
                }
            } else if (stroke.charAt(i) == 'p' && stroke.charAt(i + 1) == 'i' && stroke.charAt(i + 2) == 'e') {
                i = i + 2;
                answer++;
                //pppiepieeee
                //mapie
            }
        }
        return answer;
    }
}
/*
1
8
mappppie

1
11
pppiepieeee

1
18
mapmapmapmapmapmap

 */