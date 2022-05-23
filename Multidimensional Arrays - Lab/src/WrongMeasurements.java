import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialMeasurements = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[initialMeasurements][];
        for (int row = 0; row < initialMeasurements; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        int[][] correctMatrix = new int[initialMeasurements][matrix[0].length];
        for (int row = 0; row < correctMatrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                correctMatrix[row][col] = 0;
            }
        }
        int[] wrongValueCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[wrongValueCoordinates[0]][wrongValueCoordinates[1]];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue){
                    int sum = 0;
                    if (row > 0){
                        int upElement = matrix[row - 1][col];
                        if (upElement != wrongValue){
                            sum += upElement;
                        }
                    }
                    if (row < matrix.length - 1){
                        int downElement = matrix[row + 1][col];
                        if (downElement != wrongValue){
                            sum += downElement;
                        }
                    }
                    if (col > 0){
                        int leftElement = matrix[row][col - 1];
                        if (leftElement != wrongValue){
                            sum += leftElement;
                        }
                    }
                    if (col < matrix[row].length - 1){
                        int rightElement = matrix[row][col + 1];
                        if (rightElement != wrongValue){
                            sum += rightElement;
                        }
                    }
                    correctMatrix[row][col] = sum;
                }
                else{
                    correctMatrix[row][col] = matrix[row][col];
                }
            }
        }
        for (int[] ints : correctMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
