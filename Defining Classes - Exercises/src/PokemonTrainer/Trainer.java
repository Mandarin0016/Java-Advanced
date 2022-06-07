package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons = new ArrayList<>();

    public Trainer(String name, Pokemon pokemon){
        this.name = name;
        this.pokemons.add(pokemon);
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString(){
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }

    public void increaseBadges(){
        badges++;
    }
    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBadges() {
        return badges;
    }
    public void setBadges(int badges) {
        this.badges = badges;
    }
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
