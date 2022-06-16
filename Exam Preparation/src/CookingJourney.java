import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = initializeMatrix(n, scanner);
        int clients = 0;
        String command = scanner.nextLine();
        boolean didTheJob = false;
        while (true) {
            int myRow = findMyRow(matrix);
            int myCol = findMyCol(matrix);
            matrix[myRow][myCol] = '-';
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
            if (!outOfBounds(matrix, myRow, myCol)) {
                if (Character.isDigit(matrix[myRow][myCol])) {
                    clients += Integer.parseInt(matrix[myRow][myCol] + "");
                    matrix[myRow][myCol] = 'S';
                } else if (matrix[myRow][myCol] == 'P') {
                    int otherPillarRow = findOtherPillarRow(matrix, myRow, myCol);
                    int otherPillarCol = findOtherPillarCol(matrix, myRow, myCol);
                    matrix[myRow][myCol] = '-';
                    myRow = otherPillarRow;
                    myCol = otherPillarCol;
                    matrix[myRow][myCol] = 'S';
                } else {
                    matrix[myRow][myCol] = 'S';
                }
            } else {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (clients >= 50) {
                didTheJob = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (didTheJob) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + clients);
        printMatrix(matrix);
    }
    public static void printMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static int findOtherPillarRow(char[][] matrix, int currentRow, int currentCol) {
        int start = currentCol + 1;
        for (int row = currentRow; row < matrix.length; row++) {
            for (int col = start; col < matrix.length; col++) {
                if (matrix[row][col] == 'P') {
                    return row;
                }
            }
            start = 0;
        }
        return 0;
    }

    private static int findOtherPillarCol(char[][] matrix, int currentRow, int currentCol) {
        int start = currentCol + 1;
        for (int row = currentRow; row < matrix.length; row++) {
            for (int col = start; col < matrix.length; col++) {
                if (matrix[row][col] == 'P') {
                    return col;
                }
            }
            start = 0;
        }
        return 0;
    }

    private static boolean outOfBounds(char[][] matrix, int myRow, int myCol) {
        if (myRow < 0 || myRow >= matrix.length || myCol < 0 || myCol >= matrix.length) {
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
