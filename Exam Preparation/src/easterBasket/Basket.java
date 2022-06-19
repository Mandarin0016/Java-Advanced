package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg){
        if (this.data.size() < capacity){
            this.data.add(egg);
        }
    }
    public boolean removeEgg(String color){
        for (Egg currentEgg : this.data) {
            if (currentEgg.getColor().equals(color)){
                this.data.remove(currentEgg);
                return true;
            }
        }
        return false;
    }
    public Egg getStrongestEgg(){
        Egg strongest = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            Egg currentEgg = this.data.get(i);
            if (strongest.getStrength() < currentEgg.getStrength()){
                strongest = currentEgg;
            }
        }
        return strongest;
    }
    public Egg getEgg(String color){
        for (Egg currentEgg : this.data) {
            if (currentEgg.getColor().equals(color)){
                return currentEgg;
            }
        }
        return null;
    }
    public int getCount(){
        return this.data.size();
    }
    public String report(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s basket contains:", this.material));
        this.data.forEach(egg -> result.append(System.lineSeparator()).append(egg));
        return result.toString();
    }
}
