package CatLady;

public class Siamese extends Cat{
    private double earSize;
    private final String BREED = "Siamese";
    public Siamese(String name, double earSize){
        this.setName(name);
        this.setEarSize(earSize);
    }
    public double getEarSize() {
        return earSize;
    }
    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.BREED, getName(), getEarSize());
    }
}
