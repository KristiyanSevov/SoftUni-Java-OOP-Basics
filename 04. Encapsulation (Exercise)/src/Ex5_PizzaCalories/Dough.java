package Ex5_PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Dough extends Ingredient {
    private static final Map<String, Double> DOUGH_MODIFIERS = new HashMap<>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};

    private String flourType;
    private String preparation;
    private double weight;

    public Dough(double weight, String flourType, String preparation) {
        setFlourType(flourType);
        setPreparation(preparation);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!DOUGH_MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setPreparation(String preparation) {
        if (!DOUGH_MODIFIERS.containsKey(preparation)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.preparation = preparation;
    }

    @Override
    public double getCalories() {
        return CALORIE_BASE * weight * DOUGH_MODIFIERS.get(flourType) * DOUGH_MODIFIERS.get(preparation);
    }
}
