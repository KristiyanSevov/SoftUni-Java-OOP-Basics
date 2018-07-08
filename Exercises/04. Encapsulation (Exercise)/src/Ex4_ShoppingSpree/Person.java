package Ex4_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
        this.money -= product.getCost();
    }
    @Override
    public String toString() {
        return this.name + " - " + (this.products.size() == 0 ? "Nothing bought" :
                this.products.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
}
