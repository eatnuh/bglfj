package component.card;

import component.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * A Deck is a one of the collection using card.
 * it can shuffle cards and draw the top card.
 *
 * @author eatnuh
 */
public class Deck<C extends Card> {

    // cards store in stack
    protected Stack<C> cards = new Stack<>();

    public Deck() {
    }

    public Deck(C... cards) {
        add(cards);
    }

    public Deck(Collection<C> cards) {
        add(cards);
    }

    public void add(C card) {
        this.cards.push(card);
    }

    /**
     * add cards
     * @param cards cards
     */
    public void add(C... cards) {
        this.cards.addAll(
                Arrays.stream(cards)
                        .collect(Collectors.toList())
        );
    }

    /**
     * add cards
     * @param cards Collection of card
     */
    public void add(Collection<C> cards) {
        this.cards.addAll(cards);
    }

    /**
     * @return deck is empty
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * @return size of deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * shuffle the deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return card at the top of the deck
     */
    public C draw() {
        return this.cards.pop();
    }

}
