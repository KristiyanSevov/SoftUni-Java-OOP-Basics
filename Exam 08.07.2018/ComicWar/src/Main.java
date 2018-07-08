import entities.*;
import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.SuperPower;
import manager.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        WarManager warManager = new WarManager();

        String input = reader.readLine();
        while (!"WAR_IS_OVER".equals(input)) {
            String[] inputs = input.split("\\s+");
            String command = inputs[0];
            try{
            switch (command) {
                case "CHECK_CHARACTER":
                    String characterName = inputs[1];
                    System.out.println(warManager.checkComicCharacter(characterName));
                    break;
                case "REGISTER_HERO":
                    String chName = inputs[1];
                    String type = inputs[2];
                    int energy = Integer.parseInt(inputs[3]);
                    double health = Double.parseDouble(inputs[4]);
                    double intelligence = Double.parseDouble(inputs[5]);
                    double heroism = Double.parseDouble(inputs[6]);
                    ComicCharacter hero = null;
                    switch (type){
                        case "MarvelHero":
                            hero = new MarvelHero(chName, energy, health, intelligence, heroism);
                            break;
                        case "DCHero":
                            hero = new DCHero(chName, energy, health, intelligence, heroism);
                            break;
                    }
                    System.out.println(warManager.addHero(hero));
                    break;
                case "REGISTER_ANTI_HERO":
                    String ahName = inputs[1];
                    String ahType = inputs[2];
                    int ahEnergy = Integer.parseInt(inputs[3]);
                    double ahHealth = Double.parseDouble(inputs[4]);
                    double ahIntelligence = Double.parseDouble(inputs[5]);
                    double evilness = Double.parseDouble(inputs[6]);
                    ComicCharacter antiHero = null;
                    String arenaName = null;
                    switch (ahType){
                        case "Villain":
                            antiHero = new Villain(ahName, ahEnergy, ahHealth, ahIntelligence, evilness);
                            break;
                        case "Titan":
                            antiHero = new Titan(ahName, ahEnergy, ahHealth, ahIntelligence, evilness);
                            break;
                    }
                    System.out.println(warManager.addAntiHero(antiHero));
                    break;
                case "BUILD_ARENA":
                    arenaName = inputs[1];
                    int arenaCapacity = Integer.parseInt(inputs[2]);
                    Arena arena = new ArenaImpl(arenaName, arenaCapacity);
                    System.out.println(warManager.addArena(arena));
                    break;
                case "SEND_HERO":
                    arenaName = inputs[1];
                    String heroName = inputs[2];
                    System.out.println(warManager.addHeroToArena(arenaName, heroName));
                    break;
                case "SEND_ANTI_HERO":
                    arenaName = inputs[1];
                    String antiHeroName = inputs[2];
                    System.out.println(warManager.addAntiHeroToArena(arenaName, antiHeroName));
                    break;
                case "SUPER_POWER":
                    String superPowerName = inputs[1];
                    double powerPoints = Double.parseDouble(inputs[2]);
                    SuperPower superPower = new Power(superPowerName, powerPoints);
                    System.out.println(warManager.loadSuperPowerToPool(superPower));
                    break;
                case "ASIGN_POWER":
                    String comicChName = inputs[1];
                    String powerName = inputs[2];
                    System.out.println(warManager.asignSuperPowerToComicCharacter(comicChName, powerName));
                    break;
                case "UNLEASH":
                    String poweredChName = inputs[1];
                    System.out.println(warManager.usePowers(poweredChName));
                    break;
                case "COMICS_WAR":
                    arenaName = inputs[1];
                    System.out.println(warManager.startBattle(arenaName));
                    break;
            }} catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            input = reader.readLine();
        }
        System.out.println(warManager.endWar());
    }
}
