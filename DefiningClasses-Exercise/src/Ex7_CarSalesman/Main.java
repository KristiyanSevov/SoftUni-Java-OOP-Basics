package Ex7_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        readEngines(reader, engines);
        readCars(reader, engines, cars);
        cars.forEach(System.out::println);
    }

    private static void readCars(BufferedReader reader,
                                 Map<String, Engine> engines,
                                 List<Car> cars) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String model = inputs[0];
            String engineName = inputs[1];
            Engine engine = engines.get(engineName);
            Car car = null;
            switch (inputs.length) {
                case 2:
                    car = new Car(model, engine);
                    break;
                case 3:
                    if (Character.isDigit(inputs[2].charAt(0))) {
                        int weight = Integer.parseInt(inputs[2]);
                        car = new Car(model, engine, weight);
                    } else {
                        String color = inputs[2];
                        car = new Car(model, engine, color);
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(inputs[2]);
                    String color = inputs[3];
                    car = new Car(model, engine, weight, color);
                    break;
            }
            cars.add(car);
        }
    }

    private static void readEngines(BufferedReader reader, Map<String, Engine> engines) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String model = inputs[0];
            int power = Integer.parseInt(inputs[1]);
            Engine engine = null;
            switch (inputs.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    if (Character.isDigit(inputs[2].charAt(0))) {
                        int displacement = Integer.parseInt(inputs[2]);
                        engine = new Engine(model, power, displacement);
                    } else {
                        String efficiency = inputs[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    int displacement = Integer.parseInt(inputs[2]);
                    String efficiency = inputs[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }
            engines.put(model, engine);
        }
    }
}
