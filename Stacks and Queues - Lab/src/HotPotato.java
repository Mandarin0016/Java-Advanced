import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());
        Queue<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        while (children.size() > 1){
            for (int i = 0; i < tossCount - 1; i++) {
                String previousKid = children.poll();
                children.offer(previousKid);
            }
            System.out.println("Removed " + children.peek());
            children.poll();
        }
        System.out.printf("Last is %s%n", children.peek());
    }
}
