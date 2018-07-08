package entities;

public class DCHero extends Hero {
    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return super.getEnergy() / 1.5 + super.getSpecial() + super.getIntelligence();
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("####DC Attack Power: %.2f", this.attack());
    }
}
