import java.util.Scanner;

public class ThroneConquering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            field[i] = currentRow;
        }
        boolean isParisAlive = true;
        while (isParisAlive) {
            String[] command = scanner.nextLine().split("\\s+");
            int parisRow = findParisRow(field);
            int parisCol = findParisCol(field);
            int newParisRow = findParisRow(field);
            int newParisCol = findParisCol(field);
            field[parisRow][parisCol] = '-';
            field[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = 'S';
            switch (command[0]) {
                case "up":
                    newParisRow--;
                    break;
                case "down":
                    newParisRow++;
                    break;
                case "left":
                    newParisCol--;
                    break;
                case "right":
                    newParisCol++;
                    break;
            }
            energy--;
            if (!newPositionIsOutOfBounds(field, newParisRow, newParisCol)) {
                parisRow = newParisRow;
                parisCol = newParisCol;
            }
            if (field[parisRow][parisCol] == 'H') {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                field[parisRow][parisCol] = '-';
                break;
            }
            if (field[parisRow][parisCol] == 'S') {
                energy -= 2;
                if (energy > 0) {
                    field[parisRow][parisCol] = 'P';
                } else {
                    field[parisRow][parisCol] = 'X';
                    isParisAlive = false;
                }
            }
            if (energy > 0) {
                field[parisRow][parisCol] = 'P';
            } else {
                field[parisRow][parisCol] = 'X';
                isParisAlive = false;
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
            }
        }
        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int col = 0; col < field[i].length; col++) {
                System.out.print(field[i][col]);
            }
            System.out.println();
        }
    }

    private static boolean newPositionIsOutOfBounds(char[][] field, int parisRow, int parisCol) {
        if (parisRow < 0 || parisRow >= field.length || parisCol < 0 || parisCol >= field[parisRow].length) {
            return true;
        }
        return false;
    }

    public static int findParisRow(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    return row;
                }
            }
        }
        return -1;
    }

    public static int findParisCol(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    return col;
                }
            }
        }
        return -1;
    }
}
