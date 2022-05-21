import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> parenthesesStack = new ArrayDeque<>();
        boolean isBalanced = true;
        String input = scanner.nextLine();
        for (char symbol : input.toCharArray()) {
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                parenthesesStack.push(symbol);
            }else {
                if (parenthesesStack.isEmpty()){
                    isBalanced = false;
                    break;
                }else{
                    char lastParenthesis = parenthesesStack.pop();
                    if (lastParenthesis == '(' && symbol != ')'){
                        isBalanced = false;
                        break;
                    }else if (lastParenthesis == '{' && symbol != '}'){
                        isBalanced = false;
                        break;
                    }else if (lastParenthesis == '[' && symbol != ']'){
                        isBalanced = false;
                        break;
                    }
                }
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
