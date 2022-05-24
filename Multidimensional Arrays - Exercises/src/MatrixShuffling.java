import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        fillMatrix(matrix, scanner);
        String[] data = scanner.nextLine().split(" ");
        while (!data[0].equals("END")) {
            if (data[0].equals("swap") && data.length == 5 && coordinatesAreCorrect(matrix, Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]))) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);
                String tempElement = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = tempElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            data = scanner.nextLine().split(" ");
        }
    }

    private static boolean coordinatesAreCorrect(String[][] matrix, int row1, int col1, int row2, int col2) {
        if (row1 >= matrix.length || row2 >= matrix.length || row1 < 0 || row2 < 0) {
            return false;
        }
        return col1 < matrix[row1].length && col1 >= 0 && col2 < matrix[row2].length && col2 >= 0;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrix[row] = currentRow;
        }
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
