import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());
        Queue<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int cycles = 1;
        while (children.size() > 1) {
            for (int i = 0; i < tossCount - 1; i++) {
                String previousKid = children.poll();
                children.offer(previousKid);
            }
            if (primeChecker(cycles)) {
                System.out.printf("Prime %s%n", children.peek());
            } else {
                System.out.println("Removed " + children.peek());
                children.poll();
            }
            cycles++;
        }
        System.out.printf("Last is %s%n", children.peek());
    }

    public static boolean primeChecker(int n) {
        if (n == 1){
            return false;
        }else if (n == 2 || n == 3){
            return true;
        }else {
            for (int i = 2; i < n; i++) {
                if(n % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
