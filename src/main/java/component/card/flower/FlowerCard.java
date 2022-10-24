package component.card.flower;

import component.Component;
import component.card.Card;

/**
 * A FlowerCard inherit Card.
 * The front of a FlowerCard consists of Month and rank
 * The back of a FlowerCard HIDDEN
 */
public class FlowerCard extends Card<FlowerCard.Front, FlowerCard.Back> {

    protected FlowerCard(Front front, Back back, Component cur) {
        super(front, back, cur);
    }

    public enum Front implements Component {

        JANUARY_BRIGHT(Month.JANUARY, Rank.BRIGHT),
        JANUARY_RED_RIBBON(Month.JANUARY, Rank.RED_RIBBON),
        JANUARY_JUNK1(Month.JANUARY, Rank.JUNK),
        JANUARY_JUNK2(Month.JANUARY, Rank.JUNK),

        FEBRUARY_ANIMAL(Month.FEBRUARY, Rank.ANIMAL),
        FEBRUARY_RED_RIBBON(Month.FEBRUARY, Rank.RED_RIBBON),
        FEBRUARY_JUNK1(Month.FEBRUARY, Rank.JUNK),
        FEBRUARY_JUNK2(Month.FEBRUARY, Rank.JUNK),

        MARCH_BRIGHT(Month.MARCH, Rank.BRIGHT),
        MARCH_RED_RIBBON(Month.MARCH, Rank.RED_RIBBON),
        MARCH_JUNK1(Month.MARCH, Rank.JUNK),
        MARCH_JUNK2(Month.MARCH, Rank.JUNK),

        APRIL_ANIMAL(Month.APRIL, Rank.ANIMAL),
        APRIL_PLAIN_RIBBON(Month.APRIL, Rank.PLAIN_RIBBON),
        APRIL_JUNK1(Month.APRIL, Rank.JUNK),
        APRIL_JUNK2(Month.APRIL, Rank.JUNK),

        MAY_ANIMAL(Month.MAY, Rank.ANIMAL),
        MAY_PLAIN_RIBBON(Month.MAY, Rank.PLAIN_RIBBON),
        MAY_JUNK1(Month.MAY, Rank.JUNK),
        MAY_JUNK2(Month.MAY, Rank.JUNK),

        JUNE_ANIMAL(Month.JUNE, Rank.ANIMAL),
        JUNE_BLUE_RIBBON(Month.JUNE, Rank.BLUE_RIBBON),
        JUNE_JUNK1(Month.JUNE, Rank.JUNK),
        JUNE_JUNK2(Month.JUNE, Rank.JUNK),

        JULY_ANIMAL(Month.JULY, Rank.ANIMAL),
        JULY_PLAIN_RIBBON(Month.JULY, Rank.PLAIN_RIBBON),
        JULY_JUNK1(Month.JULY, Rank.JUNK),
        JULY_JUNK2(Month.JULY, Rank.JUNK),

        AUGUST_BRIGHT(Month.AUGUST, Rank.BRIGHT),
        AUGUST_ANIMAL(Month.AUGUST, Rank.ANIMAL),
        AUGUST_JUNK1(Month.AUGUST, Rank.JUNK),
        AUGUST_JUNK2(Month.AUGUST, Rank.JUNK),

        SEPTEMBER_ANIMAL(Month.SEPTEMBER, Rank.ANIMAL),
        SEPTEMBER_BLUE_RIBBON(Month.SEPTEMBER, Rank.BLUE_RIBBON),
        SEPTEMBER_JUNK1(Month.SEPTEMBER, Rank.JUNK),
        SEPTEMBER_JUNK2(Month.SEPTEMBER, Rank.JUNK),

        OCTOBER_ANIMAL(Month.OCTOBER, Rank.ANIMAL),
        OCTOBER_BLUE_RIBBON(Month.OCTOBER, Rank.BLUE_RIBBON),
        OCTOBER_JUNK1(Month.OCTOBER, Rank.JUNK),
        OCTOBER_JUNK2(Month.OCTOBER, Rank.JUNK),

        NOVEMBER_BRIGHT(Month.NOVEMBER, Rank.BRIGHT),
        NOVEMBER_DOUBLE_JUNK(Month.NOVEMBER, Rank.DOUBLE_JUNK),
        NOVEMBER_JUNK1(Month.NOVEMBER, Rank.JUNK),
        NOVEMBER_JUNK2(Month.NOVEMBER, Rank.JUNK),

        DECEMBER_BRIGHT(Month.DECEMBER, Rank.BRIGHT),
        DECEMBER_ANIMAL(Month.DECEMBER, Rank.ANIMAL),
        DECEMBER_PLAIN_RIBBON(Month.DECEMBER, Rank.PLAIN_RIBBON),
        DECEMBER_DOUBLE_JUNK(Month.DECEMBER, Rank.DOUBLE_JUNK);

        private final Month month;
        private final Rank rank;

        private Month getMonth() {
            return this.month;
        }

        private Rank getRank() {
            return this.rank;
        }

        Front(Month month, Rank rank) {
            this.month = month;
            this.rank = rank;
        }

        @Override
        public String getId() {
            return this.name();
        }
    }

    public enum Back implements Component {
        HIDDEN;

        @Override
        public String getId() {
            return this.name();
        }
    }

    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public enum Rank {
        BRIGHT, ANIMAL, RED_RIBBON, BLUE_RIBBON, PLAIN_RIBBON, DOUBLE_JUNK, JUNK
    }

    public Month getMonth() {
        return getFront().getMonth();
    }

    public Rank getRank() {
        return getFront().getRank();
    }

    public boolean is(Front front) {
        return getFront().equals(front);
    }

    public boolean is(Month month) {
        return getFront().month.equals(month);
    }

    public boolean is(Rank rank) {
        return getFront().rank.equals(rank);
    }

    public boolean isSameMonth(FlowerCard other) {
        return this.is(other.getMonth());
    }

    public boolean isSameRank(FlowerCard other) {
        return this.is(other.getRank());
    }

    public static FlowerCard createBackCard(Front front) {
        return new FlowerCard(front, Back.HIDDEN, Back.HIDDEN);
    }

    public static FlowerCard createFrontCard(Front front) {
        return new FlowerCard(front, Back.HIDDEN, front);
    }

    @Override
    public boolean is(String id) {
        return getFront().is(id);
    }
}