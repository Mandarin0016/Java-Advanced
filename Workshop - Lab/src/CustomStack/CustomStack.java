package CustomStack;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack<T> {
    private static final int INITIAL_CAPACITY = 4;
    private static final int INITIAL_STACK_SIZE = 0;

    private T[] data;
    private int size;
    private int capacity;

    public CustomStack(Class<T> objectClass) {
        this.capacity = INITIAL_CAPACITY;
        this.size = INITIAL_STACK_SIZE;
        this.data = (T[]) Array.newInstance(objectClass, capacity);
    }

    public void push(T element) {
        if (this.size == this.capacity) {
            this.capacity = this.capacity * 2;
            this.data = recreateData(this.data, this.capacity);
        }
        shiftElements(element);
        this.data[0] = element;
        this.size++;
    }

    public T pop() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty");
        }
        T element = this.data[0];
        T[] a = (T[]) Array.newInstance(element.getClass(), this.capacity);
        for (int i = 1; i < this.size; i++) {
            a[i - 1] = this.data[i];
        }
        this.size--;
        this.data = a;
        shrinkArray();
        return element;
    }

    public T peek() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty");
        }
        return this.data[0];
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    //support method:
    private void shrinkArray() {
        int index = this.capacity / 4;
        if (index == size && size > INITIAL_CAPACITY) {
            this.capacity /= 2;
            T[] a = (T[]) Array.newInstance(this.data[0].getClass(), this.capacity);
            for (int i = 0; i < size; i++) {
                a[i] = this.data[i];
            }
            this.data = a;
        }
    }

    private void shiftElements(T element) {
        T[] a = (T[]) Array.newInstance(element.getClass(), this.capacity);
        for (int i = 0; i < this.size; i++) {
            a[i + 1] = this.data[i];
        }
        this.data = a;
    }

    private T[] recreateData(T[] data, int newCapacity) {
        T[] a = (T[]) Array.newInstance(this.data[0].getClass(), newCapacity);
        System.arraycopy(data, 0, a, 0, data.length);
        return a;
    }

    //getters and setters:
    public int getSize() {
        return this.size;
    }

}
