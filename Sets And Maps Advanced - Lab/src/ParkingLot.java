import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parkingLot = new LinkedHashSet<>();
        String[] input = scanner.nextLine().split(", ");
        while (!input[0].equals("END")) {
            switch (input[0]) {
                case "IN":
                    parkingLot.add(input[1]);
                    break;
                case "OUT":
                    parkingLot.remove(input[1]);
                    break;
            }
            input = scanner.nextLine().split(", ");
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }

    }
}
