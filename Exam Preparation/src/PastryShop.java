import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(liquids::offer);
        Arrays.stream(secondLine).forEach(ingredients::push);
        Map<String, Integer> pastries = new LinkedHashMap<>();
        pastries.put("Biscuit", 0);
        pastries.put("Cake", 0);
        pastries.put("Pie", 0);
        pastries.put("Pastry", 0);
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;
            String cookedItem = cookChecker(sum);
            if (cookedItem == null) {
                ingredients.push(ingredient + 3);
            } else {
                pastries.put(cookedItem, pastries.get(cookedItem) + 1);
            }
        }
        if (pastries.values().stream().allMatch(e -> e > 0)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            while (!liquids.isEmpty()) {
                System.out.print(liquids.poll());
                if (liquids.isEmpty()) {
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            while (!ingredients.isEmpty()) {
                System.out.print(ingredients.pop());
                if (ingredients.isEmpty()) {
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        for (Map.Entry<String, Integer> pastry : pastries.entrySet()) {
            System.out.printf("%s: %d%n", pastry.getKey(), pastry.getValue());
        }
    }

    private static String cookChecker(int sum) {
        String item = null;
        switch (sum) {
            case 25:
                item = "Biscuit";
                break;
            case 50:
                item = "Cake";
                break;
            case 75:
                item = "Pastry";
                break;
            case 100:
                item = "Pie";
                break;
        }
        return item;
    }
}
