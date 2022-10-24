package player;

/**
 * A Player can send/receive message
 */
public interface Player {

    /**
     * output to player
     * @param message
     */
    void listen(Object message);

    /**
     * input from player
     * @return
     */
    String responseAsString();
}