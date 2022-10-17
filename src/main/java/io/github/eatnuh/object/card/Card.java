package io.github.eatnuh.object.card;

/**
 * A Card has a front face and a back face.
 * This face is mutable and can describe to String the current face.
 *
 * @param <F> front of card
 * @param <B> back of card
 * @author eatnuh
 */
public class Card<F extends CardFace, B extends CardFace> {

    private final F front;
    private final B back;
    private CardFace curFace;

    protected Card(F front, B back, CardFace curFace) {
        this.front = front;
        this.back = back;
        this.curFace = curFace;
    }

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
        this.curFace = front;
    }

    /**
     * turn to back
     */
    public void turnBack() {
        this.curFace = back;
    }

    /**
     * @return string of current face
     */
    public String getCurFace() {
        return this.curFace.getCardFace();
    }

    /**
     * @param front front of card
     * @param back  back of card
     * @param <F>   front type
     * @param <B>   back type
     * @return card of front state
     */
    public static <F extends CardFace, B extends CardFace> Card<F, B> createFrontCard(F front, B back) {
        return new Card<>(front, back, front);
    }

    /**
     * @param front front of card
     * @param back  back of card
     * @param <F>   front of card type
     * @param <B>   back of card type
     * @return card of back state
     */
    public static <F extends CardFace, B extends CardFace> Card<F, B> createBackCard(F front, B back) {
        return new Card<>(front, back, back);
    }
}
