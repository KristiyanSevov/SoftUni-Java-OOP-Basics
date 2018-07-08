package entities;

import interfaces.Arena;
import interfaces.ComicCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArenaImpl implements Arena {
    private String arenaName;
    private List<Hero> heroes;
    private List<AntiHero> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
}

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        return this.heroes.size() + this.antiHeroes.size() == capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add((Hero) hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add((AntiHero) antiHero);
    }

    @Override
    public boolean fightHeroes() {
        if (this.antiHeroes.size() == 0 && this.heroes.size() == 0) {
            throw new IllegalArgumentException("SAFE ZONE!");
        }

        int counter = heroes.size() < antiHeroes.size() ? 0 : 1;
        while (this.antiHeroes.size() > 0 && this.heroes.size() > 0){
            for (int i = 0; i < Math.min(heroes.size(), antiHeroes.size()); i++) {
                if (counter % 2 == 0) {
                    antiHeroes.get(i).takeDamage(heroes.get(i).attack());
                } else {
                    heroes.get(i).takeDamage(antiHeroes.get(i).attack());
                }
            }
            antiHeroes = antiHeroes.stream().filter(x -> x.getHealth() > 0).collect(Collectors.toList());
            heroes = heroes.stream().filter(x -> x.getHealth() > 0).collect(Collectors.toList());
            counter++;
        }
        return antiHeroes.size() == 0;
    }
}
