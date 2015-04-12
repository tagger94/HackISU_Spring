package gstat.premade.blackjack;

import java.util.ArrayList;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Deck;
import gstat.util.Inventory;
import gstat.util.Reporter;

/**
 * Blackjack, also known as twenty-one, is the most widely played casino banking
 * game in the world.[1] Blackjack is a comparing card game between a player and
 * dealer, meaning that players compete against the dealer but not against any
 * other players. It is played with one or more decks of 52 cards. The object of
 * the game is to beat the dealer, which can be done in a number of ways:
 * 
 * Get 21 points on the player's first two cards (called a blackjack), without a
 * dealer blackjack; Reach a final score higher than the dealer without
 * exceeding 21; or Let the dealer draw additional cards until his or her hand
 * exceeds 21. The player or players are dealt an initial two-card hand and add
 * together the value of their cards. Face cards (kings, queens, and jacks) are
 * counted as ten points. A player and the dealer can count their own ace as 1
 * point or 11 points. All other cards are counted as the numeric value shown on
 * the card. After receiving their initial two cards, players have the option of
 * getting a "hit", or taking an additional card. In a given round, the player
 * or the dealer wins by having a score of 21 or by having the highest score
 * that is less than 21. Scoring higher than 21 (called "busting" or
 * "going bust") results in a loss. A player may win by having any final score
 * equal to or less than 21 if the dealer busts.
 * 
 * This recreates Blackjack in our game sim API
 * 
 * @author Alex Berns
 * 
 */
public class BlackJack {
	private static Deck<StandardPlayingCard> deck = new Deck<StandardPlayingCard>(StandardPlayingCard.makeDeck());

	private static BlackJackDealerAI dealer = new BlackJackDealerAI("Dealer");

	private static ArrayList<BlackJackPlayerAI> players = new ArrayList<BlackJackPlayerAI>();

	private static int round = 0;

	private static final int START_CHIP = 50;

	private static Inventory chips = new Inventory("Chips", -1);

	/**
	 * Runs the main game. Needs no arguments
	 * @param args
	 */
	public static void main(String[] args) {

		players.add(new BlackJackPlayerAI("Bob", START_CHIP, 90));
		players.add(new BlackJackPlayerAI("Alice", START_CHIP, 50));
		players.add(new BlackJackPlayerAI("Eve", START_CHIP, 20));

		while (round < 5){
			Reporter.printReport("-----------------------------------------");
			// Set up deck
			startRound();

			// Increment Counter
			round++;

			// Take Player Turns
			for(BlackJackPlayer p : players){
				takeTurn(p);
			}

			// Take Dealer Turn
			takeTurn(dealer);

			// Reclaim Bet
			for(BlackJackPlayerAI p : players){
				int temp = p.doWin(dealer.hand.findHandValue());
				// Loss return 0, Win return (bet * 2)
				// Win
				Reporter.printReport("*****************************************");
				Reporter.printReport(p.toString() + "'s returns");
				p.addTokens_Report(chips, temp);
			}

			// Reset Deck
			endRound();

			Reporter.printReport("-----------------------------------------");
		}

		for(BlackJackPlayerAI p : players){
			p.generateReport();
		}

	}

	/**
	 * Actions to take during start of round
	 */
	private static void startRound() {

		// Shuffle
		deck.shuffle_Report();

		// Place Bets
		for(BlackJackPlayerAI p : players){
			p.removeTokens_Report(chips, p.determineBet());
		}

		// Each player gets 2 cards
		for(BlackJackPlayer p : players){
			startDraw(p);
		}

		// Dealer gets 2 cards
		startDraw(dealer);

		// Players See Dealers Face-Up Card
		for(BlackJackPlayer p : players){
			p.setDealerTopCard(dealer.hand.hand.get(0));
		}
	}

	private static void startDraw(BlackJackPlayer p) {
		Reporter.printReport("*****************************************");
		Reporter.printReport(p.toString() + "'s Draw");
		p.hand.drawCard_Report(deck.draw());
		p.hand.drawCard_Report(deck.draw());
	}

	/**
	 * Actions taken by player in middle of turn
	 * @param p
	 */
	private static void takeTurn(BlackJackPlayer p) {

		Reporter.printReport("*****************************************");
		Reporter.printReport(p.toString() + "'s Turn[" + round + "]");
		// Hit until Stop
		while (p.doHit()){
			Reporter.printReport(p.toString() + " Hits");
			p.getHand().drawCard_Report(deck.draw());
		}
		Reporter.printReport(p.toString() + " Stays");

	}

	/**
	 * Actions done during end of round
	 */
	private static void endRound() {

		for(BlackJackPlayer h : players){
			deck.giveMultiple(h.hand.discardHand());
		}
		deck.giveMultiple(dealer.hand.discardHand());
	}

}