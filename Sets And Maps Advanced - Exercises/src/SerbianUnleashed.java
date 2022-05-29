import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern correctLine = Pattern.compile("^(?<singerName>[A-Za-z0-7 ]+) @(?<venue>[A-Za-z0-7 ]+) (?<ticketPrice>[0-9]+) (?<ticketCount>[0-9]+)$");
        Map<String, LinkedHashMap<String, Long>> concertMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            Matcher checkLine = correctLine.matcher(input);
            if (checkLine.find()){
                String venue = checkLine.group("venue");
                String singerName = checkLine.group("singerName");
                Long ticketPrice = Long.parseLong(checkLine.group("ticketPrice"));
                Long ticketCount = Long.parseLong(checkLine.group("ticketCount"));
                if (!concertMap.containsKey(venue)){
                    concertMap.put(venue, new LinkedHashMap<>());
                    concertMap.get(venue).put(singerName, ticketCount * ticketPrice);
                }else {
                    if (!concertMap.get(venue).containsKey(singerName)){
                        concertMap.get(venue).put(singerName, ticketCount * ticketPrice);
                    }else {
                        concertMap.get(venue).put(singerName, (ticketCount * ticketPrice) + concertMap.get(venue).get(singerName));
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Long>> singer : concertMap.entrySet()) {
            System.out.println(singer.getKey());
            singer.getValue()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        }

    }
}
