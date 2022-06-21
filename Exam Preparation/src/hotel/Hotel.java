package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if (this.roster.size() < this.capacity){
            this.roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person currentPerson : this.roster) {
            if (currentPerson.getName().equals(name)){
                this.roster.remove(currentPerson);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){
        Person personForReturn = null;
        for (Person currentPerson : this.roster) {
            if (currentPerson.getName().equals(name) && currentPerson.getHometown().equals(hometown)){
                personForReturn = currentPerson;
                break;
            }
        }
        return personForReturn;
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("The people in the hotel %s are:", this.name));
        this.roster.forEach(person -> result.append(System.lineSeparator()).append(person));
        return result.toString();
    }
}
