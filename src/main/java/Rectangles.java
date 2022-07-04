import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rectangles {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String firstLine = reader.nextLine();
        int count = Integer.parseInt(firstLine);
        List<int[]> arrRec = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] stroke = reader.nextLine().trim().split(" ");
            int[] intFromStroke = new int[4];
            int leftX = Integer.parseInt(stroke[0]);
            int leftY = Integer.parseInt(stroke[1]);
            int rigthX = Integer.parseInt(stroke[2]);
            int rightY = Integer.parseInt(stroke[3]);
            intFromStroke[0] = leftX;
            intFromStroke[1] = leftY;
            intFromStroke[2] = rigthX;
            intFromStroke[3] = rightY;
            arrRec.add(intFromStroke);
        }
        reader.close();

        // парсим
        int[] answer = new int[count];
        for (int i = 0; i < count; i++) {
            int leftX = arrRec.get(i)[0];
            int leftY = arrRec.get(i)[1];
            int rigthX = arrRec.get(i)[2];
            int rightY = arrRec.get(i)[3];
            for (int z = 0; z < count; z++) {
                if (i == z) {
                    continue;
                }
                int leftXCompare = arrRec.get(z)[0];
                int leftYCompare = arrRec.get(z)[1];
                int rigthXCompare = arrRec.get(z)[2];
                int rightYCompare = arrRec.get(z)[3];
                boolean firstX = false;
                if (leftX == leftXCompare || rigthX == rigthXCompare) {
                    firstX = true;
                } else {
                    if (leftX < leftXCompare && rigthX > leftXCompare) {
                        firstX = true;
                    } else {
                        if (leftX > leftXCompare && leftX < rigthXCompare) {
                            firstX = true;
                        }
                    }
                }
                boolean firstY = false;
                if (leftY == leftYCompare || rightY == rightYCompare) {
                    firstY = true;
                } else {
                    if (leftY < leftYCompare && rightY > leftYCompare) {
                        firstY = true;
                    } else {
                        if (leftY > leftYCompare && leftY < rightYCompare) {
                            firstY = true;
                        }
                    }
                }
                boolean isInterset = firstX && firstY;
                if (isInterset) {
                    answer[i] = answer[i] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }

}
/*
6 - кол-во прямоугольников
-2 -4 2  2   — координаты левого нижнего и правого верхнего углов.
 1
-2 -4 0 -1
-2 -1 0  2
 0 -4 2 -1
 0 -1 2  2
-1 -2 1  0

Вывод
5 2 2 2 2 5
 */