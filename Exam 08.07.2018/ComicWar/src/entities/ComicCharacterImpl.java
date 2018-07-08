package entities;

import interfaces.ComicCharacter;
import interfaces.SuperPower;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    protected ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        setName(name);
        setEnergy(energy);
        setHealth(health);
        setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.matches("[a-zA-Z_]{2,12}")) {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
        this.name = name;
    }

    private void setEnergy(int energy) {
        if (energy < 0 || energy > 300) {
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence < 0 || intelligence > 200) {
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        setEnergy(energy);
        setHealth(health);
        setIntelligence(intelligence);
}

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    @Override
    public String getName() {
        return this.name;
    }


        @Override
        public int getEnergy() {
            return this.energy;
        }

        @Override
        public double getHealth() {
            return this.health;
        }

        @Override
        public double getIntelligence() {
            return this.intelligence;
        }

        @Override
        public String useSuperPowers() {
            if (this.powers.size() == 0) {
                return String.format("%s has no super powers!", this.name);
            }
            for (SuperPower power : powers) {
                this.energy += power.getPowerPoints();
                this.health += power.getPowerPoints() * 2;
            }
            return String.format("%s used his super powers!", this.name);
        }

        @Override
        public void addSuperPower(SuperPower superPower) {
            this.powers.add(superPower);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("#Name: %s", this.name)).append(System.lineSeparator());
        sb.append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f",
                this.health, this.energy, this.intelligence));
        return sb.toString();
    }
}
