package deck;

import cards.*;

/**
 *  This class respresents a 52 card deck with 4 suits (spades, clubs, hearts, and diamonds)
 *  and 13 ranks (2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace)
 *  @author susanuland
 *  @version 1.0
 */
public class StandardDeck extends Deck {

    public static final int MAX_NUM = 10; // max numerical rank for card
    public static final int MIN_NUM = 2; // min numerical rank for card
    public static final String[] SUITS = {"spades", "clubs", "hearts", "diamonds"};
    public static final String[] FACES = {"Jack", "Queen", "King", "Ace"};

    /**
     * Constructs a 52 card deck of standard cards
     */
    public StandardDeck() {
        //super(); java supplies this automatically no need to call
        for (String s : SUITS) {
            addSuit(s);
        }
    }

    /**
     * This method deals a card from the top of the dealer pile
     * @return the top card in the dealer pile
     */
    @Override
    public StandardCard dealTopCard() {
        return (StandardCard) super.dealTopCard();
    }

    private void addSuit(String suit) {

        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            // "" + i is the fastest way to convert int to string
            this.addCard(new StandardCard("" + i, suit));
        }

        for (String f : FACES) {
            this.addCard(new StandardCard(f, suit));
        }

    }
}

