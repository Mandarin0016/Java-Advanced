import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);
        int maxSum = Integer.MIN_VALUE;
        List<Integer> maxSumCoordinates = new ArrayList<>();
        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                int currentSum = findCurrentSum(matrix, row, col);
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxSumCoordinates.clear();
                    maxSumCoordinates.add(row);
                    maxSumCoordinates.add(col);
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMaxSumMatrix(matrix, maxSumCoordinates);
    }

    private static void printMaxSumMatrix(int[][] matrix, List<Integer> maxSumCoordinates) {
        for (int row = maxSumCoordinates.get(0); row < maxSumCoordinates.get(0) + 3; row++) {
            for (int col = maxSumCoordinates.get(1); col < maxSumCoordinates.get(1) + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int findCurrentSum(int[][] matrix, int row, int col) {
        int currentSum = 0;
        for (int currentRowElement = row; currentRowElement < row + 3; currentRowElement++) {
            for (int currentColElement = col; currentColElement < col + 3; currentColElement++) {
                currentSum += matrix[currentRowElement][currentColElement];
            }
        }
        return currentSum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
    }
}
