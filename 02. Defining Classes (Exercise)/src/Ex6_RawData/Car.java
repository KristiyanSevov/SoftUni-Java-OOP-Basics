package Ex6_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age
    ) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new Tire[]{
                new Tire(tire1Pressure, tire1Age),
                new Tire(tire2Pressure, tire2Age),
                new Tire(tire3Pressure, tire3Age),
                new Tire(tire4Pressure, tire4Age)
        };
    }

    @Override
    public String toString() {
        return this.getModel();
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }

    public class Tire {
        private double pressure;
        private int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public class Cargo {
        private int weigth;
        private String type;

        public Cargo(int weigth, String type) {
            this.weigth = weigth;
            this.type = type;
        }

        public int getWeigth() {
            return weigth;
        }

        public void setWeigth(int weigth) {
            this.weigth = weigth;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public class Engine {
        private int speed;
        private int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }
    }
}
