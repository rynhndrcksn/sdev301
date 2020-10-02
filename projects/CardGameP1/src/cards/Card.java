package cards;

/**
 * Card class that StandardCard and SetCard pull from. Creates a "Card" object that has a description of
 * the card. Example: "3 of Spades", "Ace of Hearts", and "7 of Clubs"
 * @author Ryan Hendrickson
 * @version 1.0
 * @date October 2nd, 2020.
 */

public class Card {
    // fields
    private final String cardText;

    /**
     * constructor with 1 parameter (cardText) that take a String and assigns the String value to a new card
     * @param cardText is a user provided string that gets assigned to the cardText field
     */
    public Card(String cardText) {
        this.cardText = cardText;
    }

    /**
     * allows the user to retrieve the card text on any card
     * @return a string representing the cardText
     */
    public String getCardText() {
        return cardText;
    }

    /**
     * overrides the default toString and called the getCardText() method above
     * @return the string result from getCardText()
     */
    @Override
    public String toString() {
        return getCardText();
    }
}
