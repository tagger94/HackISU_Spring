package gstat.premade.blackjack;

import gstat.premade.playingcard.StandardPlayingCard;

/**
 * Decision Maker for Dealer. Dealer is extended from a player class.
 * 
 * @author Alex Berns
 * 
 */
public class BlackJackDealerAI extends BlackJackPlayer {

	private int numOfBlackJack = 0;

	public BlackJackDealerAI(String name) {
		super(name, 0);
	}

	/**
	 * Decides if the dealer should hit based on current hand value. Uses Vegas
	 * style, hit when less than 17.
	 * 
	 * @return If Dealer should hit
	 */
	@Override
	public Boolean doHit() {

		if (hand.findHandValue() == 21 && hand.hand.size() == 2) {
			numOfBlackJack++;
		}

		if (hand.findHandValue() < 17)
			return true;

		return false;
	}

	/**
	 * Decides if the dealer should split based on current hand values. Uses
	 * Vegas style rules, dealer never splits.
	 * 
	 * @return False since Dealer does not split
	 */
	@Override
	public Boolean doSplit() {
		return false;
	}

	/**
	 * Decides what value to bet with. Uses Vegas style rules, dealer does not
	 * bet.
	 * 
	 * @return 0 since Dealer does not bet
	 */
	@Override
	public int determineBet() {
		return 0;
	}

	/**
	 * Empty method created from parent abstract class
	 */
	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		
	}
}
