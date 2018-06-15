package Ex4_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String name = inputs[0];
            double salary = Double.parseDouble(inputs[1]);
            String position = inputs[2];
            String department = inputs[3];
            switch (inputs.length) {
                case 4:
                    employees.add(new Employee(name, salary, position, department));
                    break;
                case 5:
                    if (Character.isDigit(inputs[4].charAt(0))) {
                        int age = Integer.parseInt(inputs[4]);
                        employees.add(new Employee(name, salary, position, department, age));
                    } else {
                        String email = inputs[4];
                        employees.add(new Employee(name, salary, position, department, email));
                    }
                    break;
                case 6:
                    String email = inputs[4];
                    int age = Integer.parseInt(inputs[5]);
                    employees.add(new Employee(name, salary, position, department, email, age));
            }
        }
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> x.getValue().stream()
                                .mapToDouble(Employee::getSalary).average().getAsDouble(),
                        Comparator.reverseOrder()))
                .limit(1)
                .forEach(x -> {
                    System.out.println("Highest Average Salary: " + x.getKey());
                    x.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .forEach(System.out::println);
                });


    }
}
