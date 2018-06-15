package Ex2_CreatingConstructors;

public class Person {
    private static final int DEFAULT_AGE = 1;
    private static final String DEFAULT_NAME = "No name";

    private String name;
    private int age;

    public Person() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }

    public Person(int age) {
        this(DEFAULT_NAME, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
