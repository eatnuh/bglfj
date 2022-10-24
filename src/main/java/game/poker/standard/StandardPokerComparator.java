package game.poker.standard;

import component.card.playing.PlayingCard;

import java.util.Collection;
import java.util.Comparator;

import static game.poker.standard.StandardPokerHandRanking.compareHandRanking;
import static game.poker.standard.StandardPokerRankTier.compareRank;

public class StandardPokerComparator implements Comparator<Collection<PlayingCard>> {
    /**
     * @param cards1 the first cards to be compared.
     * @param cards2 the second cards to be compared.
     * @return a negative integer : first lost
     * zero : drawn
     * a positive integer : first won
     */
    @Override
    public int compare(Collection<PlayingCard> cards1, Collection<PlayingCard> cards2) {
        StandardPokerHandRanking handRanking1 = StandardPokerHandRanking.getHandRanking(cards1);
        StandardPokerHandRanking handRanking2 = StandardPokerHandRanking.getHandRanking(cards2);

        return (handRanking1.equals(handRanking2)) ? compareRank(cards1, cards2) : compareHandRanking(handRanking1, handRanking2);
    }
}
