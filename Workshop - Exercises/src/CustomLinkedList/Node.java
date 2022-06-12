package CustomLinkedList;

public class Node {

    public int currentElement;
    public Node previous;
    public Node next;

    public Node(int currentElement){
        this.currentElement = currentElement;
    }

    @Override
    public String toString(){
        return String.valueOf(this.currentElement);
    }
}
