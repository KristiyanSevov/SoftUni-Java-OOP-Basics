package Ex6_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();
        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] inputs = input.split(";");
            String command = inputs[0];
            try {
                switch (command) {
                    case "Team":
                        String name = inputs[1];
                        teams.put(name, new Team(name));
                        break;
                    case "Add":
                        addPlayer(teams, inputs);
                        break;
                    case "Remove":
                        removePlayer(teams, inputs);
                        break;
                    case "Rating":
                        String teamName = inputs[1];
                        printRating(teams, teamName);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = reader.readLine();
        }
    }

    private static void printRating(Map<String, Team> teams, String input) {
        Team team = teams.get(input);
        if (team == null) {
            System.out.printf("Team %s does not exist.%n", input);
        } else {
            System.out.printf("%s - %d%n", input, Math.round(team.getRating()));
        }
    }

    private static void removePlayer(Map<String, Team> teams, String[] inputs) {
        String teamName = inputs[1];
        String playerName = inputs[2];
        Team team = teams.get(teamName);
        if (team == null) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            boolean removalSuccess = team.removePlayer(playerName);
            if (!removalSuccess) {
                System.out.printf("Player %s is not in %s team.%n", playerName, teamName);
            }
        }
    }

    private static void addPlayer(Map<String, Team> teams, String[] inputs) {
        String teamName = inputs[1];
        String playerName = inputs[2];
        int endurance = Integer.parseInt(inputs[3]);
        int sprint = Integer.parseInt(inputs[4]);
        int dribble = Integer.parseInt(inputs[5]);
        int passing = Integer.parseInt(inputs[6]);
        int shooting = Integer.parseInt(inputs[7]);
        Team team = teams.get(teamName);
        if (team == null) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            team.addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
        }
    }
}
