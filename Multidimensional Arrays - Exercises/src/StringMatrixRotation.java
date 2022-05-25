import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read the degrees for rotation. The input will be always valid - Rotate(90)
        String rotateString = scanner.nextLine();
        int degrees = Integer.parseInt(rotateString.substring(7, rotateString.length() - 1));
        //read all the words
        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }
        //find the matrix size
        int longestWordLength = 0;
        for (String word : words) {
            if (word.length() > longestWordLength) {
                longestWordLength = word.length();
            }
        }
        //fill the matrix
        char[][] matrix = new char[words.size()][longestWordLength];
        int currentMatrixRow = 0;
        for (String word : words) {
            for (int currentChar = 0; currentChar < word.length(); currentChar++) {
                matrix[currentMatrixRow][currentChar] = word.charAt(currentChar);
            }
            currentMatrixRow++;
        }

        //1 -> 90 degrees
        //2 -> 180 degrees
        //3 -> 270 degrees
        //4 -> 360 degrees
        switch (findIndexDegrees(0, degrees)) {
            case 1:
                printMatrix90(matrix, longestWordLength);
                break;
            case 2:
                printMatrix180(matrix);
                break;
            case 3:
                printMatrix270(matrix, longestWordLength);
                break;
            case 4:
                printMatrixNormal(matrix);
                break;
        }

    }


    private static void printMatrix270(char[][] matrix, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] != '\u0000') {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (matrix[row][col] != '\u0000') {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                if (matrix[row][col] != '\u0000') {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public static void printMatrixNormal(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != '\u0000') {
                    System.out.print(matrix[row][col]);
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }

    private static int findIndexDegrees(int index, int degrees) {
        if (degrees == 0) {
            return 4;
        }
        for (int i = 90; i <= degrees; i += 90) {
            index++;
            if (index > 4) {
                index = 1;
            }
        }
        return index;
    }
}
