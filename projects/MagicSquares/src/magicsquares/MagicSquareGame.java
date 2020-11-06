package magicsquares;

import java.util.Scanner;

/**
 * MagicSquares is a game that allows 2 users to compete where they're trying to get their choices to equal 15
 * @author Ryan Hendrickson
 * October 25th, 2020.
 * @version 1.0
 */

public class MagicSquareGame {

	/**
	 * This main method setups the game play and contains the game loop where each player continues to take turns until
	 * a player wins or the game is a DRAW
	 * @param args not used
	 */
	public static void main(String[] args) {
		printDirections();
		Player p1 = new Player();
		Player p2 = new Player();
		MagicSquare both = new MagicSquare();
		setPlayersUp(p1, p2);

		int player = 1;
		boolean playing = true;
		do {
			int whom = player % 2;
			int state;
			if (whom == 0) {
				state = takePlayerTurn(p2, both);
			} else {
				state = takePlayerTurn(p1, both);
			}

			if (state == 1) {
				if (whom == 0) {
					System.out.println(p2.getName() + " has won!");
				} else {
					System.out.println(p1.getName() + " has won!");
				}
				playing = false;
			} else if (state == 2) {
				System.out.println("The game is a draw!");
				playing = false;
			} else {
				player++;
			}
		} while (playing);
	}


	/**
	 * This takePlayerTurn method will prompt for and display the player's choice of numbers and then determine if the
	 * game has been won,
	 * is a draw, or the game should continue
	 *
	 * @param p - the Player
	 * @param both - player1 and player 2 choices
	 * @return a number indicating the game state(CONTINUE, DRAW, WIN)
	 */
	public static int takePlayerTurn(Player p, MagicSquare both) {
		int num = getSelection(p, both);
		p.choose((byte) num);
		both.choose((byte) num);
		p.printChoices();
		if (isWin(p)) {
			return 1;
		} else if (isDraw(both)) {
			return 2;
		} else { // keep playing
			return 0;
		}
	}

	/**
	 * This isDraw method will determine if the game is a draw due to all choices made and no one player had a winning
	 * combination
	 * @param both - player 1 and player 2 choices
	 * @return true if all values have been picked, game is a DRAW, false otherwise
	 */
	public static boolean isDraw(MagicSquare both) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (both.hasAlreadyChosen((byte) i)) {
				count++;
			}
		}
		return count == 10;
	}

	/**
	 * This isWin method determines if a player's magic square choices result in a winning combination
	 * @param p the player
	 * @return true, if the player has won, false otherwise
	 */
	public static boolean isWin(Player p) {
		short[] winCases =
				{0b0_0110_0010,
				0b1_0001_0001,
				0b0_1000_1100,
				0b1_0000_1010,
				0b0_0101_0100,
				0b0_1010_0001,
				0b0_1001_0010,
				0b0_0011_1000};
		boolean result = false;
		System.out.println(p.getChoices());
		for (short winCase : winCases) {
			// you need to & them together otherwise it will fail if they have extra nums - THANKS SUSAN
			if ((p.getChoices() & winCase) == winCase) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * This getSelection method asks the player for their number selection from 1 - 9.  If the user does not enter a
	 * number in this
	 * range, they are continually prompted until they do enter a number between 1 and 9.  If the user has already entered
	 * a number that has been chosen, they are continually prompted until they enter a number that has not been
	 * previously selected.
	 * @param p - Player
	 * @param both - MagicSquare that keeps track of every choice
	 * @return the number chosen from 1-9
	 *
	 */
	public static int getSelection(Player p, MagicSquare both) {
		int num = 0;
		boolean validNum = false;
		while (!validNum) {
			Scanner kb = new Scanner(System.in);
			System.out.print(p.getName() + ", please enter a number: ");
			num = kb.nextInt();
			if (num < 1 || num > 9) {
				System.out.println(num + " is not between 1 and 9");
			} else if (both.hasAlreadyChosen((byte) num)) {
				System.out.println("A player has already chosen " + num);
			} else {
				validNum = true;
			}
		}
		return num;
	}

	/**
	 * sets the Player objects up with their names and numbers
	 * @param p1 is Player 1
	 * @param p2 is Player 2
	 */
	public static void setPlayersUp(Player p1, Player p2) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Player #1 please enter your name:");
		p1.setName(kb.nextLine());
		p1.setNum(1);
		System.out.println("Player #2 please enter your name:");
		p2.setName(kb.nextLine());
		p2.setNum(2);
	}

	/**
	 * This printDirections method prints out the game introduction
	 */
	public static void printDirections() {
		System.out.println("Welcome to the game of Magic Squares!");
		System.out.println("*************************************");
		System.out.println("Rules:");
		System.out.println("Each player takes turns picking a number from 1-9.");
		System.out.println("No number can be chosen twice.");
		System.out.println("The first player to have 3 numbers that sum to 15 wins!");
		System.out.println("2 7 6\n9 5 1\n4 3 8");
		System.out.println("*************************************");
	}


}

