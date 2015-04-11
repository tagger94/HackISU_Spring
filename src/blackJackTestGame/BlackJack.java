package blackJackTestGame;

import java.util.ArrayList;

import exampleClasses.ExamplePlayer;
import exampleClasses.StandardPlayingCard;
import exampleClasses.Suit;
import gameSim.*;

public class BlackJack {
	private Suit suit;

	private StandardPlayingCard deckMaker = new StandardPlayingCard(1,
			suit.SPADES);
	private Deck deck = new Deck(deckMaker.makeDeck());

	private void startRound() {

		deck.shuffle_Report();
	}

	private void takeTurn(Player p) {

		// Check for Splits

		// Check for Aces

		// Find Hand Value

		// Determine Bet

		// 
	}

	public void runGame() {
		Inventory chips = new Inventory("Chips", -1);
		
		ExamplePlayer dealer = new ExamplePlayer("Dealer");
		ExamplePlayer player = new ExamplePlayer("Player", chips.take_Report(50));
		
		while (true) {
			startRound();
			takeTurn(player);
			takeTurn(dealer);
		}
	}

}