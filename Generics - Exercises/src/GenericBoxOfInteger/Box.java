package GenericBoxOfInteger;


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
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
