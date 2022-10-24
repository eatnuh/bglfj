package component.dice;

import component.Component;

import java.util.Random;


/**
 * A Dice is used for generating random integer
 *
 * @author eatnuh
 */
public class Dice implements Component {

    private final Random random = new Random();

    /**
     * Maximum of random integer
     */
    private final int maximum;

    /**
     * default constructor make 6d Dice
     */
    public Dice() {
        this(6);
    }

    public Dice(int maximum) {
        this.maximum = maximum;
    }

    /**
     * @return random integer from one to {@code d}
     */
    public int roll() {
        return random.nextInt(maximum) + 1;
    }

    /**
     * @return dice's identifier
     */
    @Override
    public String getId() {
        return maximum + "d Dice";
    }

    /**
     * @param id identifier
     * @return dice's identifier equals to {@param id}
     */
    @Override
    public boolean is(String id) {
        return id.equals(id);
    }
}

