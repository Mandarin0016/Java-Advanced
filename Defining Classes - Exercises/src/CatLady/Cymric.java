package CatLady;

public class Cymric extends Cat{
    private double furLength;
    private final String BREED = "Cymric";
    public Cymric(String name, double furLength){
        this.setName(name);
        this.setFurLength(furLength);
    }
    public double getFurLength() {
        return furLength;
    }
    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.BREED, getName(), getFurLength());
    }
}
