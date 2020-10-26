package magicsquares;

/**
 * MagicSquare creates a MagicSquare object to use with the MagicSquareGame
 * @author Ryan Hendrickson
 * Octobewr 25h, 2020.
 * @version 1.0
 */

public class MagicSquare {
	// field
	// choices is a short that stores the users choices in the first 9 bits
	private short choices;

	/**
	 * default constructor that makes choices 0000_0000_0000_0000
	 */
	public MagicSquare() {
		choices = 0;
	}

	/**
	 * takes the user's choice and modifies the bit needed for their choice
	 * @param selection is the users choice
	 * @return true if the choice was valid, false if it had already been selected
	 */
	public boolean choose(byte selection) {
		boolean isValid = false;
		try {
			if (!hasAlreadyChosen(selection)) {
				short mask = createMask(selection);
				choices = (short) (choices | mask);
				isValid = true;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Something went horribly wrong: " + e.getLocalizedMessage());
			isValid = false;
		}
		// I ONLY ADDED THIS TO PASS THE TEST, the program seemed to work fine without it? I think we just went
		// different routes on how to implement some of the error checking
		if (selection < 1 || selection > 9) {
			throw new IllegalArgumentException();
		}
		return isValid;
	}

	/**
	 * creates a mask then &'s it with choices
	 * @param selection is whichever bit the user is trying to activate
	 * @return true if (choices & mask) == true, otherwise return false
	 */
	public boolean hasAlreadyChosen(byte selection) {
		short mask = createMask(selection);
		return (choices & mask) == mask;
	}

	/**
	 * getter for the choices field
	 * @return the choices field
	 */
	public short getChoices() {
		return choices;
	}

	/**
	 * prints a string representation of the magic square.
	 * for example: if the user has 001011010 then print:
	 * 2 7 _
	 * _ 5 _
	 * 4 _ _
	 */
	public void printChoices() {
		// todo: make a data type to hold choices in order
		int[][] sq = {{2, 7, 6},
									{9, 5, 1},
									{4, 3, 8}};
		// todo: find way to print user's choices in that order ^ - nested for loops?
		// cycle through rows
		for (int i = 0; i < 3; i++) {
			// cycle through columns
			for (int j = 0; j < 3; j++) {
				if (hasAlreadyChosen((byte) sq[i][j])) {
					System.out.print(sq[i][j]);
				} else {
					System.out.print("_");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	/**
	 * helper method for creating mask's as needed
	 * @param index is the index to create the mask at
	 * @return a short to use as a mask
	 */
	private short createMask(int index) {
		short mask = 1;
		return (short) (mask << index-1);
	}
}
