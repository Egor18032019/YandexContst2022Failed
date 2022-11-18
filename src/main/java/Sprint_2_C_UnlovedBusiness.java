public class Sprint_2_C_UnlovedBusiness {

    public static void main(String[] args) throws Exception {
        Node<String> node3 = new Node<>("4", null);
        Node<String> node2 = new Node<>("3", node3);
        Node<String> node1 = new Node<>("2", node2);
        Node<String> node0 = new Node<>("1", node1);
        findRemoveElement(node0, 1, 2);
        System.out.println(node0.toString());
    }


    public static void findRemoveElement(Node tree, int currentNumberElement, int numberForRemoveElement) {
        currentNumberElement++;
        if (currentNumberElement == numberForRemoveElement) {
            tree.next = tree.next.next;
            return;
        }
        findRemoveElement(tree.next, currentNumberElement, numberForRemoveElement);

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