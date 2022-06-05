package SpeedRacing;

import java.awt.image.CropImageFilter;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer, and distance traveled
    private final String model;
    private double fuelAmount;
    private final double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }
    public boolean isCarDrivable(double kilometersForDriving){
        return kilometersForDriving * this.fuelCost <= this.fuelAmount;
    }

    public void drivingCar(double kilometersForDriving){
        this.fuelAmount -= kilometersForDriving * this.fuelCost;
        this.distanceTraveled += kilometersForDriving;
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.getModel(), this.getFuelAmount(),this.getDistanceTraveled());
    }
    public String getModel() {
        return model;
    }
    public double getFuelAmount() {
        return fuelAmount;
    }
    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
