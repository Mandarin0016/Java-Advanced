import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = initializeMatrix(n, scanner);
        int pollinatedFlowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int myRow = findMyRow(matrix);
            int myCol = findMyCol(matrix);
            matrix[myRow][myCol] = '.';
            switch (command) {
                case "up":
                    myRow--;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'O') {
                        matrix[myRow][myCol] = '.';
                        myRow--;
                    }
                    break;
                case "down":
                    myRow++;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'O') {
                        matrix[myRow][myCol] = '.';
                        myRow++;
                    }
                    break;
                case "left":
                    myCol--;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'O') {
                        matrix[myRow][myCol] = '.';
                        myCol--;
                    }
                    break;
                case "right":
                    myCol++;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'O') {
                        matrix[myRow][myCol] = '.';
                        myCol++;
                    }
                    break;
            }
            if (inBounds(matrix, myRow, myCol)) {
                if (matrix[myRow][myCol] == 'f') {
                    pollinatedFlowers++;
                }
                matrix[myRow][myCol] = 'B';
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
        printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean inBounds(char[][] matrix, int myNewRow, int myNewCol) {
        if (myNewRow >= 0 && myNewRow < matrix.length && myNewCol >= 0 && myNewCol < matrix.length) {
            return true;
        }
        return false;
    }

    private static int findMyRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    return row;
                }
            }
        }
        return -1;
    }

    private static int findMyCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
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
