package Ex6_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            cars.add(new Car(
                    inputs[0], Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]),
                    Integer.parseInt(inputs[3]), inputs[4],
                    Double.parseDouble(inputs[5]), Integer.parseInt(inputs[6]),
                    Double.parseDouble(inputs[7]), Integer.parseInt(inputs[8]),
                    Double.parseDouble(inputs[9]), Integer.parseInt(inputs[10]),
                    Double.parseDouble(inputs[11]), Integer.parseInt(inputs[12])
            ));
        }

        Predicate<Car> carFilter;
        String command = reader.readLine();
        if ("fragile".equals(command)) {
            carFilter = x -> "fragile".equals(x.getCargo().getType()) &&
                    Arrays.stream(x.getTires()).anyMatch(t -> t.getPressure() < 1);
        } else {
            carFilter = x -> "flamable".equals(x.getCargo().getType()) &&
                    x.getEngine().getPower() > 250;
        }

        cars.stream()
                .filter(carFilter)
                .forEach(System.out::println);

    }
}
