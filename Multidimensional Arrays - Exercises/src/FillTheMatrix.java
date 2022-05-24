import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixCreationInstructions = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(matrixCreationInstructions[0]);
        String creationMethod = matrixCreationInstructions[1];
        int[][] matrix = new int[matrixSize][matrixSize];
        if (creationMethod.equals("A")) {
            createMatrixA(matrix, 1);
        } else {
            createMatrixB(matrix, 1);
        }
        printMatrix(matrix);
    }

    private static void createMatrixA(int[][] matrix, int counter) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
        }
    }

    private static void createMatrixB(int[][] matrix, int counter) {
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 != 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
                continue;
            }
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
