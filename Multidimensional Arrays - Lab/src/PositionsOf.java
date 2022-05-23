import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[matrixData[0]][matrixData[1]];
        boolean isNotFound = true;
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int
                lookingForNumber = Integer.parseInt(scanner.nextLine());
        for
        (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == lookingForNumber) {
                    System.out.println(row + " " + col);
                    isNotFound = false;
                }
            }
        }
        if (isNotFound) {
            System.out.println("not found");
        }

    }
}
