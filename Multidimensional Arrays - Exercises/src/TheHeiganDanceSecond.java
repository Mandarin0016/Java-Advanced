import java.util.Scanner;

public class TheHeiganDanceSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageOnBoss = Double.parseDouble(scanner.nextLine());
        int playerHealth = 18500;
        double bossHealth = 3_000_000;

        int playerRow = 7;
        int playerCol = 7;

        String previousSpell = "";
        boolean activeCloud = false;

        while (playerHealth > 0 && bossHealth > 0) {
            bossHealth -= damageOnBoss;

            if (activeCloud) {
                playerHealth -= 3500;
                activeCloud = false;

                if (playerHealth <= 0) {
                    break;
                }
            }

            if (bossHealth <= 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int rowHit = Integer.parseInt(input[1]);
            int colHit = Integer.parseInt(input[2]);

            boolean[][] bossChamber = new boolean[15][15];
            for (int i = rowHit - 1; i <= rowHit + 1; i++) {
                if (i >= 0 && i < bossChamber.length) {
                    for (int j = colHit - 1; j <= colHit + 1; j++) {
                        if (j >= 0 && j < bossChamber[rowHit].length) {
                            bossChamber[i][j] = true;
                        }
                    }
                }
            }

            if (bossChamber[playerRow][playerCol]) {
                if (isRowValid(bossChamber, playerRow - 1) && !bossChamber[playerRow - 1][playerCol]) {
                    playerRow--; // move up

                } else if (isColValid(bossChamber, playerCol + 1) && !bossChamber[playerRow][playerCol + 1]) {
                    playerCol++; // move right

                } else if (isRowValid(bossChamber, playerRow + 1) && !bossChamber[playerRow + 1][playerCol]) {
                    playerRow++; // move down

                } else if (isColValid(bossChamber, playerCol - 1) && !bossChamber[playerRow][playerCol - 1]) {
                    playerCol--; // move left
                }

                if (bossChamber[playerRow][playerCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            activeCloud = true;
                            previousSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            previousSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (bossHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", previousSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isColValid(boolean[][] matrix, int col) {
        return col >= 0 && col < matrix.length;
    }

    private static boolean isRowValid(boolean[][] matrix, int row) {
        return row >= 0 && row < matrix[row].length;
    }
}