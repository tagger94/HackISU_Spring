package blackJackTestGame;

import exampleClasses.StandardPlayingCard;

public class BlackJackDealerAI extends BlackJackPlayer implements BlackJackAI{
	
	

	public BlackJackDealerAI(String name) {
		super(name);
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
	public void setDealerTopCard(StandardPlayingCard c) {
		//Empty
	}

	@Override
	public int determineBet() {
		return 0;
	}
}
