import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = initializeMatrix(n, scanner);
        int totalBombs = findTotalBombCount(matrix);
        int foundBombs = 0;
        boolean endFound = false;
        boolean stopper = true;
        int myRow = findMyRow(matrix);
        int myCol = findMyCol(matrix);
        matrix[myRow][myCol] = '+';
        for (String command : commands) {
            int myNewRow = myRow;
            int myNewCol = myCol;
            switch (command) {
                case "up":
                    myNewRow--;
                    break;
                case "down":
                    myNewRow++;
                    break;
                case "left":
                    myNewCol--;
                    break;
                case "right":
                    myNewCol++;
                    break;
            }
            if (inBounds(matrix, myNewRow, myNewCol)) {
                myRow = myNewRow;
                myCol = myNewCol;
            }
            if (matrix[myRow][myCol] == 'B'){
                foundBombs++;
                totalBombs--;
                System.out.println("You found a bomb!");
                matrix[myRow][myCol] = '+';
            }else if (matrix[myRow][myCol] == 'e'){
                endFound = true;
                break;
            }
            if (totalBombs <= 0){
                System.out.println("Congratulations! You found all bombs!");
                stopper = false;
                break;
            }
        }

        if (endFound){
            System.out.printf("END! %d bombs left on the field", totalBombs);
        }else if (stopper){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", totalBombs, myRow, myCol);
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
                if (matrix[row][col] == 's') {
                    return row;
                }
            }
        }
        return -1;
    }

    private static int findMyCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    return col;
                }
            }
        }
        return -1;
    }

    private static int findTotalBombCount(char[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    count++;
                }
            }
        }
        return count;
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
