package cards;

/**
 * StandardCard Class that is a child of Card. creates a standard playing card with a suit and rank
 * @author Ryan Hendrickson
 * @version 1.0
 * @date October 2nd, 2020.
 */

public class StandardCard extends Card{
    // fields
    private final String rank;
    private final String suit;

    /**
     * parameterized constructor for StandardCard that takes its inputs and calls
     * super() to create a new card
     * @param rank a string telling us what rank the card is
     * @param suit a string telling us what suit the card is
     */
    public StandardCard(String rank, String suit) {
        super(rank + " of " + suit);
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * getter for the rank field
     * @return a string representing the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * getter for the suit field
     * @return a string representing the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * overrides the toString method
     * @return a string
     */
    @Override
    public String toString() {
        return getCardText();
    }
}
