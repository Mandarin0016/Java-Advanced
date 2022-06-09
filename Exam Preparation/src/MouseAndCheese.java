import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[i] = currentRow;
        }
        int cheeseCount = 0;
        boolean mouseWentOut = false;
        String data = scanner.nextLine();
        while (!data.equals("end")) {
            int mouseRow = getMouseRow(matrix);
            int mouseCol = getMouseCol(matrix);
            matrix[mouseRow][mouseCol] = '-';
            switch (data) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }
            if (coordinatesAreCorrect(matrix, mouseRow, mouseCol)) {
                if (matrix[mouseRow][mouseCol] == 'c'){
                 cheeseCount++;
                }else if (matrix[mouseRow][mouseCol] == 'B'){
                    matrix[mouseRow][mouseCol] = '-';
                    switch (data) {
                        case "up":
                            mouseRow--;
                            break;
                        case "down":
                            mouseRow++;
                            break;
                        case "left":
                            mouseCol--;
                            break;
                        case "right":
                            mouseCol++;
                            break;
                    }
                    if (matrix[mouseRow][mouseCol] == 'c'){
                        cheeseCount++;
                    }
                }
                matrix[mouseRow][mouseCol] = 'M';
            } else {
                mouseWentOut = true;
                break;
            }
            data = scanner.nextLine();
        }

        if (mouseWentOut){
            System.out.println("Where is the mouse?");
        }
        if (cheeseCount >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCount);
        }else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(chars[col]);
            }
            System.out.println();
        }
    }

    private static boolean coordinatesAreCorrect(char[][] matrix, int mouseRow, int mouseCol) {
        if (mouseRow >= matrix.length || mouseRow < 0 || mouseCol >= matrix.length || mouseCol < 0) {
            return false;
        }
        return true;
    }

    private static int getMouseRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    return row;
                }
            }
        }
        return 0;
    }

    private static int getMouseCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    return col;
                }
            }
        }
        return 0;
    }
}
