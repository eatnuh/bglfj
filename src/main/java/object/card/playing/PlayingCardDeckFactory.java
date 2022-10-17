package object.card.playing;

import object.card.Deck;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A PlayingCardFactory is responsible for the creation of PlayingCard Deck.
 *
 * @author eatnuh
 */
public class PlayingCardDeckFactory {

    // This is a Utility class
    private PlayingCardDeckFactory() {
        throw new AssertionError();
    }

    /**
     * @return A total of 53 Card Deck with 13 SPADE, 13 HEART, 13 DIAMOND and 13 CLOVER + 1 JOKER.
     */
    public static Deck<PlayingCard> getDeckWithJoker() {
        return new Deck<>(
                Arrays.stream(PlayingCard.Front.values())
                        .map(PlayingCard::createBackCard)
                        .collect(Collectors.toList())
        );
    }

    /**
     * @return A total of 52 Card Deck with 13 SPADE, 13 HEART, 13 DIAMOND, 13 CLOVER
     */
    public static Deck<PlayingCard> getDeckWithoutJoker() {
        return new Deck<>(
                Arrays.stream(PlayingCard.Front.values())
                        .filter(front -> !front.equals(PlayingCard.Front.JOKER))
                        .map(PlayingCard::createBackCard)
                        .collect(Collectors.toList())
        );
    }

}
