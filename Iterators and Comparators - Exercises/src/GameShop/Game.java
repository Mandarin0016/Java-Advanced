package GameShop;

public class Game {
    private String name;
    private Double price;

    public Game(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Current Game " + this.getName() + ", it's price is " + this.getPrice() + ".";
    }
}
