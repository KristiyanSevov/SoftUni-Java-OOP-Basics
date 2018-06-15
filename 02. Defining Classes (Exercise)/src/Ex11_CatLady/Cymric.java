package Ex11_CatLady;

public class Cymric extends Cat {
    private Double furLength;

    public Cymric(String name, Double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", this.getName(), this.furLength);
    }
}
