package gstat.premade.blackjack;

import gstat.premade.exampleclasses.ExamplePlayer;
import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Hand;

/**
 * Abstract Class used to allow blackjack player objects to be placed in
 * containers
 * 
 * 
 * @author Alex Berns
 * 
 */
public abstract class BlackJackPlayer extends ExamplePlayer {

	public BlackJackHand hand;

	/**
	 * Initializer for Blackjack Player
	 * 
	 * @param name
	 *            The name of the player
	 * @param chips
	 *            The number of chips/money the player starts with
	 */
	public BlackJackPlayer(String name, int chips) {
		super(name, chips);
		hand = new BlackJackHand();

	}

	/**
	 * Sets the dealers face up card for the player. Used in determining hit and split.
	 * 
	 * @param c Dealers Face-Up Card
	 */
	public abstract void setDealerTopCard(StandardPlayingCard c);

	/**
	 * Returns if player can split
	 * 
	 * @return True is Split, False is Not Split
	 */
	public abstract Boolean doSplit();

	/**
	 * Returns if player should hit.
	 * 
	 * @return True is hit, False is Stay
	 */
	public abstract Boolean doHit();

	/**
	 * REturns the value of the bet the player gives.
	 * 
	 * @return Amount to bet
	 */
	public abstract int determineBet();

	/**
	 * returns the hand of the player
	 * 
	 * @return The hand of the player
	 */
	public Hand<StandardPlayingCard> getHand() {
		return hand;
	}

}
