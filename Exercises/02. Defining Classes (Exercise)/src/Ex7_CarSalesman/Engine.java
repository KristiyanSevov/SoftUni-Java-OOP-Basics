package Ex7_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, Integer displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s", this.model, this.power,
                this.displacement == null ? "n/a" : this.displacement,
                this.efficiency == null ? "n/a" : this.efficiency);
    }

}
