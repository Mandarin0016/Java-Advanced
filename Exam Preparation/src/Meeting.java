import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        int[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(firstLine).forEach(males::push);
        Arrays.stream(secondLine).forEach(females::offer);
        int matches = 0;
        while (!(males.isEmpty() || females.isEmpty())) {
            int male = males.peek();
            int female = females.peek();
            if ((male % 25 == 0) && (male != 0)) {
                males.pop();
                if (!males.isEmpty()) {
                    males.pop();
                }
            } else if ((female % 25 == 0) && (female != 0)) {
                females.poll();
                if (!females.isEmpty()) {
                    females.poll();
                }
            } else if (male <= 0) {
                males.pop();
            } else if (female <= 0) {
                females.poll();
            } else if (male == female) {
                matches++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                males.pop();
                males.push(male - 2);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        if (males.isEmpty()){
            System.out.println("Males left: none");
        }else{
            System.out.print("Males left: ");
            while (!males.isEmpty()){
                System.out.print(males.pop());
                if (males.isEmpty()){
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        if (females.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.print("Females left: ");
            while (!females.isEmpty()){
                System.out.print(females.poll());
                if (females.isEmpty()){
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
    }
}
