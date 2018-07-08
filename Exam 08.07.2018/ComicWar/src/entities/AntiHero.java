package entities;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    protected AntiHero(String name, int energy, double health,
                       double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness < 0) {
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("###Evilness: %.2f", this.evilness);
    }
}
