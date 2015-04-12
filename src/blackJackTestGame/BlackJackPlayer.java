package blackJackTestGame;

import exampleClasses.ExamplePlayer;
import exampleClasses.StandardPlayingCard;
import gameSim.*;

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
