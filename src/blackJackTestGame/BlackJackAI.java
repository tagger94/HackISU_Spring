package blackJackTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Card;
import gameSim.Hand;

public interface BlackJackAI {
		
	public void setDealerTopCard(StandardPlayingCard c);

	public Boolean doHit();
	
	public Boolean doSplit();
	
	public int determineBet();
	
	public Hand<StandardPlayingCard> getHand();
		
	
}
