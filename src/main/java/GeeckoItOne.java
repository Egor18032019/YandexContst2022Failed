import java.util.Scanner;

public class GeeckoItOne {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String t = reader.nextLine();
        int n = getResult(t);
        System.out.println(n);
    }

    public static int getResult(String teeth) {
        // Write your code here...
        String[] arr = teeth.split("");// tocharArray сделать
        int length = arr.length - 1;
        int point = 0;
        int fLength = arr.length / 2;
        for (int i = 0; i < fLength; i++) {
//     XXIIXIIXX
            if (arr[i].equals("X")) {
                arr[i] = "D";
                if ((i - 1) >= 0) {
                    if (arr[i - 1].equals("I")) {
                        if ((i + 1) <= fLength) {
                            if (arr[i + 1].equals("I") || arr[i + 1].equals("X")) {
                                point = point + 4;
                            }
                        }

                    } else {
                        if (arr[i - 1].equals("D")) {
                            point = point + 2;
                        }
                    }
                } else {
                    point = point + 2;
                }


            }
        }

        for (int i = length; i >= fLength; i--) {
            if (arr[i].equals("X")) {
                arr[i] = "D";
                if ((i + 1) <= length) {
                    if (arr[i + 1].equals("I")) {
                        if (arr[i - 1].equals("I") || arr[i - 1].equals("X")) {
                            point = point + 4;
                        }
                    } else {
                        if (arr[i + 1].equals("D")) point = point + 2;
                    }

                } else {
                    point = point + 2;
                }
            }
        }
        return point;
    }
}
/*
XXXX   - 8

IIXII


 */