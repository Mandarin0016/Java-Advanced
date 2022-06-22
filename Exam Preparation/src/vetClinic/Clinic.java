package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet datum : this.data) {
            if (datum.getName().equals(name)){
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet currentPet : this.data) {
            if (currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)){
                return currentPet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet oldestOne = this.data.get(0);
        for (Pet currentPet : this.data) {
            if (currentPet.getAge() > oldestOne.getAge()) {
                oldestOne = currentPet;
            }
        }
        return oldestOne;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append("The clinic has the following patients:");
        this.data.forEach(pet -> result.append(System.lineSeparator()).append(pet.getName()).append(" ").append(pet.getOwner()));
        return result.toString();
    }
}
