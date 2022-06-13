import java.util.*;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        ArrayDeque<Integer> values = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(materials::push);
        Arrays.stream(secondLine).forEach(values::offer);
        Map<String, Integer> toys = new TreeMap<>();
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(150, "Doll");
        criteria.put(250, "Wooden train");
        criteria.put(300, "Teddy bear");
        criteria.put(400, "Bicycle");
        while (!materials.isEmpty() && !values.isEmpty()){
            int material = materials.pop();
            int value = values.poll();
            int magicLevel = material * value;
            if (criteria.containsKey(magicLevel)){
                toys.putIfAbsent(criteria.get(magicLevel), 0);
                toys.put(criteria.get(magicLevel), toys.get(criteria.get(magicLevel)) + 1);
            }else if (magicLevel < 0){
                int newSum = material + value;
                materials.push(newSum);
            }else if (magicLevel > 0 && material > 0 && value > 0){
                materials.push(material + 15);
            }else if (material == 0 && value > 0){
                values.push(value);
            }else if (value == 0 && material > 0){
                materials.push(material);
            }
        }
        if ((toys.containsKey("Doll") && toys.containsKey("Wooden train")) || (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle"))){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else{
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()){
            System.out.print("Materials left: ");
            while (!materials.isEmpty()){
                System.out.print(materials.pop());
                if (materials.isEmpty()){
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        if (!values.isEmpty()){
            System.out.print("Magic left: ");
            while (!values.isEmpty()){
                System.out.print(values.poll());
                if (values.isEmpty()){
                    System.out.println();
                    break;
                }
                System.out.print(", ");
            }
        }
        for (Map.Entry<String, Integer> toy : toys.entrySet()) {
            System.out.println(toy.getKey() + ": " + toy.getValue());
        }

    }
}
