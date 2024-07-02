public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
            return;
        }
        size++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void bubble() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }
        if(col <row) {
            Node first = get(col);
            Node second = get(col + 1);
            if (first.value > second.value) {
                if (first == head) {
                    first.next = second.next;
                    second.next = first;
                    head = second;
                } else {
                    Node pre = get(col - 1);
                    pre.next = second;
                    first.next = second.next;
                    second.next = first;
                    if (first.next == null) {
                        tail = first;
                    }
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
        }
    

    public static void main(String[] args) {
        LL first = new LL();

        first.insertFirst(1);
        first.insertFirst(3);
        first.insertFirst(5);

        System.out.println("First list before sorting:");
        first.display();
        first.bubble();
        System.out.println("First list after sorting:");
        first.display();

        LL second = new LL();

        second.insertFirst(1);
        second.insertFirst(2);
        second.insertFirst(9);
        second.insertFirst(14);

        System.out.println("Second list before sorting:");
        second.display();
        second.bubble();
        System.out.println("Second list after sorting:");
        second.display();
    }
}
