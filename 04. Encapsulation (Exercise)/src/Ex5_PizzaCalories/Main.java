package Ex5_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaData = reader.readLine().split(" ");
        String pizzaName = pizzaData[1];
        int toppingCount = Integer.parseInt(pizzaData[2]);
        if (toppingCount < 0 || toppingCount > 10) {
            System.out.println("Number of toppings should be in range [0..10].");
            return;
        }
        String[] doughData = reader.readLine().split(" ");
        String flourType = doughData[1];
        String preparation = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);
        try {
            Dough dough = new Dough(doughWeight, flourType, preparation);
            List<Topping> toppings = new ArrayList<>();
            for (int i = 0; i < toppingCount; i++) {
                String[] toppingData = reader.readLine().split(" ");
                String toppingType = toppingData[1];
                double toppingWeight = Double.parseDouble(toppingData[2]);
                toppings.add(new Topping(toppingType, toppingWeight));
            }
            Pizza pizza = new Pizza(pizzaName, dough);
            for (Topping topping : toppings) {
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getTotalCalories());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
