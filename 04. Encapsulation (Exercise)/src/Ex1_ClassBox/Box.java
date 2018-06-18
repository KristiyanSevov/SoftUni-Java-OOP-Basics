package Ex1_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceArea() {
        return 2 * length * width + getLateralSurfaceArea();
    }

    public double getLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double getVolume() {
        return length * width * height;
    }
}
