import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = bounds[0];
        int end = bounds[1];
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }
        String command = scanner.nextLine();
        Predicate<Integer> numbersPredicate;
        if (command.equals("even")){
            numbersPredicate = number -> number % 2 == 0;
        }else{
            numbersPredicate = number -> number % 2 != 0;
        }
        Consumer<Integer> printer = number -> System.out.print(number + " ");
        numbers.stream()
                .filter(numbersPredicate)
                .forEach(printer);
    }
}
