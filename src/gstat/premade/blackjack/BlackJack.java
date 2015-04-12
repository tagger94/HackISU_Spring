package gstat.premade.blackjack;

import java.util.ArrayList;

import gstat.premade.playingcard.StandardPlayingCard;
import gstat.util.Deck;
import gstat.util.Inventory;
import gstat.util.Reporter;

public class BlackJack {
	private static Deck<StandardPlayingCard> deck = new Deck<StandardPlayingCard>(StandardPlayingCard.makeDeck());

	private static BlackJackDealerAI dealer = new BlackJackDealerAI("Dealer");

	private static ArrayList<BlackJackPlayerAI> players = new ArrayList<BlackJackPlayerAI>();

	private static int round = 0;

	private static final int START_CHIP = 50;

	private static Inventory chips = new Inventory("Chips", -1);

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

	private static void startRound() {

		// Shuffle
		deck.shuffle_Report();

		// Place Bets
		for(BlackJackPlayerAI p : players){
			p.subTokens_Report(chips, p.determineBet());
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

	private static void endRound() {

		for(BlackJackPlayer h : players){
			deck.giveMulti(h.hand.discardHand());
		}
		deck.giveMulti(dealer.hand.discardHand());
	}

}