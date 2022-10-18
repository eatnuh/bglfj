package game.poker.standard;

import component.card.playing.PlayingCard;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static component.card.playing.PlayingCard.Rank.*;

/**
 * This class provides utility methods used in standard rule poker games.
 * These methods assume that the number of PlayingCards is 5
 *
 * @author eatnuh
 */
public class StandardPokerUtils {

    // This is a Utility class
    private StandardPokerUtils() {
        throw new AssertionError();
    }

    /**
     * Tests if the suits of PlayingCards are same.
     *
     * @param playingCards playing cards
     * @return true if and only if All of PlayingCards have the same suit; false otherwise;
     * @throws AssertionError when playingCards is Empty
     */
    public static boolean sameSuit(Collection<PlayingCard> playingCards) {
        PlayingCard firstCard = playingCards.stream().findFirst().orElseThrow(() -> new AssertionError());
        return playingCards.stream().allMatch(trumpCard -> trumpCard.isSameSuit(firstCard));
    }

    /**
     * Tests if the ranks of PlayingCards are all in the param.
     *
     * @param playingCards playing cards
     * @param rank         rank
     * @return true if and only if the ranks in Param are all in PlayingCards; false otherwise;
     */
    public static boolean hasRank(Collection<PlayingCard> playingCards,
                                  PlayingCard.Rank... rank) {
        List<PlayingCard.Rank> ranks = playingCards.stream()
                .map(PlayingCard::getRank)
                .collect(Collectors.toList());

        return Arrays.stream(rank)
                .allMatch(r -> ranks.remove(r));
    }

    /**
     * Tests if the ranks of PlayingCards are sequential.
     *
     * @param playingCards playing cards
     * @return true if and only if the ranks of PlayingCards are sequential; false otherwise;
     */
    public static boolean isSequential(Collection<PlayingCard> playingCards) {
        return hasRank(playingCards, ACE, TWO, THREE, FOUR, FIVE) ||
                hasRank(playingCards, TWO, THREE, FOUR, FIVE, SIX) ||
                hasRank(playingCards, THREE, FOUR, FIVE, SIX, SEVEN) ||
                hasRank(playingCards, FOUR, FIVE, SIX, SEVEN, EIGHT) ||
                hasRank(playingCards, FIVE, SIX, SEVEN, EIGHT, NINE) ||
                hasRank(playingCards, SIX, SEVEN, EIGHT, NINE, TEN) ||
                hasRank(playingCards, SEVEN, EIGHT, NINE, TEN, JACK) ||
                hasRank(playingCards, EIGHT, NINE, TEN, JACK, QUEEN) ||
                hasRank(playingCards, NINE, TEN, JACK, QUEEN, KING) ||
                hasRank(playingCards, TEN, JACK, QUEEN, KING, ACE);
    }

    /**
     * Tests if PlayingCards have the same rank as the sameRankCnt in the param
     * For example, if sameRankCnt is 4, it means that there are 4 playing cards with the same rank.
     *
     * @param playingCards playing cards
     * @param sameRankCnt  number of same rank
     * @return true if and only if PlayingCards have the same rank as the number in the param; false otherwise;
     */
    public static boolean hasRankCnt(Collection<PlayingCard> playingCards, int... sameRankCnt) {
        Collection<Integer> rankCounts = playingCards.stream().collect(
                Collectors.toMap(PlayingCard::getRank, trumpCard -> 1, (cnt1, cnt2) -> cnt1 + cnt2)
        ).values();

        return Arrays.stream(sameRankCnt)
                .allMatch(c -> rankCounts.remove(c));
    }
}
