import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> realNumbersCountMap = new LinkedHashMap<>();
        List<Double> inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        for (double number : inputNumbers) {
            if (!realNumbersCountMap.containsKey(number)){
                realNumbersCountMap.put(number, 1);
            }else {
                realNumbersCountMap.put(number, realNumbersCountMap.get(number) + 1);
            }
        }
        for (Map.Entry<Double, Integer> number : realNumbersCountMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", number.getKey(), number.getValue());
        }

    }
}
