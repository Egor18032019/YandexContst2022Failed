import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Rectangles {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        int count = Integer.parseInt(firstLine);
        List<int[]> arrRec = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] stroke = reader.readLine().trim().split(" ");

            int[] intFromStroke = new int[4];
            int leftX = Integer.parseInt((stroke[0]));
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
                if(leftX>rigthXCompare)continue;
                if(leftY>rightYCompare)continue;

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
                if(!firstX)continue;

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
                if(!firstY)continue;

                    answer[i] = answer[i] + 1;

            }
        }


        for (int iterator : answer) {
            System.out.print(iterator + " ");
        }
    }

}
/*
Лучшее время
 8.014s
35.49Mb
	15
	надо не больше 8секунда
	как так то???
 */