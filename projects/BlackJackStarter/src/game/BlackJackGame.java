package game;

import cards.StandardCard;
import deck.BlackJack;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * BlackJackGame allows the user to play as many games of blackjack as they want to.
 * @author Ryan Hendrickson
 * November 15th, 2020.
 * @version 1.0
 */

public class BlackJackGame {
	public static void main(String[] args) {
		boolean play = true;
		while (play) {
			BlackJack gameDeck = new BlackJack();
			boolean playerActive = playerTurn(gameDeck);
			if (playerActive) {
				dealerTurn(gameDeck);
			}
			if (gameDeck.getPlayerTotal() == 21 && gameDeck.getDealerTotal() == 21) {
				System.out.println("\nThe game is a draw!\n");
			} else if (gameDeck.getDealerTotal() == 21) {
				System.out.println("\nDealer won!\n");
			}
			Scanner kb = new Scanner(System.in);
			System.out.print("\nDo you want to play again? (true/false) ");
			play = kb.nextBoolean();
			System.out.println();
		}
	}

	/**
	 * playerTurn was a way to get some code out of the main method. It will deal 2 cards automatically for the player,
	 * then ask if they want to hit. If they do, we keep giving them cards until they stop hitting or bust
	 * @param gameDeck passes the gameDeck object from main method in so we can manipulate it directly instead of
	 *                  having to create extra things to return more stuff
	 * @return true is the player hasn't bust, false if the player bust
	 */
	public static boolean playerTurn(BlackJack gameDeck) {
		// grab the first 2 cards, display what was dealt, and add them to the playerTotal
		Stream<StandardCard> cards = gameDeck.dealTwoCards();
		cards.forEach(standardCard -> {
							System.out.println("You were dealt a " + standardCard.getCardText());
							gameDeck.setPlayerTotal(standardCard.getRankValue());
						});

		// setup for letting the player hit
		boolean playing = true;
		boolean hitting = true;
		Scanner kb = new Scanner(System.in);
		while (hitting) {
			System.out.print("Your total is " + gameDeck.getPlayerTotal() + ", hit? ");
			if (kb.nextBoolean()) {
				System.out.println();
				StandardCard card = gameDeck.dealOneCard();
				gameDeck.setPlayerTotal(card.getRankValue());
				System.out.println("You were dealt a " + card.getCardText());
			} else {
				hitting = false;
			}
			// when player is done hitting, check their score, if over 21 then they lose
			if (gameDeck.getPlayerTotal() > 21) {
				hitting = false;
				playing = false;
				System.out.println("Your total is " + gameDeck.getPlayerTotal());
				System.out.println("You went bust, you lose!");
			}
		}
		return playing;
	}

	/**
	 * deals the dealer 1 card until they get to 21 or bust
	 * @param gameDeck is the gameDeck object from main method so we can manipulate it directly
	 */
	public static void dealerTurn(BlackJack gameDeck) {
		while (gameDeck.getDealerTotal() < 21) {
			StandardCard card = gameDeck.dealOneCard();
			System.out.println("\nDealer is dealt a " + card.getCardText());
			gameDeck.setDealerTotal(card.getRankValue());
			System.out.println("Dealer total is: " + gameDeck.getDealerTotal());
			if (gameDeck.getDealerTotal() > 21) {
				System.out.println("Dealer went bust, you win!");
			}
		}
	}
}
