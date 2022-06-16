import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[row] = currentRow;
        }
        int goldCoins = 0;
        String direction = scanner.nextLine();
        while (true){
            int officerRow = findOffcierRow(matrix);
            int officerCol = findOfficerCol(matrix);
            matrix[officerRow][officerCol] = '-';
            switch (direction){
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }
            if (!checkCordinates(matrix, officerRow, officerCol)){
                break;
            }
            if (Character.isDigit(matrix[officerRow][officerCol])){
                goldCoins += Integer.parseInt(matrix[officerRow][officerCol] + "");
                matrix[officerRow][officerCol] = 'A';
            }else if (matrix[officerRow][officerCol] == 'M'){
                int otherMirrorRow = findOtherMirrorLocationRow(matrix, officerRow, officerCol);
                int otherMirrorCol = findOtherMirrorLocationCol(matrix, officerRow, officerCol);
                matrix[officerRow][officerCol] = '-';
                matrix[otherMirrorRow][otherMirrorCol] = 'A';
            }else {
                matrix[officerRow][officerCol] = 'A';
            }

            if (goldCoins >= 65){
                break;
            }
            direction = scanner.nextLine();
        }
        if (goldCoins < 65){
            System.out.println("I do not need more swords!");
        }else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", goldCoins);
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
    private static int findOtherMirrorLocationCol(char[][] matrix, int officerRow, int officerCol) {
        int start = officerCol + 1;
        for (int row = officerRow; row < matrix.length; row++) {
            for (int col = start; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M'){
                    return col;
                }
            }
            start = 0;
        }
        return 0;
    }

    private static int findOtherMirrorLocationRow(char[][] matrix, int officerRow, int officerCol) {
        int start = officerCol + 1;
        for (int row = officerRow; row < matrix.length; row++) {
            for (int col = start; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M'){
                    return row;
                }
            }
            start = 0;
        }
        return 0;
    }

    private static boolean checkCordinates(char[][] matrix, int officerRow, int officerCol) {
        if (officerRow >= matrix.length || officerRow < 0 || officerCol >= matrix.length || officerCol < 0) {
            return false;
        }
        return true;
    }

    private static int findOffcierRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'A'){
                    return row;
                }
            }
        }
        return 0;
    }
    private static int findOfficerCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'A'){
                    return col;
                }
            }
        }
        return 0;
    }
}
