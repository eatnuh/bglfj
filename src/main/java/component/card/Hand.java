package component.card;

import component.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

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

    public void add(C card) {
        cards.add(card);
    }

    /**
     * Select card in Hand without removing.
     *
     * @param select selected card
     * @return card
     * @throws AssertionError when can't find it
     */
    public C pick(C select) {
        return cards.stream()
                .filter(c -> c.equals(select))
                .findAny()
                .orElseThrow(() -> new AssertionError());
    }

    public C pick(String id) {
        return cards.stream().filter(c -> c.is(id)).findFirst().orElseThrow(() -> new AssertionError());
    }

    /**
     * Remove card in Hand
     *
     * @param select selected card
     * @return card
     */
    public C draw(C select) {
        C pick = pick(select);
        remove(pick);
        return pick;
    }

    public C draw(String id) {
        C pick = pick(id);
        remove(pick);
        return pick;
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
