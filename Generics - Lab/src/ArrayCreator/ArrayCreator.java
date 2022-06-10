package ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator{
    public static <T> T[] create(int length, T element){
        T[] array =(T[]) Array.newInstance(element.getClass(), length);
        for (int i = 0; i < length; i++) {
         array[i] = element;
        }
        return array;
    }
    public static <T> T[] create(Class<T> thisClass,int length, T element){
        T[] array = (T[]) Array.newInstance(thisClass, length);
        for (int i = 0; i < length; i++) {
         array[i] = element;
        }
        return array;
    }
}
