package component.card.playing;

import component.Component;
import component.card.Card;

/**
 * A playingCard inherit Card.
 * The front of a PlayingCard consists of suits(SPADE, HEART, DIAMOND, CLOVER)
 * and rank(ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING)
 * The back of a PlayingCard HIDDEN
 */
public final class PlayingCard extends Card<PlayingCard.Front, PlayingCard.Back> {

    private PlayingCard(Front front, Back back, Component init) {
        super(front, back, init);
    }

    public enum Front implements Component {

        SPADE_A(Suit.SPADE, Rank.ACE),
        SPADE_2(Suit.SPADE, Rank.TWO),
        SPADE_3(Suit.SPADE, Rank.THREE),
        SPADE_4(Suit.SPADE, Rank.FOUR),
        SPADE_5(Suit.SPADE, Rank.FIVE),
        SPADE_6(Suit.SPADE, Rank.SIX),
        SPADE_7(Suit.SPADE, Rank.SEVEN),
        SPADE_8(Suit.SPADE, Rank.EIGHT),
        SPADE_9(Suit.SPADE, Rank.NINE),
        SPADE_10(Suit.SPADE, Rank.TEN),
        SPADE_J(Suit.SPADE, Rank.JACK),
        SPADE_Q(Suit.SPADE, Rank.QUEEN),
        SPADE_K(Suit.SPADE, Rank.KING),

        HEART_A(Suit.HEART, Rank.ACE),
        HEART_2(Suit.HEART, Rank.TWO),
        HEART_3(Suit.HEART, Rank.THREE),
        HEART_4(Suit.HEART, Rank.FOUR),
        HEART_5(Suit.HEART, Rank.FIVE),
        HEART_6(Suit.HEART, Rank.SIX),
        HEART_7(Suit.HEART, Rank.SEVEN),
        HEART_8(Suit.HEART, Rank.EIGHT),
        HEART_9(Suit.HEART, Rank.NINE),
        HEART_10(Suit.HEART, Rank.TEN),
        HEART_J(Suit.HEART, Rank.JACK),
        HEART_Q(Suit.HEART, Rank.QUEEN),
        HEART_K(Suit.HEART, Rank.KING),

        DIAMOND_A(Suit.DIAMOND, Rank.ACE),
        DIAMOND_2(Suit.DIAMOND, Rank.TWO),
        DIAMOND_3(Suit.DIAMOND, Rank.THREE),
        DIAMOND_4(Suit.DIAMOND, Rank.FOUR),
        DIAMOND_5(Suit.DIAMOND, Rank.FIVE),
        DIAMOND_6(Suit.DIAMOND, Rank.SIX),
        DIAMOND_7(Suit.DIAMOND, Rank.SEVEN),
        DIAMOND_8(Suit.DIAMOND, Rank.EIGHT),
        DIAMOND_9(Suit.DIAMOND, Rank.NINE),
        DIAMOND_10(Suit.DIAMOND, Rank.TEN),
        DIAMOND_J(Suit.DIAMOND, Rank.JACK),
        DIAMOND_Q(Suit.DIAMOND, Rank.QUEEN),
        DIAMOND_K(Suit.DIAMOND, Rank.KING),

        CLOVER_A(Suit.CLOVER, Rank.ACE),
        CLOVER_2(Suit.CLOVER, Rank.TWO),
        CLOVER_3(Suit.CLOVER, Rank.THREE),
        CLOVER_4(Suit.CLOVER, Rank.FOUR),
        CLOVER_5(Suit.CLOVER, Rank.FIVE),
        CLOVER_6(Suit.CLOVER, Rank.SIX),
        CLOVER_7(Suit.CLOVER, Rank.SEVEN),
        CLOVER_8(Suit.CLOVER, Rank.EIGHT),
        CLOVER_9(Suit.CLOVER, Rank.NINE),
        CLOVER_10(Suit.CLOVER, Rank.TEN),
        CLOVER_J(Suit.CLOVER, Rank.JACK),
        CLOVER_Q(Suit.CLOVER, Rank.QUEEN),
        CLOVER_K(Suit.CLOVER, Rank.KING),

        JOKER(Suit.JOKER, Rank.JOKER);

        Front(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        private final Suit suit;
        private final Rank rank;

        private Suit getSuit() {
            return suit;
        }

        private Rank getRank() {
            return rank;
        }

        @Override
        public String getName() {
            return this.name();
        }

    }

    public enum Back implements Component {
        HIDDEN;

        @Override
        public String getName() {
            return this.name();
        }
    }

    public enum Suit {
        SPADE, CLOVER, HEART, DIAMOND, JOKER
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER
    }

    public boolean is(Front front) {
        return getFront().equals(front);
    }

    public boolean is(Suit suit) {
        return getFront().suit.equals(suit);
    }

    public boolean is(Rank rank) {
        return getFront().suit.equals(rank);
    }

    public boolean isSameSuit(PlayingCard other) {
        return this.is(other.getSuit());
    }

    public boolean isSameRank(PlayingCard other) {
        return this.is(other.getRank());
    }

    public Suit getSuit() {
        return getFront().getSuit();
    }

    public Rank getRank() {
        return getFront().getRank();
    }

    public static PlayingCard createBackCard(Front front) {
        return new PlayingCard(front, Back.HIDDEN, Back.HIDDEN);
    }

    public static PlayingCard createFrontCard(Front front) {
        return new PlayingCard(front, Back.HIDDEN, front);
    }
}
