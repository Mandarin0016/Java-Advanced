package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        //add new node that will be placed as a head of the linked list
        customLinkedList.addFirst(1);
        customLinkedList.addFirst(2);
        //add new node that will be placed as a tail of the linked list
        customLinkedList.addLast(3);
        customLinkedList.addLast(4);
        //get an element of a given index from the linked list
        customLinkedList.get(2);
        //remove the first element(the current head) of the linked list
        customLinkedList.removeFirst();
        //remove the last element(the current tail) of the linked list
        customLinkedList.removeLast();
        //parse the linked list into an array of integers
        int[] myArray = customLinkedList.toArray();
        //iterate through the linked list and perform an action over each of its elements
        customLinkedList.forEach(nodeValue -> System.out.printf("Number: %d%n", nodeValue));
    }
}
