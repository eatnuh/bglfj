package player;

/**
 * A Player can send/receive message
 */
public interface Player {

    /**
     * output to player
     * @param message A message to send to the player
     */
    void listen(Object message);

    /**
     * input from player
     * @return player's input
     */
    String responseAsString();
}