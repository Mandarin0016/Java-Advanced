package CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> myCars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            if (data.length == 3) {
                String model = data[1];
                int horsePowers = Integer.parseInt(data[2]);
                Car currentCar = new Car(brand, model, horsePowers);
                myCars.add(currentCar);
            }else {
                Car currentCar = new Car(brand);
                myCars.add(currentCar);
            }
        }
        myCars.forEach(carPrevious -> System.out.println(carPrevious.carInfo()));
    }
}
