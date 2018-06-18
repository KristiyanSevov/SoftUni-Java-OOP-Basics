package Ex6_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public boolean removePlayer(String playerName){
        return this.players.removeIf(x -> x.getName().equals(playerName));
    }

    public double getRating() {
        return players.stream()
                .mapToDouble(x -> (x.getDribble() + x.getEndurance() + x.getPassing() +
                        x.getShooting() + x.getSprint()) / 5.0)
                .sum();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}
