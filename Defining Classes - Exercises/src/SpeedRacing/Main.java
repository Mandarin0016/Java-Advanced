package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split(" ");
            Car currentCar = new Car(carData[0], Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
            cars.put(carData[0], currentCar);
        }
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("End")){
            String carModel = input[1];
            double kilometersForDriving = Double.parseDouble(input[2]);
            if (cars.get(carModel).isCarDrivable(kilometersForDriving)){
                cars.get(carModel).drivingCar(kilometersForDriving);
            }else {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine().split("\\s+");
        }
        cars.values().forEach(System.out::println);
    }
}
