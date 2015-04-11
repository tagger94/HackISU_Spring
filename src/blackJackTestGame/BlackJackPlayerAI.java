package blackJackTestGame;

import exampleClasses.StandardPlayingCard;

public class BlackJackPlayerAI extends BlackJackPlayer implements BlackJackAI {

	/*
	 * Possible Actions
	 * 
	 * Hit Stand Split***Double***Surrender
	 */

	private StandardPlayingCard dealerCard;
	private int riskLevel;

	private int bet;

	public BlackJackPlayerAI(String name, int chips, int riskLevel) {
		super(name);
		this.riskLevel = riskLevel;
		this.chips = chips;
		bet = 0;
	}

	@Override
	public int determineBet() {
		bet = chips * riskLevel / 100;
		chips -= bet;

		return bet;
	}

	public int doWin(int dealerVal) {
		int val = hand.findHandValue();
		int temp = bet;

		// Win
		if (dealerVal > 21 || (val <= 21 && val > dealerVal)) {
			chips += bet * 2;
			bet = 0;
			return temp;
		}

		// Lost
		bet = 0;
		return temp * -1;

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

	@Override
	public void setDealerTopCard(StandardPlayingCard c) {
		dealerCard = c;
	}

}
