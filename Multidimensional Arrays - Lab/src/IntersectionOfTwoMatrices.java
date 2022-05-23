import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //3
        //4
        //a b c d
        //a b c d
        //a b c d
        //k b c k
        //a b g d
        //a k c d
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = currentRow[col].charAt(0);
            }
        }
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = currentRow[col].charAt(0);
            }
        }
        char[][] thirdMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    thirdMatrix[row][col] = firstMatrix[row][col];
                }else {
                    thirdMatrix[row][col] = '*';
                }
            }
        }

        for (char[] row : thirdMatrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

    }
}
