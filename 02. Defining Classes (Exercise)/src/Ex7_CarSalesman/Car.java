package Ex7_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, Integer weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%nWeight: %s%nColor: %s",
                this.model, this.engine,
                this.weight == null ? "n/a" : this.weight,
                this.color == null ? "n/a" : this.color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
