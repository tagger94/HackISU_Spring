package blackJackTestGame;

import gameSim.Hand;

public class BlackJackHand extends Hand{

	public Boolean checkForAce() {
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getRank == 1) {
				return true;
			}
		}
		
		return false;
	}
}
