import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        Queue<String> printingQueue = new ArrayDeque<>();
        while (!data.equals("print")) {
            if (data.equals("cancel")) {
                if (printingQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", printingQueue.peek());
                    printingQueue.poll();
                }
            } else {
                printingQueue.offer(data);
            }
            data = scanner.nextLine();
        }
        printingQueue.forEach(System.out::println);
    }
}
