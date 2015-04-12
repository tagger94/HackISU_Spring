package blackJackTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Hand;

public class BlackJackDealerAI extends BlackJackPlayer {
	
	

	public BlackJackDealerAI(String name) {
		super(name, 0);
	}
	
	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		//Empty
	}

	@Override
	public Boolean doHit() {
		
		if(hand.findHandValue() < 17)
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
