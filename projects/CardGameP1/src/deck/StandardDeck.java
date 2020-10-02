package deck;

import cards.Card;
import cards.StandardCard;

import java.util.ArrayList;

/**
 * StandardDeck Class that is a child of Deck. Constructs a standard 52 card deck for us to manipulate
 * @author Ryan Hendrickson
 * @version 1.0
 * @date October 2nd, 2020.
 */

public class StandardDeck extends Deck {

    /**
     * non-parameterized constructor for StandardDeck. We create a new StandardDeck Class then call
     * super() to create new ArrayList's for our dealer/discard piles. Then we create a String[] so
     * we can add the suits to it, another String[] for the ranks, then we pass everything into addCard()
     */
    public StandardDeck() {
        super(new ArrayList<>(), new ArrayList<>());
        String[] SUITS = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        for (int i = 0; i < SUITS.length; i++) {
            String[] RANKS = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
            for (int j = 0; j < RANKS.length; j++) {
                addCard(new Card(RANKS[j] + " of " + SUITS[i]));
            }
        }
    }

    /**
     * overrides Deck dealTopCard() but uses it in the process by calling super.dealTopCard()
     * SUSAN: Your instructions told us to cast the Card as a StandardCard but we can't do that? So I
     * ended up making a String[] to split our results from topCard so I could then turn it into a
     * new StandardCard which Java allows.
     * @return a StandardCard that has the results from splitting the Card object returned by dealTopCard()
     */
    public StandardCard dealTopCard() {
        Card topCard = super.dealTopCard();

        String[] split = topCard.getCardText().split("\\s+");

        return new StandardCard(split[0], split[2]);
    }
}
