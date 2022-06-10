package Scale;

public class Scale<T extends Comparable<T>> {
    private final T left;
    private final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }
    public T getHeavier(){
        T object = null;
        if (left.compareTo(right) > 0){
            object = left;
        }else if (right.compareTo(left) > 0){
            object = right;
        }
        return object;
    }
}
