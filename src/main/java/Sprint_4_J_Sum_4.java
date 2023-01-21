import java.util.*;

public class Sprint_4_J_Sum_4 {
    // Функция для проверки существования четверки в массиве с заданной суммой
    public static void hasQuadruplet(int[] nums, int n, int target, Set<List<Integer>> storage) {
        // создаем пустую карту
        // ключ —> цель пары в массиве
        // значение —> список, в котором хранится индекс каждой пары, имеющей эту сумму
        Map<Integer, List<Pair>> map = new HashMap<>();

// 2 3 2 4 1 10 3 0
        // рассмотрим каждый элемент, кроме последнего элемента
        for (int i = 0; i < n - 1; i++) {
            // начинаем с i-го элемента до последнего элемента
            for (int j = i + 1; j < n; j++) {
                // вычисляем оставшуюся сумму
                int val = target - (nums[i] + nums[j]);// 10 - ( 2 +3) = 5

                // если оставшаяся сумма найдена на карте,
                // мы нашли 5
                if (map.containsKey(val)) {
                    // проверяем каждую пару, у которой сумма равна оставшейся сумме
                    for (Pair pair : map.get(val)) {
                        int x = pair.x;
                        int y = pair.y;
// то есть пришло [[1,2],[2,3]] и т.п.
                        // если 5 не пересекается, выводим ее и
                        // return true
                        if ((x != i && x != j) && (y != i && y != j)) {
                            List<Integer> answer = new ArrayList();
                            answer.add(nums[i]);
                            answer.add(nums[j]);
                            answer.add(nums[x]);
                            answer.add(nums[y]);
                            Collections.sort(answer);
                            storage.add(answer);
                        }
                    }
                }
                // вставляем текущую пару в карту
                // проверка нуля (Java 8)
                map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                map.get(nums[i] + nums[j]).add(new Pair(i, j));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 4, 1, 10, 3, 0};
        int target = 10;
        Set<List<Integer>> storage = new HashSet<>();
        hasQuadruplet(nums, nums.length, target, storage);
        for (List<Integer> point : storage) {
            System.out.println(point.toString());
        }
    }
}

class Pair {
    public int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
8
10
2 3 2 4 1 10 3 0

6
0
1 0 -1 0 2 -2

5
4
1 1 1 1 1

 */