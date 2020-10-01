package deck;

import cards.Card;
import cards.StandardCard;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StandardDeck extends Deck {
    public StandardDeck(ArrayList<Card> dealerPile, ArrayList<Card> discardPile) {
        super(dealerPile, discardPile);
        while(dealerPile.size() < 52) {
            dealerPile.add(genCards());
        }
    }

    public StandardCard dealTopCard() {
        return ;
    }

    public Card genCards() {
        return ;
    }
}
