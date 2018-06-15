package Ex5_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String model = inputs[0];
            double fuel = Double.parseDouble(inputs[1]);
            double fuelCost = Double.parseDouble(inputs[2]);
            cars.put(model, new Car(model, fuel, fuelCost));
        }
        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] inputs = input.split(" ");
            String model = inputs[1];
            int distance = Integer.parseInt(inputs[2]);
            try{
                cars.get(model).moveCar(distance);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input = reader.readLine();
        }
        cars.values().forEach(System.out::println);
    }
}
