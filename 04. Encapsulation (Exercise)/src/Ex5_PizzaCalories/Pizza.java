package Ex5_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, Dough dough) {
        setName(name);
        this.dough = dough;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        if (toppings.size() == 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        toppings.add(topping);
    }

    public double getTotalCalories(){
        return this.dough.getCalories() + this.toppings.stream().mapToDouble(Topping::getCalories).sum();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
}
