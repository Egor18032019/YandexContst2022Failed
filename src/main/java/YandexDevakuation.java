import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YandexDevakuation {
    public static byte[][] pole;

    public static void main(String[] args) throws IOException {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // BufferedReader reader = new BufferedReader(new FileReader("src/InputFiles/input_test2.txt"));


        // узнаю количество сток и столбцов поля
        String[] values = reader.readLine().split(" ");
        int rowValue = Integer.parseInt(values[0]);
        int columnValue = Integer.parseInt(values[1]);

        // создаю массив размером поля
        pole = new byte[rowValue][columnValue];
        // ищу стартовую точку
        int rowStart = 0;
        int columnStart = 0;
        // перебираю все символы заданного поля
        for (int i = 0; i < rowValue; i++) {
            byte[] row = reader.readLine().getBytes();
            for (int j = 0; j < row.length; j++) {
                pole[i][j] = row[j];
                if (row[j] == 'S') {
                    rowStart = i;
                    columnStart = j;
                }
            }
        }
        // Ищу пути к соседним точкам
        findPath(rowStart, columnStart);

        // вывожу поле с отмеченными возможными путями
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[0].length; j++) {
                System.out.print((char) pole[i][j]);
            }
            System.out.println();
        }
        reader.close();
    }

    public static void findPath(int rowStart, int columnStart) {
        if(rowStart==8 || columnStart==5){
            System.out.println("Проверка на границы не нужно.");
        }
        // если найден хотя бы один путь рекурсивно вызываю метод поиска пути
        if (pole[rowStart - 1][columnStart] == '.') {
            pole[rowStart - 1][columnStart] = 'D';
            findPath(rowStart - 1, columnStart);
        }
        if (pole[rowStart + 1][columnStart] == '.') {
            pole[rowStart + 1][columnStart] = 'U';
            findPath(rowStart + 1, columnStart);
        }
        if (pole[rowStart][columnStart - 1] == '.') {
            pole[rowStart][columnStart - 1] = 'R';
            findPath(rowStart, columnStart - 1);
        }
        if (pole[rowStart][columnStart + 1] == '.') {
            pole[rowStart][columnStart + 1] = 'L';
            findPath(rowStart, columnStart + 1);
        }
        return;
    }

}
/*
5 4
0 1 1 0 0
1 1 1 0 1
1 1 0 0 1
0 0 0 1 0
 */