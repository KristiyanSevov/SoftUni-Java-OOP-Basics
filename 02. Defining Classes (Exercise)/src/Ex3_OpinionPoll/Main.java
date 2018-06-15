package Ex3_OpinionPoll;

import Ex2_CreatingConstructors.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String name = inputs[0];
            int age = Integer.parseInt(inputs[1]);
            people.add(new Person(name, age));
        }
        people.stream()
                .filter(x -> x.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(x -> System.out.printf("%s - %d%n", x.getName(), x.getAge()));
    }
}
