package blackJackTestGame;

import exampleClasses.StandardPlayingCard;

public class BlackJackPlayerAI extends BlackJackPlayer implements BlackJackAI {

	/*
	 * Possible Actions
	 * 
	 * Hit Stand Split***Double***Surrender
	 */
	
	private StandardPlayingCard dealerCard;

	public BlackJackPlayerAI(String name, int chips) {
		super(name);
	}
	
	@Override
	public int determineBet() {
		
		return 0;
	}

	@Override
	public Boolean doHit() {
		
		int val = hand.findHandValue();
		int dRank = Math.max(dealerCard.getRank(),10);
		
		//Deals with greater than you 17
		if(val >= 17) {
			return false;
		}
		
		//Deals with Dealer Ace
		if(dRank == 1) {
			return true;
		}
		
		if(val >= 13 && dRank <= 6) {
			return false;
		}
		
		if(val == 12 && dRank >= 4 && dRank <= 6) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean doSplit() {
		if(!hand.canSplit())
			return false;
		
		int val = hand.findHandValue();
		//Do not Split on Double 4,5,6,10
		if(val == 4 || val == 5 || val == 6 || val == 10)
			return false;
		
		
		return true;
	}

	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		dealerCard = c;
	}

}
