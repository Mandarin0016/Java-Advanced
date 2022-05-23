import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMatrixData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] firstMatrix = new int[firstMatrixData[0]][firstMatrixData[1]];
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[row] = currentRow;
        }
        int[] secondMatrixData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] secondMatrix = new int[secondMatrixData[0]][secondMatrixData[1]];
        for (int row = 0; row < secondMatrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[row] = currentRow;
        }
        if (matricesComparator(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean matricesComparator(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        } else {
            for (int row = 0; row < firstMatrix.length; row++) {
                if (firstMatrix[row].length != secondMatrix[row].length) {
                    return false;
                } else {
                    for (int col = 0; col < firstMatrix[row].length; col++) {
                        if (firstMatrix[row][col] != secondMatrix[row][col]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
