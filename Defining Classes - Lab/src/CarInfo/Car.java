package CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePowers;
    //getters
    public int getHorsePowers(){
        return this.horsePowers;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    //setters
    public void setHorsePowers(int horsePowers){
        this.horsePowers = horsePowers;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }

    //printing method
    String carInfo(){
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePowers);
    }


}
