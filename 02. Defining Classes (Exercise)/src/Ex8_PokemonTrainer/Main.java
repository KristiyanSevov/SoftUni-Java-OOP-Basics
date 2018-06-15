package Ex8_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!"Tournament".equals(input)) {
            String[] inputs = input.split(" ");
            String trainerName = inputs[0];
            String pokemonName = inputs[1];
            String pokemonElement = inputs[2];
            int pokemonHealth = Integer.parseInt(inputs[3]);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemon().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            input = reader.readLine();
        }
        String type = reader.readLine();
        while (!"End".equals(type)) {
            final String pokemonType = type;
            for (Trainer trainer : trainers.values()) {
                if (trainer.getPokemon().stream().anyMatch(x -> x.getElement().equals(pokemonType))) {
                    trainer.setBadgeCount(trainer.getBadgeCount() + 1);
                } else {
                    trainer.lowerPokemonHealth();
                }
            }
            type = reader.readLine();
        }
        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getBadgeCount, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
