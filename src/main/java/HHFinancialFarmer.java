import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HHFinancialFarmer {
    private static BufferedReader reader = null;
    public static int n;
    public static int m;
    public static byte[][] pole;
    public static Map<String, Region> onlyRegion;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]); //ширина участка
        m = Integer.parseInt(firstLine[1]);//высота участка
        pole = new byte[m][n];
//        if (n == 0 && m == 0) {
//            System.out.println(0);
//            return;
//        }
        // заполняем массив
        for (int i = 0; i < m; i++) {
            byte[] row = reader.readLine().getBytes();
            int index = 0;
            // заполняем карту
            for (byte it : row) {
                if (it == ' ') {
                    continue;
                }
                pole[i][index] = it;
                index++;
            }
        }
        onlyRegion = new HashMap<>();
        StringBuilder key = new StringBuilder();
        // теперь в onlyRegion закидываем участки с полезной площадью
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                key.append(i).append(j);
                findRegion(i, j, key.toString());
            }
        }

        // Сортируем и берем самый верхний
        List<Region> mapValues = new ArrayList<>(onlyRegion.values());
        if (mapValues.size() == 0) {
            //                System.out.println("– Минимальное количество плодородных участков в регионе для покупки – 2");
            System.out.println(0);
            return;
        }


//        mapValues.sort(Comparator
//                .comparingDouble(Region::getEffectiveness)
////                .reversed()
//                .thenComparingInt(Region::getFullArea)
//                .reversed());
//        // брать из хранилища пока Площадь полезных участков не станет > 2
//        for (Region i : mapValues) {
//            //  так как мы до этого вызывали getEffectiveness то areaFertile должна быть заполнено
//            int area = i._getAreaFertile();
//            if (area >= 2) {
//                System.out.println(i.getFullArea());
//                return;
//            }
//        }

        int resultPlots = 0;
        int resultSize = 0;
        for (HashMap.Entry<String, Region> entry : onlyRegion.entrySet()) {
            int currentPlots = entry.getValue().getTruthAreaFertile();
            int currentSize = entry.getValue().getFullArea();

            if (resultSize * currentPlots > currentSize * resultPlots) {
                resultPlots = currentPlots;
                resultSize = currentSize;
            } else if (resultSize * currentPlots == currentSize * resultPlots) {
                if (resultSize < currentSize) {
                    resultPlots = currentPlots;
                    resultSize = currentSize;
                }
            } else if (resultSize == 0) {
                resultPlots = currentPlots;
                resultSize = currentSize;
            }

        }
        System.out.println(resultSize);

    }

    public static void findRegion(int row, int column, String key) {
        if (pole[row][column] == '0') {
            return;
        }

        if (pole[row][column] == '1') {
            pole[row][column] = '2'; // метка что посчитали
            saveRegion(key, column, row);
        }

        // рекурсия же
        if ((row - 1) >= 0) {
            if (pole[row - 1][column] == '1') {
                pole[row - 1][column] = '2'; // метка что посчитали
                saveRegion(key, column, row - 1);
                findRegion(row - 1, column, key);
            }
        }
        // byte[][] pole = new byte[m][n];
        if ((row + 1) < m) {
            if (pole[row + 1][column] == '1') {
                pole[row + 1][column] = '2';
                saveRegion(key, column, row + 1);
                findRegion(row + 1, column, key);
            }
        }
        if ((column - 1) >= 0) {
            if (pole[row][column - 1] == '1') {
                pole[row][column - 1] = '2';
                saveRegion(key, column - 1, row);
                findRegion(row, column - 1, key);
            }
        }

        if ((column + 1) < n) {
            byte point = pole[row][column + 1];
            if (point == '1') {
                pole[row][column + 1] = '2';
                saveRegion(key, column + 1, row);
                findRegion(row, column + 1, key);
            }
        }
// диагонали
        if ((column + 1) < n && (row + 1) < m) {
            byte point = pole[row + 1][column + 1];
            if (point == '1') {
                pole[row + 1][column + 1] = '2';
                saveRegion(key, column + 1, row + 1);
                findRegion(row + 1, column + 1, key);
            }
        }

        if ((column - 1) >= 0 && (row - 1) >= 0) {
            byte point = pole[row - 1][column - 1];
            if (point == '1') {
                pole[row - 1][column - 1] = '2';
                saveRegion(key, column - 1, row - 1);
                findRegion(row - 1, column - 1, key);
            }
        }

        if ((column + 1) < n && (row - 1) >= 0) {
            byte point = pole[row - 1][column + 1];
            if (point == '1') {
                pole[row - 1][column + 1] = '2';
                saveRegion(key, column + 1, row - 1);
                findRegion(row - 1, column + 1, key);
            }
        }

        if ((column - 1) >= 0 && (row + 1) < m) {
            byte point = pole[row + 1][column - 1];
            if (point == '1') {
                pole[row + 1][column - 1] = '2';
                saveRegion(key, column - 1, row + 1);
                findRegion(row + 1, column - 1, key);
            }
        }

    }

    public static class Region {
        private int truthAreaFertile;
        private int lefTopX;
        private int leftTopY;
        private int rightDownX;
        private int rightDownY;

        private int area;

        public Region(int lefTopX, int leftTopY, int rightDownX, int rightDownY) {
            this.lefTopX = lefTopX;
            this.leftTopY = leftTopY;
            this.rightDownX = rightDownX;
            this.rightDownY = rightDownY;
        }

        public void setTruthAreaFertile(Integer areaFertile) {
            this.truthAreaFertile = areaFertile;
        }

        public void setCoordinate(int x, int y) {
            if (x < lefTopX) {
                this.lefTopX = x;
            } else {
                if (x > rightDownX) this.rightDownX = x;
            }
            if (y < leftTopY) {
                this.leftTopY = y;
            } else {
                if (y > rightDownY) this.rightDownY = y;
            }
        }

        public int _getAreaFertile() {
            return truthAreaFertile;
        }

        public int getFullArea() {
            int fullArea = (rightDownX - lefTopX + 1) * (rightDownY - leftTopY + 1);
            area = fullArea;
            return (fullArea);
        }

        public int getTruthAreaFertile() {
            int answer = 0;
            for (int x = lefTopX; x <= rightDownX; x++) {
                for (int y = leftTopY; y <= rightDownY; y++) {
                    byte point = pole[y][x];
                    // '1'=50
                    if (point == 50) {
                        answer++;
                    }
                }
            }
            return answer;
        }

        public double getEffectiveness() {

            int truthAreaFertile = _getAreaFertile();
            if (truthAreaFertile == 0) {
                truthAreaFertile = getTruthAreaFertile();
                setTruthAreaFertile(truthAreaFertile);
            }
//            System.out.println("truthAreaFertile " + truthAreaFertile);
            double answer;
            int areaRegion = getFullArea();
            answer = (double) truthAreaFertile / areaRegion;
//            System.out.println("getEffectiveness " + answer);
            return answer;
        }

    }


    public static void saveRegion(String key, int column, int row) {
        if (onlyRegion.containsKey(key)) {
            Region region = onlyRegion.get(key);
            region.setCoordinate(column, row);
            onlyRegion.replace(key, region);
        } else {
            Region r = new Region(column, row, column, row);
            onlyRegion.put(key, r);
        }
    }
}
/*
2 4
0 0
1 1
0 0
1 0

2 4
0 0
0 0
0 0
0 0

5 4
0 1 1 0 0
1 1 1 0 1
1 1 0 0 1
0 0 0 1 0

6 6
1 1 1 1 1 1
1 0 0 0 0 1
1 0 1 0 0 1
1 0 0 1 0 1
1 0 0 0 0 1
1 1 1 1 1 1


5 3
1 1 1 1 1
1 0 0 0 1
1 0 1 0 1

3 5
1 0 1
0 1 1
1 0 1
0 0 0
0 1 0

3 3
1 1 1
1 1 1
1 1 1

3 3
1 0 0
0 0 0
0 0 1

5 3
0 0 0 0 0
0 1 0 1 0
0 0 0 0 0



2 4
0 0
1 1
0 0
1 0

6 9
1 1 1 1 1 1
1 0 0 0 0 1
1 0 1 0 0 1
1 0 0 1 0 1
1 0 0 0 0 1
1 1 1 1 1 1
0 0 0 0 0 0
0 1 1 0 0 0
0 1 1 0 0 0


6 6
1 1 1 1 1 1
1 0 0 0 0 1
1 0 1 0 0 1
1 0 1 1 0 1
1 0 0 0 0 1
1 1 1 1 1 1
 */