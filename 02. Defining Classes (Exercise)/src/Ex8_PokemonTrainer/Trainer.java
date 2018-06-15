package Ex8_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badgeCount;
    private List<Pokemon> pokemon;

    public Trainer(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
    }

    public void lowerPokemonHealth() {
        List<Pokemon> updatedPokemon = new ArrayList<>();
        for (Pokemon p : pokemon) {
            if (p.getHealth() <= 10) {
                continue;
            }
            p.setHealth(p.getHealth() - 10);
            updatedPokemon.add(p);
        }
        this.pokemon = updatedPokemon;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badgeCount, this.pokemon.size());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(int badgeCount) {
        this.badgeCount = badgeCount;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
