import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).map(Object::toString).collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbers));
        evenNumbers = evenNumbers.stream().map(Integer::parseInt).sorted().map(Object::toString).collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbers));
    }
}
