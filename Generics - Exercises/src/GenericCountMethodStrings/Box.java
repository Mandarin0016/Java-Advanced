package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public List<T> getElements() {
        return elements;
    }

    public static <T> void swap(List<T> collection, int indexOne, int indexTwo){
        List<T> resultCollection = collection;
        T firstElement = collection.get(indexOne);
        T secondElement = collection.get(indexTwo);
        resultCollection.set(indexOne, secondElement);
        resultCollection.set(indexTwo, firstElement);
    }
    public static <T extends Comparable<T>> int countGreaterElements(List<T> collection, T element){
        int greaterElements = 0;
        for (T t : collection) {
            if (element.compareTo(t) < 0){
                greaterElements++;
            }
        }
        return greaterElements;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
