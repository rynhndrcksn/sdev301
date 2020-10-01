package deck;

import cards.Card;

import java.util.ArrayList;

public class Deck {
    // fields
    private ArrayList<Card> dealerPile;
    private ArrayList<Card> discardPile;

    // constructor
    public Deck() {

    }
    public Deck(ArrayList<Card> dealerPile, ArrayList<Card> discardPile) {
        this.dealerPile = dealerPile;
        this.discardPile = discardPile;
    }

    //methods
    public void addCard(Card card) {

    }

    public void shuffle() {

    }

    public Card dealTopCard() {

        return ;
    }

    public int cardCount() {

        return ;
    }

    // toString()
    @Override
    public String toString() {
        return "Deck{" +
                "dealerPile=" + dealerPile +
                ", discardPile=" + discardPile +
                '}';
    }
}
