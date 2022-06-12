package CustomLinkedList;

import java.util.function.Consumer;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;

    //methods
    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.size++;
    }
    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
            this.size++;
        }
    }
    public int get(int index) {
        if (isIndexValid(index)) {
            if (index <= this.size / 2) {
                Node currentNode = this.head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
                return currentNode.currentElement;
            } else {
                Node currentNode = this.tail;
                for (int i = this.size - 1; i > index; i--) {
                    currentNode = currentNode.previous;
                }
                return currentNode.currentElement;
            }
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
    }
    public int removeFirst(){
        int removedElement;
        if (isEmpty()){
            throw new IllegalArgumentException();
        }if (this.size == 1){
            removedElement = this.head.currentElement;
            this.head = null;
            this.tail = null;
            this.size--;
        }else {
            removedElement = this.head.currentElement;
            this.head = this.head.next;
            this.head.previous = null;
            this.size--;
        }
        return removedElement;
    }
    public int removeLast(){
        int removedElement;
        if (isEmpty()){
            throw new IllegalArgumentException();
        }if (this.size == 1){
            removedElement = this.head.currentElement;
            this.head = null;
            this.tail = null;
            this.size--;
        }else {
            removedElement = this.tail.currentElement;
            this.tail = this.tail.previous;
            this.tail.next = null;
            this.size--;
        }
        return removedElement;
    }
    public void forEach(Consumer<Integer> consumer){
        Node currentNode = this.head;
        while (currentNode != null){
            consumer.accept(currentNode.currentElement);
            currentNode = currentNode.next;
        }
    }
    public int[] toArray(){
        int[] array = new int[this.size];
        Node currentNode = this.head;
        for (int i = 0; i < array.length; i++) {
            array[i] = currentNode.currentElement;
            currentNode = currentNode.next;
        }
        return array;
    }
    //support methods
    private boolean isIndexValid(int index) {
        return index >= 0 && index < this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
