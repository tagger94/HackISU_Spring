package blackJackTestGame;

import exampleClasses.ExamplePlayer;
import exampleClasses.StandardPlayingCard;
import gameSim.*;

/**
 * This is an abstract class for a Blackjack game. The abstract class allows for
 * looping of dealer and players
 * 
 * @author Alex Berns
 * 
 */
public abstract class BlackJackPlayer extends ExamplePlayer {

	/**
	 * The hand for the player
	 */
	public BlackJackHand hand;

	/**
	 * Initilizer for Blackjack Player
	 * @param name The name of the player
	 * @param chips The number of chips/money the player starts with
	 */
	public BlackJackPlayer(String name, int chips) {
		super(name, chips);
		hand = new BlackJackHand();

	}

	/**
	 * Sets the deals face up card for the player
	 * @param c
	 */
	public abstract void setDealerTopCard(StandardPlayingCard c);

	/**
	 * NOT USED: determines when player should split the same cards
	 * @return
	 */
	public abstract Boolean doSplit();

	/**
	 * Decides whether to have the player hit or stay
	 * @return True is hit, False is Stay
	 */
	public abstract Boolean doHit();

	/**
	 * Decides what bet should be
	 * @return amount to bet;
	 */
	public abstract int determineBet();

	/**
	 * returns the hand of the player
	 * @return
	 */
	public Hand<StandardPlayingCard> getHand() {
		return hand;
	}

}
