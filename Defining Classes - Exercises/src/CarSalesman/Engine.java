package CarSalesman;

public class Engine {
    //An Engine has a model, power, displacement, and efficiency.
    private String model;
    private String power;
    private final int DISPLACEMENT_DEFAULT_VALUE = -1;
    private int displacement = DISPLACEMENT_DEFAULT_VALUE;
    private final String EFFICIENCY_DEFAULT_VALUE = "n/a";
    private String efficiency = EFFICIENCY_DEFAULT_VALUE;

    public Engine(String model, String power){
        this.model = model;
        this.power = power;
    }
    public Engine(String model, String power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, String power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }
    public Engine(String model, String power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    //getters and setters
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public int getDisplacement() {
        return displacement;
    }
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
    public String getEfficiency() {
        return efficiency;
    }
    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
