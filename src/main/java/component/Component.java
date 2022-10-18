package component;

/**
 * A Component used in the board game implement this interface.
 */
public interface Component {

    /**
     * @return component's name
     */
    default String getName() {
        return this.getClass().getName();
    }
}
