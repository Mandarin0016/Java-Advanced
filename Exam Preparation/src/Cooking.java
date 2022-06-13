import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(liquids::offer);
        Arrays.stream(secondLine).forEach(ingredients::push);
        Map<String, Integer> backings = new LinkedHashMap<>();
        backings.put("Bread", 0);
        backings.put("Cake", 0);
        backings.put("Fruit Pie", 0);
        backings.put("Pastry", 0);
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            String result = findProperBacking(liquid + ingredient);
            if (result == null) {
                ingredients.push(ingredient + 3);
            } else {
                backings.put(result, backings.get(result) + 1);
            }
        }
        if (backings.entrySet().stream().allMatch(product -> product.getValue() > 0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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
        backings.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static String findProperBacking(int value) {
        String result = null;
        switch (value) {
            case 25:
                result = "Bread";
                break;
            case 50:
                result = "Cake";
                break;
            case 75:
                result = "Pastry";
                break;
            case 100:
                result = "Fruit Pie";
                break;
        }
        return result;
    }
}
