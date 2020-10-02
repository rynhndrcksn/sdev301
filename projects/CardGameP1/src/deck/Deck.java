package deck;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck class that creates a Deck object which is filled can be filled
 * with Card objects.
 * @author Ryan Hendrickson
 * @version 1.0
 * @date October 2nd, 2020.
 */

public class Deck {
    // fields
    private final ArrayList<Card> dealerPile;
    private final ArrayList<Card> discardPile;

    /**
     * parameterized constructor for Deck
     * @param dealerPile ArrayList for Card objects in the dealer's hand
     * @param discardPile ArrayList for Card objects for the discard pile
     */
    public Deck(ArrayList<Card> dealerPile, ArrayList<Card> discardPile) {
        this.dealerPile = dealerPile;
        this.discardPile = discardPile;
    }

    /**
     * adds a Card to the dealerPile
     * @param card is a Card object that is added to the dealerPile ArrayList
     */
    public void addCard(Card card) {
        dealerPile.add(card);
    }

    /**
     * takes any Cards in discardPile and adds them back to the dealerPile
     * empties the discardPile
     * shuffles the dealerPile in a random order using Random
     */
    public void shuffle() {
        for (int i = 0; i < discardPile.size(); i++) {
            addCard(discardPile.get(i));
        }
        discardPile.clear();

        Random rand = new Random();
        for (int i = 0; i < cardCount(); i++) {
            int index1 = rand.nextInt(cardCount()); // the use of cardCount() allows us to make sure our
            int index2 = rand.nextInt(cardCount()); // rand.nextInt doesn't go out of bounds
            Collections.swap(dealerPile, index1, index2);
        }
    }

    /**
     * draws the "top" Card from the deck, adds it to our discardPile, and removes it from
     * our dealerPile
     * @return a Card object called 'top'
     */
    public Card dealTopCard() {
        Card top = dealerPile.get(0);
        dealerPile.remove(0);
        discardPile.add(top);
        return top;
    }

    /**
     * counts the amount of Card objects in the dealerPile
     * @return the number of Card objects in the dealerPile
     */
    public int cardCount() {
        return dealerPile.size();
    }

    /**
     * overrides the toString method using a StringBuilder as it seemed to be more memory efficient
     * using a StringBuilder also gave us access to StringBuilder methods (which I prefer)
     * @return text, a StringBuilder object that everything is added to before being returned
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(cardCount() + " cards in deck\n");
        System.out.println("****************");

        for (int i = 0; i < dealerPile.size(); i++) {
            text.append(dealerPile.get(i).getCardText());
            text.append("\n");
        }

        text.append("\n");
        text.append(discardPile.size());
        text.append(" cards in the discard pile\n");
        text.append("****************\n");

        for (int i = 0; i < discardPile.size(); i++) {
            text.append(dealerPile.get(i).getCardText());
            text.append("\n");
        }

        return text.toString();
    }
}
