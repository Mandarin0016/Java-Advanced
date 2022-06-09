import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfIngredients = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(listOfIngredients);
        List<Integer> listOfFreshnessLevel = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();
        freshnessLevel.addAll(listOfFreshnessLevel);
        Map<String, Integer> cocktails = new LinkedHashMap<>();
        cocktails.put("Pear Sour", 150);
        cocktails.put("The Harvest", 250);
        cocktails.put("Apple Hinny", 300);
        cocktails.put("High Fashion", 400);
        Map<String, Integer> cocktailsIveMade = new TreeMap<>();
        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
            int currentIngredient = ingredients.pop();
            int currentFreshnessLevel = freshnessLevel.getLast();
            if (currentIngredient != 0) {
                freshnessLevel.removeLast();
                int mix = currentFreshnessLevel * currentIngredient;
                boolean cocktailMade = false;
                for (Map.Entry<String, Integer> cocktail : cocktails.entrySet()) {
                    if (cocktail.getValue() == mix) {
                        if (!cocktailsIveMade.containsKey(cocktail.getKey())) {
                            cocktailsIveMade.put(cocktail.getKey(), 1);
                        } else {
                            cocktailsIveMade.put(cocktail.getKey(), cocktailsIveMade.get(cocktail.getKey()) + 1);
                        }
                        cocktailMade = true;
                        break;
                    }
                }
                if (!cocktailMade) {
                    currentIngredient += 5;
                    ingredients.offer(currentIngredient);
                }
            }
        }
        if (cocktailsIveMade.size() >= 4){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()){
            int ingredientsSum = ingredients.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Ingredients left: " + ingredientsSum);
        }
        for (Map.Entry<String, Integer> cocktail : cocktailsIveMade.entrySet()) {
            System.out.printf(" # %s --> %d%n", cocktail.getKey(), cocktail.getValue());
        }
    }
}