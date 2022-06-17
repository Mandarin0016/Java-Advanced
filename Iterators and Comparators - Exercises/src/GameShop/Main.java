package GameShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game lol = new Game("League of Legends", 345.50);
        Game wow = new Game("World of Warcraft", 589.00);
        Game lineage = new Game("Lineage 2", 420.70);
        Game GTA = new Game("Grand Theft Auto", 125.00);
        Game counterStrike = new Game("Counter Strike", 5.00);
        List<Game> availableGames = new ArrayList<>();
        availableGames.add(lol);
        availableGames.add(wow);
        availableGames.add(lineage);
        availableGames.add(GTA);
        availableGames.add(counterStrike);
        GameShop pulsar = new GameShop(availableGames);
        Iterator<Game> gameIterator = pulsar.iterator();
//        for (Game game : pulsar) {
//            System.out.println(game);
//        }
        while (gameIterator.hasNext()){
            System.out.println(gameIterator.next());
        }

    }
}
