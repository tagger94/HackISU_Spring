package gstat.premade.uno;

import gstat.util.Hand;

/**
 * This class is a player for UNO. It is a super class for any AI classes or UI
 * classes. It holds the name of the player and the hand of the player. It could
 * be modified to handle more, such as drawing and playing cards.
 * 
 * @author Camden Voigt
 *
 */

public class UnoPlayer {

	public Hand<UnoCard> playerHand;
	private String name;

	/**
	 * Creates a default UnoPlayer with the name Alice.
	 */
	public UnoPlayer() {
		name = "Alice";
		playerHand = new Hand<UnoCard>();
	}

	/**
	 * Creates an UNOPlayer with the given name.
	 * 
	 * @param name
	 *            The name of the UNOPlayer
	 */
	public UnoPlayer(String name) {
		this.name = name;
		playerHand = new Hand<UnoCard>();
	}

	/**
	 * Returns the name of the UNOPlayer.
	 * 
	 * @return name of the UNOPlayer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Finds the number of red cards in the players hand.
	 * 
	 * @return number of red cards
	 */
	public int findNumRed() {
		int numRed = 0;
		UnoCard red = new UnoCard(Color.RED, 1);
		for(int i = 0; i < playerHand.hand.size(); i++){
			if (playerHand.hand.get(i).equalColor(red)){
				numRed++;
			}
		}
		return numRed;
	}

	/**
	 * Finds the number of blue cards in the players hand.
	 * 
	 * @return number of blue cards
	 */
	public int findNumBlue() {
		int numBlue = 0;
		UnoCard blue = new UnoCard(Color.BLUE, 1);
		for(int i = 0; i < playerHand.hand.size(); i++){
			if (playerHand.hand.get(i).equalColor(blue)){
				numBlue++;
			}
		}
		return numBlue;
	}

	/**
	 * Finds the number of green cards in the players hand.
	 * 
	 * @return number of green cards
	 */
	public int findNumGreen() {
		int numGreen = 0;
		UnoCard green = new UnoCard(Color.GREEN, 1);
		for(int i = 0; i < playerHand.hand.size(); i++){
			if (playerHand.hand.get(i).equalColor(green)){
				numGreen++;
			}
		}
		return numGreen;
	}

	/**
	 * Finds the number of yellow cards in the players hand.
	 * 
	 * @return number of yellow cards
	 */
	public int findNumYellow() {
		int numYellow = 0;
		UnoCard yellow = new UnoCard(Color.YELLOW, 1);
		for(int i = 0; i < playerHand.hand.size(); i++){
			if (playerHand.hand.get(i).equalColor(yellow)){
				numYellow++;
			}
		}
		return numYellow;
	}
}
