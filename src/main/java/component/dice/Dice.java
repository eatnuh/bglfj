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
    private final String name;

    public Dice() {
        this(6);
    }

    public Dice(int maximum) {
        this.maximum = maximum;
        this.name = maximum + "d Dice";
    }

    /**
     * @return random integer from one to {@code d}
     */
    public int roll() {
        return random.nextInt(maximum) + 1;
    }

    @Override
    public String getName() {
        return name;
    }
}

