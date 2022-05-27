import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, List<String>>> continentMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];
            if (!continentMap.containsKey(continent)) {
                continentMap.put(continent, new LinkedHashMap<>());
            }
            if (!continentMap.get(continent).containsKey(country)) {
                continentMap.get(continent).put(country, new ArrayList<>());
            }
            continentMap.get(continent).get(country).add(city);
        }
        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : continentMap.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.println("  " + country.getKey() + " -> " + String.join(", ", country.getValue()));
            }
        }

    }
}
