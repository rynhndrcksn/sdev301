package cards;

/**
 * @author susanuland
 * @version 1.0
 *
 * This class represents a common superclass playing Card
 */
public class Card {
    private String cardText;

    /**
     * constructs a Card object with given description
     * @param cardText description of card like "Ace of Spades", if null set to unknown
     */
    public Card(String cardText) {
        this.cardText = cardText;
    }

    /**
     * Returns the playing card's description
     * @return playing card description
     */
    public String getCardText() {
        return cardText;
    }

    @Override
    /**
     * Returns a String representation of the Card object
     */
    public String toString() {

        return getCardText();
    }
}

