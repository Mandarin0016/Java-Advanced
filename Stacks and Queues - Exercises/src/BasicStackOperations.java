import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int stackSize = Integer.parseInt(input[0]);
        int elementsToBePopped = Integer.parseInt(input[1]);
        int lookingForNumber = Integer.parseInt(input[2]);
        List<Integer> stackInitialData = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> myStack = new ArrayDeque<>();
        for (int i = 0; i < stackSize; i++) {
            myStack.push(stackInitialData.get(i));
        }
        for (int i = 0; i < elementsToBePopped; i++) {
            myStack.pop();
        }
        if (myStack.isEmpty()){
            System.out.println(0);
        }else if (myStack.contains(lookingForNumber)){
            System.out.println("true");
        }else {
            int minNumber = Integer.MAX_VALUE;
            for (int i = 0; i < myStack.size(); i++) {
                int currentNumber = myStack.pop();
                if (currentNumber < minNumber){
                    minNumber = currentNumber;
                }
            }
            System.out.println(minNumber);
        }

    }
}
