package Ex10_FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String infoToPrint = reader.readLine();
        Map<String, String> namesToDates = new HashMap<>();
        Map<String, String> datesToNames = new HashMap<>();

        String input = reader.readLine();
        List<String> relationInfo = new ArrayList<>();
        while (!"End".equals(input)) {
            if (input.contains(" - ")) {
                relationInfo.add(input);
            } else {
                String[] inputs = input.split(" ");
                String name = inputs[0] + " " + inputs[1];
                String date = inputs[2];
                namesToDates.put(name, date);
                datesToNames.put(date, name);
            }
            input = reader.readLine();
        }

        String personName = isDate(infoToPrint) ? datesToNames.get(infoToPrint) : infoToPrint;
        String personDate = isDate(infoToPrint) ? infoToPrint : namesToDates.get(infoToPrint);
        List<String> parents = new ArrayList<>();
        List<String> children = new ArrayList<>();
        for (String line : relationInfo) {
            String[] data = line.split(" - ");
            String parent = data[0];
            String child = data[1];
            if (parent.equals(personName) || parent.equals(personDate)) {
                if (isDate(child)) {
                    children.add(datesToNames.get(child) + " " + child);
                } else {
                    children.add(child + " " + namesToDates.get(child));
                }
            } else if (child.equals(personName) || child.equals(personDate)) {
                if (isDate(parent)) {
                    parents.add(datesToNames.get(parent) + " " + parent);
                } else {
                    parents.add(parent + " " + namesToDates.get(parent));
                }
            }
        }
        System.out.println(personName + " " + personDate);
        System.out.println("Parents:");
        parents.forEach(System.out::println);
        System.out.println("Children:");
        children.forEach(System.out::println);
    }

    private static boolean isDate(String str) {
        return str.contains("/");
    }
}
