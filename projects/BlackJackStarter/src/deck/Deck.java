package deck;

import cards.Card;

import java.util.*;

/**
 * @author susanuland
 * @version 1.0
 */
public class Deck {
    // fields
    private ArrayList<Card> dealerPile;
    private ArrayList<Card> discardPile;

    /**
     * constructs a Deck object
     */
    public Deck() {
        dealerPile = new ArrayList<>();
        discardPile = new ArrayList<>();
    }

    /**
     * Adds a card to the dealer pile
     *
     * @param card added to deck
     */
    public void addCard(Card card) {
        dealerPile.add(card);
    }

    /**
     * This method takes all cards in the discard pile and places them back into the dealer pile, then
     * shuffles the cards
     */
    public void shuffle() {
        combineDecks();
        Collections.shuffle(dealerPile);
    }

    private void combineDecks() {
        dealerPile.addAll(discardPile);
        discardPile.clear();
    }

    /**
     * This method checks if the deck has a card to deal and if so returns the top card in deck
     * otherwise it returns null
     *
     * @return removed card from dealer deck or null if deck is empty
     */
    public Card dealTopCard() {
        Card removed = null;

        if (cardCount() > 0) {
            removed = dealerPile.remove(0);
            discardPile.add(removed);
        }

        return removed;
    }

    /**
     *
     * @return the number of cards in the dealer pile
     */
    public int cardCount() {
        return dealerPile.size();
    }

    /**
     * This method returns a string representation of the dealer and discard piles
     * @return a String representation of the dealer cards and the discard cards
     */
    @Override
    public String toString() {

        StringBuilder toReturn = new StringBuilder();

        // gather dealer cards
        makeDescription(toReturn, "deck", dealerPile);
        addAllCards(toReturn, dealerPile);

        // gather discard cards;
        makeDescription(toReturn, "discard", discardPile);
        addAllCards(toReturn, discardPile);

        return toReturn.toString();

    }

    private void addAllCards(StringBuilder toReturn, ArrayList<Card> deck) {
        for (Card c : deck) {
            toReturn.append(c.getCardText());
            toReturn.append(System.lineSeparator());
        }
        toReturn.append(System.lineSeparator());
    }

    private void makeDescription(StringBuilder toReturn, String type, ArrayList<Card> deck) {
        toReturn.append(deck.size() + " cards in " + type + " " + System.lineSeparator());
        toReturn.append("*".repeat(17));
        toReturn.append(System.lineSeparator());
    }


}

