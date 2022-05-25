import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);
        for (int col = cols - 1; col >= 0; col--) {
            int row = matrix.length - 1;
            for (int currentColElement = col; currentColElement < cols ; currentColElement++) {
                System.out.print(matrix[row][currentColElement] + " ");
                row--;
                if (row < 0){
                    break;
                }
            }
            System.out.println();
        }
        for (int row = rows - 2; row >= 0 ; row--) {
            int currentRowElement = row;
            for (int currentColElement = 0; currentColElement < cols; currentColElement++) {
                System.out.print(matrix[currentRowElement][currentColElement] + " ");
                currentRowElement--;
                if (currentRowElement < 0){
                    break;
                }
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
    }
}
