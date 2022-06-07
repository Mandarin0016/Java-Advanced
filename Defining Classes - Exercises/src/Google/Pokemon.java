package Google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }
    @Override
    public String toString(){
        return String.format("%s %s", getPokemonName(), getPokemonType());
    }

    public String getPokemonName() {
        return pokemonName;
    }
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
    public String getPokemonType() {
        return pokemonType;
    }
    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }
}
