package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }


    public void add(Fish fish){
        boolean isThereSuchFish = false;
        for (Fish currentFish : this.fishInPool) {
            if (currentFish.getName().equals(fish.getName())){
                isThereSuchFish = true;
                break;
            }
        }
        if (!isThereSuchFish && this.fishInPool.size() < this.capacity){
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        for (Fish currentFish : this.fishInPool) {
            if (currentFish.getName().equals(name)){
                this.fishInPool.remove(currentFish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){
        Fish fishForReturn = null;
        for (Fish currentFish : this.fishInPool) {
            if (currentFish.getName().equals(name)){
                fishForReturn = currentFish;
            }
        }
        return fishForReturn;
    }

    public String report(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size));
        this.fishInPool.forEach(fish -> result.append(System.lineSeparator()).append(fish));
        return result.toString();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
