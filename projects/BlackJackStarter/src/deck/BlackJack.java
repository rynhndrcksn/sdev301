package deck;

import cards.StandardCard;

import java.util.stream.Stream;

/**
 * BlackJack builds off StandardCard and allows our card game to now include blackjack.
 * @author Ryan Hendrickson
 * November 15th, 2020.
 * @version 1.0
 */

public class BlackJack {
	// fields
	private int playerTotal;
	private int dealerTotal;
	private final StandardDeck deck;

	/**
	 * default constructor: constructs a new StandardDeck, shuffles it, sets the total fields to 0, and prints a
	 * welcome message
	 */
	public BlackJack() {
	deck = new StandardDeck();
	deck.shuffle();
	playerTotal = 0;
	dealerTotal = 0;
	welcome();
	}

	/**
	 * method to get the player's total
	 * @return playerTotal (int)
	 */
	public int getPlayerTotal() {
		return playerTotal;
	}

	/**
	 * method to get the dealer's total
	 * @return dealerTotal (int)
	 */
	public int getDealerTotal() {
		return dealerTotal;
	}

	/**
	 * increments the playerTotal by the provided int
	 * @param playerTotal is an int to raise the total by
	 */
	public void setPlayerTotal(int playerTotal) {
		this.playerTotal += playerTotal;
	}

	/**
	 * increments the dealerTotal by the provided int
	 * @param dealerTotal is an int to raise the total by
	 */
	public void setDealerTotal(int dealerTotal) {
		this.dealerTotal += dealerTotal;
	}

	/**
	 * deals 2 cards by calling them and returning them as a stream. If deck has less than 2 cards in it (0-1) then we
	 * shuffle the deck.
	 * @return a stream containing 2 cards
	 */
	public Stream<StandardCard> dealTwoCards() {
		if (deck.cardCount() < 2) {
			System.out.println("Shuffling the deck because we don't have enough cards...");
			deck.shuffle();
			System.out.println("Shuffle is done, thanks for waiting :3");
		}
		return Stream.of(deck.dealTopCard(), deck.dealTopCard());
	}

	/**
	 * deals 1 card. If deck has less than 1 card in it (0) then we shuffle the deck.
	 * @return a StandardCard
	 */
	public StandardCard dealOneCard() {
	if (deck.cardCount() < 1) {
		System.out.println("We ran out of cards, please standby while we find more...");
		deck.shuffle();
		System.out.println("GOOD NEWS EVERYBODY, WE FOUND MORE CARDS!");
	}
	return deck.dealTopCard();
	}

	/**
	 * just prints a welcome message for the user.
	 */
	public void welcome() {
		System.out.println("Welcome to blackjack everyone.");
		System.out.println("*****************************");
	}

	/**
	 * toString for testing the game, left in for debugging purposes
	 * @return a String
	 */
	@Override
	public String toString() {
		return "BlackJack{" +
				"playerTotal=" + playerTotal +
				", dealerTotal=" + dealerTotal +
				'}';
	}
}
