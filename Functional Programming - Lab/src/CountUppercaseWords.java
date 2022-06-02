import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> checkUpperCaseStartingWord = word -> Character.isUpperCase(word.charAt(0));
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        words = words.stream().filter(checkUpperCaseStartingWord).collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
