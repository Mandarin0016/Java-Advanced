import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] secondLine = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacao = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(milk::offer);
        Arrays.stream(secondLine).forEach(cacao::push);
        Map<String, Integer> preparedChocolates = new TreeMap<>();
        while (!milk.isEmpty() && !cacao.isEmpty()) {
            double currentMilk = milk.poll();
            double currentCacaoPowder = cacao.pop();
            if (currentCacaoPowder == 0) {
                milk.offer(currentMilk + 10);
                continue;
            }
            double sum = currentMilk + currentCacaoPowder;
            double percentage = (currentCacaoPowder / sum) * 100;
            String foundChocolate = foundOne(percentage);
            if (foundChocolate != null) {
                preparedChocolates.putIfAbsent(foundChocolate, 0);
                preparedChocolates.put(foundChocolate, preparedChocolates.get(foundChocolate) + 1);
            } else {
                milk.offer(currentMilk + 10);
            }
        }

        if (preparedChocolates.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> chocolate : preparedChocolates.entrySet()) {
            //# Baking Chocolate --> 1
            System.out.printf("# %s --> %d%n", chocolate.getKey(), chocolate.getValue());
        }
    }

    private static String foundOne(double percentage) {
        if (percentage == 30.0) {
            return "Milk Chocolate";
        } else if (percentage == 50.0) {
            return "Dark Chocolate";
        } else if (percentage == 100.0) {
            return "Baking Chocolate";
        }
        return null;
    }
}
