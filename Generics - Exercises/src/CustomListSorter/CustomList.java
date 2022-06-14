package CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public List<T> getElements() {
        return elements;
    }

    public CustomList() {
        this.elements = new ArrayList<>();
    }
    public void add(T element){
        this.elements.add(element);
    }
    public T remove(int index){
        T element = this.elements.get(index);
        this.elements.remove(element);
        return element;
    }
    public boolean contains(T element){
        return this.elements.contains(element);
    }
    public void swap(int indexOne, int indexTwo){
        T elementOne = this.elements.get(indexOne);
        T elementTwo = this.elements.get(indexTwo);
        this.elements.set(indexOne, elementTwo);
        this.elements.set(indexTwo, elementOne);
    }
    public int greater(T element){
        int greaterElements = 0;
        for (T e : this.elements) {
            if (element.compareTo(e) < 0){
                greaterElements++;
            }
        }
        return greaterElements;
    }
    public T max(){
        return Collections.max(this.elements);
    }
    public T min(){
        return Collections.min(this.elements);
    }
    public void print(){
        for (T element : this.elements) {
            System.out.println(element);
        }
    }
}
