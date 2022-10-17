package io.github.eatnuh.game.poker.standard;

import io.github.eatnuh.object.card.playing.PlayingCard;

import java.util.Collection;
import java.util.function.Predicate;

import static io.github.eatnuh.game.poker.standard.StandardPokerUtils.*;
import static io.github.eatnuh.object.card.playing.PlayingCard.Rank.*;

/**
 * Hand ranking used in standard poker rules
 *
 * @author eatnuh
 */
public enum StandardPokerHandRanking {

    /**
     * A royal flush is a hand that contains ACE, KING, QUEEN, JACK, TEN rank, all the same suit
     */
    ROYAL_FLUSH(1, playingCards ->
            sameSuit(playingCards)
                    && hasRank(playingCards, ACE, KING, QUEEN, JACK, TEN)
    ),
    /**
     * A straight flush is a hand that contains five cards of sequential rank, all the same suit
     */
    STRAIGHT_FLUSH(2, playingCards ->
            sameSuit(playingCards) && isSequential(playingCards)
    ),
    /**
     * A four of a kind is a hand that contains four cards of one rank and one card of another rank
     */
    FOUR_OF_A_KIND(3, playingCards ->
            hasRankCnt(playingCards, 4)
    ),
    /**
     * A full house is a hand that contains three cards of one rank and two cards of another rank
     */
    FULL_HOUSE(4, playingCards ->
            hasRankCnt(playingCards, 3, 2)
    ),
    /**
     * A flush is a hand that contains five cards all the same suit
     */
    FLUSH(5, playingCards ->
            sameSuit(playingCards)
    ),
    /**
     * A straight is a hand that contains five cards of sequential rank
     */
    STRAIGHT(6, playingCards ->
            isSequential(playingCards)
    ),
    /**
     * A three of a kind is a hand that contains three cards of one rank and two cards of two other ranks
     */
    THREE_OF_A_KIND(7, playingCards ->
            hasRankCnt(playingCards, 3)
    ),
    /**
     * A two pair is a hand that contains two cards of one rank, two cards of another rank and one card of a third rank
     */
    TWO_PAIR(8, playingCards ->
            hasRankCnt(playingCards, 2, 2)
    ),
    /**
     * A one pair is a hand that contains two cards of one rank and three cards of three other ranks
     */
    ONE_PAIR(9, playingCards ->
            hasRankCnt(playingCards, 2)
    ),
    /**
     * A high card is a hand that does not fall into any other category
     */
    HIGH_CARD(10, playingCards -> true);

    /**
     * tier of hand ranking
     * The lower the tier, the higher the value.
     */
    private final int tier;
    private final Predicate<Collection<PlayingCard>> handPredicate;

    StandardPokerHandRanking(int tier, Predicate<Collection<PlayingCard>> handPredicate) {
        this.tier = tier;
        this.handPredicate = handPredicate;
    }

    /**
     * Tests if cards to match hand ranking.
     *
     * @param playingCards playing cards
     * @return true if and only if cards to match hand ranking; false otherwise;
     */
    public boolean match(Collection<PlayingCard> playingCards) {
        return handPredicate.test(playingCards);
    }

    /**
     * @param playingCards playing cards
     * @return Matching hand ranking with cards
     */
    public static StandardPokerHandRanking getHandRanking(Collection<PlayingCard> playingCards) {
        return (ROYAL_FLUSH.match(playingCards)) ? ROYAL_FLUSH :
                (STRAIGHT_FLUSH.match(playingCards)) ? STRAIGHT_FLUSH :
                        (FOUR_OF_A_KIND.match(playingCards)) ? FOUR_OF_A_KIND :
                                (FULL_HOUSE.match(playingCards)) ? FULL_HOUSE :
                                        (FLUSH.match(playingCards)) ? FLUSH :
                                                (STRAIGHT.match(playingCards)) ? STRAIGHT :
                                                        (THREE_OF_A_KIND.match(playingCards)) ? THREE_OF_A_KIND :
                                                                (TWO_PAIR.match(playingCards)) ? TWO_PAIR :
                                                                        (ONE_PAIR.match(playingCards)) ? ONE_PAIR :
                                                                                HIGH_CARD;
    }

    /**
     * compare hand ranking
     *
     * @param h1 hand ranking of first
     * @param h2 hand ranking of second
     * @return
     * a negative integer : first has low value hand ranking
     * zero : hand rankings are same
     * a positive integer : first has high value hand ranking
     */
    public static int compareHandRanking(StandardPokerHandRanking h1, StandardPokerHandRanking h2) {
        return h2.tier - h1.tier;
    }
}
