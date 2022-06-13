import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lineOne = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] lineTwo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(lineOne).forEach(firstLootBox::offer);
        Arrays.stream(lineTwo).forEach(secondLootBox::push);
        int totalValue = 0;
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()){
            int firstBoxItem = firstLootBox.poll();
            int secondBoxItem = secondLootBox.pop();
            if ((firstBoxItem + secondBoxItem) % 2 == 0){
                totalValue += firstBoxItem + secondBoxItem;
            }else {
                firstLootBox.push(firstBoxItem);
                firstLootBox.offer(secondBoxItem);
            }
        }
        if (secondLootBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }else {
            System.out.println("First lootbox is empty");
        }
        if (totalValue >= 100){
            System.out.println("Your loot was epic! Value: " + totalValue);
        }else {
            System.out.println("Your loot was poor... Value: " + totalValue);
        }
    }
}
