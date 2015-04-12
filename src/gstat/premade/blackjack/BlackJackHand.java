package gstat.premade.blackjack;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Hand;

/**
 * The custom hand class for Blackjack. Adds methods to make checking hand values easier
 * @author Alex Berns
 *
 */
public class BlackJackHand extends Hand<StandardPlayingCard> {

	public Boolean checkForAce() {
		for(int i = 0; i < hand.size(); i++){
			if (hand.get(i).getRank() == 1){
				return true;
			}
		}

		return false;
	}

	/**
	 * returns the value of the hand. Handles Aces by adding 10 until you go over.
	 * @return
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
	 * Determines with the first 2 cards can be split (same rank)
	 * @return
	 */
	public Boolean canSplit() {

		if (hand.size() > 2)
			return false;

		if (hand.get(0).getRank() == hand.get(1).getRank())
			return true;

		return false;
	}
}
