import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialMatrixData = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[initialMatrixData][initialMatrixData];
        for (int row = 0; row < initialMatrixData; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        int difference = Math.abs(findPrimaryDiagonalSum(matrix) - findSecondaryDiagonalSum(matrix));
        System.out.println(difference);
    }

    private static int findSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            sum += matrix[row][matrix.length - 1 - row];
        }
        return sum;
    }

    private static int findPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }
}
