package player.dice;

import component.dice.Dice;
import player.Player;

/**
 * A Dice player can deal with dice
 */
public interface DicePlayer extends Player {


    /**
     * player receive Dice
     * @param dice dice
     */
    void receiveDice(Dice dice);

    /**
     * player remove Dice
     * @return dice
     */
    Dice removeDice();

    /**
     * player roll dice
     * @return dice number
     */
    int roll();

}
