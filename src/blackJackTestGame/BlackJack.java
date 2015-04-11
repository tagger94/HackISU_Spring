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

	private void takeTurn(BlackJackPlayer p) {
		
		Boolean hit = false;
		
		//Used for Splits
		BlackJackHand second_hand;

		// Check for Splits
		if(p.hand.canSplit()){
			second_hand = new BlackJackHand();
		}

		// Find Hand Value
	
		// Determine Bet

		// Hit or Not
		do {
			if(p.hand.findHandValue() >= 17){
				hit = true;
				p.hand.drawCard_Report(deck.draw());
			} else {
				hit = false;
			}
			
		} while(hit);
	}
	

	public void runGame() {
		Inventory chips = new Inventory("Chips", -1);
		
		BlackJackPlayer dealer = (BlackJackPlayer) new ExamplePlayer("Dealer");
		BlackJackPlayer player = (BlackJackPlayer) new ExamplePlayer("Player", chips.take_Report(50));
		
		while (true) {
			startRound();
			takeTurn(player);
			takeTurn(dealer);
		}
	}

}