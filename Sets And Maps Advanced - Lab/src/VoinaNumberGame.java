import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstInput = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondInput = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Set<Integer> firstPlayerCards = new LinkedHashSet<>(firstInput);
        Set<Integer> secondPlayerCards = new LinkedHashSet<>(secondInput);
        for (int i = 0; i < 50; i++) {
            if (firstPlayerCards.isEmpty()){
                System.out.println("Second player win!");
            }
            if (secondPlayerCards.isEmpty()){
                System.out.println("First player win!");
            }
            int firstCard = getTopCardFromTheSet(firstPlayerCards);
            int secondCard = getTopCardFromTheSet(secondPlayerCards);
            firstPlayerCards.remove(firstCard);
            secondPlayerCards.remove(secondCard);
            if (firstCard > secondCard){
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            }else if (secondCard > firstCard){
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }else {
                firstPlayerCards.add(secondCard);
                secondPlayerCards.add(firstCard);
            }
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        }else if (secondPlayerCards.size() > firstPlayerCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }

    private static int getTopCardFromTheSet(Set<Integer> firstPlayerCards) {
        for (Integer card : firstPlayerCards) {
            return card;
        }

        return 0;
    }
}
