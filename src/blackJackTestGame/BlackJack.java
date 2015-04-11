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

	private void takeTurn(ExamplePlayer p) {
		
		int handValue = 0;
		Boolean soft_flag = false;

		// Check for Splits

		// Check for Aces
		for(int i = 0; i < p.hand.hand.size(); i++) {
			
		}

		// Find Hand Value

		// Determine Bet

		// Hit or Not
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