package Ex5_SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, double fuel, double fuelCostPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void moveCar(int distance){
        if (distance * fuelCostPerKm > fuel) {
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
        this.fuel -= distance * fuelCostPerKm;
        this.distanceTraveled += distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }

}
