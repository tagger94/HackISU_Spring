package blackJackTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Hand;

public class BlackJackHand extends Hand<StandardPlayingCard> {

	public Boolean checkForAce() {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getRank() == 1) {
				return true;
			}
		}

		return false;
	}

	public int findHandValue() {
		int val = 0;

		for (StandardPlayingCard c : hand) {
			val += Math.min(c.getRank(), 10);
		}

		if (checkForAce() && val <= 11) {
			val += 10;
		}

		return val;
	}

	public Boolean canSplit() {

		if (hand.size() > 2)
			return false;

		if (hand.get(0).getRank() == hand.get(1).getRank())
			return true;

		return false;
	}
}
