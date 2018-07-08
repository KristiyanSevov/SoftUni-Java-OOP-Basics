package manager;

import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.Manager;
import interfaces.SuperPower;

import java.util.*;

public class WarManager implements Manager {
    private int heroWonBattles;
    private int antiHeroWonBattles;
    private Map<String, ComicCharacter> characters;
    private Map<String, ComicCharacter> heroes;
    private Map<String, ComicCharacter> antiHeroes;
    private Map<String, Arena> arenas;
    private Map<String, String> assignedHeroes;
    private Map<String, String> assignedAntiHeroes;
    private Map<String, SuperPower> superPowers;
    private Set<String> assignedPowers;

    public WarManager() {
        this.characters = new LinkedHashMap<>();
        this.heroes = new LinkedHashMap<>();
        this.antiHeroes = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.assignedHeroes = new HashMap<>();
        this.assignedAntiHeroes = new HashMap<>();
        this.superPowers = new HashMap<>();
        this.assignedPowers = new HashSet<>();
    }

    @Override
    public String checkComicCharacter(String characterName) {
        ComicCharacter character = characters.get(characterName);
        if (character == null) {
            return String.format("Sorry, fans! %s doesn't exist in out comics!", characterName);
        }
        if (character.getHealth() <= 0) {
            return String.format("%s has fallen in battle!", characterName);
        }
        return character.toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (heroes.containsKey(hero.getName())) {
            ComicCharacter existing = heroes.get(hero.getName());
            try {
                existing.boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
            return String.format("%s evolved!", hero.getName());
        }
        heroes.put(hero.getName(), hero);
        characters.put(hero.getName(), hero);
        return String.format("%s is ready for battle!", hero.getName());
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if (antiHeroes.containsKey(antiHero.getName())) {
            ComicCharacter existing = antiHeroes.get(antiHero.getName());
            try {
                existing.boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
            return String.format("%s is getting stronger!", antiHero.getName());
        }
        antiHeroes.put(antiHero.getName(), antiHero);
        characters.put(antiHero.getName(), antiHero);
        return String.format("%s is ready for destruction!", antiHero.getName());
    }

    @Override
    public String addArena(Arena arena) {
        if (arenas.containsKey(arena.getArenaName())) {
            return "A battle is about to start there!";
        }
        arenas.put(arena.getArenaName(), arena);
        return String.format("%s is becoming a fighting ground!", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        Arena fightingArena = arenas.get(arena);
        ComicCharacter fightingHero = heroes.get(hero);
        if (assignedHeroes.values().contains(hero)) {
            return String.format("%s is fighting!", hero);
        }
        if (fightingHero.getHealth() <= 0) {
            return String.format("%s is dead!", fightingHero.getName());
        }
        if (fightingArena.isArenaFull()) {
            return "Arena is full!";
        }
        fightingArena.addHero(fightingHero);
        assignedHeroes.put(arena, hero);
        return String.format("%s is fighting for your freedom in %s!",
                hero, arena);
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        Arena fightingArena = arenas.get(arena);
        ComicCharacter fightingAntiHero = antiHeroes.get(antiHero);
        if (assignedAntiHeroes.values().contains(antiHero)) {
            return String.format("%s is fighting!", antiHero);
        }
        if (fightingAntiHero.getHealth() <= 0) {
            return String.format("%s is dead!", fightingAntiHero.getName());
        }
        if (fightingArena.isArenaFull()) {
            return "Arena is full!";
        }
        fightingArena.addAntiHero(fightingAntiHero);
        assignedAntiHeroes.put(arena, antiHero);
        return String.format("%s and his colleagues are trying to take over %s!",
                antiHero, arena);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (superPowers.containsKey(superPower.getName())) {
            return "This super power already exists!";
        }
        superPowers.put(superPower.getName(), superPower);
        return String.format("%s added to pool!", superPower.getName());
    }

    @Override
    public String asignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        if (assignedPowers.contains(superPower)) {
            return String.format("%s already asigned!", superPower);
        }
        ComicCharacter character = characters.get(comicCharacter);
        character.addSuperPower(superPowers.get(superPower));
        assignedPowers.add(superPower);
        return String.format("%s has a new super power!", character.getName());
    }

    @Override
    public String usePowers(String comicCharacter) {
        ComicCharacter character = characters.get(comicCharacter);
        return character.useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        Arena fightingArena = arenas.get(arena);
        try {
            boolean heroesWin = fightingArena.fightHeroes();
            assignedHeroes.remove(arena);
            assignedAntiHeroes.remove(arena);
            arenas.remove(arena);
            if (heroesWin) {
                this.heroWonBattles++;
                return String.format("Heroes won the battle of %s!", fightingArena.getArenaName());
            } else {
                this.antiHeroWonBattles++;
                return String.format("Anti Heroes won the battle of %s!", fightingArena.getArenaName());
            }
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    @Override
    public String endWar() {
        if (this.heroWonBattles >= this.antiHeroWonBattles) {
            return String.format("After %d battles our FRIENDLY HEROES WON!",
                    this.heroWonBattles + this.antiHeroWonBattles);

        } else {
            return "WE ARE DOOMED!";
        }
    }
}
