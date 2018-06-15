package Ex11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats = new HashMap<>();
        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] inputs = input.split(" ");
            String breed = inputs[0];
            String name = inputs[1];
            Cat cat = null;
            switch (breed){
                case "Siamese":
                    Double earSize = Double.parseDouble(inputs[2]);
                    cat = new Siamese(name, earSize);
                    break;
                case "Cymric":
                    Double furLength = Double.parseDouble(inputs[2]);
                    cat = new Cymric(name, furLength);
                    break;
                case "StreetExtraordinaire":
                    Double meowDecibels = Double.parseDouble(inputs[2]);
                    cat = new StreetExtraordinaire(name, meowDecibels);
                    break;
            }
            cats.put(name, cat);
            input = reader.readLine();
        }
        String catToPrint = reader.readLine();
        System.out.println(cats.get(catToPrint));
    }
}
