import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicsQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int numbersToEnqueue = scanner.nextInt();
        int numbersToDequeue = scanner.nextInt();
        int numberToBeFound = scanner.nextInt();
        for (int i = 0; i < numbersToEnqueue; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < numbersToDequeue; i++) {
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.println(0);
        }else {
            if (queue.contains(numberToBeFound)){
                System.out.println("true");
            }else{
                System.out.println(Collections.min(queue));
            }
        }
    }
}
