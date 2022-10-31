import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class LogisticheskyiCentre {
    static BufferedReader reader = null;
    public static int N;
    public static int M;
    public static int R;
    public static int[][] pole;
    public static Map<Integer, byte[]> storage;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        R = Integer.parseInt(firstLine[2]);
        // создаю массив размером поля
        pole = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = reader.readLine().split(" ");
            // заполняем карту
            for (int j = 0; j < row.length; j++) {
                int cell = Integer.parseInt(row[j]);
                pole[i][j] = cell;
            }
        }

        int bigSumAroundR = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int preAnswer = giveMeSumForR(i, j);
                if (preAnswer == 29) {
//                    System.out.println(i + " " + j);
                }
                if (preAnswer > bigSumAroundR) bigSumAroundR = preAnswer;
            }
        }

        System.out.println(bigSumAroundR);
    }

    //     pole = new int[N][M]; 3 5
    public static int giveMeSumForR(int rowStart, int columnStart) {
        if (rowStart == 2 && columnStart == 0) {
//            System.out.println(",,??");
        }
        int answer = 0;
        if (rowStart == (N - 1) && columnStart == (M - 1)) {
//            System.out.println("нижний угол правый");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int x = rowStart - i;
                int up = 0;
                if (x >= 0) {
                    up = pole[x][columnStart];
                }
                int y = columnStart - i;
                int left = 0;
                if (y >= 0) {
                    left = pole[rowStart][y];
                }

                int upLeft = 0;
                if (i % 2 == 0 && i != 0) {
                    if (rowStart - i / 2 >= 0 && (columnStart - i / 2) >= 0) {
                        upLeft = pole[rowStart - i / 2][columnStart - i / 2];
                    }
                }
                answer = answer + up + left + center + upLeft;
                center = 0;
            }

            return answer;
        }
        if (rowStart == 0 && columnStart == (M - 1)) {
//            System.out.println("верхний угол правый");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int d = rowStart + i;
                int down = 0;
                if (d < N) {
                    down = pole[d][columnStart];
                }
                int l = columnStart - i;
                int left = 0;
                if (l >= 0) {
                    left = pole[rowStart][l];
                }
                int downLeft = 0;
                if (i / 2 == 0 && i != 0) {
                    if ((rowStart + i / 2) < N && (columnStart - i / 2) >= 0) {
                        downLeft = pole[rowStart + i / 2][columnStart - i / 2];
                    }
                }
                answer = answer + down + left + center + downLeft;
                center = 0;
            }
            return answer;
        }
//        pole = new int[N][M]; 3 5
        if (rowStart == 0 && columnStart == 0) {
//            System.out.println("верхний угол левый");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int d = rowStart + i;
                int down = 0;
                if (d < N) {
                    down = pole[d][columnStart];
                }
                int r = columnStart + i;
                int right = 0;
                if (r < M) {
                    right = pole[rowStart][r];
                }
                int downRight = 0;
                if (i % 2 == 0 && i != 0) {
                    if ((rowStart + i / 2) < N && (columnStart + i / 2) < M) {
                        downRight = pole[rowStart + i / 2][columnStart + i / 2];
                    }
                }
                answer = answer + down + right + center + downRight;
                center = 0;
            }
            return answer;
        }
        if (rowStart == (N - 1) && columnStart == 0) {
//            System.out.println("нижний угол левый");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int u = rowStart - i;
                int up = 0;
                if (u >= 0) {
                    up = pole[u][columnStart];
                }
                int r = columnStart + i;
                int right = 0;
                if (r < M) {
                    right = pole[rowStart][r];
                }
                int upRight = 0;
                if (i % 2 == 0 && i != 0) {
                    if (rowStart - i / 2 >= 0 && (columnStart + i / 2) < M) {
                        upRight = pole[rowStart - i / 2][columnStart + i / 2];
                    }
                }
                answer = answer + up + right + center + upRight;
                center = 0;
            }
            return answer;
        }
        if (rowStart == 0) {
//            System.out.println("верхняя строка");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int d = rowStart + i;
                int down = 0;
                if (d < N) {
                    down = pole[d][columnStart];
                }
                int r = columnStart + i;
                int right = 0;
                if (r < M) {
                    right = pole[rowStart][r];
                }
                int l = columnStart - i;
                int left = 0;
                if (l >= 0) {
                    left = pole[rowStart][l];
                }

                int downRight = 0;
                if (i % 2 == 0 && i != 0) {
                    if ((rowStart + i / 2) < N && (columnStart + i / 2) < M) {
                        downRight = pole[rowStart + i / 2][columnStart + i / 2];
                    }
                }
                int downLeft = 0;
                if (i % 2 == 0 && i != 0) {
                    if ((rowStart + i / 2) < N && (columnStart - i / 2) >= 0) {
                        downLeft = pole[rowStart + i / 2][columnStart - i / 2];
                    }
                }
                answer = answer + down + right + center + left + downLeft + downRight;
                center = 0;
            }
            return answer;
        }
                /*
1 2 3 4 5
2 0 3 0 3
3 0 3 3 0
         */
        if (rowStart == (N - 1)) {
//            System.out.println("нижняя строка");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int u = rowStart - i;
                int up = 0;
                if (u >= 0) {
                    up = pole[u][columnStart];
                }
                int r = columnStart + i;
                int right = 0;
                if (r < M) {
                    right = pole[rowStart][r];
                }
                int l = columnStart - i;
                int left = 0;
                if (l >= 0) {
                    left = pole[rowStart][l];
                }
                int upLeft = 0;
                if (i % 2 == 0 && i != 0) {
                    if (rowStart - i / 2 >= 0 && (columnStart - i / 2) >= 0) {
                        upLeft = pole[rowStart - i / 2][columnStart - i / 2];
                    }
                }
                int upRight = 0;
                if (i % 2 == 0 && i != 0) {
                    if (rowStart - i / 2 >= 0 && (columnStart + i / 2) < M) {
                        upRight = pole[rowStart - i / 2][columnStart + i / 2];
                    }
                }
                answer = answer + up + right + center + left + upRight + upLeft;
                center = 0;
            }
            return answer;
        }
        if (columnStart == (M - 1)) {
//            System.out.println("справа");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int u = rowStart - i;
                int up = 0;
                if (u >= 0) {
                    up = pole[u][columnStart];
                }
                int d = rowStart + i;
                int down = 0;
                if (d < N) {
                    down = pole[d][columnStart];
                }
                int l = columnStart - i;
                int left = 0;
                if (l >= 0) {
                    left = pole[rowStart][l];
                }
                int upLeft = 0;
                if (i % 2 == 0 && i != 0) {
                    if (rowStart - i / 2 >= 0 && (columnStart - i / 2) >= 0) {
                        upLeft = pole[rowStart - i / 2][columnStart - i / 2];
                    }
                }
                int downLeft = 0;
                if (i % 2 == 0 && i != 0) {
                    if ((rowStart + i / 2) < N && (columnStart - i / 2) >= 0) {
                        downLeft = pole[rowStart + i / 2][columnStart - i / 2];
                    }
                }
                answer = answer + up + down + center + left + downLeft + upLeft;
                center = 0;
            }
            return answer;
        }
        if (columnStart == 0) {
//            System.out.println("слева");
            int center = pole[rowStart][columnStart];
            for (int i = 1; i <= R; i++) {
                int u = rowStart - i;
                int up = 0;
                if (u >= 0) {
                    up = pole[u][columnStart];
                }
                int d = rowStart + i;
                int down = 0;
                if (d < N) {
                    down = pole[d][columnStart];
                }
                int r = columnStart + i;
                int right = 0;
                if (r < M) {
                    right = pole[rowStart][r];
                }

                int upRight = 0;
                if (i % 2 == 0 && i != 0) {
                    if (rowStart - i / 2 >= 0 && (columnStart + i / 2) < M) {
                        upRight = pole[rowStart - i / 2][columnStart + i / 2];
                    }
                }
                int downRight = 0;
                if (i % 2 == 0 && i != 0) {
                    if ((rowStart + i / 2) < N && (columnStart + i / 2) < M) {
                        downRight = pole[rowStart + i / 2][columnStart + i / 2];
                    }
                }
                answer = answer + up + down + center + right + upRight + downRight;
                center = 0;
            }
            return answer;
        }
        int center = pole[rowStart][columnStart];
        for (int i = 1; i <= R; i++) {
            int u = rowStart - i;
            int up = 0;
            if (u >= 0) {
                up = pole[u][columnStart];
            }
            int d = rowStart + i;
            int down = 0;
            if (d < N) {
                down = pole[d][columnStart];
            }
            int r = columnStart + i;
            int right = 0;
            if (r < M) {
                right = pole[rowStart][r];
            }
            int l = columnStart - i;
            int left = 0;
            if (l >= 0) {
                left = pole[rowStart][l];
            }
            int upLeft = 0;
            if (i % 2 == 0 && i != 0) {
                if (rowStart - i / 2 >= 0 && (columnStart - i / 2) >= 0) {
                    upLeft = pole[rowStart - i / 2][columnStart - i / 2];
                }
            }
            int upRight = 0;
            if (i % 2 == 0 && i != 0) {
                if (rowStart - i / 2 >= 0 && (columnStart + i / 2) < M) {
                    upRight = pole[rowStart - i / 2][columnStart + i / 2];
                }
            }
            int downRight = 0;
            if (i % 2 == 0 && i != 0) {
                if ((rowStart + i / 2) < N && (columnStart + i / 2) < M) {
                    downRight = pole[rowStart + i / 2][columnStart + i / 2];
                }
            }
            int downLeft = 0;
            if (i % 2 == 0 && i != 0) {
                if ((rowStart + i / 2) < N && (columnStart - i / 2) >= 0) {
                    downLeft = pole[rowStart + i / 2][columnStart - i / 2];
                }
            }

            answer = answer + up + down + center + right + left + downLeft + downRight + upRight + upLeft;
            center = 0;
        }

        return answer;
    }
}
