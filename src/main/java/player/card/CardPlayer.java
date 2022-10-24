package player.card;

import component.card.Card;
import player.Player;

/**
 * The card player can deal with cards.
 * @param <C> card
 */
public interface CardPlayer<C extends Card> extends Player {

    /**
     * player pick card without removing
     * @return card
     */
    C pickCard();

    /**
     * player remove card
     * @return card
     */
    C drawCard();

    /**
     * player receive card
     * @param card card
     */
    void receiveCard(C card);
}
