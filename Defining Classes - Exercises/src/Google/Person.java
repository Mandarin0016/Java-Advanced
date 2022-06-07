package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private List<Pokemon> pokemons = new ArrayList<>();

    //constructors
    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
    }
    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }
    public Person(String name, Parent parent) {
        this.name = name;
        this.parents.add(parent);
    }
    public Person(String name, Child child) {
        this.name = name;
        this.children.add(child);
    }
    public Person(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemons.add(pokemon);
    }
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(getName()).append(System.lineSeparator());
        output.append("Company: ").append(System.lineSeparator());
        if (getCompany() != null){
            output.append(getCompany()).append(System.lineSeparator());
        }
        output.append("Car: ").append(System.lineSeparator());
        if (getCar() != null){
            output.append(getCar()).append(System.lineSeparator());
        }
        output.append("Pokemon: ").append(System.lineSeparator());
        getPokemons().forEach(pokemon -> output.append(pokemon).append(System.lineSeparator()));
        output.append("Parents: ").append(System.lineSeparator());
        getParents().forEach(parent -> output.append(parent).append(System.lineSeparator()));
        output.append("Children: ").append(System.lineSeparator());
        getChildren().forEach(child -> output.append(child).append(System.lineSeparator()));
        return output.toString();
    }

    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public List<Parent> getParents() {
        return parents;
    }
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }
    public List<Child> getChildren() {
        return children;
    }
    public void setChildren(List<Child> children) {
        this.children = children;
    }
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
