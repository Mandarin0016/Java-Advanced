package GenericSwapMethodIntegers;

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
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
