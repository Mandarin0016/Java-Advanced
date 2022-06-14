package CustomListSorter;

import java.util.Collections;

public class Sorter {
    public static <T extends CustomList<T> & Comparable<T>> void sort(CustomList<String> list){
        Collections.sort(list.getElements());
    }
}
