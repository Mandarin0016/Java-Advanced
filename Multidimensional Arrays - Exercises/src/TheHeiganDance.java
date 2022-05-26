import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //the center of the table has coordinates(7;7)
        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        double heiganLife = 3000000;
        int playerLife = 18500;
        int playerRow = 7;
        int playerCol = 7;
        boolean activeCloud = false;
        String lastSpell = "";
        while (playerLife > 0 && heiganLife > 0) {
            //each turn, the player does damage to Heigan
            heiganLife -= damageToHeigan;
            //check if cloud is active
            if (activeCloud) {
                playerLife -= 3500;
                activeCloud = false;
                if (playerLife <= 0) {
                    break;
                }
            }
            //check if Heigan is alive
            if (heiganLife <= 0) {
                break;
            }
            //next move of Heigan
            String[] heigansMove = scanner.nextLine().split(" ");
            String spell = heigansMove[0];
            int row = Integer.parseInt(heigansMove[1]);
            int col = Integer.parseInt(heigansMove[2]);

            int[][] danceTable = new int[15][15];
            //set all the dangerous cells with value -1
            for (int i = row - 1; i <= row + 1 ; i++) {
                if (i >= 0 && i < danceTable.length){
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < danceTable[row].length){
                            danceTable[i][j] = -1;
                        }
                    }
                }
            }
            //the player tries to move only if he is placed on dangerous zone
            if (danceTable[playerRow][playerCol] == -1) {
                if (coordinatesAreCorrect(danceTable, playerRow - 1, playerCol) && danceTable[playerRow - 1][playerCol] == 0) {
                    playerRow--;
                }else if (coordinatesAreCorrect(danceTable, playerRow, playerCol + 1) && danceTable[playerRow][playerCol + 1] == 0){
                    playerCol++;
                }else if (coordinatesAreCorrect(danceTable, playerRow + 1, playerCol) && danceTable[playerRow + 1][playerCol] == 0){
                    playerRow++;
                }else if (coordinatesAreCorrect(danceTable, playerRow, playerCol - 1) && danceTable[playerRow][playerCol - 1] == 0){
                    playerCol--;
                }
            }
            //check if the player changed his position and apply the dmg if he is in the dangerous zone.
            if (danceTable[playerRow][playerCol] == -1) {
                if (spell.equals("Cloud")) {
                    playerLife -= 3500;
                    activeCloud = true;
                    lastSpell = "Plague Cloud";
                } else {
                    playerLife -= 6000;
                    lastSpell = "Eruption";
                }
            }
        }
        if (heiganLife > 0) {
            System.out.printf("Heigan: %.2f%n", heiganLife);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerLife > 0) {
            System.out.printf("Player: %d%n", playerLife);
        } else {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static void createDangerZone(int[][] danceTable, int row, int col) {
        //set all the dangerous cells with value -1
        for (int i = row - 1; i <= row + 1 ; i++) {
            if (row >= 0 && row < danceTable.length){
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j >= 0 && j < danceTable[row].length){
                        danceTable[i][j] = -1;
                    }
                }
            }
        }

    }

    private static boolean coordinatesAreCorrect(int[][] matrix, int row, int col) {
        if (row >= matrix.length || row < 0) {
            return false;
        }
        return col < matrix[row].length && col >= 0;
    }
}
