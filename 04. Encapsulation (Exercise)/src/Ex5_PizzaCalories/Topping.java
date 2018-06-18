package Ex5_PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Topping extends Ingredient {
    private static final Map<String, Double> TOPPING_MODIFIERS = new HashMap<>() {{
        put("Meat", 1.2);
        put("Veggies", 0.8);
        put("Cheese", 1.1);
        put("Sauce", 0.9);
    }};

    private String name;
    private double weight;

    public Topping(String name, double weight) {
        setName(name);
        setWeight(weight);
    }

    @Override
    public double getCalories() {
        return CALORIE_BASE * this.weight * TOPPING_MODIFIERS.get(this.name);
    }

    private void setName(String name) {
        if (!TOPPING_MODIFIERS.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", name));
        }
        this.name = name;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.name));
        }
        this.weight = weight;
    }
}
