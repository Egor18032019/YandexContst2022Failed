public class Sprint_2_D_Mother {

    public static void main(String[] args) throws Exception {
        Node<String> node3 = new Node<>("3", null, null);
        Node<String> node2 = new Node<>("2", node3, null);
        Node<String> node1 = new Node<>("1", node2, null);
        Node<String> rootNode = new Node<>("0", node1, null);
        node1.prev = rootNode;
        node2.prev = node1;
        node3.prev = node2;

        printDDL("Original list: ", rootNode);
        Node<String> head = null;
        head = reverseDDL(rootNode);
        printDDL("Reversed list: ", head);
    }

    // Вспомогательная функция для помещения узла в начало двусвязного списка
    public static Node push(Node head, int key) {
        Node node = new Node();
        node.value = key;
        node.prev = null;
        node.next = head;

// изменить `prev` существующего головного узла, чтобы он указывал на новый узел
        if (head != null) {
            head.prev = node;
        }

// обновить указатель заголовка и вернуться
        head = node;
        return head;
    }

    // Функция для замены указателей `next` и `prev` данного узла
    public static void swap(Node<String> node) {
        Node<String> point = node.prev;
        node.prev = node.next;
        node.next = point;
    }

    // Функция для реверсирования двусвязного списка
    public static Node<String> reverseDDL(Node<String> head) {
        Node<String> prev = null;
        Node<String> curr = head;
// обход списка
        while (curr != null) {
// поменять местами указатели `next` и `prev` для текущего узла
            swap(curr);
// обновить предыдущий узел перед переходом к следующему узлу
            prev = curr;
// перейти к следующему узлу в двусвязном списке (перейти с помощью
// указатель `prev`, так как указатели `next` и `prev` поменялись местами)
            curr = curr.prev;
        }
// обновить указатель на последний узел
        // можно просто вернуть prev но тогда нужно будет делать проверку на null
        if (prev != null) {
            head = prev;
        }

        return head;
    }

    // Вспомогательная функция для вывода узлов двусвязного списка
    public static void printDDL(String msg, Node head) {
        System.out.print(msg);
        while (head != null) {
            System.out.print(head.value + " —> ");
            head = head.next;
        }

        System.out.println("null");
    }





    static class Node<String> {
        public String value;
        public Node<String> next;
        public Node<String> prev;

        public Node(String value, Node<String> next, Node<String> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
            this.value = null;
            this.next = null;
            this.prev = null;
        }

        public Node(String value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node(Node<String> node) {
            this.value = node.value;
            this.next = node.next;
            this.prev = node.prev;
        }

        @Override
        public java.lang.String toString() {
            java.lang.String left = "";
            java.lang.String right = "";
            if (next != null) right = java.lang.String.valueOf(next.value);
            if (prev != null) left = java.lang.String.valueOf(prev.value);

            return "Node{" +
                    "value=" + value +
                    ", next=" + right +
                    ", prev=" + left +
                    '}';
        }
    }
}
