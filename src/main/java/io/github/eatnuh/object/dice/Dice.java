package io.github.eatnuh.object.dice;

import java.util.Random;


/**
 * A Dice is used for generating random integer
 * @author eatnuh
 */
public class Dice {

    private final Random random = new Random();

    /**
     * Maximum of random integer
     */
    private final int maximum;

    public Dice() {
        this(6);
    }
    public Dice(int d) {
        this.maximum = d;
    }

    /**
     * @return random integer from one to {@code d}
     */
    public int roll() {
        return random.nextInt(maximum) + 1;
    }
}

