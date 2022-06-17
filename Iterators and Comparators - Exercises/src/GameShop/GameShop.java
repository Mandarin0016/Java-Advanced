package GameShop;

import java.util.Iterator;
import java.util.List;

public class GameShop implements Iterable<Game> {
    private List<Game> games;
    //GameIterator gameIterator = new GameIterator();

    public GameShop(List<Game> games) {
        this.games = games;
    }


    @Override
    public Iterator<Game> iterator() {
        return new GameIterator();
    }

    private class GameIterator implements Iterator<Game> {
        int count;

        public GameIterator() {
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            return count >= 0 && count < games.size();
        }

        @Override
        public Game next() {
            return games.get(count++);
        }
    }
}
