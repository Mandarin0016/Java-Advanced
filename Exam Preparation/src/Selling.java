import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = initializeMatrix(n, scanner);
        int clients = 0;
        boolean moneyFound = false;
        String command = scanner.nextLine();
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
            if (inBounds(matrix, myRow, myCol)) {
                if (Character.isDigit(matrix[myRow][myCol])) {
                    clients += Integer.parseInt(matrix[myRow][myCol] + "");
                    matrix[myRow][myCol] = 'S';
                } else if (matrix[myRow][myCol] == 'O') {
                    int otherPillarRow = findOtherPillarRow(matrix, myRow, myCol);
                    int otherPillarCol = findOtherPillarCol(matrix, myRow, myCol);
                    matrix[myRow][myCol] = '-';
                    myRow = otherPillarRow;
                    myCol = otherPillarCol;
                    matrix[myRow][myCol] = 'S';
                }else {
                    matrix[myRow][myCol] = 'S';
                }
            } else {
                break;
            }
            if (clients >= 50){
                moneyFound = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (moneyFound){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }else {
            System.out.println("Bad news, you are out of the bakery.");
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
    private static int findOtherPillarRow(char[][] matrix, int myRow, int myCol) {
        int start = myCol + 1;
        for (int row = myRow; row < matrix.length; row++) {
            for (int col = start; col < matrix.length; col++) {
                if (matrix[row][col] == 'O'){
                    return row;
                }
            }
            start = 0;
        }
        return -1;
    }
    private static int findOtherPillarCol(char[][] matrix, int myRow, int myCol) {
        int start = myCol + 1;
        for (int row = myRow; row < matrix.length; row++) {
            for (int col = start; col < matrix.length; col++) {
                if (matrix[row][col] == 'O'){
                    return col;
                }
            }
            start = 0;
        }
        return -1;
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
            char[] currentRow = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[i] = currentRow;
        }
        return matrix;
    }
}
