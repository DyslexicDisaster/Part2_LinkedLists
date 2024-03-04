package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int numElements;

    public LinkedList() {
    }

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        this.numElements = 0;
    }

    public int size(){
        return numElements;
    }

    public Song get(int pos){
        if(pos < 0 || pos >= numElements){
            // If validation fails, throw an exception
            throw new IndexOutOfBoundsException("Illegal position supplied: " + pos);
        }

        Node current = head;
        for(int i = 0; i < pos; i++){
            current = current.getNext();
        }
        return current.getData();
    }

    protected static class Node {
        private Song data;
        private Node next;

        public Node(Song data) {
            this.data = data;
            next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public void setData(Song data) {
            this.data = data;
        }

        public Song getData() {
            return this.data;
        }
    }
}

