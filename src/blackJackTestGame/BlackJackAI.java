package blackJackTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Card;

public interface BlackJackAI {
	
	public void setDealerTopCard(StandardPlayingCard c);

	public Boolean doHit();
	
	public Boolean doSplit();
	
	public int determineBet();
		
	
}
