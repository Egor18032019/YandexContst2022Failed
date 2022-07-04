import java.util.Arrays;
import java.util.Scanner;

public class BinaryMedian {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String firstLine = reader.nextLine();
        int count = Integer.parseInt(firstLine);
        String[] stroke = reader.nextLine().trim().split("");
        int[] answer = new int[stroke.length];
        int nulls = 0;
        int units = 0;
        for (int i = 0; i < count; i++) {
            if (stroke[i].equals("0")) {
                nulls++;
            } else {
                units++;
            }
            if (i == 0) {
                answer[i] = -1;
            } else {

                if (nulls == units) {
                    answer[i] = -1;
                } else {
                    if (nulls > units) {
                        if (stroke[i].equals("0")) {
                            answer[i] = 1;
                        } else {
                            answer[i] = -1;
                        }
                    } else {
                        if (stroke[i].equals("1")) {
                            answer[i] = 1;
                        } else {
                            answer[i] = -1;
                        }
                    }
                }

            }

        }

        System.out.println(Arrays.toString(answer));
    }


}
/*
5
01001

L1 = -1 по определению
L2 = -1 так как  S[2] = 1 то  S[1,1] = 1 то есть медиана = 0.5 а == 1/2
L3 =  1 так как S[0,1,2] = 010 медиана 0 a S[3] = 0
L4 =  1 так как  S[0,1,2,3} = 0100 медина = 0 а S[4] = 0
L5 = -1 так как S[0,1,2,3,4] = 01 001 то есть нолей 3 а единиц 2 медина равна 0
              a S[5] = 1  == 1/2

 */