import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countryMap = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("\\|");
        while (!input[0].equals("report")){
            String country = input[1];
            String city = input[0];
            Long population = Long.parseLong(input[2]);
            if (!countryMap.containsKey(country)) {
                countryMap.put(country, new LinkedHashMap<>());
            }
            countryMap.get(country).put(city, population);
            input = scanner.nextLine().split("\\|");
        }
        Map<String, Long> countryMapTotalPopulation = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Long>> country : countryMap.entrySet()) {
            long totalPopulation = 0;
            for (Map.Entry<String, Long> city : country.getValue().entrySet()) {
                totalPopulation += city.getValue();
            }
            countryMapTotalPopulation.put(country.getKey(), totalPopulation);
        }
        Map<String, Long> sortedCountryMap = new LinkedHashMap<>();
        countryMapTotalPopulation.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedCountryMap.put(x.getKey(), x.getValue()));
        for (Map.Entry<String, Long> country : sortedCountryMap.entrySet()) {
            System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());
            //=>Veliko Tarnovo: 2
            //=>Sofia: 1
            Map<String, Long> sortedCityMap = new LinkedHashMap<>();
            countryMap.get(country.getKey()).entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(e -> sortedCityMap.put(e.getKey(), e.getValue()));
            for (Map.Entry<String, Long> city : sortedCityMap.entrySet()) {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            }
        }
    }
}