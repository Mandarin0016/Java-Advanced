import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOfSubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixData = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixData[0];
        int cols = matrixData[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        int maxSubMatrixSum = 0;
        List<Integer> coordinates = new ArrayList<>();
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > maxSubMatrixSum){
                    coordinates.clear();
                    coordinates.add(matrix[row][col]);
                    coordinates.add(matrix[row][col + 1]);
                    coordinates.add(matrix[row + 1][col]);
                    coordinates.add(matrix[row + 1][col + 1]);
                    maxSubMatrixSum = currentSum;
                }
            }
        }
        System.out.printf("%d %d%n", coordinates.get(0), coordinates.get(1));
        System.out.printf("%d %d%n", coordinates.get(2), coordinates.get(3));
        System.out.println(maxSubMatrixSum);

    }
}
