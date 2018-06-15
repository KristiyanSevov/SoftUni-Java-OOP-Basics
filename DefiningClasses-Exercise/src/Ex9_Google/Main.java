package Ex9_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new HashMap<>();
        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] inputs = input.split(" ");
            String name = inputs[0];
            people.putIfAbsent(name, new Person(name));
            Person person = people.get(name);
            String command = inputs[1];
            switch (command){
                case "company":
                    String companyName = inputs[2];
                    String department = inputs[3];
                    double salary = Double.parseDouble(inputs[4]);
                    person.updateCompany(companyName, department, salary);
                    break;
                case "car":
                    String model = inputs[2];
                    int speed = Integer.parseInt(inputs[3]);
                    person.updateCar(model, speed);
                    break;
                case "parents":
                    String parentName = inputs[2];
                    String parentBirthday = inputs[3];
                    person.addParent(parentName, parentBirthday);
                    break;
                case "children":
                    String childName = inputs[2];
                    String childBirthday = inputs[3];
                    person.addChild(childName, childBirthday);
                    break;
                case "pokemon":
                    String pokemonName = inputs[2];
                    String type = inputs[3];
                    person.addPokemon(pokemonName, type);
                    break;
            }
            input = reader.readLine();
        }
        String nameToPrint = reader.readLine();
        System.out.print(people.get(nameToPrint));
    }
}
