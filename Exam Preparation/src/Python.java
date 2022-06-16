import java.util.Arrays;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        String[] commands = scanner.nextLine().split(", ");
        int myRowPosition = -1;
        int myColPosition = -1;
        int pythonLength = 1;
        boolean killedByEnemy = false;
        for (int i = 0; i < n; i++) {
            char[] currentRow = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] == 's') {
                    myRowPosition = i;
                    myColPosition = j;
                }
            }
            matrix[i] = currentRow;
        }
        int totalFood = getTotalFood(matrix);
        for (String command : commands) {
            switch (command) {
                case "up":
                    myRowPosition--;
                    break;
                case "down":
                    myRowPosition++;
                    break;
                case "right":
                    myColPosition++;
                    break;
                case "left":
                    myColPosition--;
                    break;
            }
            if (outOfBounds(matrix, myRowPosition, myColPosition)) {
                if (myRowPosition < 0) {
                    myRowPosition = matrix.length - 1;
                } else if (myRowPosition >= matrix.length) {
                    myRowPosition = 0;
                }
                if (myColPosition < 0) {
                    myColPosition = matrix.length - 1;
                } else if (myColPosition >= matrix.length) {
                    myColPosition = 0;
                }
            }
            char currentSymbol = matrix[myRowPosition][myColPosition];
            if (currentSymbol == 'f') {
                matrix[myRowPosition][myColPosition] = '*';
                pythonLength++;
                totalFood --;
                if (totalFood <= 0){
                    break;
                }
            } else if (currentSymbol == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                killedByEnemy = true;
                break;
            }
        }
        int leftFood = 0;
        if (!killedByEnemy){
            for (char[] chars : matrix) {
                for (char c : chars) {
                    if (c == 'f'){
                        leftFood++;
                    }
                }
            }
            if (leftFood > 0){
                System.out.printf("You lose! There is still %d food to be eaten.%n", leftFood);
            }else {
                System.out.printf("You win! Final python length is %d%n", pythonLength);
            }
        }

    }

    private static int getTotalFood(char[][] matrix) {
        int totalFood = 0;
        for (char[] chars : matrix) {
            for (char c : chars) {
                if (c == 'f'){
                    totalFood++;
                }
            }
        }
        return totalFood;
    }

    private static boolean outOfBounds(char[][] matrix, int myRowPosition, int myColPosition) {
        if (myRowPosition < 0 || myRowPosition >= matrix.length || myColPosition < 0 || myColPosition >= matrix.length) {
            return true;
        }
        return false;
    }
}
