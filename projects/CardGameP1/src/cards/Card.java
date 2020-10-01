package cards;

public class Card {
    // fields
    private String cardText;

    // constructors
    public Card() {
        this.cardText = "";
    }
    public Card(String cardText) {
        this.cardText = cardText;
    }

    // getter
    public String getCardText() {
        return cardText;
    }

    // toString()
    @Override
    public String toString() {
        return "Card{" +
                "cardText='" + cardText + '\'' +
                '}';
    }
}
