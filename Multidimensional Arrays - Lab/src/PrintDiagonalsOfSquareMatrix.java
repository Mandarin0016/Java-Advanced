import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixData = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixData][matrixData];
        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            System.out.print(matrix[row][matrix.length - 1 - row] + " ");
        }
    }
}
