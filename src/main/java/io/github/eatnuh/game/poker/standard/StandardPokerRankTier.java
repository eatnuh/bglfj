package io.github.eatnuh.game.poker.standard;

import io.github.eatnuh.object.card.playing.PlayingCard;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.github.eatnuh.object.card.playing.PlayingCard.Rank.*;

/**
 * This class takes place when both hands have the same hand ranking in the standard poker rules.
 * Win or lose is decided by rank with high value.
 *
 * @author eatnuh
 */
public class StandardPokerRankTier {

    /**
     * List in ascending order of rank value in standard rules
     */
    private static final List<PlayingCard.Rank> RANK_VALUE_ASC_LIST =
            Arrays.asList(TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE);

    /**
     * compare rank value
     *
     * @param playingCards1 playing cards of first
     * @param playingCards2 playing cards of second
     * @return
     * a negative integer : first has low rank value
     * zero : rank values are same
     * a positive integer : first has high rank value
     */
    public static int compareRank(Collection<PlayingCard> playingCards1, Collection<PlayingCard> playingCards2) {
        List<PlayingCard.Rank> sorted1 = sortByRankCntRankTier(playingCards1);
        List<PlayingCard.Rank> sorted2 = sortByRankCntRankTier(playingCards2);

        int size = sorted1.size();

        for (int i = 0; i < size; i++) {
            int rankValue1 = RANK_VALUE_ASC_LIST.indexOf(sorted1.get(i));
            int rankValue2 = RANK_VALUE_ASC_LIST.indexOf(sorted2.get(i));

            if (rankValue1 != rankValue2) return rankValue1 - rankValue2;
        }
        return 0;
    }

    /**
     * The ranks of the playing cards are sorted in ascending order of the same rank number and rank value.
     * As an exception, when the ranks of the playing cards are FIVE, FOUR, THREE, TWO, and ACE,
     * ACE has the weakest rank value.
     *
     * @param playingCards playing cards
     * @return sorted List
     */
    private static List<PlayingCard.Rank> sortByRankCntRankTier(Collection<PlayingCard> playingCards) {
        if (StandardPokerUtils.hasRank(playingCards, ACE, TWO, THREE, FOUR, FIVE))
            return Arrays.asList(FIVE, FOUR, THREE, TWO, ACE);

        Map<PlayingCard.Rank, Integer> rankCntMap = playingCards.stream()
                .collect(
                        Collectors.toMap(PlayingCard::getRank, playingCard -> 1, (cnt1, cnt2) -> cnt1 + cnt2)
                );

        return playingCards.stream()
                .map(PlayingCard::getRank)
                .sorted((e1, e2) -> rankCntMap.get(e1) != rankCntMap.get(e2) ? rankCntMap.get(e2) - rankCntMap.get(e1) :
                        RANK_VALUE_ASC_LIST.indexOf(e2) - RANK_VALUE_ASC_LIST.indexOf(e1)
                )
                .collect(Collectors.toList());
    }

}
