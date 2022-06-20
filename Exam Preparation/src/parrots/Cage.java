package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    //name: String
    //capacity: int
    //data: List<Parrot>
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void add(Parrot parrot){
        if (this.data.size() < capacity){
            this.data.add(parrot);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(currentParrot -> currentParrot.getName().equals(name));
    }
    public Parrot sellParrot(String name){
        Parrot parrotForSelling = null;
        for (Parrot currentParrot : this.data) {
            if (currentParrot.getName().equals(name)){
                this.data.get(this.data.indexOf(currentParrot)).setAvailable(false);
                parrotForSelling = currentParrot;
            }
        }
        return parrotForSelling;
    }
    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> parrotsForSelling = new ArrayList<>();
        for (Parrot currentParrot : this.data) {
            if (currentParrot.getSpecies().equals(species)){
                this.data.get(this.data.indexOf(currentParrot)).setAvailable(false);
                parrotsForSelling.add(currentParrot);
            }
        }
        return parrotsForSelling;
    }
    public int count(){
        return this.data.size();
    }
    public String report(){
        List<Parrot> notSoldParrots = new ArrayList<>();
        for (Parrot currentParrot : this.data) {
            if (currentParrot.isAvailable()){
                notSoldParrots.add(currentParrot);
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format("Parrots available at %s:", this.name));
        notSoldParrots.forEach(parrot -> result.append(System.lineSeparator()).append(parrot));
        return result.toString();
    }
}
