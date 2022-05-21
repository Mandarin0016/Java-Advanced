import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistoryStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.push(browserHistoryStack.pop());
                    System.out.println(browserHistoryStack.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.isEmpty()){
                    System.out.println("no next URLs");
                }else {
                    browserHistoryStack.push(forwardHistory.peek());
                    System.out.println(forwardHistory.pop());
                }
            } else {
                browserHistoryStack.push(input);
                System.out.println(browserHistoryStack.peek());
                forwardHistory.clear();
            }
            input = scanner.nextLine();
        }
    }
}
