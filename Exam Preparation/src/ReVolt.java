import java.util.Scanner;

public class ReVolt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = initializeMatrix(n, scanner);
        int myRow = findMyRow(matrix);
        int myCol = findMyCol(matrix);
        boolean didNotWon = true;
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            matrix[myRow][myCol] = '-';
            switch (command) {
                case "up":
                    myRow--;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'B') {
                        myRow--;
                    } else if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'T') {
                        myRow++;
                    }
                    break;
                case "down":
                    myRow++;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'B') {
                        myRow++;
                    } else if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'T') {
                        myRow--;
                    }
                    break;
                case "left":
                    myCol--;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'B') {
                        myCol--;
                    } else if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'T') {
                        myCol++;
                    }
                    break;
                case "right":
                    myCol++;
                    if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'B') {
                        myCol++;
                    } else if (inBounds(matrix, myRow, myCol) && matrix[myRow][myCol] == 'T') {
                        myCol--;
                    }
                    break;
            }
            if (inBounds(matrix, myRow, myCol)) {
                if (matrix[myRow][myCol] == 'F') {
                    System.out.println("Player won!");
                    didNotWon = false;
                    matrix[myRow][myCol] = 'f';
                    break;
                }
                matrix[myRow][myCol] = 'f';
            } else {
                if (myRow >= matrix.length) {
                    myRow = 0;
                } else if (myRow < 0) {
                    myRow = matrix.length - 1;
                } else if (myCol >= matrix[myRow].length) {
                    myCol = 0;
                } else if (myCol < 0) {
                    myCol = matrix[myRow].length - 1;
                }
                if (matrix[myRow][myCol] == 'F') {
                    System.out.println("Player won!");
                    didNotWon = false;
                    matrix[myRow][myCol] = 'f';
                    break;
                } else if (matrix[myRow][myCol] == 'B') {
                    if (command.equals("up")) {
                        myRow --;
                    } else if (command.equals("down")) {
                        myRow++;
                    } else if (command.equals("right")) {
                        myCol++;
                    } else {
                        myCol--;
                    }
                } else if (matrix[myRow][myCol] == 'T') {
                    if (command.equals("up")) {
                        myRow ++;
                    } else if (command.equals("down")) {
                        myRow--;
                    } else if (command.equals("right")) {
                        myCol--;
                    } else {
                        myCol++;
                    }
                    if (myRow >= matrix.length) {
                        myRow = 0;
                    } else if (myRow < 0) {
                        myRow = matrix.length - 1;
                    } else if (myCol >= matrix[myRow].length) {
                        myCol = 0;
                    } else if (myCol < 0) {
                        myCol = matrix[myRow].length - 1;
                    }
                }
                matrix[myRow][myCol] = 'f';
            }
        }
        if (didNotWon) {
            System.out.println("Player lost!");
        }
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

    private static boolean inBounds(char[][] matrix, int myRow, int myCol) {
        if (myRow >= 0 && myRow < matrix.length && myCol >= 0 && myCol < matrix[myRow].length) {
            return true;
        }
        return false;
    }

    private static int findMyRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'f') {
                    return row;
                }
            }
        }
        return -1;
    }

    private static int findMyCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'f') {
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
