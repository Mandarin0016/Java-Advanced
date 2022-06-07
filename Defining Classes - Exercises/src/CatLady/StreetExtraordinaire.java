package CatLady;

public class StreetExtraordinaire extends Cat{
    private double meowingDecibels;
    private final String BREED = "StreetExtraordinaire";
    public StreetExtraordinaire(String name, double meowingDecibels) {
        this.setName(name);
        this.setMeowingDecibels(meowingDecibels);
    }
    public double getMeowingDecibels() {
        return meowingDecibels;
    }
    public void setMeowingDecibels(double meowingDecibels) {
        this.meowingDecibels = meowingDecibels;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.BREED, getName(), getMeowingDecibels());
    }
}