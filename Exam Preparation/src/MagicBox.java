import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lineOne = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] lineTwo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        Arrays.stream(lineOne).forEach(firstMagicBox::offer);
        Arrays.stream(lineTwo).forEach(secondMagicBox::push);
        int totalValue = 0;
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()){
            int firstBoxItem = firstMagicBox.poll();
            int secondBoxItem = secondMagicBox.pop();
            if ((firstBoxItem + secondBoxItem) % 2 == 0){
                totalValue += firstBoxItem + secondBoxItem;
            }else {
                firstMagicBox.push(firstBoxItem);
                firstMagicBox.offer(secondBoxItem);
            }
        }
        if (secondMagicBox.isEmpty()){
            System.out.println("Second magic box is empty.");
        }else {
            System.out.println("First magic box is empty.");
        }
        if (totalValue >= 90){
            System.out.println("Wow, your prey was epic! Value: " + totalValue);
        }else {
            System.out.println("Poor prey... Value: " +  totalValue);
        }
    }
}
