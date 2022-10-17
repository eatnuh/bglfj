package object.card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Hand is the cards of the player who holds them.
 * It can pick one of the cards and can draw one.
 *
 * @author eatnuh
 */
public class Hand<C extends Card> {

    // cards store in list
    protected List<C> cards = new ArrayList<>();

    public Hand() {
    }

    public Hand(Collection<C> cards) {
        add(cards);
    }

    public void add(C card) {
        cards.add(card);
    }

    public void add(Collection<C> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Select card in Hand without removing.
     *
     * @return card
     * @throws AssertionError when can't find it
     */
    public C pick(C select) {
        return cards.stream()
                .filter(c -> c.equals(select))
                .findAny()
                .orElseThrow(() -> new AssertionError());
    }

    public C pick(int index) {
        return this.cards.get(index);
    }

    /**
     * Remove card in Hand
     *
     * @return card
     */
    public C draw(C select) {
        C pick = pick(select);
        remove(pick);
        return pick;
    }

    public C draw(int index) {
        return cards.remove(index);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    protected void remove(C select) {
        cards.remove(select);
    }

}
