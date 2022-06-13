import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> effects = new ArrayDeque<>();
        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(effects::offer);
        Arrays.stream(secondLine).forEach(casings::push);
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        while (!effects.isEmpty() && !casings.isEmpty()) {
            int effect = effects.poll();
            int casing = casings.pop();
            int mix = effect + casing;
            String result = createMaterial(mix);
            if (result == null) {
                effects.push(effect);
                casings.push(casing - 5);
            } else {
                bombs.put(result, bombs.get(result) + 1);
            }
            if (bombs.entrySet().stream().allMatch(bombEntry -> bombEntry.getValue() >= 3)) {
                break;
            }
        }
        if (bombs.entrySet().stream().allMatch(bombEntry -> bombEntry.getValue() >= 3)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            while (!effects.isEmpty()) {
                System.out.print(effects.poll());
                if (effects.isEmpty()) {
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        if (casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            while (!casings.isEmpty()) {
                System.out.print(casings.pop());
                if (casings.isEmpty()) {
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String createMaterial(int mix) {
        String result = null;
        switch (mix) {
            case 40:
                result = "Datura Bombs";
                break;
            case 60:
                result = "Cherry Bombs";
                break;
            case 120:
                result = "Smoke Decoy Bombs";
                break;
        }
        return result;
    }
}
