package gstat.premade.blackjack;

import gstat.premade.exampleclasses.ExamplePlayer;
import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Hand;

public abstract class BlackJackPlayer extends ExamplePlayer {

	public BlackJackHand hand;

	public BlackJackPlayer(String name, int chips) {
		super(name, chips);
		hand = new BlackJackHand();

	}

	public abstract void setDealerTopCard(StandardPlayingCard c);

	public abstract Boolean doSplit();

	public abstract Boolean doHit();

	public abstract int determineBet();

	public Hand<StandardPlayingCard> getHand() {
		return hand;
	}

}
