public class Sprint_2_D_Mother {

    public static void main(String[] args) throws Exception {
        Node<String> node3 = new Node<>("a", null);
        Node<String> node2 = new Node<>("3", node3);
        Node<String> node1 = new Node<>("2", node2);
        Node<String> node0 = new Node<>("1", node1);
        findIndexValue(node0, "a");
    }

    public static void findIndexValue(Node<String> tree, String value) {
        int count = 1;
        Node<String> element = tree;
        while (element!= null) {

            if (element.value.equals(value)) {
                System.out.println(count);
                return;
            }
            element = element.next;
            count++;
        }
        System.out.println(-1);
    }

    static class Node<String> {
        public String value;
        public Node<String> next;

        public Node(String value, Node<String> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public java.lang.String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
