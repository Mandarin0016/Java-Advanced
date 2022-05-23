import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matrixData = scanner.nextLine();
        int[][] matrix = new int[Integer.parseInt(matrixData.split(", ")[0])]
                [Integer.parseInt(matrixData.split(", ")[1])];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            String[] currentMatrixRow = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(currentMatrixRow[col]);
                sum += matrix[row][col];
            }
        }
        System.out.println(matrixData.split(", ")[0]);
        System.out.println(matrixData.split(", ")[1]);
        System.out.println(sum);
    }
}
