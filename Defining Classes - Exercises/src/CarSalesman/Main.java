package CarSalesman;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            //{Model} {Power} {Displacement} {Efficiency}
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            String power = data[1];
            Engine currentEngine;
            if (data.length == 4){
                int displacement = Integer.parseInt(data[2]);
                String efficiency = data[3];
                currentEngine = new Engine(model, power, displacement, efficiency);
            }else if (data.length == 3){
                if (Character.isDigit(data[2].charAt(0))){
                    int displacement = Integer.parseInt(data[2]);;
                    currentEngine = new Engine(model, power, displacement);
                }else {
                    String efficiency = data[2];
                    currentEngine = new Engine(model, power, efficiency);
                }
            }else {
                currentEngine = new Engine(model, power);
            }
            engines.put(model, currentEngine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            Engine engine = engines.get(data[1]);
            Car currentCar;
            if (data.length == 4){
                String weight = data[2];
                String color = data[3];
                currentCar = new Car(model, engine, weight, color);
            }else if (data.length == 3){
                if (Character.isDigit(data[2].charAt(0))){
                    String weight = data[2];
                    currentCar = new Car(model, engine, weight);
                }else {
                    String color = data[2];
                    currentCar = new Car(model, color, engine);
                }
            }else {
                currentCar = new Car(model, engine);
            }
            System.out.println(currentCar);
        }



    }
}
