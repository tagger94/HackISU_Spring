package gstat.premade.blackjack;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Hand;

/**
 * Creates methods helpful for Blackjack. Extends Hand class and adds the Blackjack methods to that.
 * @author Alex Berns
 *
 */
public class BlackJackHand extends Hand<StandardPlayingCard> {

	/**
	 * Checks is Hand contains an ace.
	 * @return If hand contains an ace
	 */
	public Boolean checkForAce() {
		for(int i = 0; i < hand.size(); i++){
			if (hand.get(i).getRank() == 1){
				return true;
			}
		}

		return false;
	}

	/**
	 * Calculates the value of the Hand. Soft hands (Aces = 11) are automatically dealt with.
	 * @return Value of Hand
	 */
	public int findHandValue() {
		int val = 0;

		for(StandardPlayingCard c : hand){
			val += Math.min(c.getRank(), 10);
		}

		if (checkForAce() && val <= 11){
			val += 10;
		}

		return val;
	}

	/**
	 * Determines if the Hand can be split. Checks for two cards of same suit.
	 * @return If Hand can be split
	 */
	public Boolean canSplit() {

		if (hand.size() > 2)
			return false;

		if (hand.get(0).getRank() == hand.get(1).getRank())
			return true;

		return false;
	}
}
