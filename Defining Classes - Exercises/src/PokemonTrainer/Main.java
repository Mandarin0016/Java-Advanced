package PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        String[] data = scanner.nextLine().split("\\s+");
        while (!data[0].equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer currentTrainer;
            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).addPokemon(currentPokemon);
            } else {
                currentTrainer = new Trainer(trainerName, currentPokemon);
                trainers.put(trainerName, currentTrainer);
            }
            data = scanner.nextLine().split("\\s+");
        }
        data = scanner.nextLine().split("\\s+");
        while (!data[0].equals("End")) {
            String currentElement = data[0];
            boolean thereIsSuchPokemon = false;
            for (Map.Entry<String, Trainer> trainerEntry : trainers.entrySet()) {
                for (Pokemon pokemon : trainerEntry.getValue().getPokemons()) {
                    if (pokemon.getElement().equals(currentElement)) {
                        thereIsSuchPokemon = true;
                        break;
                    }
                }
                if (thereIsSuchPokemon) {
                    trainers.get(trainerEntry.getKey()).increaseBadges();
                } else {
                    trainers.get(trainerEntry.getKey()).getPokemons().forEach(Pokemon::lowerPokemonHealth);
                    trainers.get(trainerEntry.getKey()).getPokemons().removeIf(pokemon -> pokemon.getHealth() <= 0);
                }
                thereIsSuchPokemon = false;
            }
            data = scanner.nextLine().split("\\s+");
        }
        trainers.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}
