import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> symbolOccurrenceMap = new TreeMap<>();
        char[] symbols = scanner.nextLine().toCharArray();
        for (char symbol : symbols) {
            if (!symbolOccurrenceMap.containsKey(symbol)){
                symbolOccurrenceMap.put(symbol, 1);
            }else {
                symbolOccurrenceMap.put(symbol, symbolOccurrenceMap.get(symbol) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbolOccurrenceMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
