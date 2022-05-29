import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, int[]>> dragonMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] dragonInfo = scanner.nextLine().split(" ");
            String dragonType = dragonInfo[0];
            String dragonName = dragonInfo[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!dragonInfo[2].equals("null")) {
                damage = Integer.parseInt(dragonInfo[2]);
            }
            if (!dragonInfo[3].equals("null")) {
                health = Integer.parseInt(dragonInfo[3]);
            }
            if (!dragonInfo[4].equals("null")) {
                armor = Integer.parseInt(dragonInfo[4]);
            }
            if (!dragonMap.containsKey(dragonType)) {
                dragonMap.put(dragonType, new TreeMap<>());
                dragonMap.get(dragonType).put(dragonName, new int[]{damage, health, armor});
            } else if (dragonMap.containsKey(dragonType) && dragonMap.get(dragonType).containsKey(dragonName)) {
                dragonMap.get(dragonType).get(dragonName)[0] = damage;
                dragonMap.get(dragonType).get(dragonName)[1] = health;
                dragonMap.get(dragonType).get(dragonName)[2] = armor;
            } else {
                dragonMap.get(dragonType).put(dragonName, new int[]{damage, health, armor});
            }
        }
        for (Map.Entry<String, TreeMap<String, int[]>> type : dragonMap.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), getAverageDamage(type.getValue()), getAverageHealth(type.getValue()), getAverageArmor(type.getValue()));
            type.getValue().forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]));
        }
    }

    private static double getAverageDamage(TreeMap<String, int[]> value) {
        double sum = 0;
        int counter = 0;
        for (Map.Entry<String, int[]> damagePointer : value.entrySet()) {
            sum += damagePointer.getValue()[0];
            counter++;
        }
        return sum / counter;
    }
    private static double getAverageHealth(TreeMap<String, int[]> value) {
        double sum = 0;
        int counter = 0;
        for (Map.Entry<String, int[]> healthPointer : value.entrySet()) {
            sum += healthPointer.getValue()[1];
            counter++;
        }
        return sum / counter;
    }
    private static double getAverageArmor(TreeMap<String, int[]> value) {
        double sum = 0;
        int counter = 0;
        for (Map.Entry<String, int[]> armorPointer : value.entrySet()) {
            sum += armorPointer.getValue()[2];
            counter++;
        }
        return sum / counter;
    }
}
