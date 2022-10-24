package component.card.flower;

import component.card.Deck;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A FlowerCardDeckFactory is responsible for the creation of Flower card Deck.
 */
public class FlowerCardDeckFactory {

    // This is a Utility class
    private FlowerCardDeckFactory() {
        throw new AssertionError();
    }

    /**
     * @return A total of 48 Card Deck
     */
    public static Deck<FlowerCard> getDeck() {
        return new Deck<>(
                Arrays.stream(FlowerCard.Front.values())
                        .map(FlowerCard::createBackCard)
                        .collect(Collectors.toList())
        );
    }
}
