package RawData;

public class Car {
    //model, engine, cargo, and a collection of exactly 4 tires
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires = new Tire[4];

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Tire[] getTires() {
        return tires;
    }
    public void setTires(Tire[] tires) {
        this.tires = tires;
    }

    @Override
    public String toString(){
        return getModel();
    }
}
