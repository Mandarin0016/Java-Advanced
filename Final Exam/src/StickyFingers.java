import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = initializeMatrix(n, scanner);
        int myRow = findMyRow(matrix);
        int myCol = findMyCol(matrix);
        int myPocket = 0;
        boolean dillingerInJail = false;
        for (String command : commands) {
            matrix[myRow][myCol] = '+';
            switch (command) {
                case "up":
                    myRow--;
                    if (!inBounds(matrix, myRow, myCol)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        myRow++;
                        matrix[myRow][myCol] = 'D';
                    }
                    break;
                case "down":
                    myRow++;
                    if (!inBounds(matrix, myRow, myCol)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        myRow--;
                        matrix[myRow][myCol] = 'D';
                    }
                    break;
                case "left":
                    myCol--;
                    if (!inBounds(matrix, myRow, myCol)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        myCol++;
                        matrix[myRow][myCol] = 'D';
                    }
                    break;
                case "right":
                    myCol++;
                    if (!inBounds(matrix, myRow, myCol)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        myCol--;
                        matrix[myRow][myCol] = 'D';
                    }
                    break;
            }
            if (matrix[myRow][myCol] == '$') {
                //robbing a house
                int profit = myRow * myCol;
                System.out.printf("You successfully stole %d$.%n", profit);
                myPocket += profit;
                matrix[myRow][myCol] = 'D';
            } else if (matrix[myRow][myCol] == 'P') {
                //caught by police
                System.out.printf("You got caught with %d$, and you are going to jail.%n", myPocket);
                dillingerInJail = true;
                matrix[myRow][myCol] = '#';
                break;
            }else {
                matrix[myRow][myCol] = 'D';
            }

        }

        if (!dillingerInJail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", myPocket);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(chars[col] + " ");
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
                if (matrix[row][col] == 'D') {
                    return row;
                }
            }
        }
        return -1;
    }

    private static int findMyCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'D') {
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
