package SmartArray;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class SmartArray<T> {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    public T[] data;
    public int size;
    public int capacity;

    public SmartArray(Class<T> arrayClass) {
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
        this.data =(T[]) Array.newInstance(arrayClass, capacity);
    }

    public void add(T element) {
        this.data[size] = element;
        resize();
    }

    public void add(int index, T element){
        if (indexIsValid(index)){
            resize();
            T[] a = (T[]) Array.newInstance(element.getClass(), this.capacity);
            for (int i = 0; i < index; i++) {
                a[i] = this.data[i];
            }
            a[index] = element;
            for (int i = index + 1; i < a.length; i++) {

                a[i] = this.data[i - 1];
            }
            this.data = a;
        }else {
            throw new IndexOutOfBoundsException("Index is out of bounds for SmartArray");
        }
    }
    public T remove(int index){
        T value = null;
        if (indexIsValid(index)){
            value = this.data[index];
            shiftElements(index);
            shrinkArray();
            return value;
        }else{
            throw new IndexOutOfBoundsException("Index is out of bounds for SmartArray");
        }
    }
    public T get(int index){
        if (index >= 0 && index < this.size){
            return this.data[index];
        }else {
            throw new IndexOutOfBoundsException("Index is out of bounds for SmartArray");
        }
    }
    public T get(){
        return this.data[size - 1];
    }
    public <T extends Comparable<T>> boolean contains(T element){
        for (int i = 0; i < this.size; i++) {
            T currentElement = (T) this.data[i];
            if (element.compareTo(currentElement) == 0){
                return true;
            }
        }
        return false;
    }
    public void forEach(Consumer<T> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
    //support methods:
    private void resize(){
        this.size++;
        if (this.size == this.capacity) {
            this.capacity = this.capacity * 2;
            this.data = recreateData(this.data, capacity);
        }
    }
    private void shrinkArray() {
        int index = capacity / 4;
        if (index == size && size > INITIAL_CAPACITY){
            this.capacity /= 2;
            T[] a = (T[]) Array.newInstance(this.data[0].getClass(), this.capacity);
            for (int i = 0; i < size; i++) {
                a[i] = this.data[i];
            }
            this.data = a;
        }
    }
    private void shiftElements(int index) {
        if (index != this.size - 1) {
            T[] a = (T[]) Array.newInstance(this.data[0].getClass(), this.capacity);
            for (int i = 0; i < index; i++) {
                a[i] = this.data[i];
            }
            for (int i = index + 1; i < this.size; i++) {
                a[i - 1] = this.data[i];
            }
            this.data = a;
        }else {
            this.data[index] = null;
        }
        this.size -= 1;
    }
    private boolean indexIsValid(int index) {
        return index >= 0 && index < this.size;
    }
    private T[] recreateData(T[] data, int newCapacity) {
        T[] a = (T[]) Array.newInstance(this.data[0].getClass(), newCapacity);
        System.arraycopy(data, 0, a, 0, data.length);
        return a;
    }
}
