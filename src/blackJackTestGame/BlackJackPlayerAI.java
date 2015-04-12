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

	private int hotStreak;
	private int reqLenOfHotStreak;

	// Trackers
	// Turns
	private int numOfWins = 0;
	private int numOfLoses = 0;
	private int numOfRounds = 0;

	private int longestHotStreak = 0;
	private int numOfStreaksLongerThanThree = 0;

	private int numOfHits = 0;
	private int numOfBlackJack = 0;

	private int totNumOfCards = 0;

	private int totMoneyProfit = 0;
	private int totMoneyLost = 0;
	private int totMoneyWon = 0;

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

		if (hand.findHandValue() == 21 && hand.hand.size() == 2){
			numOfBlackJack++;
		}

		// Deals with greater than you 17
		if (val >= 17){
			return false;
		}

		// Deals with Dealer Ace
		if (dRank == 1){
			return true;
		}

		if (val >= 13 && dRank <= 6){
			return false;
		}

		if (val == 12 && dRank >= 4 && dRank <= 6){
			return false;
		}

		numOfHits++;
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

		// Track Stats
		numOfRounds++;
		totNumOfCards += 2;

		return bet;
	}

	public int doWin(int dealerVal) {
		int val = hand.findHandValue();
		int temp = bet;
		bet = 0;

		// Win
		if ((val <= 21 && (dealerVal > 21 || val > dealerVal))){
			numOfWins++;
			totMoneyWon = temp;
			return temp * 2;
		}
		else{
			// Lost
			numOfLoses++;
			totMoneyLost += temp;
			return 0;
		}

	}

	public int getNumOfWins() {
		return numOfWins;
	}

	public int getNumOfLoses() {
		return numOfLoses;
	}

	public int getNumOfRounds() {
		return numOfRounds;
	}

	public int getLongestHotStreak() {
		return longestHotStreak;
	}

	public int getNumOfStreaksLongerThanThree() {
		return numOfStreaksLongerThanThree;
	}

	public int getNumOfHits() {
		return numOfHits;
	}

	public int getNumOfBlackJacks() {
		return numOfBlackJack;
	}

	public int getTotNumOfCards() {
		return totNumOfCards;
	}

	public int getTotMoneyLost() {
		return totMoneyLost;
	}

	public int getTotMoneyWon() {
		return totMoneyWon;
	}

	public int getTotProfit() {
		return totMoneyWon - totMoneyLost;
	}

	public Double getAvgMoneyLost() {
		return 1.0 * totMoneyLost / numOfRounds;
	}

	public Double getAvgMoneyWon() {
		return 1.0 * totMoneyLost / numOfRounds;
	}

	public Double getWinRatio() {
		return 1.0 * numOfWins / numOfLoses;
	}

	public Double getHitPerLoss() {
		return 1.0 * numOfHits / numOfLoses;
	}

	public Double getHitPerWin() {
		return 1.0 * numOfHits / numOfWins;
	}

	public Double getAvgCardPerRound() {
		return 1.0 * totNumOfCards / numOfRounds;
	}

	public void generateReport() {
		String s = "";
		s += "=========================\n";
		s += "Player Name: " + this.toString() + "\n";
		s += "Final Money: " + this.getNumTokens() + "\n";

		Reporter.printReport(s);
	}
}
