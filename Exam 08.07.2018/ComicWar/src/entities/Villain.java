package entities;

public class Villain extends AntiHero {

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
    }

    @Override
    public String toString() {
        double x = this.attack();
        return super.toString() + System.lineSeparator() +
                String.format("####Villain Attack Power: %.2f", this.attack());
    }
}
