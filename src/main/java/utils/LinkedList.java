package utils;

/**
 *
 * @author michelle
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int numElements;

    protected static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }
}

