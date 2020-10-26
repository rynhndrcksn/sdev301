package magicsquares;

/**
 * Player class which extends MagicSquare and is mostly added so we can add names to the players
 * @author Ryan Hendrickson
 * October 25th, 2020.
 * @version 1.0
 */
public class Player extends MagicSquare {
	// fields
	private String name; // players name
	private int num; // assign the player a number

	/**
	 * default constructor
	 */
	public Player() {
		name = "No name entered";
		num = 0;
	}

	/**
	 * constructor that takes the users name
	 * @param name is the users name
	 */
	public Player(String name, int num) {
		this.name = name;
		this.num = num;
	}

	/**
	 * get the Player's name
	 * @return Player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * assign Player's name
	 * @param name is the Player's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the Player's number
	 * @return Player's number
	 */
	public int getNum() {
		return num;
	}

	/**
	 * assign Player's number
	 * @param num is the Player's number
	 */
	public void setNum(int num) {
		this.num = num;
	}
}
