import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);
        while (stack.size() > 1){
            int numberOne = Integer.parseInt(stack.pop());
            String symbol = stack.pop();
            int numberTwo = Integer.parseInt(stack.pop());
            int result = 0;
            switch (symbol){
                case "+":
                    result = numberOne + numberTwo;
                    break;
                case "-":
                    result = numberOne - numberTwo;
                    break;
            }
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.peek());
    }
}