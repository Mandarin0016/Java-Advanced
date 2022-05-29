import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> sumMap = new TreeMap<>();
        TreeMap<String, TreeSet<String>> IPMap = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //192.168.0.11 peter 33
            String[] input = scanner.nextLine().split("\\s+");
            String IP = input[0];
            String name = input[1];
            int time = Integer.parseInt(input[2]);
            if (!sumMap.containsKey(name)) {
                sumMap.put(name, time);
                IPMap.put(name, new TreeSet<>());
                IPMap.get(name).add(IP);
            } else {
                sumMap.put(name, sumMap.get(name) + time);
                IPMap.get(name).add(IP);
            }
        }
        printMaps(sumMap, IPMap);
    }

    private static void printMaps(Map<String, Integer> sumMap, Map<String, TreeSet<String>> ipMap) {
        sumMap.forEach((key, value) -> System.out.printf("%s: %d %s%n", key, value, ipMap.get(key).toString()));
    }
}
