package blackJackTestGame;

import exampleClasses.StandardPlayingCard;
import gameSim.Reporter;

public class BlackJackPlayerAI extends BlackJackPlayer {

	/*
	 * Possible Actions
	 * 
	 * Hit Stand Split***Double***Surrender
	 */

	private int riskLevel;
	private StandardPlayingCard dealerCard;
	private int bet;

	public BlackJackPlayerAI(String name, int chips, int riskLevel) {
		super(name, chips);
		this.riskLevel = riskLevel;
		bet = 0;
	}
	
	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		dealerCard = c;
	}

	@Override
	public Boolean doHit() {

		int val = hand.findHandValue();
		int dRank = Math.max(dealerCard.getRank(), 10);

		// Deals with greater than you 17
		if (val >= 17) {
			return false;
		}

		// Deals with Dealer Ace
		if (dRank == 1) {
			return true;
		}

		if (val >= 13 && dRank <= 6) {
			return false;
		}

		if (val == 12 && dRank >= 4 && dRank <= 6) {
			return false;
		}

		return true;
	}
	
	@Override
	public Boolean doSplit() {
		if (!hand.canSplit())
			return false;

		int val = hand.findHandValue();
		// Do not Split on Double 4,5,6,10
		if (val == 4 || val == 5 || val == 6 || val == 10)
			return false;

		return true;
	}

	public int determineBet() {
		bet = getNumTokens() * riskLevel / 100;

		Reporter.printReport(this.toString() + " places a bet of " + bet);

		return bet;
	}

	public int doWin(int dealerVal) {
		int val = hand.findHandValue();
		int temp = bet;
		bet = 0;

		// Win
		if ((val <= 21 && (dealerVal > 21 || val > dealerVal))) {
			return temp * 2;
		} else {
			// Lost
			return 0;
		}

	}

}
