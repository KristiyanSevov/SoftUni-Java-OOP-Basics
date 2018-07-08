package entities;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    protected Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism < 0) {
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("###Heroism: %.2f", this.heroism);
    }
}
