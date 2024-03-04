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

    public int indexOf(Song toBeFound){
        Node current = head;
        int count = 0;
        while(current != null){
            if (current.data.equals(toBeFound)){
                return count;
            }
            count++;
            current = current.getNext();
        }
        return -1;
    }

    /*public void addToStart(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        numElements++;
    }*/

    public void add(Song toBeAdded) {
        if (toBeAdded == null) {
            throw new IllegalArgumentException("Wrong stop that");
        }

        Node newNode = new Node(toBeAdded);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        numElements++;
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

