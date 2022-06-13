import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(lilies::push);
        Arrays.stream(secondLine).forEach(roses::offer);
        int wreaths = 0;
        int leftFlowerSum = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lily = lilies.pop();
            int rose = roses.poll();
            if (lily + rose == 15) {
                wreaths++;
            } else if (lily + rose > 15) {
                int sum = lily + rose;
                while (sum > 15) {
                    lily -= 2;
                    sum = lily + rose;
                }
                if (sum == 15) {
                    wreaths++;
                } else {
                    leftFlowerSum += sum;
                }
            } else {
                leftFlowerSum += lily + rose;
            }
        }
        while (leftFlowerSum >= 15) {
            wreaths++;
            leftFlowerSum -= 15;
        }
        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        }else {
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        }
    }
}
