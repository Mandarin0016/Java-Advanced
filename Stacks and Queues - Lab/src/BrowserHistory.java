import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        while (!input.equals("Home")){
            if (input.equals("back")){
                if (browserHistoryStack.size() <= 1){
                    System.out.println("no previous URLs");
                }else {
                    browserHistoryStack.pop();
                    System.out.println(browserHistoryStack.peek());
                }
            }else {
                browserHistoryStack.push(input);
                System.out.println(browserHistoryStack.peek());
            }
            input = scanner.nextLine();
        }
    }
}