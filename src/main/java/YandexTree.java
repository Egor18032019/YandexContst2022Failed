import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class YandexTree {
    private static BufferedReader bufferedReader = null;
    static TreeNode pp;
    static TreeNode parrent;
    static TreeNode child;

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    private static void run() throws IOException {
        String[] firstLine = bufferedReader.readLine().split(" ");
        int peack = Integer.parseInt(firstLine[0]);
        int changes = Integer.parseInt(firstLine[1]);
        String[] seckondLine = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        // создаем дерево
        TreeNode treeNode = new TreeNode();
        // заполняем дерево
        inorder(treeNode, 1, peack);

        //номер вершины, обменявшейся местами со своим предком в i-ю ночь.
        for (int i = 0; i < seckondLine.length; i++) {
            // надо ли так ?
            pp = null;
            parrent = null;
            child = null;
            boolean isParentLeft = false;
            int changesPeack = Integer.parseInt(seckondLine[i]);
            System.out.println(changesPeack);
            search(treeNode, changesPeack);
            searchPP(treeNode, parrent.val, isParentLeft);
            if (isParentLeft) {

            }

            System.out.println(pp);

            // ищем в дереве вершину с таким значением
            // и сразу предка ?
            // меняем их местами согласно приведенному алгоритму

        }
    }

    public static void inorder(TreeNode root, int value, int end) {

        if (value > end) {

            return;
        }

        root.val = value;

        int leftValue = 2 * value;
        if (leftValue <= end) {
            root.left = new TreeNode();
            inorder(root.left, leftValue, end);
        }

        int rightValue = 2 * value + 1;
        if (rightValue <= end) {
            root.right = new TreeNode();
            inorder(root.right, rightValue, end);
        }
    }

    public static void search(TreeNode root, int changesPeack) {
//        if (root == null) return;
        if (root.left != null) {
            if (root.left.val == changesPeack) {
                child = root.left;
                parrent = root;

                System.out.println("с лево");
                return;
            }
            search(root.left, changesPeack);
        }
        if (root.right != null) {
            if (root.right.val == changesPeack) {
                child = root.right;
                parrent = root;

                System.out.println("с права");
                return;
            }

            search(root.right, changesPeack);
        }


    }


    public static void searchPP(TreeNode root, int valueCHild, boolean isParentLeft) {
        if (root.left != null) {
            if (root.left.val == valueCHild) {
                pp = root;
                isParentLeft = true;
                return;
            }
            searchPP(root.left, valueCHild);
        }
        if (root.right != null) {
            if (root.right.val == valueCHild) {
                pp = root;
                isParentLeft = false;
                return;
            }
            searchPP(root.right, valueCHild);
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
