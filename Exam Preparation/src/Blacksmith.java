import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOfSteel = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] arrayOfCarbon = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> steelStack = ParseStack(arrayOfSteel);
        ArrayDeque<Integer> carbonQueue = ParseQueue(arrayOfCarbon);
        Map<String, Integer> swordsIveMade = new TreeMap<>();
        while (!(steelStack.isEmpty() || carbonQueue.isEmpty())){
            int steel = steelStack.pop();
            int carbon = carbonQueue.poll();
            int sumOfMaterials = steel + carbon;
            String swordMade = swordChecker(sumOfMaterials);
            if (swordMade == null){
                carbonQueue.push(carbon + 5);
            }else {
                swordsIveMade.putIfAbsent(swordMade, 0);
                swordsIveMade.put(swordMade, swordsIveMade.get(swordMade) + 1);
            }
        }
        if (!swordsIveMade.isEmpty()){
            int swordCount = getSwordCount(swordsIveMade);
            System.out.printf("You have forged %d swords.%n", swordCount);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelStack.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            System.out.print("Steel left: ");
            while (!steelStack.isEmpty()){
                System.out.print(steelStack.pop());
                if (steelStack.isEmpty()){
                    break;
                }
                System.out.print(", ");
            }
            System.out.println();
        }
        if (carbonQueue.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            System.out.print("Carbon left: ");
            while (!carbonQueue.isEmpty()){
                System.out.print(carbonQueue.pop());
                if (carbonQueue.isEmpty()){
                    break;
                }
                System.out.print(", ");
            }
            System.out.println();
        }
        for (Map.Entry<String, Integer> sword : swordsIveMade.entrySet()) {
            System.out.printf("%s: %d%n", sword.getKey(), sword.getValue());
        }
    }

    private static int getSwordCount(Map<String, Integer> swordsIveMade) {
        int count = 0;
        for (Map.Entry<String, Integer> swordType : swordsIveMade.entrySet()) {
            count += swordType.getValue();
        }
        return count;
    }
    //CHECK_IF_THE_SUM_CAN_BRING_A_SWORD
    private static String swordChecker(int sumOfMaterials) {
        String foundSword = null;
        switch (sumOfMaterials){
            case 70:
                foundSword = "Gladius";
                break;
            case 80:
                foundSword = "Shamshir";
                break;
            case 90:
                foundSword = "Katana";
                break;
            case 110:
                foundSword = "Sabre";
                break;
        }
        return foundSword;
    }


    //CREATE_QUEUE_FROM_ARRAY
    private static ArrayDeque<Integer> ParseQueue(int[] arrayOfCarbon) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int element : arrayOfCarbon) {
            queue.push(element);
        }
        return queue;
    }
    //CREATE_STACK_FROM_ARRAY
    private static ArrayDeque<Integer> ParseStack(int[] arrayOfSteel) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int element : arrayOfSteel) {
            stack.offer(element);
        }
        return stack;
    }
}
