package Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> jarStack;

    public Jar() {
        jarStack = new ArrayDeque<>();
    }

    public void add(T element){
        jarStack.push(element);
    }
    public T remove(){
        return jarStack.pop();
    }
}
