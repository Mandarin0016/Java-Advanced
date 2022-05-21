import java.util.*;
import java.util.stream.Collectors;

public class ReverseStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numsFromConsole = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        ArrayDeque<String> numbers = new ArrayDeque<>();
        for (String number:numsFromConsole) {
            numbers.push(number);
        }
        System.out.println(String.join(" ", numbers));
    }
}
