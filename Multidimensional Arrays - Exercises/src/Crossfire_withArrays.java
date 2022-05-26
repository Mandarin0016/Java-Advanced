import java.util.Arrays;
import java.util.Scanner;

public class Crossfire_withArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix);
        String coordinates = scanner.nextLine();
        while (!coordinates.equals("Nuke it from orbit")) {
            int coordinateRow = Integer.parseInt(coordinates.split(" ")[0]);
            int coordinateCol = Integer.parseInt(coordinates.split(" ")[1]);
            int radius = Integer.parseInt(coordinates.split(" ")[2]);
            int startLeft = coordinateCol - radius;
            int startUp = coordinateRow - radius;
            int endRight = coordinateCol + radius;
            int endDown = coordinateRow + radius;
            destroyCells(matrix, coordinateRow, coordinateCol, startLeft, endRight, startUp, endDown);
            matrix = generateNewMatrix(matrix);
            coordinates = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateNewMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][];
        int rowCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            int colCount = (int) Arrays.stream(matrix[row]).filter(e -> e != -1).count();
            if (colCount > 0) {
                newMatrix[rowCount] = new int[colCount];
                int count = 0;
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] != -1) {
                        newMatrix[rowCount][count] = matrix[row][col];
                        count++;
                    }
                }
                rowCount++;
            }
        }
        int[][] finalMatrix = new int[rowCount][];
        for (int row = 0; row < rowCount; row++) {
            finalMatrix[row] = new int[newMatrix[row].length];
            System.arraycopy(newMatrix[row], 0, finalMatrix[row], 0, finalMatrix[row].length);
        }
        return finalMatrix;
    }

    private static void destroyCells(int[][] matrix, int thisRow, int thisCol, int startLeft, int endRight, int startUp, int endDown) {
        for (int col = startLeft; col <= endRight; col++) {
            if (coordinatesAreCorrect(matrix, thisRow, col)) {
                matrix[thisRow][col] = -1;
            }
        }
        for (int row = startUp; row <= endDown; row++) {
            if (coordinatesAreCorrect(matrix, row, thisCol)) {
                matrix[row][thisCol] = -1;
            }
        }
    }

    private static boolean coordinatesAreCorrect(int[][] matrix, int row, int col) {
        if (row >= matrix.length || row < 0) {
            return false;
        }
        return col < matrix[row].length && col >= 0;
    }

    private static void fillMatrix(int[][] matrix) {
        int multiplicationIndex = 1;
        int n = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = n++;
                }
                n--;
            } else {
                int addIndex = 1;
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = multiplicationIndex * n + addIndex;
                    addIndex++;
                }
                multiplicationIndex++;
            }
        }
    }
}
