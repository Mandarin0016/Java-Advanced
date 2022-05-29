import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();
        String reward = "";
        boolean isFound = false;
        while (!isFound) {
            String[] materialsInput = scanner.nextLine().split(" ");
            for (int i = 0; i < materialsInput.length; i++) {
                if (i % 2 == 1) {
                    if (materialsInput[i].equalsIgnoreCase("shards")) {
                        keyMaterials.put("shards", keyMaterials.get("shards") + Integer.parseInt(materialsInput[i - 1]));
                    } else if (materialsInput[i].equalsIgnoreCase("fragments")) {
                        keyMaterials.put("fragments", keyMaterials.get("fragments") + Integer.parseInt(materialsInput[i - 1]));
                    } else if (materialsInput[i].equalsIgnoreCase("motes")) {
                        keyMaterials.put("motes", keyMaterials.get("motes") + Integer.parseInt(materialsInput[i - 1]));
                    } else {
                        String material = materialsInput[i].toLowerCase();
                        if (!junkMaterials.containsKey(material)) {
                            junkMaterials.put(material, Integer.parseInt(materialsInput[i - 1]));
                        } else {
                            junkMaterials.put(material, Integer.parseInt(materialsInput[i - 1]) + junkMaterials.get(material));
                        }
                    }
                    //check if legendary item could be obtained
                    if (keyMaterials.get("shards") >= 250) {
                        reward = "Shadowmourne";
                        keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                        isFound = true;
                        break;
                    } else if (keyMaterials.get("fragments") >= 250) {
                        reward = "Valanyr";
                        keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
                        isFound = true;
                        break;
                    } else if (keyMaterials.get("motes") >= 250) {
                        reward = "Dragonwrath";
                        keyMaterials.put("motes", keyMaterials.get("motes") - 250);
                        isFound = true;
                        break;
                    }
                }
            }
        }
        System.out.printf("%s obtained!%n", reward);
        keyMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
        junkMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
