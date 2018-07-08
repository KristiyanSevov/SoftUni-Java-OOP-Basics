package Ex9_Google;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemon;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public void updateCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }

    public void updateCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    public void addParent(String name, String birthday) {
        this.parents.add(new Parent(name, birthday));
    }

    public void addChild(String name, String birthday) {
        this.children.add(new Child(name, birthday));
    }

    public void addPokemon(String name, String type) {
        this.pokemon.add(new Pokemon(name, type));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        this.pokemon.forEach(x -> sb.append(x).append(System.lineSeparator()));
        sb.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(x -> sb.append(x).append(System.lineSeparator()));
        sb.append("Children:").append(System.lineSeparator());
        this.children.forEach(x -> sb.append(x).append(System.lineSeparator()));
        return sb.toString();
    }

    class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return this.name + " " + this.type;
        }
    }

    class Relative {
        private String name;
        private String birthday; //inconsistent date formats passed in Judge

        public Relative(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return this.name + " " + this.birthday;
        }
    }

    class Parent extends Relative {
        public Parent(String name, String birthday) {
            super(name, birthday);
        }
    }

    class Child extends Relative {
        public Child(String name, String birthday) {
            super(name, birthday);
        }
    }

    class Car {
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return this.model + " " + this.speed;
        }
    }

    class Company {
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", this.name, this.department, this.salary);
        }
    }
}
