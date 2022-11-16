import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YandexTree {
    private static BufferedReader bufferedReader = null;
    static TreeNode pp;
    static TreeNode p;
    static TreeNode v;

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


        // создаем дерево
        TreeNode treeNode = new TreeNode();
        // заполняем дерево
        inorder(treeNode, 1, peack, null);

        //номер вершины, обменявшейся местами со своим предком в i-ю ночь.
        for (int i = 0; i < changes; i++) {
            // надо ли так ?
            pp = null;
            p = null;
            v = null;
            int changesPeack = Integer.parseInt(seckondLine[i]);
            search(treeNode, changesPeack);

            boolean isChildLeft = false;
            if (p != null) {
                if (p.left.val == v.val) {
                    isChildLeft = true;
                }
                if (isChildLeft) {
                    p.left = v.left;
                    if (p.left != null) {
                        p.left.root = p;
                    }
                    v.left = p;
                    if (v.left != null) {
                        v.left.root = v;
                    }
                } else {
                    p.right = v.right;
                    if (p.right != null) {
                        p.right.root = p;
                    }
                    v.right = p;
                    if (v.right != null) {
                        v.right.root = v;
                    }
                }
            }

            boolean isParentLeft = false;
            if (pp != null) {
                if (pp.left.val == p.val) {
                    isParentLeft = true;
                }

                if (isParentLeft) {
                    pp.left = v;
                    if (pp.left != null) {
                        pp.left.root = pp;
                    }
                } else {
                    pp.right = v;
                    if (pp.right != null) {
                        pp.right.root = pp;
                    }
                }
            } else {
                if (v != null) {

                    v.root = null;
                    treeNode = v;
                }
            }

        }

        answer(treeNode);

    }

    public static void inorder(TreeNode root, int value, int end, TreeNode main) {

        if (value > end) {
            return;
        }

        root.val = value;

        int leftValue = 2 * value;
        if (leftValue <= end) {
            root.left = new TreeNode();
            inorder(root.left, leftValue, end, root);
        }

        int rightValue = 2 * value + 1;
        if (rightValue <= end) {
            root.right = new TreeNode();
            inorder(root.right, rightValue, end, root);
        }
        if (main == null) {
            root.root = null;
        } else {
            root.root = main;
        }


    }

    public static void search(TreeNode root, int changesPeack) {
//        if (root == null) return;
        if (root.left != null) {
            if (root.left.val == changesPeack) {
                v = root.left;
                p = root;
                pp = root.root;
                return;
            }
            search(root.left, changesPeack);
        }
        if (root.right != null) {
            if (root.right.val == changesPeack) {
                pp = root.root;
                p = root;
                v = root.right;
                return;
            }

            search(root.right, changesPeack);
        }


    }

    public static void answer(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            System.out.print(treeNode.val + " ");
            return;
        }
        if (treeNode.left != null) {
            answer(treeNode.left);
            System.out.print(treeNode.val + " ");
        } else {
            System.out.print(treeNode.val + " ");
        }
        if (treeNode.right != null) {
            answer(treeNode.right);
        }
    }

    // 7 10 5 2 8 4 9 1 6 3
    // 7 10 5 2 8 4 9 1 6 3
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode root;

        TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right, TreeNode root) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.root = root;
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

        /*
        1 1
        1


10 0
5 7 4 7 8 7

7 10 5 2 8 4 9 1 6 3

        В единственной строке через пробел требуется вывести номера вершин дерева после всех изменений в формате LVR, начиная с корня дерева.

Формат LVR(v) определяется рекурсивно для вершины v.

    если у вершины v есть левый ребенок lv, то сначала выводится всё поддерево lv в формате LVR(lv);
    а потом выводится номер вершины v;
    если у вершины v есть правый ребенок rv, то выводится всё поддерево rv в формате LVR(rv);
         */