package gstat.premade.blackjack;

import gstat.premade.playingcard.StandardPlayingCard;

public class BlackJackDealerAI extends BlackJackPlayer {

	private int numOfBlackJack = 0;

	public BlackJackDealerAI(String name) {
		super(name, 0);
	}

	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		// Empty
	}

	@Override
	public Boolean doHit() {

		if (hand.findHandValue() == 21 && hand.hand.size() == 2){
			numOfBlackJack++;
		}

		if (hand.findHandValue() < 17)
			return true;

		return false;
	}

	@Override
	public Boolean doSplit() {
		return false;
	}

	@Override
	public int determineBet() {
		return 0;
	}
}
