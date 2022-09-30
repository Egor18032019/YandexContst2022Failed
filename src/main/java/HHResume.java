import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HHResume {

    private static BufferedReader bufferedReader = null;


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); //высота стопки
        int m = Integer.parseInt(firstLine[1]);//высота стопки
        int s = Integer.parseInt(firstLine[2]); // Маша устанавливает значение s максимальной суммы зарплат и
        int length = Math.max(n, m);
        ArrayDeque<Integer> firstDeque = new ArrayDeque<Integer>();
        ArrayDeque<Integer> secondDeque = new ArrayDeque<Integer>();


        //складываем в стопки
        for (int i = 0; i < length; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            String firstPoint = line[0];
            String secondPoint = line[1];
            if (!firstPoint.equals("-")) {
                firstDeque.addLast(Integer.parseInt(firstPoint));
            }
            if (!secondPoint.equals("-")) {
                secondDeque.addLast(Integer.parseInt(secondPoint));
            }
        }
        int minLength = Math.min(n, m);
        // находим меньшее
        int firstSum = 0;
        int secondSum = 0;
        Iterator<Integer> itF = firstDeque.iterator();
        Iterator<Integer> itS = secondDeque.iterator();

        while (minLength > 0) {
            minLength = minLength - 1;
            firstSum = firstSum + itF.next();
            secondSum = secondSum + itS.next();
        }

        List<Integer> result = new ArrayList<>();
        int workedLimit = 0;
        if (firstSum < secondSum) {
            while (workedLimit < s && (firstDeque.peek() != null || secondDeque.peek() != null)) {
                if (firstDeque.peek() != null) {
                    int point = firstDeque.peek();
                    if ((workedLimit + point) > s) {
                        break;
                    } else {
                        workedLimit = workedLimit + firstDeque.pop();
                        result.add(point);
                    }
                } else {
                    if (secondDeque.peek() != null) {
                        int point = secondDeque.peek();
                        if ((workedLimit + point) > s) {
                            break;
                        } else {
                            workedLimit = workedLimit + secondDeque.pop();
                            result.add(workedLimit);
                        }
                    }
                }
            }
        }

        if (secondSum < firstSum) {
            while (workedLimit < s && (firstDeque.peek() != null || secondDeque.peek() != null)) {
                if (secondDeque.peek() != null) {
                    int point = secondDeque.peek();
                    if ((workedLimit + point) > s) {
                        break;
                    } else {
                        workedLimit = workedLimit + secondDeque.pop();
                        result.add(point);
                    }
                } else {
                    if (firstDeque.peek() != null) {
                        int point = firstDeque.peek();
                        if ((workedLimit + point) > s) {
                            break;
                        } else {
                            workedLimit = workedLimit + firstDeque.pop();
                            result.add(point);
                        }
                    }
                }
            }
        }
        if (secondSum == firstSum) {
            while (workedLimit < s && (firstDeque.peek() != null || secondDeque.peek() != null)) {
                if (secondDeque.peek() != null && firstDeque.peek() != null) {
                    int firstPop = firstDeque.peek();
                    int secondPop = secondDeque.peek();
                    if (firstPop < secondPop) {
                        if ((workedLimit + firstPop) > s) {
                            break;
                        } else {
                            workedLimit = workedLimit + firstDeque.pop();
                            result.add(firstPop);
                        }
                    }
                    if (secondPop < firstPop) {
                        if ((workedLimit + secondPop) > s) {
                            break;
                        } else {
                            workedLimit = workedLimit + secondDeque.pop();
                            result.add(secondPop);
                        }
                    }
                    /*
1 2 10
9 9
- 1

1 2 10
9 9
1 -
                     */
                    if (secondPop == firstPop) {
                        // тащим от туда которая длинее ??
                        if (firstDeque.size() > secondDeque.size()) {
                            if ((workedLimit + firstPop) > s) {
                                break;
                            } else {
                                workedLimit = workedLimit + firstDeque.pop();
                                result.add(firstPop);
                            }
                        } else {
                            if ((workedLimit + secondPop) > s) {
                                break;
                            } else {
                                workedLimit = workedLimit + secondDeque.pop();
                                result.add(firstPop);
                            }
                        }
                    }
                } else {
                    if (secondDeque.peek() != null) {
                        int point = secondDeque.peek();
                        if ((workedLimit + point) > s) {
                            break;
                        } else {
                            workedLimit = workedLimit + secondDeque.pop();
                            result.add(point);
                        }
                    } else {
                        if (firstDeque.peek() != null) {
                            int point = firstDeque.peek();
                            if ((workedLimit + point) > s) {
                                break;
                            } else {
                                workedLimit = workedLimit + firstDeque.pop();
                                result.add(workedLimit);
                            }
                        }
                    }

                }
            }
        }
        System.out.println(result.size());
    }
}
/*
1 2 10
9 9
- 1

1 1 22
1 9

6 4 10
4 2
2 1
4 8
6 5
1 -
7 -

5 5 10
5 1
1 3
1 3
1 3
1 3

3 4 11
1 1
2 2
3 3
- 4
 */