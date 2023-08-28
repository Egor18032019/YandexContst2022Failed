import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DenisApi {
    private static BufferedReader reader = null;
    public static int N; // количество  ,


    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        N = Integer.parseInt(reader.readLine());
        Map<String, TreenNode> storage = new TreeMap<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] arr = reader.readLine().split(" ");
            String nameRootNode = arr[0];
            TreenNode bar;
            if (storage.containsKey(nameRootNode)) {
                bar = storage.get(nameRootNode);
            } else {
                bar = new TreenNode();
                bar.name = nameRootNode;
                bar.points = new ArrayList<>();
                storage.put(nameRootNode, bar);
            }
            // и добавляем в ветки новые Nodы
            for (int x = 2; x < arr.length; x++) {
                TreenNode point = new TreenNode();
                point.name = arr[x];
                point.points = new ArrayList<>();
                point.root = bar;
                bar.points.add(point);
                storage.put(arr[x], point);
            }
        }
        TreenNode element = storage.entrySet().iterator().next().getValue();

        console(giveMeRootNode(element), answer);
//        console(storage.get("main"), answer);
        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                System.out.print(answer.get(i));
            } else {
                System.out.print(answer.get(i) + " ");
            }
        }
    }

    public static TreenNode giveMeRootNode(TreenNode node) {
        if (node.root != null) {
            return giveMeRootNode(node.root);
        } else {
            return node;
        }
    }

    public static void console(TreenNode root, List<String> answer) {
        answer.add(0, root.name);
        List<TreenNode> cell = root.points;
        for (TreenNode node : cell) {
            console(node, answer);
        }
    }

    public static class TreenNode {
        String name;

        List<TreenNode> points;
        TreenNode root;

        public TreenNode() {
        }

    }

}
/*
Ввод
3
main 2 foo baz
baz 0
foo 0
Вывод
baz foo main

Пример 2
Ввод
5
main 1 foo
foo 2 baz bar
baz 0
bar 1 brr
brr 0
Вывод
brr bar baz foo main
 */