import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<String, Double> parser = Double::parseDouble;
        UnaryOperator<Double> addingVAT = price -> price * 1.2;
        Consumer<Double> printer = price -> System.out.printf("%.2f%n", price);
        List<Double> numbers = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(parser)
                .map(addingVAT).collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        numbers.forEach(printer);
    }
}
