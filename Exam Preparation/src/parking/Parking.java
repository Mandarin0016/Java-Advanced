package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
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

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("The cars are parked in %s:", this.type));
        this.data.forEach(car -> result.append(System.lineSeparator()).append(car));
        return result.toString();
    }
}
