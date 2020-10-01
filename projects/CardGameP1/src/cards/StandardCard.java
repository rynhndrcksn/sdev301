package cards;

public class StandardCard extends Card{
    // fields
    private String rank;
    private String suit;

    // constructor
    public StandardCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // getters
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    // toString()
    @Override
    public String toString() {
        return "StandardCard{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
