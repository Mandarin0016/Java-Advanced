import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = initializeMatrix(n, scanner);

        int foodQuantity = 0;

        String command = scanner.nextLine();
        while (true) {
            int myRow = findMyRow(matrix);
            int myCol = findMyCol(matrix);
            matrix[myRow][myCol] = '.';
            switch (command) {
                case "up":
                    myRow--;
                    break;
                case "down":
                    myRow++;
                    break;
                case "left":
                    myCol--;
                    break;
                case "right":
                    myCol++;
                    break;
            }
            if (inBounds(matrix, myRow, myCol)) {
                if (matrix[myRow][myCol] == '*') {
                    foodQuantity++;
                    matrix[myRow][myCol] = 'S';
                } else if (matrix[myRow][myCol] == 'B') {
                    int otherLairSpawnRow = findOtherLiarRowPosition(matrix, myRow, myCol);
                    int otherLairSpawnCol = findOtherLiarColPosition(matrix, myRow, myCol);
                    matrix[myRow][myCol] = '.';
                    matrix[otherLairSpawnRow][otherLairSpawnCol] = 'S';
                }else {
                    matrix[myRow][myCol] = 'S';
                }
            } else {
                System.out.println("Game over!");
                break;
            }
            if (foodQuantity >= 10){
                System.out.println("You won! You fed the snake.");
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Food eaten: " + foodQuantity);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int findOtherLiarRowPosition(char[][] matrix, int myRow, int myCol) {
        int start = myCol + 1;
        for (int row = myRow; row < matrix.length; row++) {
            for (int col = start; col < matrix.length; col++) {
                if (matrix[row][col] == 'B'){
                    return row;
                }
            }
            start = 0;
        }
        return 0;
    }
    private static int findOtherLiarColPosition(char[][] matrix, int myRow, int myCol) {
        int start = myCol + 1;
        for (int row = myRow; row < matrix.length; row++) {
            for (int col = start; col < matrix.length; col++) {
                if (matrix[row][col] == 'B'){
                    return col;
                }
            }
            start = 0;
        }
        return 0;
    }

    private static boolean inBounds(char[][] matrix, int myRow, int myCol) {
        if (myRow >= 0 && myRow < matrix.length && myCol >= 0 && myCol < matrix.length) {
            return true;
        }
        return false;
    }

    private static int findMyRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    return row;
                }
            }
        }
        return -1;
    }

    private static int findMyCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    return col;
                }
            }
        }
        return -1;
    }

    public static char[][] initializeMatrix(int n, Scanner scanner) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[i] = currentRow;
        }
        return matrix;
    }
}
