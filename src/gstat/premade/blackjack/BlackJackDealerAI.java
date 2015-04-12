package gstat.premade.blackjack;

import gstat.premade.playingcard.StandardPlayingCard;

/**
 * Extends the Blackjack Player class. Addes AI to choice of the dealer
 * @author Alex Berns
 *
 */
public class BlackJackDealerAI extends BlackJackPlayer {

	private int numOfBlackJack = 0;

	public BlackJackDealerAI(String name) {
		super(name, 0);
	}

	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		// Empty
	}

	/**
	 * Using Casino Rules: Dealer must hit until over 17
	 */
	@Override
	public Boolean doHit() {

		if (hand.findHandValue() == 21 && hand.hand.size() == 2){
			numOfBlackJack++;
		}

		if (hand.findHandValue() < 17)
			return true;

		return false;
	}

	/**
	 * NOT USED: Casino Rules does not allow deal to split
	 */
	@Override
	public Boolean doSplit() {
		return false;
	}

	/**
	 * NOT USED: Dealer does not bet
	 */
	@Override
	public int determineBet() {
		return 0;
	}
}
