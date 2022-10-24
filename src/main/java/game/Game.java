package game;

import player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Game has players and can notify message to players
 * @param <P> Player
 */
public abstract class Game<P extends Player> implements Runnable {

    protected List<P> players;

    public Game(Collection<P> players) {
        this.players = new ArrayList<>(players);
    }

    /**
     * notify message to all player
     * @param message message
     */
    protected void notifyAllPlayer(Object message) {
        players.stream().forEach(player -> player.listen(message));
    }

    /**
     * notify message to player
     * @param massage message
     * @param player player
     */
    protected void notifyPlayer(Object massage, P player) {
        player.listen(massage);
    }

}
