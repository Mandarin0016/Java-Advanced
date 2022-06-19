import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = initializeMatrix(n, scanner);
        int niceKindsCount = findNiceKidsCount(matrix);
        int originalKidsCount = findNiceKidsCount(matrix);
        boolean ranOutOfPresents = false;
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
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
                if (matrix[myRow][myCol] == 'V') {
                    niceKindsCount--;
                    presentsCount--;
                    matrix[myRow][myCol] = 'S';
                } else if (matrix[myRow][myCol] == 'X') {
                    matrix[myRow][myCol] = 'S';
                } else if (matrix[myRow][myCol] == 'C') {
                    //check up
                    if (matrix[myRow - 1][myCol] == 'V') {
                        niceKindsCount--;
                        presentsCount--;
                    } else if (matrix[myRow - 1][myCol] == 'X') {
                        presentsCount--;
                        originalKidsCount++;
                    }
                    matrix[myRow - 1][myCol] = '-';
                    //check down
                    if (matrix[myRow + 1][myCol] == 'V') {
                        niceKindsCount--;
                        presentsCount--;
                    } else if (matrix[myRow + 1][myCol] == 'X') {
                        presentsCount--;
                        originalKidsCount++;
                    }
                    matrix[myRow + 1][myCol] = '-';
                    //check left
                    if (matrix[myRow][myCol - 1] == 'V') {
                        niceKindsCount--;
                        presentsCount--;
                    } else if (matrix[myRow][myCol - 1] == 'X') {
                        presentsCount--;
                        originalKidsCount++;
                    }
                    matrix[myRow][myCol - 1] = '-';
                    //check right
                    if (matrix[myRow][myCol + 1] == 'V') {
                        niceKindsCount--;
                        presentsCount--;
                    } else if (matrix[myRow][myCol + 1] == 'X') {
                        presentsCount--;
                        originalKidsCount++;
                    }
                    matrix[myRow][myCol + 1] = '-';
                    matrix[myRow][myCol] = 'S';
                } else {
                    matrix[myRow][myCol] = 'S';
                }
            } else {
                ranOutOfPresents = true;
                break;
            }
            if (presentsCount <= 0) {
                ranOutOfPresents = true;
                break;
            }
            command = scanner.nextLine();
        }

        if (ranOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (niceKindsCount <= 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", originalKidsCount);
        }else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKindsCount);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    private static boolean inBounds(char[][] matrix, int myRow, int myCol) {
        if (myRow >= 0 && myRow < matrix.length && myCol >= 0 && myCol < matrix.length) {
            return true;
        }
        return false;
    }

    private static int findMyCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    return col;
                }
            }
        }
        return 0;
    }

    private static int findMyRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    return row;
                }
            }
        }
        return 0;
    }

    private static int findNiceKidsCount(char[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'V') {
                    counter++;
                }
            }
        }
        return counter;
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
