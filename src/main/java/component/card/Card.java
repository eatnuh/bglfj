package component.card;

import component.Component;

/**
 * A Card has a front face and a back face.
 * This face is mutable and can describe to String the current face.
 *
 * @param <F> front of card
 * @param <B> back of card
 * @author eatnuh
 */
public class Card<F extends Component, B extends Component> implements Component {

    private final F front;
    private final B back;
    private Component cur;

    /**
     * @param front front of card
     * @param back  back of card
     * @param cur   current state of card
     */
    protected Card(F front, B back, Component cur) {
        this.front = front;
        this.back = back;
        this.cur = cur;
    }

    /**
     * @param front front of card
     * @param back  back of card
     */
    public Card(F front, B back) {
        this(front, back, back);
    }

    /**
     * @return get front of card
     */
    public F getFront() {
        return front;
    }

    /**
     * @return get back of card
     */
    public B getBack() {
        return back;
    }

    /**
     * turn to front
     */
    public void turnFront() {
        this.cur = front;
    }

    /**
     * turn to back
     */
    public void turnBack() {
        this.cur = back;
    }

    /**
     * @param front front of card
     * @param back  back of card
     * @param <F>   front of card type
     * @param <B>   back of card type
     * @return card of front state
     */
    public static <F extends Component, B extends Component> Card<F, B> createFrontCard(F front, B back) {
        return new Card<>(front, back, front);
    }

    /**
     * @param front front of card
     * @param back  back of card
     * @param <F>   front of card type
     * @param <B>   back of card type
     * @return card of back state
     */
    public static <F extends Component, B extends Component> Card<F, B> createBackCard(F front, B back) {
        return new Card<>(front, back, back);
    }

    /**
     * @return card identifier
     */
    @Override
    public String getId() {
        return cur.getId();
    }
}
