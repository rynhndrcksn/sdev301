package cards;

/**
 *
 * @author susanuland
 * @version 1.0
 *
 * This class represents a playing card that has a rank (Ace, 2, 3, ... 10, Jack, Queen, King) and
 * a suit (Hearts, Diamonds, Clubs, Spades)
 */
public class StandardCard extends Card {

    private String rank;
    private String suit;


    /**
     * constructs a StandardCard object representing a playing card in a standard 52 card deck.
     * @param rank - playing card's rank ex. Ace
     * @param suit - playing cards' suit ex. Hearts
     */
    public StandardCard(String rank, String suit) {
        super(rank +" of "+ suit);
        this.rank = rank;
        this.suit = suit;

    }
    /**
     * Returns playing card rank ex. Ace
     * @return playing card's rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns playing card suit ex. Hearts
     * @return playing card's suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * used for the blackjack game, returns the appropriate values for blackjack
     * @return rankValue which is 11 for an ace, 10 for face cards, and the regular int if it's a standard card
     */
    public int getRankValue() {
        int rankValue;
        if (rank.equalsIgnoreCase("Ace")) {
            rankValue = 11;
        } else if (rank.equalsIgnoreCase("Jack") || rank.equalsIgnoreCase("Queen")
            || rank.equalsIgnoreCase("King")) {
            rankValue = 10;
        } else {
            rankValue = Integer.parseInt(rank);
        }

        return rankValue;
    }
    /**
     *
     * @return string representation of the standard card object
     */
    @Override
    public String toString() {
        return super.toString();
    }
}

