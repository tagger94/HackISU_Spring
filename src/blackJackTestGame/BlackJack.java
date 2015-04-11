package blackJackTestGame;

import java.util.ArrayList;

import exampleClasses.ExamplePlayer;
import exampleClasses.StandardPlayingCard;
import exampleClasses.Suit;
import gameSim.*;

public class BlackJack {
	private static Suit suit;

	private static StandardPlayingCard deckMaker = new StandardPlayingCard(1,
			suit.SPADES);
	private static Deck deck = new Deck(deckMaker.makeDeck());

	private static BlackJackDealerAI dealer = new BlackJackDealerAI("Dealer");

	private static ArrayList<BlackJackPlayerAI> players = new ArrayList<BlackJackPlayerAI>();

	private static int round = 0;

	private static final int START_CHIP = 50;

	// TODO: Bank

	public static void main() {
		Inventory chips = new Inventory("Chips", -1);

		players.add(new BlackJackPlayerAI("Bob", chips.take(START_CHIP), 90));
		players.add(new BlackJackPlayerAI("Alice", chips.take(START_CHIP), 50));
		players.add(new BlackJackPlayerAI("Eve", chips.take(START_CHIP), 20));

		while (round < 100) {
			// Set up deck
			startRound();

			// Increment Counter
			round++;

			// Place Bets
			for (BlackJackPlayerAI p : players) {
				p.determineBet();
			}

			// Take Player Turns
			for (BlackJackPlayer p : players) {
				takeTurn((BlackJackAI) p);
			}

			// Take Dealer Turn
			takeTurn(dealer);

			// Reclaim Bet
			for (BlackJackPlayerAI p : players) {
				int temp = p.doWin(dealer.hand.findHandValue());
				if(temp < 1)
					chips.give(temp * -1);
				else
					chips.take(temp);
			}

			// Reset Deck
			endRound();
		}
	}

	private static void startRound() {

		// Shuffle
		deck.shuffle_Report();
		System.out.println("Shuffled Deck");

		// Each player gets 2 cards
		for (BlackJackPlayer h : players) {
			h.hand.drawCard_Report((StandardPlayingCard) deck.draw_Report());
			h.hand.drawCard_Report((StandardPlayingCard) deck.draw_Report());
			System.out.println(h.toString() + ": drew " + h.hand);
		}

		// Dealer gets 2 cards
		dealer.hand.drawCard_Report((StandardPlayingCard) deck.draw_Report());
		dealer.hand.drawCard_Report((StandardPlayingCard) deck.draw_Report());

	}

	private static void takeTurn(BlackJackAI p) {

		// Determine Bet
		p.determineBet();
		// Hit until Stop
		while (p.doHit()) {
		}

	}

	private static void endRound() {

		for (BlackJackPlayer h : players) {
			deck.giveMulti( h.hand.discardHand());
		}
		deck.giveMulti(dealer.hand.discardHand());
	}

}