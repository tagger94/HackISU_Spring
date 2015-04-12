package gstat.premade.exampleclasses;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Hand;
import gstat.util.Inventory;
import gstat.util.Player;

/**
 * 
 * This class is meant to be a good example of how implement a player class
 * using one inventory.
 * 
 * @author Camden Voigt
 * 
 */

public class ExamplePlayer implements Player {

	// The players hand
	public Hand<StandardPlayingCard> hand;

	// The players name
	private String name;

	// Number of tokens the player currently holds
	private int numTokens;

	// Total amount of tokens the player has ever received
	private int totalTokens;

	// Total amount of tokens the player has ever lost
	private int totalLostTokens;

	/**
	 * Default constructor that gets just the name of the player
	 * 
	 * @param name
	 *            -Name of the player
	 */
	public ExamplePlayer(String name) {
		this.name = name;
		hand = new Hand<StandardPlayingCard>();
		numTokens = 0;
		totalTokens = 0;
		totalLostTokens = 0;
	}

	/**
	 * Constructor used to give the player a name and starting amount of tokens
	 * 
	 * @param name
	 *            -Name of the player
	 * @param numTokens
	 *            -Starting number of tokens
	 */
	public ExamplePlayer(String name, int numTokens) {
		this.name = name;
		hand = new Hand<StandardPlayingCard>();
		this.numTokens = numTokens;
		totalTokens = numTokens;
		totalLostTokens = 0;
	}

	/**
	 * Adds a specific number of tokens to the players total and subtracts that
	 * amount from the inventory from which they are taken.
	 * 
	 * @param i
	 *            - inventory to be taken from
	 * @param num
	 *            - number of tokens to be added to player total
	 */

	@Override
	public int addTokens(Inventory i, int num) {
		numTokens += num;
		totalTokens += num;
		return i.take(num);
	}

	/**
	 * Adds a specific number of tokens to the players total and subtracts that
	 * amount from the inventory from which they are taken. Also, prints a
	 * string representation to the console.
	 * 
	 * @param i
	 *            - inventory to be taken from
	 * @param num
	 *            - number of tokens to be added to player total
	 */

	@Override
	public int addTokens_Report(Inventory i, int num) {
		int temp = addTokens(i, num);
		System.out.println(temp + " tokens were given to " + name + "\n");
		System.out.println(temp + " tokens were take from inventory " + i + "\n");
		return temp;
	}

	/**
	 * SubStracts a specific number of tokens to the players total and adds that
	 * amount form the inventory from which they from.
	 * 
	 * @param i
	 *            - inventory to be added to
	 * @param num
	 *            - number of tokens to be taken from the player total
	 */

	@Override
	public int subTokens(Inventory i, int num) {
		numTokens -= num;
		totalLostTokens += num;
		return i.give(num);
	}

	/**
	 * SubStracts a specific number of tokens to the players total and adds that
	 * amount form the inventory from which they from. Also, prints a string
	 * representation to the console.
	 * 
	 * @param i
	 *            - inventory to be added to
	 * @param num
	 *            - number of tokens to be taken from the player total
	 */

	@Override
	public int subTokens_Report(Inventory i, int num) {
		int temp = subTokens(i, num);
		System.out.println(temp + " tokens were taken from " + name + ".\n");
		System.out.println(temp + " tokens were given to inventory " + i + ".\n");
		return temp;
	}

	/**
	 * returns the number of tokens the player is holding currently
	 * 
	 * @return Number of tokens player currently holds
	 */
	public int getNumTokens() {
		return numTokens;
	}

	/**
	 * Returns and prints a String representation of the number of tokens the
	 * player is holding currently. Generates report
	 * 
	 * @return Number of tokens player currently holds
	 */
	public String numTokens_Report() {
		System.out.println(name + " has " + numTokens);
		return name + " has " + numTokens;
	}

	/**
	 * Returns the total number of tokens ever received by the player
	 * 
	 * @return The total number of tokens ever held by the player
	 */
	public int getTotalTokens() {
		return totalTokens;
	}

	/**
	 * Returns and prints a string representation of the total number of tokens
	 * ever received by the player
	 * 
	 * @return The String representation of the total number of tokens every
	 *         held by the player
	 */
	public String totalTokens_Report() {
		System.out.println(name + " has recieved" + totalTokens + "total.\n");
		return name + " has recieved" + totalTokens + "total.";
	}

	/**
	 * Returns the total number of tokens ever lost by the player
	 * 
	 * @return The total number of tokens lost by the player
	 */
	public int getTotalLostTokens() {
		return totalLostTokens;
	}

	/**
	 * Returns and prints a string representation of the total number of tokens
	 * ever lost by the player
	 * 
	 * @return The string representation of the number of tokens lost by the
	 *         player
	 */
	public String totalLostTokens_Report() {
		System.out.println(name + " has lost " + totalLostTokens + "total.\n");
		return name + " has lost " + totalLostTokens + "total.\n";
	}

	@Override
	/**
	 * Returns the number of players
	 */
	public String toString() {
		return name;
	}
}
