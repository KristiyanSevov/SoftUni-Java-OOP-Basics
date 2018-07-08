package Ex4_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        try {
            readPeople(reader, people);
            readProducts(reader, products);
            processOrders(reader, people, products);
            people.values().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processOrders(BufferedReader reader,
                                      Map<String, Person> people,
                                      Map<String, Product> products) throws IOException {
        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] inputs = input.split(" ");
            String personName = inputs[0];
            String productName = inputs[1];
            Person person = people.get(personName);
            Product product = products.get(productName);
            if (person.getMoney() < product.getCost()) {
                System.out.printf("%s can't afford %s%n", personName, productName);
            } else {
                person.addProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            }
            input = reader.readLine();
        }
    }

    private static void readProducts(BufferedReader reader, Map<String, Product> products) throws IOException {
        String[] productsData = reader.readLine().split(";");
        for (String data : productsData) {
            String[] productData = data.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            products.put(name, new Product(name, cost));
        }
    }

    private static void readPeople(BufferedReader reader, Map<String, Person> people) throws IOException {
        String[] peopleData = reader.readLine().split(";");
        for (String data : peopleData) {
            String[] personData = data.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            people.put(name, new Person(name, money));
        }
    }
}
