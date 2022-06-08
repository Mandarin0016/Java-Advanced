package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split(" ");
            String carModel = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine carEngine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire firstTier = new Tire(Double.parseDouble(carData[5]), Integer.parseInt(carData[6]));
            Tire secondTier = new Tire(Double.parseDouble(carData[7]), Integer.parseInt(carData[8]));
            Tire thirdTier = new Tire(Double.parseDouble(carData[9]), Integer.parseInt(carData[10]));
            Tire forthTier = new Tire(Double.parseDouble(carData[11]), Integer.parseInt(carData[12]));
            Car currentCar = new Car(carModel, carEngine, cargo, new Tire[]{firstTier, secondTier, thirdTier, forthTier});
            cars.add(currentCar);
        }
        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                cars
                        .stream()
                        .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                        .filter(car -> {
                            Tire[] carTiers = car.getTires();
                            for (Tire carTier : carTiers) {
                                if (carTier.getTierPressure() < 1){
                                    return true;
                                }
                            }
                            return false;
                        }).forEach(System.out::println);
                break;
            case "flamable":
                cars
                        .stream()
                        .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                        .filter(car -> car.getEngine().getEnginePower() > 250).forEach(System.out::println);
                break;
        }
    }
}
