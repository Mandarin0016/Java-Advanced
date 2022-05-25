import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        String[][] matrix =  new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstLetter = (char) (97 + row);
                char lastLetter = (char) (97 + row);
                char middleLetter = (char) (97 + col + row);
                String currentPalindrome = "" + firstLetter + middleLetter + lastLetter;
                matrix[row][col] = currentPalindrome;
            }
        }
        printMatrix(matrix);
    }
    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int col = 0; col < strings.length; col++) {
                System.out.print(strings[col] + " ");
            }
            System.out.println();
        }
    }
}
