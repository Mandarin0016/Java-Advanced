package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(18);
        numbers.add(63);
        numbers.add(542);
        numbers.add(2);
        System.out.println(ListUtils.getMin(numbers));
    }
}
