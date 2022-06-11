import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstInput = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(firstInput).forEach(tulips::push);
        Arrays.stream(secondInput).forEach(daffodils::offer);
        int bouquets = 0;
        int leftBouquets = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulip = tulips.pop();
            int daffodil = daffodils.poll();
            int flowerSum = tulip + daffodil;
            if (flowerSum == 15) {
                bouquets++;
            } else if (flowerSum > 15) {
                while (flowerSum > 15) {
                    tulip -= 2;
                    flowerSum = tulip + daffodil;
                    if (flowerSum == 15) {
                        bouquets++;
                        break;
                    } else if (flowerSum < 15) {
                        leftBouquets += flowerSum;
                        break;
                    }
                }
            } else {
                leftBouquets += flowerSum;
            }
        }
        if (leftBouquets >= 15) {
            while (leftBouquets >= 15) {
                bouquets++;
                leftBouquets -= 15;
            }
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}