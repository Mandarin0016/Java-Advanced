import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[i] = currentRow;
        }
        boolean won = false;
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            int playerRow = findPlayerRow(matrix);
            int playerCol = findPlayerCol(matrix);
            int playerNextStepRow = findPlayerRow(matrix);
            int playerNextStepCol = findPlayerCol(matrix);
            matrix[playerRow][playerCol] = '.';
            switch (command) {
                case "up":
                    playerNextStepRow--;
                    break;
                case "down":
                    playerNextStepRow++;
                    break;
                case "left":
                    playerNextStepCol--;
                    break;
                case "right":
                    playerNextStepCol++;
                    break;
            }
            boolean checkAgain = false;
            if (correctCoordinates(matrix, playerNextStepCol, playerNextStepRow)){
                if (matrix[playerNextStepRow][playerNextStepCol] == 'B'){
                    switch (command) {
                        case "up":
                            playerNextStepRow--;
                            break;
                        case "down":
                            playerNextStepRow++;
                            break;
                        case "left":
                            playerNextStepCol--;
                            break;
                        case "right":
                            playerNextStepCol++;
                            break;
                    }
                }else if (matrix[playerNextStepRow][playerNextStepCol] == 'T') {
                    switch (command) {
                        case "up":
                            playerNextStepRow++;
                            break;
                        case "down":
                            playerNextStepRow--;
                            break;
                        case "left":
                            playerNextStepCol++;
                            break;
                        case "right":
                            playerNextStepCol--;
                            break;
                    }
                }
            }else {
                if (rowOutOfBounds(matrix, playerNextStepRow)) {
                    if (playerNextStepRow < 0) {
                        playerNextStepRow = matrix.length - 1;
                    } else {
                        playerNextStepRow = 0;
                    }
                }
                if (colOutOfBounds(matrix, playerNextStepCol)){
                    if (playerNextStepCol < 0){
                        playerNextStepCol = matrix.length - 1;
                    }else {
                        playerNextStepCol = 0;
                    }
                }
                checkAgain = true;
            }
            if (checkAgain){
                if (matrix[playerNextStepRow][playerNextStepCol] == 'B'){
                    switch (command) {
                        case "up":
                            playerNextStepRow--;
                            break;
                        case "down":
                            playerNextStepRow++;
                            break;
                        case "left":
                            playerNextStepCol--;
                            break;
                        case "right":
                            playerNextStepCol++;
                            break;
                    }
                }else if (matrix[playerNextStepRow][playerNextStepCol] == 'T') {
                    switch (command) {
                        case "up":
                            playerNextStepRow++;
                            break;
                        case "down":
                            playerNextStepRow--;
                            break;
                        case "left":
                            playerNextStepCol++;
                            break;
                        case "right":
                            playerNextStepCol--;
                            break;
                    }
                }
            }
            if (rowOutOfBounds(matrix, playerNextStepRow)){
                if (playerRow == 0){
                    playerRow = matrix.length - 1;
                }else{
                    playerRow = 0;
                }
            }else {
                playerRow = playerNextStepRow;
            }
            if (colOutOfBounds(matrix, playerNextStepCol)){
                if (playerCol == 0){
                    playerCol = matrix.length - 1;
                }else {
                    playerCol = 0;
                }
            }else {
                playerCol = playerNextStepCol;
            }

            if (matrix[playerRow][playerCol] == 'F'){
                System.out.println("Well done, the player won first place!");
                matrix[playerRow][playerCol] = 'P';
                won = true;
                break;
            }else {
                matrix[playerRow][playerCol] = 'P';
            }
        }
        if (!won){
            System.out.println("Oh no, the player got lost on the track!");
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

    private static boolean correctCoordinates(char[][] matrix, int playerNextStepCol, int playerNextStepRow) {
        if (playerNextStepRow < 0 || playerNextStepRow >= matrix.length || playerNextStepCol < 0 || playerNextStepCol >= matrix.length){
            return false;
        }
        return true;
    }

    private static boolean colOutOfBounds(char[][] matrix, int playerNextStepCol) {
        if (playerNextStepCol < 0 || playerNextStepCol >= matrix.length){
            return true;
        }
        return false;
    }

    private static boolean rowOutOfBounds(char[][] matrix, int playerNextStepRow) {
        if (playerNextStepRow < 0 || playerNextStepRow >= matrix.length){
            return true;
        }
        return false;
    }

    private static int findPlayerRow(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'P'){
                    return i;
                }
            }
        }
        return -1;
    }
    private static int findPlayerCol(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'P'){
                    return j;
                }
            }
        }
        return -1;
    }
}
