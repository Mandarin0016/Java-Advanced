package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car currentCar : this.data) {
            if (currentCar.getManufacturer().equals(manufacturer) && currentCar.getModel().equals(model)) {
                this.data.remove(currentCar);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (!this.data.isEmpty()) {
            Car latestCar = this.data.get(0);
            for (Car currentCar : this.data) {
                if (currentCar.getYear() > latestCar.getYear()) {
                    latestCar = currentCar;
                }
            }
            return latestCar;
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car currentCar : this.data) {
            if (currentCar.getManufacturer().equals(manufacturer) && currentCar.getModel().equals(model)) {
                return currentCar;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("The cars are in a car dealership %s:", this.name));
        this.data.forEach(car -> result.append(System.lineSeparator()).append(car));
        return result.toString();
    }
}
