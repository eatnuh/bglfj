package component;

/**
 * A Component used in the board game implement this interface.
 * It has identifier
 */
public interface Component {

    /**
     * @return component's identifier
     */
    default String getId() {
        return this.getClass().getName();
    }

    /**
     * @param id identifier
     * @return parameter equals component's identifier
     */
    default boolean is(String id) {
        return getId().equals(id);
    }
}
