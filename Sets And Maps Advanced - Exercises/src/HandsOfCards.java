import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playersMap = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(": ");
        while (!input[0].equals("JOKER")) {
            if (!playersMap.containsKey(input[0])) {
                Set<String> currentCardSet = new HashSet<>(List.of(input[1].split(", ")));
                playersMap.put(input[0], currentCardSet);
            } else {
                Set<String> newCardSet = new HashSet<>(List.of(input[1].split(", ")));
                for (String s : newCardSet) {
                    playersMap.get(input[0]).add(s);
                }
            }
            input = scanner.nextLine().split(": ");
        }
        printPersonalCardValue(playersMap);
    }

    private static void printPersonalCardValue(Map<String, Set<String>> playersMap) {
        for (Map.Entry<String, Set<String>> player : playersMap.entrySet()) {
            int cardsValue = 0;
            for (String card : player.getValue()) {
                char firstLetter = card.charAt(0);
                char secondLetter = card.charAt(card.length() - 1);
                int firstMultiplier = 1;
                int secondMultiplier = 1;
                if (Character.isDigit(firstLetter) || card.length() == 3){
                    if (card.length() == 3){
                        firstMultiplier = Integer.parseInt(card.substring(0, 2));
                    }else {
                        firstMultiplier = Integer.parseInt(String.valueOf(firstLetter));
                    }
                }else {
                    switch (firstLetter){
                        case 'J':
                            firstMultiplier = 11;
                            break;
                        case 'Q':
                            firstMultiplier = 12;
                            break;
                        case 'K':
                            firstMultiplier = 13;
                            break;
                        case 'A':
                            firstMultiplier = 14;
                            break;
                    }
                }
                switch (secondLetter){
                    case 'S':
                        secondMultiplier = 4;
                        break;
                    case 'H':
                        secondMultiplier = 3;
                        break;
                    case 'D':
                        secondMultiplier = 2;
                        break;
                }
                cardsValue += firstMultiplier * secondMultiplier;
            }
            System.out.println(player.getKey() + ": " + cardsValue);
        }

    }
}
