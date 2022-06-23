package guild;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {

        return this.roster.removeIf(player -> player.getName().equals(name));

//        for (Player player : this.roster) {
//            if (player.getName().equals(name)) {
//                this.roster.remove(player);
//                return true;
//            }
//        }
//        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] players = this.roster.stream().filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);

        setRoster(roster.stream().filter(player -> !player.getClazz().equals(clazz))
                .collect(Collectors.toList()));

        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":");
        sb.append(System.lineSeparator());

        this.roster.forEach(player -> sb.append(player).append(System.lineSeparator()));

        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }
}
