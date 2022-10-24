package game.poker;

import component.card.Deck;
import component.card.playing.PlayingCard;
import component.card.playing.PlayingCardDeckFactory;
import game.poker.standard.StandardPokerComparator;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Supplier;

/**
 * A poker rule has instances of various poker rules.
 * <p>
 * Each rule has a strategy for determining victory and defeat
 * and a strategy for creating a deck to be used in the game.
 *
 * @author eatnuh
 */
public enum PokerRule {

    /**
     * STANDARD RULE
     * strategy for determining victory and defeat
     * Victory or defeat is judged by the standard genealogy of the British and American countries.
     * <p>
     * strategy for creating a deck
     * Uses 52 decks of playing cards without jokers.
     */
    STANDARD(
            new StandardPokerComparator(),
            PlayingCardDeckFactory::getDeckWithoutJoker
    );

    /**
     * strategy for determining victory and defeat
     */
    private final Comparator<Collection<PlayingCard>> winLossStrategy;
    /**
     * strategy for creating a deck
     */
    private final Supplier<Deck<PlayingCard>> deckCreationStrategy;

    PokerRule(Comparator<Collection<PlayingCard>> pokerCardComparator, Supplier<Deck<PlayingCard>> pokerDeckSupplier) {
        this.winLossStrategy = pokerCardComparator;
        this.deckCreationStrategy = pokerDeckSupplier;
    }

    /**
     * determining victory and defeat with cards
     *
     * @param cards1 - first
     * @param cards2 - second
     * @param cards2 - second
     * @return a negative integer : first lost
     * zero : drawn
     * a positive integer : first won
     */
    public int determineWinLoss(Collection<PlayingCard> cards1, Collection<PlayingCard> cards2) {
        return winLossStrategy.compare(cards1, cards2);
    }

    /**
     * Create a deck to be used in poker
     *
     * @return a deck to be used in poker
     */
    public Deck<PlayingCard> createDeck() {
        return deckCreationStrategy.get();
    }
}
