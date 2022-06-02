import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            people.put(data[0], Integer.parseInt(data[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        //Predicate<Integer> ageCondition;
        BiPredicate<Integer, Integer> ageCondition;
        if (condition.equals("younger")){
            ageCondition = (personAge, limit) -> personAge <= limit;
        }else {
            ageCondition = (personAge, limit) -> personAge >= limit;
        }
        Consumer<Map.Entry<String, Integer>> printer = entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        if (format.equals("name")){
            printer = entry -> System.out.printf("%s%n", entry.getKey());
        }else if (format.equals("age")){
            printer = entry -> System.out.printf("%d%n", entry.getValue());
        }
        people.entrySet().stream()
                //.filter(personAge -> ageCondition.test(personAge.getValue())) <- only with Predicate
                .filter(personAge -> ageCondition.test(personAge.getValue(), age)) //<- with BIPredicate
                .forEach(printer);
    }
}
