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
    private int maxSize;

    /**
     * default constructor
     */
    public LinkedList() {
    }
/*
    /**
     *
     * parameterized constructor
     *
     * @param head the first node to be added to the list
     * @param tail the last node to be added to the list
     */
    /*public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        this.numElements = 0;
    }*/

    /**
     *
     * @return int of the number of elements in the list
     */
    public int size(){
        return numElements;
    }

    /**
     * gets the Song at a spesified position
     *
     * @param pos position to be got at
     * @return the song at the index of pos
     */
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

    /**
     * Finds the index of the specified Song in the list
     *
     * @param toBeFound The Song to find in the list.
     * @return The index of the specified Song, or -1 if not found
     */
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

    /**
     *Adds a Song to the end of the list
     *
     * @param toBeAdded Song to be added
     */
    public void add(Song toBeAdded) {
        if (toBeAdded == null) {
            throw new IllegalArgumentException("Wrong stop that");
        }

        /*if (numElements > maxSize) {
            throw new IndexOutOfBoundsException("Max size oh list reached");
        }*/
        //this line is supossed to make sure the list dosen't extend past the max number of elements howver it made all my test fail so somthing is wrong

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

    /**
     * Tells if the list is empty or not
     * @return true if empty or false if not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Retrieves the last element (tail) of the list
     *
     * @return The last element of the list, or null if the list is empty.
     */
    public Song tail() {
        if (tail == null) {
            return null;
        }
        return tail.getData();
    }

    public LinkedList(Node head, Node tail, int max) {
        this.head = head;
        this.tail = tail;
        this.numElements = 0;
        this.maxSize = max;
    }

    /**
     * Adds all Songs from the given array to the end of the list.
     *
     * @param songs The array of Songs to be added.
     */
    public void addAll(Song[] songs) {
        for (int i = 0; i < songs.length; i++) {
            add(songs[i]);
        }
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

