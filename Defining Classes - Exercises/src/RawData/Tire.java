package RawData;

public class Tire {
    private double tierPressure;
    private int tireAge;

    public Tire(double tierPressure, int tireAge) {
        this.tierPressure = tierPressure;
        this.tireAge = tireAge;
    }

    public double getTierPressure() {
        return this.tierPressure;
    }
    public void setTierPressure(double tierPressure) {
        this.tierPressure = tierPressure;
    }
    public int getTireAge() {
        return tireAge;
    }
    public void setTireAge(int tireAge) {
        this.tireAge = tireAge;
    }
}
